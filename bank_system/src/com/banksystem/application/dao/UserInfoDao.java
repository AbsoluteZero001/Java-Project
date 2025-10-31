package com.banksystem.application.dao;

import com.banksystem.application.db.Database;
import com.banksystem.application.entity.UserInfo;

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

    // 根据 mobile 查询 UserInfo
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
}