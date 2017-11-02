package com.bridgeIt.fundooNotes.Dao;

import java.util.List;

import com.bridgeIt.fundooNotes.model.UserModel;

public interface UserDataBase {
public String addDataInDB(UserModel user);
public String checkEmailId(String email);
public List<UserModel> getAllUserData();
public String loginValidation(String email, String passWord);
}
