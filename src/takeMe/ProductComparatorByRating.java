package takeMe;

import java.util.Comparator;

import onlineShop.Product;

public class ProductComparatorByRating implements Comparator<Product>{

	@Override
	public int compare(Product o1, Product o2) {
		if(o1.getRating() == o2.getRating()){
			return o2.getProductNumber() - o1.getProductNumber();
		}
		return o2.getRating() - o1.getRating(); 
	}

}
