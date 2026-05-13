package com.qianmian.tech.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.qianmian.tech.entity.Partner;
import com.qianmian.tech.mapper.PartnerMapper;
import com.qianmian.tech.service.PartnerService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PartnerServiceImpl extends ServiceImpl<PartnerMapper, Partner> implements PartnerService {
    
    @Override
    public List<Partner> listPartners() {
        return this.list();
    }
}