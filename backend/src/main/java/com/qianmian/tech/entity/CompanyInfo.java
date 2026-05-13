package com.qianmian.tech.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@TableName("company_info")
public class CompanyInfo {
    @TableId(type = IdType.AUTO)
    private Long id;
    
    private String name;
    private String description;
    private String vision;
    private Integer employeeCount;
    private Integer projectCount;
    private Integer clientCount;
    private Integer yearsExperience;
    private String imageUrl;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}