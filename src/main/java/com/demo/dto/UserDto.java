package com.demo.dto;

import java.io.Serializable;
import javax.persistence.*;

import java.util.Arrays;
import java.util.Date;


/**
 * The persistent class for the user database table.
 * 
 */
public class UserDto implements Serializable {
	private static final long serialVersionUID = 1L;

	private String id;

	private int active;

	private int age;

	private Date birthdate;

	private String cityDesc;

	private Date createTime;

	private String creator;

	private String education;

	private String email;

	private String empDeptDesc;

	private String empName;

	private String empNo;

	private String empSecondDeptDesc;

	private String empTypeDesc;

	private String gender;

	private byte[] headIcon;

	private Date jobHiredate;

	private int jobLeval;

	private String jobName;

	private int jobSequence;

	private int phoneNumber;

	private Date updateTime;

	private String updator;

	public UserDto() {
	}

	@Override
	public String toString() {
		return "UserDto [id=" + id + ", active=" + active + ", age=" + age + ", birthdate=" + birthdate + ", cityDesc="
				+ cityDesc + ", createTime=" + createTime + ", creator=" + creator + ", education=" + education
				+ ", email=" + email + ", empDeptDesc=" + empDeptDesc + ", empName=" + empName + ", empNo=" + empNo
				+ ", empSecondDeptDesc=" + empSecondDeptDesc + ", empTypeDesc=" + empTypeDesc + ", gender=" + gender
				+ ", headIcon=" + Arrays.toString(headIcon) + ", jobHiredate=" + jobHiredate + ", jobLeval=" + jobLeval
				+ ", jobName=" + jobName + ", jobSequence=" + jobSequence + ", phoneNumber=" + phoneNumber
				+ ", updateTime=" + updateTime + ", updator=" + updator + "]";
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getActive() {
		return this.active;
	}

	public void setActive(int active) {
		this.active = active;
	}

	public int getAge() {
		return this.age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Date getBirthdate() {
		return this.birthdate;
	}

	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}

	public String getCityDesc() {
		return this.cityDesc;
	}

	public void setCityDesc(String cityDesc) {
		this.cityDesc = cityDesc;
	}

	public Date getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getCreator() {
		return this.creator;
	}

	public void setCreator(String creator) {
		this.creator = creator;
	}

	public String getEducation() {
		return this.education;
	}

	public void setEducation(String education) {
		this.education = education;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEmpDeptDesc() {
		return this.empDeptDesc;
	}

	public void setEmpDeptDesc(String empDeptDesc) {
		this.empDeptDesc = empDeptDesc;
	}

	public String getEmpName() {
		return this.empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getEmpNo() {
		return this.empNo;
	}

	public void setEmpNo(String empNo) {
		this.empNo = empNo;
	}

	public String getEmpSecondDeptDesc() {
		return this.empSecondDeptDesc;
	}

	public void setEmpSecondDeptDesc(String empSecondDeptDesc) {
		this.empSecondDeptDesc = empSecondDeptDesc;
	}

	public String getEmpTypeDesc() {
		return this.empTypeDesc;
	}

	public void setEmpTypeDesc(String empTypeDesc) {
		this.empTypeDesc = empTypeDesc;
	}

	public String getGender() {
		return this.gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public byte[] getHeadIcon() {
		return this.headIcon;
	}

	public void setHeadIcon(byte[] headIcon) {
		this.headIcon = headIcon;
	}

	public Date getJobHiredate() {
		return this.jobHiredate;
	}

	public void setJobHiredate(Date jobHiredate) {
		this.jobHiredate = jobHiredate;
	}

	public int getJobLeval() {
		return this.jobLeval;
	}

	public void setJobLeval(int jobLeval) {
		this.jobLeval = jobLeval;
	}

	public String getJobName() {
		return this.jobName;
	}

	public void setJobName(String jobName) {
		this.jobName = jobName;
	}

	public int getJobSequence() {
		return this.jobSequence;
	}

	public void setJobSequence(int jobSequence) {
		this.jobSequence = jobSequence;
	}

	public int getPhoneNumber() {
		return this.phoneNumber;
	}

	public void setPhoneNumber(int phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Date getUpdateTime() {
		return this.updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public String getUpdator() {
		return this.updator;
	}

	public void setUpdator(String updator) {
		this.updator = updator;
	}

}