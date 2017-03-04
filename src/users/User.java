package users;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.HashSet;

import onlineShop.Order;
import onlineShop.Product;

public class User {
	
	
	private class Cart {
		private HashMap<Product, Integer> products;
		private double cartPrice;
		
		private Cart(){
			this.products = new HashMap<>();
			this.cartPrice = 0;
		}
		
		private void addProduct(Product p){
			if(p == null){
				return;
			}
			
			int quantity = 0;
			
			if(!this.products.containsKey(p)){
				quantity = 1;
			}
			else{
				quantity = this.products.get(p) + 1;
			}
			
			this.products.put(p, quantity);
			this.cartPrice += p.getPrice();
			
		}
		
		private void removeProduct(Product p){
			if(this.products.containsKey(p)){
				this.products.remove(p);
			}
		}
	}
	
	private String username;
	private String password;
	private String name;
	private LocalDate birthDate;
	private String email;
	private String phoneNumber;
	
	private HashSet<Product> products;
	private HashSet<Product> soldProducts;
	private HashSet<Order> finishedOrders;
	private Cart shoppingCart;
	private double money;
	private HashSet<Product> favouriteProducts;
	private int rating;
	
	
	
	public User(String username, String password, String name, LocalDate birthDate, String email, String phoneNumber, double money) {
		//TODO validation for User constructor
		this.username = username;
		this.password = password;
		this.name = name;
		this.birthDate = birthDate;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.money = money;
		this.rating = 0;
		
		this.products = new HashSet<>();
		this.soldProducts = new HashSet<>();
		this.finishedOrders = new HashSet<>();
		this.shoppingCart = new Cart();
		this.favouriteProducts = new HashSet<>();
	}



	public void addToCart(Product p){
		if(p == null){
			return;
		}
		
		this.shoppingCart.addProduct(p);
	}
	
	
	
}
