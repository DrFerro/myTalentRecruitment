package com.myTalentRecruitment.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.myTalentRecruitment.model.FieldModel;
import com.myTalentRecruitment.model.SuggestionModel;
import com.myTalentRecruitment.model.UserModel;
import com.myTalentRecruitment.service.SuggestionService;

@RestController
@RequestMapping("/suggestion")
public class SuggestionController {

	private Logger logger = LoggerFactory.getLogger(SuggestionController.class);
	private SuggestionService suggestionService;

	@Autowired
	public SuggestionController(SuggestionService userService) {
		this.suggestionService = userService;
	}	
	
	@RequestMapping(path = "/suggestion", method = RequestMethod.POST)
	SuggestionModel createSuggestion(@RequestBody SuggestionModel suggestionIn){
		return suggestionService.createSuggestion(suggestionIn);
	}
	
	@RequestMapping(path = "/user", method = RequestMethod.POST)
	UserModel createUser(@RequestBody UserModel userIn){
		return suggestionService.createUser(userIn);
	}
	
	@RequestMapping(path = "/users", method = RequestMethod.GET)
	List<UserModel> findUsers(){
		return suggestionService.findAllUsers();
	}
	
	@RequestMapping(path = "/fields", method = RequestMethod.GET)
	List<FieldModel> findFields() {
		return suggestionService.findFields();
	}
	
	
}
