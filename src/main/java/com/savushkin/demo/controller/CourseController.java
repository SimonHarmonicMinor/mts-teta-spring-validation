package com.savushkin.demo.controller;

import com.savushkin.demo.dao.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
}
