package com.qianmian.tech.controller;

import com.qianmian.tech.entity.Solution;
import com.qianmian.tech.service.SolutionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class SolutionController {
    
    @Autowired
    private SolutionService solutionService;
    
    @GetMapping("/solutions")
    public Map<String, Object> listSolutions(@RequestParam(required = false) String category) {
        Map<String, Object> result = new HashMap<>();
        List<Solution> solutions;
        if (category != null && !category.isEmpty()) {
            solutions = solutionService.listSolutionsByCategory(category);
        } else {
            solutions = solutionService.listSolutions();
        }
        result.put("code", 200);
        result.put("message", "success");
        result.put("data", solutions);
        return result;
    }
    
    @PostMapping("/solutions")
    public Map<String, Object> saveSolution(@RequestBody Solution solution) {
        Map<String, Object> result = new HashMap<>();
        solutionService.save(solution);
        result.put("code", 200);
        result.put("message", "保存成功");
        return result;
    }
}