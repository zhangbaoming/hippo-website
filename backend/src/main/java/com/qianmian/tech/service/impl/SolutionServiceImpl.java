package com.qianmian.tech.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.qianmian.tech.entity.Solution;
import com.qianmian.tech.mapper.SolutionMapper;
import com.qianmian.tech.service.SolutionService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SolutionServiceImpl extends ServiceImpl<SolutionMapper, Solution> implements SolutionService {
    
    @Override
    public List<Solution> listSolutions() {
        return this.list();
    }
    
    @Override
    public List<Solution> listSolutionsByCategory(String category) {
        return this.list(new LambdaQueryWrapper<Solution>()
                .eq(Solution::getCategory, category)
                .orderByAsc(Solution::getSortOrder));
    }
}