package com.qianmian.tech.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.qianmian.tech.entity.CompanyInfo;
import com.qianmian.tech.mapper.CompanyInfoMapper;
import com.qianmian.tech.service.CompanyInfoService;
import org.springframework.stereotype.Service;

@Service
public class CompanyInfoServiceImpl extends ServiceImpl<CompanyInfoMapper, CompanyInfo> implements CompanyInfoService {
    
    @Override
    public CompanyInfo getCompanyInfo() {
        return this.getOne(new LambdaQueryWrapper<CompanyInfo>().orderByDesc(CompanyInfo::getId).last("LIMIT 1"));
    }
}