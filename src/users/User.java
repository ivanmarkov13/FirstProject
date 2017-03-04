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
		
		//TODO remove product
		//TODO make order?
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
		String usernameValidation = "^[a-z0-9_-]{3,15}$";
		if(username.matches(usernameValidation)){
			this.username = username;
		}
		else{
			System.out.println("Invalid username!");
		}
		
		String passValid = "(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*?[0-9])(?=\\S+$).{5,}";
		if(password.matches(passValid)){
			this.password = password;
		}
		else{
			System.out.println("The password must have at least 5 symbols, at least one lower case, at least one upper case and at least one number.");
		}
	
		String nameValid = "^[\\p{L} .'-]+$";
		if(name.matches(nameValid)){
			this.name = name;
		}	
		else{
			System.out.println("Invalid name!");
		}
		
		this.birthDate = birthDate;
		
		String mailValid = "^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$";
		if(email.matches(mailValid)){
			this.email = email;
		}
		
		String phoneValid = "^08[7-9][0-9]{7}$";
		if(phoneNumber.matches(phoneValid)){
			this.phoneNumber = phoneNumber;
		}
		
		if(money > 0){
			this.money = money;
		}
		
		if(rating >= 0 && rating <= 100){
			this.rating = 0;
		}
		
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
	
	public void removeFromCart(Product p){
		//TODO if exists in cart -> remove
	}
	
}

