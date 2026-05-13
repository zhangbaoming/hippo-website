package com.qianmian.tech.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.qianmian.tech.entity.CompanyInfo;

public interface CompanyInfoService extends IService<CompanyInfo> {
    CompanyInfo getCompanyInfo();
}