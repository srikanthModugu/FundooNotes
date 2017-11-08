package com.bridgeit.model;

public class User {

	
	private String email;
	private String password;
	private String phnNo;
	
	
	public User( String email, String password, String phnNo) {
		super();
		
		this.email = email;
		this.password = password;
		this.phnNo = phnNo;
	}

	public String getEmail() 
	{
		return email;
	}
	
	public void setEmail(String email)
	{
		this.email = email;
	}
	
	public String getPassword()
	{
		return password;
	}
	
	public void setPassword(String password)
	{
		this.password = password;
	}
	
	public String getPhnNo() 
	{
		return phnNo;
	}
	
	public void setPhnNo(String phnNo)
	{
		this.phnNo = phnNo;
	} 
	
	
}
