package com.qianmian.tech.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.qianmian.tech.entity.Partner;

import java.util.List;

public interface PartnerService extends IService<Partner> {
    List<Partner> listPartners();
}