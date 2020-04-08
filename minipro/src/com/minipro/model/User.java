package com.minipro.model;

public class User {
	private String firstName;
	private String lastName;
	private String email;
	private String pwd;
	private String role;
	private long mobileno;
	private String organization;
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public long getMobileno() {
		return mobileno;
	}
	public void setMobileno(long mobileno) {
		this.mobileno = mobileno;
	}
	public String getOrganization() {
		return organization;
	}
	public void setOrganization(String organization) {
		this.organization = organization;
	}
	
	public User() 
	{
		super();// TODO Auto-generated constructor stub
	}
	
	public User(String firstName, String lastName, String email, String pwd, String role, long mobileno,
			String organization) 
	{
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.pwd = pwd;
		this.role = role;
		this.mobileno = mobileno;
		this.organization = organization;
	}
	@Override
	public String toString() {
		return "user [firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + ", pwd=" + pwd
				+ ", role=" + role + ", mobileno=" + mobileno + ", organization=" + organization + "]";
	}

}
