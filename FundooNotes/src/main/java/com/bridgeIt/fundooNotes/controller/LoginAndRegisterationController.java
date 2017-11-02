package com.bridgeIt.fundooNotes.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bridgeIt.fundooNotes.services.*;
import com.bridgeIt.fundooNotes.Dao.LoginRegisterImplMysqlDB;
import com.bridgeIt.fundooNotes.model.UserModel;

/**
 * Servlet implementation class LoginAndRegisterationController
 */
public class LoginAndRegisterationController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	LoginRegisterImplMysqlDB database = new LoginRegisterImplMysqlDB();
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginAndRegisterationController(){
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String url = request.getRequestURL().toString();
		if (url.contains("Login.do")) {
			loginValidation(request, response);
		}
		if (url.contains("Registration.do")) {
			try {
				registerValidation(request, response);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	protected void loginValidation(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("welcome to login......");
		try {
			
			
			
		    LoginRegisterationServiceDB user = new LoginRegisterationServiceDB(database);
			System.out.println("Aobaaaa");
			String status = user.loginValidation(request.getParameter("lEmail"),request.getParameter("lPassWord"));
			System.out.println("Bobaaaa");
				if (status.equalsIgnoreCase("Sucess")){
					
					System.out.println("Cobaaaa");
					List<UserModel> userList = new ArrayList<UserModel>();
					
					System.out.println("Dobaaaa");
					userList = user.getAllUserData();
					
					System.out.println("Eobaaaa");
					request.setAttribute("user", userList);
					
					System.out.println("Fobaaaa");
					if(userList != null){
					request.setAttribute("lEmail",request.getParameter("lEmail"));
					RequestDispatcher requestDispatcher = request.getRequestDispatcher("HomePage.jsp");
					requestDispatcher.forward(request, response);
					System.out.println("Gobaaaa");
					}
					else{
						System.out.println("something wrong baby...");
					}
					
				}
				else{
					
					request.setAttribute("errorMesg", status);
					RequestDispatcher requestDispatcher = request.getRequestDispatcher("LoginView.jsp");
					requestDispatcher.forward(request, response);	
				}
			
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
	
		
	}

	protected void registerValidation(HttpServletRequest request, HttpServletResponse response) throws SQLException {
		System.out.println("welcome to register page......");

		UserModel rd = (UserModel) request.getAttribute("bean");

		String email = rd.getrEmail();
		System.out.println("the email:" + email);
		try {
			LoginRegisterationServiceDB user = new LoginRegisterationServiceDB(database);
			
			
			String 	status = user.checkEmailId(email);
            if(status.equalsIgnoreCase("fail")){
				 status = user.addDataInDB(rd);
				if (status.equalsIgnoreCase("Sucess")) {
					List<UserModel> userList = new ArrayList<UserModel>();

					userList = user.getAllUserData();

					if (userList != null) {
						request.setAttribute("lEmail", email);
						request.setAttribute("user", userList);
						RequestDispatcher requestDispatcher = request.getRequestDispatcher("HomePage.jsp");
						requestDispatcher.forward(request, response);
					}
					else{
						System.out.println("the data is empty");
					}
				}
				else{
					System.out.println("the value of status : "+status);
					System.out.println("some thing is going wrong....dady");
				}
			}
            else{
				request.setAttribute("errorMsg","Email is alredy Registered");
				RequestDispatcher requestDispatcher = request.getRequestDispatcher("RegisterView.jsp");
				requestDispatcher.forward(request, response);
			}
				
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
