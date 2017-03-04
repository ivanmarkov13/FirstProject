package onlineShop;

import users.User;

public class Product {
	
	private class Service {
		private String name;
		private double price;
		
		public Service(String name, double price) {
			//TODO validation
			this.name = name;
			this.price = price;
		}
	}
	
	private String name;
	private String description;
	private double price;
	private User owner;
	private Service bonusService;
	private int productNumber;
	private int quantity;
	
	public Product(String name, String description, double price, User owner, Service bonusService, int productNumber, int quantity) {
		//TODO validation
		this.name = name;
		this.description = description;
		this.price = price;
		this.owner = owner;
		this.bonusService = bonusService;
		this.productNumber = productNumber;
		this.quantity = quantity;
	}

	public double getPrice() {
		return price;
	}
	

}
