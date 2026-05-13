package com.qianmian.tech.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.qianmian.tech.entity.Service;

import java.util.List;

public interface ServiceService extends IService<Service> {
    List<Service> listServices();
}