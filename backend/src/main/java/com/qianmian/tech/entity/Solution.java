package com.qianmian.tech.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@TableName("solution")
public class Solution {
    @TableId(type = IdType.AUTO)
    private Long id;
    
    private String title;
    private String description;
    private String category;
    private String imageUrl;
    private String features;
    private Integer sortOrder;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}