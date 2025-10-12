package com.springboot.springboot2.property.mapper;

import com.springboot.springboot2.pojo.FreightBasis;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface FreightBasisMapper {

    @Select("SELECT * FROM freight_basis")
    List<FreightBasis> findAll();

    @Select("SELECT * FROM freight_basis WHERE type = #{type} LIMIT 1")
    FreightBasis findByType(String type);
}
