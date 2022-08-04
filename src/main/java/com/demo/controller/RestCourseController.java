package com.demo.controller;

import com.demo.dao.CourseRepository;
import com.demo.domain.Course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/rest/course")
public class RestCourseController {

    @Autowired
    private CourseRepository courseRepository;

    @GetMapping
    public List<Course> courseTable() {
        return courseRepository.findAll();
    }

    @GetMapping("/{id}")
    public Course courseForm(@PathVariable Long id) {
        return courseRepository.findById(id).orElseThrow();
    }

    @PostMapping("/submit")
    public List<Course> submitCourseForm(@RequestBody Course course) {
        courseRepository.save(course);
        return courseRepository.findAll();
    }

    @DeleteMapping("/{id}")
    public List<Course> deleteCourse(@PathVariable Long id) {
        courseRepository.delete(id);
        return courseRepository.findAll();
    }
}
