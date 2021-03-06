package controller;

import java.io.IOException;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import daoObjs.UserDAO;
import users.User;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect("index.jsp");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		if((Boolean) request.getSession().getAttribute("logged")){
//			User u = (User) request.getSession().getAttribute("user");
//			System.out.println(u.getEmail());
//			response.sendRedirect("wrongClickLogin.html");
//		}
		
		
//		else{
			String email = request.getParameter("email");
			String password = request.getParameter("password");
			if(UserDAO.getInstance().validLogin(email, password)){
				User u = UserDAO.getInstance().getAllUsers().get(email);
				HttpSession session = request.getSession();
				session.setAttribute("user", u);
				session.setMaxInactiveInterval(3000);
				session.setAttribute("logged", true);
				response.sendRedirect("profile.jsp");
			}
			else{
				response.sendRedirect("errorLogin.html");
			}
//		}
	}

}
