package com.qianmian.tech.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.qianmian.tech.entity.Solution;

import java.util.List;

public interface SolutionService extends IService<Solution> {
    List<Solution> listSolutions();
    List<Solution> listSolutionsByCategory(String category);
}