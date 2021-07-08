package com.savushkin.demo.service;

import com.savushkin.demo.dao.CourseRepository;
import com.savushkin.demo.domain.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CourseLister {
	private final CourseRepository repository;

	@Autowired
	public CourseLister(CourseRepository repository) {
		this.repository = repository;
	}

	public List<Course> coursesByAuthor(String name) {
		List<Course> allCourses = repository.findAll();
		return allCourses.stream().filter(course -> course.getAuthor().equals(name)).collect(Collectors.toList());
	}
}
