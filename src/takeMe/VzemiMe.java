package takeMe;

import java.util.Comparator;
import java.util.HashSet;
import java.util.TreeSet;

import onlineShop.Order;
import onlineShop.Product;
import users.User;

public class VzemiMe {
	
	private TreeSet<Product> productsByName;
	private TreeSet<User> users;
	private HashSet<Order> finishedOrders;
	
	public VzemiMe() {
		productsByName = new TreeSet<>(new Comparator<Product>() {
			@Override
			public int compare(Product o1, Product o2) {
				return o1.getName().compareTo(o2.getName());
			}
		});
		users = new TreeSet<>();
	}
	
	public void addOrder(Order o){
		
	}
	
	public void registerUser(User u){
		if(users.contains(u)){
			System.out.println("The user has a registration.");
			return;
		}
		users.add(u);
	}

	public void addFinishedOrder(Order o){
		if(o == null){
			return;
		}
		this.finishedOrders.add(o);
	}
}
