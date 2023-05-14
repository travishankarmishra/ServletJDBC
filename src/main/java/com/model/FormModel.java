package com.model;

public class FormModel {

	int sno;
	String name;
	String email; 
	String mobile;
	String password;
	String file_name;
	public FormModel(int sno,String name, String email, String mobile, String password, String file_name) {
		super();
		this.sno = sno;
		this.name = name;
		this.email = email;
		this.mobile = mobile;
		this.password = password;
		this.file_name = file_name;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getFile_name() {
		return file_name;
	}
	public void setFile_name(String file_name) {
		this.file_name = file_name;
	}

	public int getSno() {
		return sno;
	}
	public void setSno(int sno) {
		this.sno = sno;
	}
	@Override
	public String toString() {
		return "FormModel [name=" + name + ", email=" + email + ", mobile=" + mobile + ", password=" + password
				+ ", file_name=" + file_name + "]";
	}
	
	
	
}
