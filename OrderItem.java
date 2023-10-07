/**
 * 
 */
package lab3;

/**
 * @author hp
 *
 */
public class OrderItem implements Comparable<OrderItem> {
	private Product p;
	private int quality;

	/**
	 * This is the constructor of class OrderItem. The constructor have 2 input:
	 * 
	 * @param p
	 * @param quality
	 * 
	 * Example: 
	 * Product p1 = new Product("ad01", "Coca Cola", 4.5, "Drink");
	 * Product p2 = new Product("ad02", "Twister", 4.5, "Drink");
	 * Product p3 = new Product("af01", "Slide", 3.0, "Food");
	 * Product p4 = new Product("af02", "Oishi", 2.5, "Food");
	 * Product p5 = new Product("at01", "Barbie", 10.25, "Toys");
	 * Product p6 = new Product("at02", "Scooter", 20.5, "Toys");
     *
	 *	OrderItem i1 = new OrderItem(p1, 8);
	 *	OrderItem i2 = new OrderItem(p2, 14);
	 *	OrderItem i3 = new OrderItem(p3, 6);
	 *	OrderItem i4 = new OrderItem(p4, 12);
	 *	OrderItem i5 = new OrderItem(p5, 2);
	 *	OrderItem i6 = new OrderItem(p6, 1);
	 */
	public OrderItem(Product p, int quality) {
		super();
		this.p = p;
		this.quality = quality;
	}

	/**
	 * @return the quality
	 */
	public int getQuality() {
		return quality;
	}

	/**
	 * @param quality the quality to set
	 */
	public void setQuality(int quality) {
		this.quality = quality;
	}

	/**
	 * @return the p
	 */
	public Product getP() {
		return p;
	}

	/**
	 * @param p the p to set
	 */
	public void setP(Product p) {
		this.p = p;
	}

	@Override
	public int compareTo(OrderItem o) {
		return this.p.getId().compareTo(o.p.getId());
		
	}

	@Override
	public String toString() {
		return  p + ", " + quality + '\n';
	}
	

}
