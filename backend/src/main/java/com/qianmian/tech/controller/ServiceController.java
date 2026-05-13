package com.qianmian.tech.controller;

import com.qianmian.tech.entity.Service;
import com.qianmian.tech.service.ServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class ServiceController {
    
    @Autowired
    private ServiceService serviceService;
    
    @GetMapping("/services")
    public Map<String, Object> listServices() {
        Map<String, Object> result = new HashMap<>();
        List<Service> services = serviceService.listServices();
        result.put("code", 200);
        result.put("message", "success");
        result.put("data", services);
        return result;
    }
    
    @PostMapping("/services")
    public Map<String, Object> saveService(@RequestBody Service service) {
        Map<String, Object> result = new HashMap<>();
        serviceService.save(service);
        result.put("code", 200);
        result.put("message", "保存成功");
        return result;
    }
}