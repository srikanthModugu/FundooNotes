package com.bridgeit.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bridgeit.dao.UserDataBaseDAO;
import com.bridgeit.model.User;
import com.bridgeit.validation.RegisterValidator;



public class RegisterServlet extends HttpServlet {
	
	private RegisterValidator validate = null;
	private RequestDispatcher dispatcher = null;
	private String status;
	private String auth;
	UserDataBaseDAO dataBase = null;
	
    public RegisterServlet() {
        super();
        System.out.println("it is in the constructor of register");
    }


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		try{
			
		System.out.println("it is in the register page");
		dataBase = new UserDataBaseDAO();
		String email = request.getParameter("email");
		System.out.println("email"+email);
		String password = request.getParameter("password");
		User user = new User( email, password, request.getParameter("phnNo"));
		validate = new RegisterValidator();
	 status = validate.validateEmailId(email);
	 if(status.equalsIgnoreCase("sucess"))
	 {
		 status = validate.validatePassword(password);
		 auth = dataBase.authEmail(email);
		 if(status.equalsIgnoreCase("sucess"))
		 {	 System.out.println("baby1");
			 if(auth.equalsIgnoreCase("sucess"))
			 {
				 dataBase.addUser(user);
				 System.out.println("baby4");
				 response.sendRedirect("login");
			
			 }
			 else
			 {
				 System.out.println("baby3");
				 request.setAttribute("errorMsg", auth);
				 dispatcher = request.getRequestDispatcher("register"); 
				 dispatcher.forward(request, response);
				 
			 }
		 }
		 else
		 {
			 request.setAttribute("errorMsg", status);
			 dispatcher = request.getRequestDispatcher("register");
			 dispatcher.forward(request, response);
		 }
	 }
	 else
	 {
		 request.setAttribute("errorMsg", status);
		 dispatcher = request.getRequestDispatcher("register");
		 dispatcher.forward(request, response);
	 }	
	 System.out.println("printing staus"+status);
	 System.out.println(auth);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
}
