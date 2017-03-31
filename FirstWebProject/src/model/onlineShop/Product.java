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
	private int owner_id;
	private int service_id;
	private long product_id;
	private static int productNumberGenerator = 1;
	private int quantity;
	private ProductCategory category;
	private int soldPieces;


	public Product(String name, String description, double price, int quantity, int owner_id, ProductCategory category) {
		if(name != null && !name.isEmpty()){
			this.name = name;
		}
		if(description != null && !description.isEmpty()){
			this.description = description;
		}
		if(price > 0){
			this.price = price;
		}
		if(quantity > 0){
			this.quantity = quantity;
		}
		if(owner_id > 0){
			this.owner_id = owner_id;
		}
		if(category != null){
			this.category = category;
		}
		this.soldPieces = 0;
		
	}
	
	public void setProduct_id(long product_id) {
		if(product_id < 1){
			return;
		}
		this.product_id = product_id;
	}
	
	public void setCategory(ProductCategory category) {
		if(category == null){
			return;
		}
		this.category = category;
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


	public long getProduct_id() {
		return product_id;
	}

	public ProductCategory getCategory() {
		return category;
	}

	

	public String getDescription() {
		return description;
	}
	
	
	public int getOwner_id() {
		return owner_id;
	}
	
	
	public int getService_id() {
		return service_id;
	}
	
	public void incrementSoldPieces() {
		this.soldPieces++;
	}

	public void setSoldPieces(int sold_pieces) {
		this.soldPieces = sold_pieces;
	}
}
