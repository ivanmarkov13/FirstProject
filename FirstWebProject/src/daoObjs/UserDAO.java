package daoObjs;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.HashMap;

import com.mysql.jdbc.Statement;

import users.User;

public class UserDAO {
	
	private static UserDAO instance;
	private static final HashMap<String, User> allUsers = new HashMap<>();
	
	private UserDAO(){
		
	}
	
	public static synchronized UserDAO getInstance(){
		if(instance == null){
			instance = new UserDAO();
		}
		return instance;
	}
	
	public synchronized void addUser(User u){
		//TODO insert into db
		String sql = "INSERT INTO users (username, password, name, birthdate, email, phonenumber, money) values (?, ?, ?, ?, ?, ?, ?)";
		PreparedStatement st;
		try {
			st = DBManager.getInstance().getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			st.setString(1, u.getUsername());
			st.setString(2, u.getPassword());
			st.setString(3, u.getName());
			st.setDate(4, Date.valueOf(u.getBirthDate()));
			st.setString(5, u.getEmail());
			st.setString(6, u.getPhoneNumber());
			st.setDouble(7, u.getMoney());
			st.execute();
			ResultSet res = st.getGeneratedKeys();
			res.next();
			long user_id = res.getLong(1);
			u.setUserId(user_id);
		} catch (SQLException e) {
//			System.out.println("addUser: " + e.getMessage());
			e.printStackTrace();
		}
		allUsers.put(u.getUsername(), u);
	}
	
	public HashMap<String, User> getAllUsers(){
		if(allUsers.isEmpty()){
			String sql = "SELECT id, username, password, name, birthDate, email, phonenumber, money;";
			PreparedStatement st;
			try {
				st = DBManager.getInstance().getConnection().prepareStatement(sql);
				ResultSet res = st.executeQuery();
				while(res.next()){
					String username = res.getString("username");
					String pass = res.getString("password");
					String name = res.getString("name");
					LocalDate date = res.getDate("birthdate").toLocalDate();
					String email = res.getString("email");
					Double money = res.getDouble("money");
					String phoneNum = res.getString("phonenumber");
					User u = new User(username, pass, name, date, email, phoneNum, money);
					u.setUserId(res.getLong("user_id"));
					allUsers.put(u.getUsername(), u);
				}
			} catch (SQLException e) {
				System.out.println("getUsers: " + e.getMessage());
			}
		}
		return allUsers;
	}
	
	public synchronized boolean validLogin(String user, String pass){
		if(getAllUsers().containsKey(user)){
			return getAllUsers().get(user).getPassword().equals(pass);
		}
		return false;
	}
	
}
