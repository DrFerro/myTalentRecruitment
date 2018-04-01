package com.myTalentRecruitment.db;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table (name="candidate")
public class Candidate {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column
	private long id;
	
	@Column(length = 60)
	private String name;
	
	@Column(length = 60)
	private String lastName1;
	
	@Column(length = 60)
	private String lastName2;
	
	@Column(length = 125)
	private String email;
	
	@Column(length = 60)
	private String phone;
	
	@Column
	private long fieldId;
	
	@Column
	private long specialityId;
	
	@Column(length = 300)
	private String observations;
	
	@OneToOne(mappedBy = "candidate", cascade=CascadeType.ALL)
	private Suggestion suggestion;
	
	@ManyToOne	
	@JoinColumn(name = "fieldId",insertable=false,updatable=false)
	private Field field;
	
	@ManyToOne	
	@JoinColumn(name = "specialityId",insertable=false,updatable=false)
	private Speciality speciality;
	
	public Candidate() {}
	
	public Candidate(String name, String lastName1, String lastName2, String email, String phone, long fieldId, long specialityId, String observations) {
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

	public String getObservations() {
		return observations;
	}

	public void setObservations(String observations) {
		this.observations = observations;
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

	public Field getField() {
		return field;
	}

	public void setField(Field field) {
		this.field = field;
	}

	public Speciality getSpeciality() {
		return speciality;
	}

	public void setSpeciality(Speciality speciality) {
		this.speciality = speciality;
	}

	public Suggestion getSuggestion() {
		return suggestion;
	}

	public void setSuggestion(Suggestion suggestion) {
		this.suggestion = suggestion;
	}
	
}

