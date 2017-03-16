package takeMe;

import java.util.Comparator;

import onlineShop.Product;

public class ProductComparatorByName implements Comparator<Product>, IProductComparator{

	@Override
	public int compare(Product o1, Product o2) {
		if(o1.getName().equals(o2.getName())){
			return o2.getProductNumber() - o1.getProductNumber();
		}
		return o1.getName().compareTo(o2.getName());
	}

}
