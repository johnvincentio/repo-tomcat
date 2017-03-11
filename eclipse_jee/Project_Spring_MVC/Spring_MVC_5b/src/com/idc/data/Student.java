package com.idc.data;

import java.util.ArrayList;
import java.util.Date;

import javax.validation.constraints.Max;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

import com.idc.validator.IsValidHobby;

public class Student {

//	@Size(min=5, max=20, message="Please enter a value of student name between {min} and {max} characters.")
	@Pattern(regexp="[^0-9]*")
	private String studentName;

	@Size(min=2, max=30)
	@IsValidHobby(listOfValidHobbies="AAAA|BBBB|CCCC")
	private String studentHobby;

	@Max(2222)
	private Long studentMobile;

	@Past
	private Date studentDOB;

	@NotEmpty
	private String studentComment;

	public String getStudentComment() {
		return studentComment;
	}
	public void setStudentComment(String studentComment) {
		this.studentComment = studentComment;
	}
	private ArrayList<String> studentSkills;
	private Address studentAddress;

	public Address getStudentAddress() {
		return studentAddress;
	}
	public void setStudentAddress(Address studentAddress) {
		this.studentAddress = studentAddress;
	}
	public Long getStudentMobile() {
		return studentMobile;
	}
	public void setStudentMobile(Long studentMobile) {
		this.studentMobile = studentMobile;
	}
	public Date getStudentDOB() {
		return studentDOB;
	}
	public void setStudentDOB(Date studentDOB) {
		this.studentDOB = studentDOB;
	}
	public ArrayList<String> getStudentSkills() {
		return studentSkills;
	}
	public void setStudentSkills(ArrayList<String> studentSkills) {
		this.studentSkills = studentSkills;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public String getStudentHobby() {
		return studentHobby;
	}
	public void setStudentHobby(String studentHobby) {
		this.studentHobby = studentHobby;
	}
}
