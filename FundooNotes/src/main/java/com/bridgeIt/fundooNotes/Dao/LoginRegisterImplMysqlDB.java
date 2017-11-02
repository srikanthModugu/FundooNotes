package com.bridgeIt.fundooNotes.Dao;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;


import com.bridgeIt.fundooNotes.model.UserModel;




public class LoginRegisterImplMysqlDB implements UserDataBase {
	
	SessionFactory factory = HibernateUtil.getSessionFactory();
	
	List<UserModel> list = null;
    // create session
   

	public String addDataInDB(UserModel user) {
		// TODO Auto-generated method stub
		Session session = factory.getCurrentSession();
		try{
			session.save(user);
			session.getTransaction().commit();
			return UserConstants.sucessStatus;
		}
		
		catch (Exception e) {
			// TODO: handle exception
	         e.printStackTrace();
		}
		finally {
			
			session.close();
		}
		return null;
	}

	
	public String checkEmailId(String email) {
		// TODO Auto-generated method stub
		Session session = factory.getCurrentSession();
		try{
			session.beginTransaction();
			Query query=  session.createQuery("FROM com.bridgeIt.fundooNotes.model.UserModel where user_email = :email");
			query.setParameter("email", email);
		    list = query.getResultList();
		    System.out.println(list);
		    session.getTransaction().commit();
		    if(!list.isEmpty() && list.size()==1){
		    	return UserConstants.sucessStatus;
		    }
		    else{
		    	return UserConstants.failStatus;
		    }
		}
		
		catch (Exception e) {
			// TODO: handle exception
	         e.printStackTrace();
		}
		finally {
			//session.close();
		}
		return null;
	}

	
	public List<UserModel> getAllUserData() {
		// TODO Auto-generated method stub
		Session session = factory.getCurrentSession();
          try{
			
        	session.beginTransaction();
        	Query query=  session.createQuery("FROM com.bridgeIt.fundooNotes.model.UserModel");
        	list = query.getResultList();
			System.out.println("printing all the details"+list);
			session.getTransaction().commit();
			return list;
		}
		
		catch (Exception e) {
			// TODO: handle exception
	         e.printStackTrace();
		}
		finally {
			session.close();
		}
		return null;
	}

	
	public String loginValidation(String email, String passWord) {
		// TODO Auto-generated method stub
		
		try{
			String status = checkEmailId(email);
			if(status.equalsIgnoreCase("Sucess")){
			
				UserModel user = list.get(0);
			
				System.out.println("printing password: "+user.getrPassWord());
				
				if(passWord.equals(user.getrPassWord())){
					
					return UserConstants.sucessStatus;
				}
				else{
					return "Password is wrong";
				}
			}
			else{
				return "User is not Registered";
			}
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}
}
