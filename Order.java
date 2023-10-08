/**
 * 
 */
package lab3;

/**
 * @author hp
 *
 */
public class Order {
	private OrderItem[] items;

	/**
	 * This is the constructor of class Order. The constructor have 3 input:
	 * 
	 * @param p
	 * @param quality
	 * @param items   
	 * Example:  
	 * Product p1 = new Product("ad01", "Coca Cola", 4.5, "Drink");
	 * Product p2 = new Product("ad02", "Twister", 4.5, "Drink");
	 * Product p3 = new Product("af01", "Slide", 3.0, "Food");
	 * Product p4 = new Product("af02", "Oishi", 2.5, "Food");
	 * Product p5 = new Product("at01", "Barbie", 10.25, "Toys");
	 * Product p6 = new Product("at02", "Scooter", 20.5, "Toys");
	 * 
	 * OrderItem i1 = new OrderItem(p1, 8);
	 * OrderItem i2 = new OrderItem(p2, 14);
	 * OrderItem i3 = new OrderItem(p3, 6);
	 * OrderItem i4 = new OrderItem(p4, 12);
	 * OrderItem i5 = new OrderItem(p5, 2);
	 * OrderItem i6 = new OrderItem(p6, 1);	
	 * 
	 * OrderItem[] its={i1,i2,i3,i4,i5,i6};
	 */

	public Order(OrderItem[] items) {
		super();
		this.items = items;
	}

	public double cost() {
		double totalCost = 0;
		for (int i = 0; i < items.length; i++) {
			totalCost += items[i].getP().getPrice() * items[i].getQuality();
		}
		return totalCost;
	}

	// using binary search approach
	public boolean contains(Product p) {
		int low = 0, mid = 0;
		int high = items.length - 1;
//		boolean result = false;

		while (low < high) {
			mid = (low + high) / 2;
			int comparison = p.getId().compareTo(items[mid].getP().getId());

			if (comparison == 0) {
				return true;
			} else if (comparison < 0) {
				high = mid - 1;
			} else {
				low = mid + 1;
			}
		}

		return false;
	}

	// get all products based on the given type using linear search
	public Product[] filter(String type) {
		int count = 0;
		for (int i = 0; i < items.length; i++) {
			String itemType = items[i].getP().getType();
			if (itemType.equals(type)) {
				count++;
			}
		}

		Product[] result = new Product[count];
		int index = 0;
		for (int i = 0; i < items.length; i++) {
			String itemType = items[i].getP().getType();
			if (itemType.equals(type)) {
				result[index] = items[i].getP();
				index++;
			}
		}

		return result;
	}

}
