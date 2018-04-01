package com.myTalentRecruitment.model;

public class CandidateModel {

	private long id;
	private String name;
	private String lastName1;
	private String lastName2;
	private String email;
	private String phone;
	private long fieldId;
	private long specialityId;
	private String observations;
	
	public CandidateModel() {}
	
	public CandidateModel(String name, String lastName1, String lastName2, String email, String phone, long fieldId, long specialityId, String observations) {
		this.name = name;
		this.lastName1 = lastName1;
		this.lastName2 = lastName2;
		this.email = email;
		this.phone = phone;
		this.fieldId = fieldId;
		this.specialityId = specialityId;
		this.observations = observations;
	}
	
	public CandidateModel(long id, String name, String lastName1, String lastName2, String email, String phone, long fieldId, long specialityId, String observations) {
		this.id = id;
		this.name = name;
		this.lastName1 = lastName1;
		this.lastName2 = lastName2;
		this.email = email;
		this.phone = phone;
		this.fieldId = fieldId;
		this.specialityId = specialityId;
		this.observations = observations;
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLastName1() {
		return lastName1;
	}
	public void setLastName1(String lastName1) {
		this.lastName1 = lastName1;
	}
	public String getLastName2() {
		return lastName2;
	}
	public void setLastName2(String lastName2) {
		this.lastName2 = lastName2;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public long getFieldId() {
		return fieldId;
	}
	public void setFieldId(long fieldId) {
		this.fieldId = fieldId;
	}
	public long getSpecialityId() {
		return specialityId;
	}
	public void setSpecialityId(long specialityId) {
		this.specialityId = specialityId;
	}
	public String getObservations() {
		return observations;
	}
	public void setObservations(String observations) {
		this.observations = observations;
	}
	
}
