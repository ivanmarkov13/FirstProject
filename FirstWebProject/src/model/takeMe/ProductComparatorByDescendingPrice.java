package takeMe;

import java.util.Comparator;

import onlineShop.Product;

public class ProductComparatorByDescendingPrice implements Comparator<Product>, IProductComparator{

	@Override
	public int compare(Product o1, Product o2) {
		if(o1.getPrice() == o2.getPrice()){
//			return o2.getProductNumber() - o1.getProductNumber();
		}
		if(o1.getPrice() > o2.getPrice()){
			return -1;
		}
		return 1;
	}

}
