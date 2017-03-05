package onlineShop;

import java.time.LocalDate;
import java.util.Date;
import java.util.HashMap;

import users.User;

public class Order {
	
	private HashMap<Product, Integer> products;
	private LocalDate date;
	private double price;
	private User user;
	private int orderNumber;
	private static int orderNumberGenerator;
	private boolean isVerified;
	 
	public Order(HashMap<Product, Integer> products, double price, User user){
		if(products != null || price >= 0 || user != null){
			this.date = LocalDate.now();
			 
			 this.products = products;
			 this.price = price;
			 this.user = user;
			 this.orderNumber = orderNumberGenerator++;
			 if(verifyOrder()){
					this.isVerified = true;
				}
		 }
		 
	 }
	
	
	public boolean verifyOrder(){
		//TODO sending an email and return true
		return false;
	}
	

}
