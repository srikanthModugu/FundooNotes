package com.bridgeit.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bridgeit.dao.UserDataBaseDAO;



public class LoginServlet extends HttpServlet {

	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
	}
	private RequestDispatcher dispatcher = null;
	private String status;
	UserDataBaseDAO dataBase = null;
    public LoginServlet() {
        super();
        System.out.println("it is in the login constructor");
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("it is in login page");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		dataBase = new UserDataBaseDAO();
		System.out.println("password is printing "+password);
		status = dataBase.authUser(email, password);
		if(status.equalsIgnoreCase("sucess")){
			HttpSession session = request.getSession();
			session.setAttribute("email",email);
			response.sendRedirect("home");
		}
		else{
			 request.setAttribute("errorMesg", "Invalid credintal");
			 dispatcher = request.getRequestDispatcher("login");
			 dispatcher.forward(request, response);
		}
	}

}
