/**
 * 
 */
package lab3;

/**
 * @author hp
 *
 */
public class Order extends OrderItem {
	private OrderItem[] items;

	/**
	 * This is the constructor of class Order. The constructor have 3 input:
	 * @param p
	 * @param quality
	 * @param items
	 * Example:
	 * Product p1 = new Product ("ad01","Coca Cola",4.5,"Drink");
	 * Product p2 = new Product ("ad02","Twister",4.5,"Drink");
	 * Product p3 = new Product ("af01","Slide",3.0,"Food");
	 * Product p4 = new Product ("af02","Oishi",2.5,"Food");
	 * Product p5 = new Product ("at01","Barbie",10.25,"Toys");
	 * Product p6 = new Product ("at02","Scooter",20.5,"Toys");
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
	
	public Order(Product p, int quality, OrderItem[] items) {
		super(p, quality);
		this.items = items;
	}
	
	public double cost() {
		double totalCost = 0;
		for (int i = 0; i < items.length; i++) {
			totalCost += items[i].getP().getPrice() * items[i].getQuality();
		}
		return totalCost;
	}

	
	

	//using binary search approach
	public boolean contains(Product p) {
//		String name = p.getName();
//		int temp = 0;
//		int low = 0, mid = 0;
//		int high = items.length - 1;
//		for (int i = 1; i < items.length; i++) {
//			for (int j = 0; j < i; j++) {
//				if (items[i] < items[j]) {
//					temp = items[i];
//					items[i] = items[j];
//					items[j] = temp;
//				}
//			}
//		
			
		

		return false;
	}

	// get all products based on the given type using linear search
	public Product[] filter(String type) {

		return null;
	}

}
