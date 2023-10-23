package com.aurionpro.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aurionpro.model.ICoach;

@RestController
public class CoachController {
	
//	@Autowired
//	@Qualifier(value="cricketCoach")
	private ICoach coach1;
	
	public CoachController(@Qualifier(value="normalCoach") ICoach coach1) {
		super();
		this.coach1=coach1;
	}
	
	
	
	
	@GetMapping("/controller")
	public String showTrainingTable() {
//		System.out.println(coach1==coach2);
		System.out.println(coach1.getClass().getSimpleName()+":"+coach1.hashCode());
//		System.out.println(coach1.getTrainingPlan());
		return coach1.getTrainingPlan()+"<br> ";
	}

}
