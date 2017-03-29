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

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect("index.html");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		if(UserDAO.getInstance().validLogin(email, password)){
			HttpSession session = request.getSession();
			session.setAttribute("username", email);
			session.setAttribute("logged", true);
			//TODO profile page .html
			response.sendRedirect("profile.html");
		}
		else{
			//TODO error page
			response.sendRedirect("regis.html");
		}
	}

}
