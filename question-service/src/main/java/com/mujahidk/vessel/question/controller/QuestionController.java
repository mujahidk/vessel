package com.mujahidk.vessel.question.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mujahidk.vessel.question.aop.LogTime;
import com.mujahidk.vessel.question.persistence.entity.Question;

@RestController
public class QuestionController {

	@GetMapping(path = "/questions")
	@LogTime
	public Question[] list() {
		return new Question[] { new Question("1", "This is a simple question 1"),
				new Question("2", "This is a simple question 2"), new Question("3", "This is a simple question 3"),
				new Question("4", "This is a simple question 4"), new Question("5", "This is a simple question 5") };
	}
}
