package onlineShop;

import java.time.LocalDate;
import java.util.HashMap;

import users.User;

public class Order {
	 private HashMap<Product, Integer> products;
	 private LocalDate date;
	 private double price;
	 private User user;
	 private int orderNumber;
	 private static int orderNumberGenerator;
	 
	 public Order(HashMap<Product, Integer> products, double price, User user){
		 if(products == null || price < 0 || user == null){
			 return;
		 }
		 this.date = LocalDate.now();
		 
		 this.products = products;
		 this.price = price;
		 this.user = user;
		 this.orderNumber = orderNumberGenerator++;
	 }
}
