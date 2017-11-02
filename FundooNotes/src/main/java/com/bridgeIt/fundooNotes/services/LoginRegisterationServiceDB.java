package com.bridgeIt.fundooNotes.services;



import java.util.List;


import com.bridgeIt.fundooNotes.Dao.UserDataBase;
import com.bridgeIt.fundooNotes.model.UserModel;


public class LoginRegisterationServiceDB  {
	   private UserDataBase dataBase;
	   
	public LoginRegisterationServiceDB(UserDataBase dataBase){
		this.dataBase = dataBase;
	}
	public String addDataInDB(UserModel user) {
		// TODO Auto-generated method stub
		String status = dataBase.addDataInDB(user);
		return status;
	}

	public String checkEmailId(String email) {
		// TODO Auto-generated method stub
		String status = dataBase.checkEmailId(email);
		
		return status;
	}

	public List<UserModel> getAllUserData() {
		// TODO Auto-generated method stub
		List< UserModel> list = dataBase.getAllUserData();
		return list;
	}

	public String loginValidation(String email, String passWord) {
		// TODO Auto-generated method stub
		String status = dataBase.loginValidation(email, passWord);
		return status;
	}
	
}
