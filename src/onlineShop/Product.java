package onlineShop;

import users.User;

public class Product {
	
	private class Service {
		private String name;
		private double price;
		
		public Service(String name, double price) {
			if(name != null && !name.isEmpty()){
				this.name = name;
			}
			if(price > 0){
				this.price = price;
			}
		}
	}
	
	private String name;
	private String description;
	private double price;
	private User owner;
	private Service bonusService;
	private int productNumber;
	private int quantity;
	
	public Product(String name, String description, double price, User owner, Service bonusService, int quantity) {
		if(name != null && !name.isEmpty()){
			this.name = name;
		}
		if(description != null && !description.isEmpty()){
			this.description = description;
		}
		if(price > 0){
			this.price = price;
		}
		this.owner = owner;
		this.bonusService = bonusService;
		if(quantity > 0){
			this.quantity = quantity;
		}
		productNumber++;
	}

	public double getPrice() {
		return price;
	}

	public int getQuantity() {
		return quantity;
	}
	
	

}
