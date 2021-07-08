package com.savushkin.demo.controller;

import com.savushkin.demo.dao.CourseRepository;
import com.savushkin.demo.domain.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/course")
public class CourseController {

  @Autowired
  private CourseRepository courseRepository;

  @RequestMapping
  public String courseTable(Model model) {
    model.addAttribute("courses", courseRepository.findAll());
    return "course_table";
  }

  @RequestMapping("/{id}")
  public String courseForm(Model model, @PathVariable Long id) {
    model.addAttribute(
        "course",
        courseRepository.findById(id).orElseThrow()
    );
    return "course_form";
  }

  @PostMapping
  public String submitCourseForm(Course course) {
    courseRepository.save(course);
    return "redirect:/course";
  }

  @RequestMapping("/new")
  public String courseForm(Model model) {
    model.addAttribute("course", new Course());
    return "course_form";
  }

  @DeleteMapping("/{id}")
  public String deleteCourse(@PathVariable Long id) {
    courseRepository.delete(id);
    return "redirect:/course";
  }
}
