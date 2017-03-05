package onlineShop;

import java.util.Date;
import java.util.HashMap;

import users.User;

public class Order {
	
	private HashMap<Product, Integer> products;
	private Date date;
	private User user;
	private boolean isVerified;
	
	public Order(HashMap<Product, Integer> products, Date date, User user) {
		this.products = new HashMap<>();
		this.products = products;
		this.date = date;
		this.user = user;
		if(verifyOrder()){
			this.isVerified = true;
		}
	}
	
	public boolean verifyOrder(){
		//TODO sending an email
		return false;
	}
	

}
