package com.springboot.springboot2.pojo;

import lombok.Data;

import java.time.LocalDate;

@Data

public class Building {
    private Integer buildingId;
    private String buildingCode;
    private String buildingName;
    private Short buildingStatus;
    private Short buildingFloors;
    private LocalDate completionDate;
    private Short designLife;
    private Short ownership;
}
