package daoObjs;

import java.sql.*;

public class DBManager {
		private static final String DB_IP = "localhost";
		private static final String DB_PORT = "3306";
		private static final String DB_NAME =  "firstprojectdb";
		private static final String DB_USER = "root";
//		private static final String DB_PASS = "dominos";
		private static final String DB_PASS = "summertime11";

		private static DBManager instance;
		
		private static Connection con;
		
		public static synchronized DBManager getInstance(){
			if(instance == null){
				instance = new DBManager();
			}
			return instance;
		}
		
		private DBManager(){
			try {
				Class.forName("com.mysql.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				System.out.println("oops " + e.getMessage());
			}
			try {
				con = DriverManager.getConnection("jdbc:mysql://"+ DB_IP +":" + DB_PORT + "/" + DB_NAME , DB_USER, DB_PASS);
			} catch (SQLException e) {
				System.out.println("oops " + e.getMessage());
			}
		}
	
		public Connection getConnection() {
			return con;
		}
	
		
}
