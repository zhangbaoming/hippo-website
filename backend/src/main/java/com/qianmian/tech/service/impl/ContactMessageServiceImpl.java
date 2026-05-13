package com.qianmian.tech.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.qianmian.tech.entity.ContactMessage;
import com.qianmian.tech.mapper.ContactMessageMapper;
import com.qianmian.tech.service.ContactMessageService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class ContactMessageServiceImpl extends ServiceImpl<ContactMessageMapper, ContactMessage> implements ContactMessageService {
    
    @Override
    public boolean submitMessage(ContactMessage message) {
        message.setStatus("PENDING");
        message.setCreatedAt(LocalDateTime.now());
        message.setUpdatedAt(LocalDateTime.now());
        return this.save(message);
    }
}