/**
 * 
 */
package lab3;

/**
 * @author hp
 *
 */
public class Product implements Comparable<Product> {
	private String id;
	private String name;
	private double price;
	private String type;

	/**
	 * This is the constructor of class Product. The constructor have 4 input:
	 * 
	 * @param id
	 * @param name
	 * @param price
	 * @param type
	 * 
	 * Example: 
	 * Product p1 = new Product("ad01", "Coca Cola", 4.5, "Drink");
	 * Product p2 = new Product("ad02", "Twister", 4.5, "Drink");
	 * Product p3 = new Product("af01", "Slide", 3.0, "Food");
	 * Product p4 = new Product("af02", "Oishi", 2.5, "Food");
	 * Product p5 = new Product("at01", "Barbie", 10.25, "Toys");
	 * Product p6 = new Product("at02", "Scooter", 20.5, "Toys");
	 * 
	 */
	public Product(String id, String name, double price, String type) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.type = type;
	}

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @return the price
	 */
	public double getPrice() {
		return price;
	}

	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	@Override
	public int compareTo(Product o) {
		int byName = this.name.compareTo(o.name);
		if (byName == 0) {
			return Double.compare(this.price, o.price);
		}

		return byName;
	}

	@Override
	public String toString() {
		return id + ", " + name + ", " + price + "$" + ", " + type;
	}

}
