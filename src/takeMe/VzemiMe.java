package takeMe;

import java.util.Comparator;
import java.util.HashSet;
import java.util.TreeSet;

import onlineShop.Order;
import onlineShop.Product;
import users.User;

public class VzemiMe {
	
	private TreeSet<Product> productsByName;
	private HashSet<User> users;
	//finished orders
	
	public VzemiMe() {
		productsByName = new TreeSet<>(new Comparator<Product>() {
			@Override
			public int compare(Product o1, Product o2) {
				return o1.getName().compareTo(o2.getName());
			}
		});
		users = new HashSet<>();
	}
	
	public void addOrder(Order o){
		
	}
	
	public void registrateUser(User u){
		if(users.contains(u)){
			System.out.println("The user has registration.");
			return;
		}
		users.add(u);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((users == null) ? 0 : users.hashCode());
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
		VzemiMe other = (VzemiMe) obj;
		if (users == null) {
			if (other.users != null)
				return false;
		} else if (!users.equals(other.users))
			return false;
		return true;
	}
	
	

}
