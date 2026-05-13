package com.qianmian.tech.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@TableName("service")
public class Service {
    @TableId(type = IdType.AUTO)
    private Long id;
    
    private String title;
    private String description;
    private String icon;
    private Integer sortOrder;
    private String features;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}