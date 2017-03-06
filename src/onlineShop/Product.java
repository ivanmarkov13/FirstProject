package onlineShop;

import java.util.ArrayList;
import java.util.HashSet;

import users.User;

public class Product {
	public enum ProductCategory{BEAUTY, SPA, RELAX, FOOD, ADVENTURE, SECOND_HAND, BRAND_NEW};
	
	private class Service {
		private String name;
		private double price;
		
		private Service(String name, double price) {
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
	private static int productNumberGenerator = 1;
	private int quantity;
	private HashSet<ProductCategory> categories;
	private int rating;
	
	public Product(String name, String description, double price, User owner, Service bonusService, int quantity, int rating) {
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
		if(rating > 0){
			this.rating = rating;
		}
		this.productNumber = productNumberGenerator++;
	}
	
	public void addCategory(ProductCategory category){
		if(category == null){
			return;
		}
		this.categories.add(category);
	}

	public double getPrice() {
		return price;
	}

	public int getQuantity() {
		return quantity;
	}

	public String getName() {
		return name;
	}

	public int getRating() {
		return rating;
	}

	public int getProductNumber() {
		return productNumber;
	}

	public HashSet<ProductCategory> getCategories() {
		return categories;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + productNumber;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		if (productNumber != other.productNumber)
			return false;
		return true;
	}
	


}
