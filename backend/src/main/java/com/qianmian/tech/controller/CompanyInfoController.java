package com.qianmian.tech.controller;

import com.qianmian.tech.entity.CompanyInfo;
import com.qianmian.tech.service.CompanyInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class CompanyInfoController {
    
    @Autowired
    private CompanyInfoService companyInfoService;
    
    @GetMapping("/about")
    public Map<String, Object> getCompanyInfo() {
        Map<String, Object> result = new HashMap<>();
        CompanyInfo info = companyInfoService.getCompanyInfo();
        result.put("code", 200);
        result.put("message", "success");
        result.put("data", info);
        return result;
    }
    
    @PostMapping("/about")
    public Map<String, Object> saveCompanyInfo(@RequestBody CompanyInfo companyInfo) {
        Map<String, Object> result = new HashMap<>();
        companyInfoService.save(companyInfo);
        result.put("code", 200);
        result.put("message", "保存成功");
        return result;
    }
}