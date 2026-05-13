package com.qianmian.tech.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.qianmian.tech.entity.ContactMessage;

public interface ContactMessageService extends IService<ContactMessage> {
    boolean submitMessage(ContactMessage message);
}