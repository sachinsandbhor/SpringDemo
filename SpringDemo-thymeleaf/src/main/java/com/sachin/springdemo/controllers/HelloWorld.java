package com.sachin.springdemo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.sachin.springdemo.model.Student;

@Controller
public class HelloWorld {

	@GetMapping("/hello")
	public String hello() {
		return "Hello";
	}
	
	@GetMapping("/sendData")
	public ModelAndView sendData() {
		ModelAndView mv = new ModelAndView("data");
		mv.addObject("message", "Life is beautiful");
		return mv;
	}
	
	@GetMapping("/student")
	public ModelAndView getStudent() {
		ModelAndView mv = new ModelAndView("student");
		Student student = new Student();
		student.setName("Shreeja");
		student.setScore(95);
		mv.addObject(student);
		return mv;
	}
}
