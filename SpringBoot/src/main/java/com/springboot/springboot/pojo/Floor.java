package com.springboot.springboot.pojo;

import lombok.Data;

@Data
public class Floor {
    private Integer floorId;
    private Integer belongBuilding;
    private Integer floorNumber;
    private Integer roomNumber;

    private Building building; // 嵌套对象
}
