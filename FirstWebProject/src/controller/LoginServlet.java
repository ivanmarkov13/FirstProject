package controller;

import java.io.IOException;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	

	private static final String DB_IP = "127.0.0.1";
	private static final String DB_PORT = "3306";
	private static final String DB_NAME = "hr";
	private static final String DB_USERNAME = "root";
	private static final String DB_PASSWORD = "dominos";


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		try {	
			String driverName = "oracle.jdbc.driver.OracleDriver";
			try {
				Class.forName("com.mysql.jdbc.Driver").newInstance();
			} catch (InstantiationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
//			Class.forName(driverName);
			
		} catch (ClassNotFoundException e) {
			response.getWriter().append("Problem with db driver" + e.getMessage());
		} 
		
		
//		Connection con Connection con = DriverManager. DriverManager.
//				GetConnection(“ GetConnection(“jdbc:mysql://localhost:3306/MyDat jdbc:mysql://localhost:3306/MyDat
//				abase“, “root“, “root“ abase“, “root“, “root“);
		
		Connection con = null;
		Statement stmt = null;
		ResultSet set = null;
		try {
//			con = DriverManager.getConnection("jdbc:mysql://" + DB_IP + ":" + DB_PORT + "/" + DB_NAME, DB_USERNAME, DB_PASSWORD);
			
//			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hr", "root", "dominos");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hr?autoconnect=true&useSSL=false", "root", "dominos");
			
			stmt = con.createStatement();
			
			String query = "select first_name from employees";
			set = stmt.executeQuery(query);
			
			while(set.next()){
				String name = set.getString("first_name");
				response.getWriter().append(name);
			}
		} catch (SQLException e) {
			System.out.println("Connection with DB gone wrong " );
			e.printStackTrace();
		}
		finally{
			try {
				con.close();
				stmt.close();
				set.close();
			} catch (SQLException e) {
				System.out.println("not closed");
			}
			
		}
	
	
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println("Problem with db driver" + e.getMessage());
		} 
		
		
//		Connection con Connection con = DriverManager. DriverManager.
//				GetConnection(“ GetConnection(“jdbc:mysql://localhost:3306/MyDat jdbc:mysql://localhost:3306/MyDat
//				abase“, “root“, “root“ abase“, “root“, “root“);
		
		Connection con = null;
		Statement stmt = null;
		ResultSet set = null;
		try {
			con = DriverManager.getConnection("jdbc:mysql://" + DB_IP + ":" + DB_PORT + "/" + DB_NAME, DB_USERNAME, DB_PASSWORD);
			
			stmt = con.createStatement();
			
			String query = "select first_name from employees";
			set = stmt.executeQuery(query);
			
			while(set.next()){
				String name = set.getString("first_name");
				response.getWriter().append(name);
			}
		} catch (SQLException e) {
			System.out.println("Connection with DB gone wrong " + e.getMessage());
		}
		finally{
			try {
				con.close();
				stmt.close();
				set.close();
			} catch (SQLException e) {
				System.out.println("not closed");
			}
			
		}
	
	}

}
