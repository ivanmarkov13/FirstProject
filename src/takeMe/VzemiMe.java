package takeMe;

import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map.Entry;
import java.util.TreeSet;

import onlineShop.Order;
import onlineShop.Product;
import onlineShop.Product.ProductCategory;
import users.User;

public class VzemiMe {
	
	
	
//	private TreeSet<Product> productsByName;
	private HashMap<ProductCategory, TreeSet<Product>> products;
	private TreeSet<User> users;
	private HashSet<Order> finishedOrders;
	private VzemiMe instance;
	
	private VzemiMe() {
		
//		productsByName = new TreeSet<>(new Comparator<Product>() {
//			@Override
//			public int compare(Product o1, Product o2) {
//				return o1.getName().compareTo(o2.getName());
//			}
//		});
		
		this.products = new  HashMap<>();
		ProductComparatorByRating comp = new ProductComparatorByRating();
		this.products.put(ProductCategory.BEAUTY, new TreeSet<>(comp));
		this.products.put(ProductCategory.SPA, new TreeSet<>(comp));
		this.products.put(ProductCategory.RELAX, new TreeSet<>(comp));
		this.products.put(ProductCategory.FOOD, new TreeSet<>(comp));
		this.products.put(ProductCategory.ADVENTURE, new TreeSet<>(comp));
		this.products.put(ProductCategory.SECOND_HAND, new TreeSet<>(comp));
		this.products.put(ProductCategory.BRAND_NEW, new TreeSet<>(comp));
		
		this.users = new TreeSet<>(new Comparator<User>() {

			@Override
			public int compare(User o1, User o2) {
				return o1.getUsername().compareTo(o2.getUsername());
			}
			
		});
		
		this.finishedOrders = new HashSet<>();
	}
	
	public VzemiMe getInstance(){
		if(this.instance == null){
			this.instance = new VzemiMe();
		}
		return this.instance;
	}
	
	public void addOrder(Order o){
		
	}
	
	public void registerUser(User u){
		if(users.contains(u)){
			System.out.println("The user already has a registration.");
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
	
	
	public void addProduct(Product p){
		if(p == null){
			return;
		}
		
		HashSet<ProductCategory> categories = p.getCategories();
		
		for (ProductCategory productCategory : categories) {
			this.products.get(productCategory).add(p);
		}
		
		
	}
	
	private void putProductsInSortedCollection(TreeSet<Product> sortedProducts){
		for (Entry<ProductCategory, TreeSet<Product>> e : this.products.entrySet()) {
			for (Product product : e.getValue()) {
				sortedProducts.add(product);
			}
		}
	}
	
	public void showAllProductsByRating(){
		TreeSet<Product> sortedProducts = new TreeSet<>(new ProductComparatorByRating());
		
		putProductsInSortedCollection(sortedProducts);
		
		//TODO print sortedProducts
	}
	

	public void showAllProductsByName(){
		TreeSet<Product> sortedProducts = new TreeSet<>(new ProductComparatorByName());

		putProductsInSortedCollection(sortedProducts);
		
		//TODO print sortedProducts

	}
	
	public void showAllProductsByAscendingPrice(){
		TreeSet<Product> sortedProducts = new TreeSet<>(new ProductComparatorByAscendingPrice());
		
		putProductsInSortedCollection(sortedProducts);
		
		//TODO print sortedProducts

	}
	
	public void showAllProductsDescendingPrice(){
		TreeSet<Product> sortedProducts = new TreeSet<>(new ProductComparatorByDescendingPrice());

		putProductsInSortedCollection(sortedProducts);
		
		//TODO print sortedProducts
	}
}
