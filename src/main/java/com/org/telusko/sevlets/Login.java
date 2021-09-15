package com.org.telusko.sevlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.org.telusko.dao.LoginDao;

/**
 * Servlet implementation class Application
 */
@WebServlet("/Login")
public class Login extends HttpServlet {       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name=request.getParameter("uname");
		System.out.println(name);
		String password=request.getParameter("password");
		System.out.println(password);
		LoginDao logindao=new LoginDao();
		 PrintWriter out = response.getWriter();  
		try {
			
			try {
				if(logindao.check(name, password))
				{
					HttpSession session= request.getSession();
					session.setAttribute("username", name);
					response.sendRedirect("welcome.jsp");
				}
				else
				{
					
					response.sendRedirect("login.jsp");
					
				}
			} catch (ClassNotFoundException | SQLException e) {
				
				e.printStackTrace();
			}
		}
		catch (IOException e) {
			
			e.printStackTrace();
		}

	}
}
