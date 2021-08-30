package com.Servlet;
import java.io.IOException;
import javax.servlet.annotation.WebServlet;
import java.io.PrintWriter;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.sql.Connection;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.DAO.UserDAO;
import com.Db.DBConnect;
import com.User.UserDetails;
import java.sql.Connection;
@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet {
	

	public void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException,IOException
	{
		String name=request.getParameter("fname");
		String email=request.getParameter("uemail");
		String password=request.getParameter("upassword");
		
		UserDetails us=new UserDetails();
		us.setName(name);
		us.setEmail(email);
		us.setPassword(password);
		
		
		
		
		   try {
	     
			UserDAO dao = new UserDAO(DBConnect.getConn());
			
			boolean f=dao.addUser(us);
			PrintWriter out=response.getWriter();

			
			if(f)
			{
				
			HttpSession session=request.getSession();
			session.setAttribute("reg-success","Registration Successfull");
			response.sendRedirect("register.jsp");
			}
			
			else
			{
				HttpSession session=request.getSession();
				session.setAttribute("failed-msg","Something went wrong on server");
				response.sendRedirect("register.jsp");
			}
		   }catch(Exception e)
		   {
			   e.printStackTrace();
		   }
		
		
	}
	}
		



