package daoObjs;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;

import onlineShop.Product;
import onlineShop.Product.ProductCategory;
import users.User;

public class ProductDAO {
	private static ProductDAO instance;
	private static final HashMap<Long, Product> allProducts = new HashMap<>();
	
	
	private ProductDAO() {
		
	}
	
	
	public synchronized static ProductDAO getInstance(){
		if(instance == null){
			instance = new ProductDAO();
		}
		return instance;
	}
	
	
	
	public synchronized void addProduct(Product p, User u){
		String sql = "INSERT INTO products (name, description, price, quantity, owner_id, soldpieces, category) values (?, ?, ?, ?, ?, ?, ?)";
		PreparedStatement st = null;
		ResultSet res = null;
		try {
			st = DBManager.getInstance().getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			
			st.setString(1, p.getName());
			st.setString(2, p.getDescription());
			st.setDouble(3, p.getPrice());
			st.setInt(4, p.getQuantity());
			st.setInt(5, p.getOwner_id());
			st.setInt(6, 0);
			st.setString(7, p.getCategory().name());
			st.execute();
			
			res = st.getGeneratedKeys();
			res.next();
			long id = res.getLong(1);
			p.setProduct_id(id);
			allProducts.put(id, p);
			
			u.addPersonalProduct(p);
			
		} catch (SQLException e) {
			System.out.println("oops " + e.getMessage());
		}
		finally {
			try{
				if(st != null){
					st.close();
				}
				if(res != null){
					res.close();
				}
			}
			catch (SQLException e) {
				System.out.println("oops " + e.getMessage());
			}
		}
		
		
		
	}
	
	
	public HashMap<Long, Product> getAllProducts(){
		if(allProducts.isEmpty()){
			String sql = "SELECT * FROM products";
			PreparedStatement st = null;
			ResultSet set = null;
			try {
				st = DBManager.getInstance().getConnection().prepareStatement(sql);
				set = st.executeQuery();
				
				while(set.next()){
					
					long product_id = set.getInt("product_id");
					String product_name = set.getString("name");
					String description = set.getString("description");
					double price = set.getDouble("price");
					int quantity = set.getInt("quantity");
					int owner_id = set.getInt("owner_id");
					int sold_pieces = set.getInt("soldpieces");
					ProductCategory category = ProductCategory.valueOf(set.getString("category"));
					
					Product p = new Product(product_name, description, price, quantity, owner_id, category);
					p.setProduct_id(product_id);
					p.setSoldPieces(sold_pieces);
					
					allProducts.put(product_id, p);
				}
			} catch (SQLException e) {
				System.out.println("oops " + e.getMessage());
			}
			finally {
				try{
					if(st != null){
						st.close();
					}
					if(set != null){
						set.close();
					}
				}
				catch (SQLException e) {
					System.out.println("oops " + e.getMessage());
				}
			}
			
		}
		
		return allProducts;
	}
	
}
