package com.bridgeIt.fundooNotes.model;

public class UserModel {
    
	private int id;
	private String rEmail;
	private String rPassWord;
	
	private String rPhnNo;
	
	public String getrEmail() {
		return rEmail;
	}
	public void setrEmail(String rEmail) {
		this.rEmail = rEmail;
	}
	public String getrPassWord() {
		return rPassWord;
	}
	public void setrPassWord(String rPassWord) {
		this.rPassWord = rPassWord;
	}
	
	public String getrPhnNo() {
		return rPhnNo;
	}
	public void setrPhnNo(String rPhnNo) {
		this.rPhnNo = rPhnNo;
	}
	@Override
	public String toString() {
		return "UserModel [rEmail=" + rEmail + ", rPassWord=" + rPassWord + ", rPhnNo="
				+ rPhnNo + "]";
	}
	public int getId() {
		return id;
	}
	private void setId(int id) {
		this.id = id;
	}
	
	
}
