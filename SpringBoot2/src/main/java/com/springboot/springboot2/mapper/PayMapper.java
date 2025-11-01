package com.springboot.springboot2.mapper;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.springboot.springboot2.pojo.PayInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
@Mapper
public interface PayMapper {

    /**
     * 按条件分页查询支付信息
     *
     * @param page       MyBatis-Plus 分页对象
     * @param start      开始日期
     * @param end        结束日期
     * @param username   用户姓名
     * @param idCard     身份证号
     * @param floorId    楼层ID
     * @param buildingId 建筑ID
     * @return 支付信息分页结果
     */
    Page<PayInfo> selectPayInfoOnCondition(
            Page<PayInfo> page,
            @Param("start") LocalDate start,
            @Param("end") LocalDate end,
            @Param("username") String username,
            @Param("idCard") String idCard,
            @Param("floorId") Integer floorId,
            @Param("buildingId") Integer buildingId
    );
}
