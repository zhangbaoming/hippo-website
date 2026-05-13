package com.qianmian.tech.controller;

import com.qianmian.tech.entity.Partner;
import com.qianmian.tech.service.PartnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class PartnerController {
    
    @Autowired
    private PartnerService partnerService;
    
    @GetMapping("/partners")
    public Map<String, Object> listPartners() {
        Map<String, Object> result = new HashMap<>();
        List<Partner> partners = partnerService.listPartners();
        result.put("code", 200);
        result.put("message", "success");
        result.put("data", partners);
        return result;
    }
    
    @PostMapping("/partners")
    public Map<String, Object> savePartner(@RequestBody Partner partner) {
        Map<String, Object> result = new HashMap<>();
        partnerService.save(partner);
        result.put("code", 200);
        result.put("message", "保存成功");
        return result;
    }
}