package com.bridgeit.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginFilter implements Filter {
	private RequestDispatcher dispatcher = null;

	/**
	 * Default constructor.
	 */
	public LoginFilter() {
		// TODO Auto-generated constructor stub
		System.out.println("in filter");
	}

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here
		String email = null;
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		HttpSession session = req.getSession(false);
		// System.out.println("hai...."+session);

		try {

			if (session != null) {
				chain.doFilter(req, res);
			} else {

				req.setAttribute("errorMesg", "Session Exprie");
				//RequestDispatcher dispatcher = req.getRequestDispatcher("login");
				//dispatcher.forward(req, res);
				res.sendRedirect("login");
			}
		} catch (NullPointerException e) {
			e.printStackTrace();
		}
		/*
		 * if(email != null) { System.out.println("session  email is there");
		 * res.sendRedirect("home"); } else {
		 * if(req.getRequestURL().toString().contains("register")){
		 * chain.doFilter(req, res); } else{ res.sendRedirect("login"); } } }
		 * else { System.out.println("session is null");
		 * res.sendRedirect("login"); } }
		 * 
		 * catch (NullPointerException e) { e.printStackTrace(); }
		 */

	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
		System.out.println("the filter init method");

	}

}
