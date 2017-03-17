package controller;

import java.sql.*;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.fabric.Response;
import com.mysql.jdbc.Connection;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	
	private static final String DB_IP = "25.74.14.85";
	private static final String DB_PORT = "3306";
	private static final String DB_NAME = "hr";
	private static final String DB_USERNAME = "zara";
	private static final String DB_PASSWORD = "123";
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
		} catch (ClassNotFoundException e) {
			resp.getWriter().append(e.getMessage());
		}
		
		try {
			java.sql.Connection con = DriverManager.getConnection("jdbc:mysql://25.74.14.85:3306/firstprojectdb",DB_USERNAME,DB_PASSWORD);
			Statement stmt = con.createStatement();
			
			ResultSet rs = stmt.executeQuery("");
		} catch (SQLException e) {
			resp.getWriter().append(e.getMessage());
		}
		
	}

}
