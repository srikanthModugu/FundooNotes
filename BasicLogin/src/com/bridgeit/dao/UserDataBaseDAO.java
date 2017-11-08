package com.bridgeit.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.bridgeit.model.User;

public class UserDataBaseDAO {
	  Connection conn = null;
	  PreparedStatement stm = null;
	  JDBCHelper helper = new JDBCHelper();
	  ResultSet rs = null;
	  
	public void addUser(User user)
	{
		try
		{
		conn = helper.getConnection();
		stm = conn.prepareStatement("insert into FirstApp.user(email,password,phnNo) values(?,?,?)");
		stm.setString(1, user.getEmail());
		stm.setString(2, user.getPassword());
		stm.setString(3, user.getPhnNo());
		stm.execute();
		}
		
		catch(Exception e)
		{
			e.printStackTrace();
			
		}
		finally
		{
			helper.close(conn);
			helper.close(stm);
		}
	}
	
	public String authUser(String email,String password)
	{
		try{
		conn = helper.getConnection();
		String queryCheck = "SELECT * from FirstApp.user WHERE email = ?";
		stm = conn.prepareStatement(queryCheck);
		System.out.println("email printing"+email);
		stm.setString(1, email);
		stm.execute();
	    rs = stm.getResultSet();
		if(rs.next())
		{
			System.out.println("printing resultset"+rs.getString("password"));
			
			if(rs.getString("password").equals(password)){
				return "sucess";
			}
			else{
				return "Invalid Password";
			}
			
		}
		else{
			return"Invalid Details";
		}
		
		
		}
		catch (Exception e) {
			e.printStackTrace();
			return "Connection Problem try after Some time";
		}
		finally
		{
			helper.close(conn);
			helper.close(stm);
			helper.close(rs);
		}
		
	}
	  
	
	public String authEmail(String email)
	{
	    try
	      {
	   	 System.out.println("shakalaka baby");
		   conn = helper.getConnection();
		   String queryCheck = "SELECT * from FirstApp.user WHERE email = ?";
		   stm = conn.prepareStatement(queryCheck);
		   stm.setString(1, email);
			stm.execute();
			 rs = stm.getResultSet();
		   if(!rs.next())
		    {
			 	 System.out.println(" naka babybaby4");
		      return "sucess";
		
		      }
		   else
		    {
			  return "User already registered";
		      }
	      }
	    catch (Exception e) 
	       {
		return "Connection Problem try after Some time";
	           }
	   finally
	       {
		    helper.close(conn);
		    helper.close(stm);
		    helper.close(rs);
	      }
	   }
	
   }
