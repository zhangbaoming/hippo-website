package com.qianmian.tech.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.qianmian.tech.entity.Service;
import com.qianmian.tech.mapper.ServiceMapper;
import com.qianmian.tech.service.ServiceService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceServiceImpl extends ServiceImpl<ServiceMapper, Service> implements ServiceService {
    
    @Override
    public List<Service> listServices() {
        return this.list();
    }
}