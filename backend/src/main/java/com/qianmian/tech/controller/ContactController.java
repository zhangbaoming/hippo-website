package com.qianmian.tech.controller;

import com.qianmian.tech.entity.ContactMessage;
import com.qianmian.tech.service.ContactMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class ContactController {
    
    @Autowired
    private ContactMessageService contactMessageService;
    
    @PostMapping("/contact")
    public Map<String, Object> submitMessage(@RequestBody ContactMessage message) {
        Map<String, Object> result = new HashMap<>();
        boolean success = contactMessageService.submitMessage(message);
        if (success) {
            result.put("code", 200);
            result.put("message", "提交成功");
        } else {
            result.put("code", 500);
            result.put("message", "提交失败");
        }
        return result;
    }
}