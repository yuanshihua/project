package com.demo.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the user database table.
 * 
 */
@Entity
@Table(name="user")
@NamedQuery(name="User.findAll", query="SELECT u FROM User u")
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String id;

	private int active;

	private int age;

	@Temporal(TemporalType.DATE)
	private Date birthdate;

	@Column(name="city_desc")
	private String cityDesc;

	@Temporal(TemporalType.DATE)
	@Column(name="create_time")
	private Date createTime;

	private String creator;

	private String education;

	private String email;

	@Column(name="emp_dept_desc")
	private String empDeptDesc;

	@Column(name="emp_name")
	private String empName;

	@Column(name="emp_no")
	private String empNo;

	@Column(name="emp_second_dept_desc")
	private String empSecondDeptDesc;

	@Column(name="emp_type_desc")
	private String empTypeDesc;

	private String gender;

	@Lob
	@Column(name="head_icon")
	@Basic(fetch=FetchType.LAZY)
	private byte[] headIcon;

	@Temporal(TemporalType.DATE)
	@Column(name="job_hiredate")
	private Date jobHiredate;

	@Column(name="job_leval")
	private int jobLeval;

	@Column(name="job_name")
	private String jobName;

	@Column(name="job_sequence")
	private int jobSequence;

	@Column(name="phone_number")
	private int phoneNumber;

	@Temporal(TemporalType.DATE)
	@Column(name="update_time")
	private Date updateTime;

	private String updator;

	public User() {
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