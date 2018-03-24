package com.myTalentRecruitment.model;

import java.util.Date;

public class SuggestionModel {
	
	private long id;
	private Date date ;
	
	private long userId;
	private String userName;
	private String userLastName1;
	private String userLastName2;
	private String userEmail;
	private boolean userWorker;
	
//	private long candidateId;
//	private String candidateName;
//	private String candidateLastName1;
//	private String candidateLastName2;
//	private String candidateEmail;
//	private Sector candidateSector;
//	private String candidateEmail;
//	private String candidateEmail;

	
	public SuggestionModel() {}
	
	public SuggestionModel(long id, Date date, long userId) {
		this.id = id;
		this.date = date;
		this.userId = userId;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserLastName1() {
		return userLastName1;
	}

	public void setUserLastName1(String userLastName1) {
		this.userLastName1 = userLastName1;
	}

	public String getUserLastName2() {
		return userLastName2;
	}

	public void setUserLastName2(String userLastName2) {
		this.userLastName2 = userLastName2;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public boolean isUserWorker() {
		return userWorker;
	}

	public void setUserWorker(boolean userWorker) {
		this.userWorker = userWorker;
	}	

}
