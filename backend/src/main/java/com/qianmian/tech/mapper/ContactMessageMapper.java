package com.qianmian.tech.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.qianmian.tech.entity.ContactMessage;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ContactMessageMapper extends BaseMapper<ContactMessage> {
}