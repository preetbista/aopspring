package com.example.springaop.controller;

import com.example.springaop.model.Department;
import com.example.springaop.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/departments")
public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;

    @PostMapping
    public Department save(@RequestBody Department department ){
        return departmentService.save(department);
    }

    @GetMapping("/{id}")
    public Department findById( @PathVariable(value = "id") Integer id ){
        return departmentService.findById(id);
    }
}
