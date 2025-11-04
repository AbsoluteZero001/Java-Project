package com.banksystem.application.dao;

import com.alibaba.fastjson.JSONArray;
import com.banksystem.application.db.Database;
import com.banksystem.application.entity.AdminInfo;
import com.banksystem.application.entity.UserInfo;
import com.banksystem.application.utills.ConvertUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;

public class UserInfoDao {
    public Long addOne(UserInfo userInfo) {
        Long id = 0L;
        Connection conn = Database.getConn();
        String sql = "INSERT INTO user_info (card_type, card_no, password, nickname, " +
                "name, address, id_num,mobile) VALUES (?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, userInfo.getCardType());
            ps.setString(2, userInfo.getCardNo());
            ps.setString(3, userInfo.getPassword());
            ps.setString(4, userInfo.getNickname());
            ps.setString(5, userInfo.getName());
            ps.setString(6, userInfo.getAddress());
            ps.setString(7, userInfo.getIdNum());
            ps.setString(8, userInfo.getMobile());
            int i = ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if (i > 0) {
                System.out.println("添加成功");
                if (rs.next()) {
                    id = rs.getLong(1);
                }

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return id;
    }

    // 1.根据 mobile 查询 UserInfo
    public static UserInfo getUserByMobile(String mobile) {
        Connection conn = Database.getConn();
        String sql = "SELECT card_type, card_no, password, nickname, name, address, id_num,mobile FROM user_info WHERE mobile =?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, mobile);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                UserInfo user= new UserInfo();
                user.setCardType(rs.getString("card_type"));
                user.setCardNo(rs.getString("card_no"));
                user.setPassword(rs.getString("password"));
                user.setNickname(rs.getString("nickname"));
                user.setName(rs.getString("name"));
                user.setAddress(rs.getString("address"));
                user.setIdNum(rs.getString("id_num"));
                user.setMobile(rs.getString("mobile"));
                return user;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null; // 没有找到
    }
    //2.查询全部
    public JSONArray queryAll() {
        JSONArray list = new JSONArray();
        //获取连接池
        Connection conn = Database.getConn();
        String sql = "select id, card_type, card_no, password, nickname, name, address, " +
                "id_num,mobile, create_by, update_by, state, deleted, create_time, update_time from user_info";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
//            ps.setString(1,mobile);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                UserInfo userInfo = new UserInfo();
                userInfo.setId(rs.getLong("id"));
                userInfo.setPassword(rs.getString("password"));
                userInfo.setMobile(rs.getString("mobile"));
                userInfo.setCardType(rs.getString("card_type"));
                userInfo.setCardNo(rs.getString("card_no"));
                userInfo.setName(rs.getString("name"));
                userInfo.setIdNum(rs.getString("id_num"));
                userInfo.setNickname(rs.getString("nickname"));
                userInfo.setCreateBy(rs.getLong("create_by"));
                userInfo.setUpdateBy(rs.getLong("update_by"));
                userInfo.setState(rs.getInt("state"));
                userInfo.setAddress(rs.getString("address"));
                userInfo.setDeleted(rs.getBoolean("deleted"));
                userInfo.setUpdateTime(ConvertUtils.toInstant(rs.getString("update_time")));
                userInfo.setCreateTime(ConvertUtils.toInstant(rs.getString("create_time")));
                list.add(userInfo);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
    }

    //3.修改用户信息
    public void updateUser(UserInfo userInfo) {
        //获取连接池
        Connection conn = Database.getConn();
        String sql = "update user_info set password = ?, nickname = ?, name = ?, mobile = ? where id = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, userInfo.getPassword());
            ps.setString(2, userInfo.getNickname());
            ps.setString(3, userInfo.getName());
            ps.setString(4, userInfo.getMobile());
            ps.setLong(5, userInfo.getId());
            int i = ps.executeUpdate();
            if (i > 0) {
                System.out.println("修改成功");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}