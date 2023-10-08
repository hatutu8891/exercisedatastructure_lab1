/**
 * 
 */
package lab3;

import java.util.Arrays;

/**
 * @author hp
 *
 */
public class TestOrder {
	public static void main(String[] args) {
		Product p1 = new Product("ad01", "Coca Cola", 4.5, "Drink");
		Product p2 = new Product("ad02", "Twister", 4.5, "Drink");
		Product p3 = new Product("af01", "Slide", 3.0, "Food");
		Product p4 = new Product("af02", "Oishi", 2.5, "Food");
		Product p5 = new Product("at01", "Barbie", 10.25, "Toys");
		Product p6 = new Product("at02", "Scooter", 20.5, "Toys");

		OrderItem i1 = new OrderItem(p1, 8);
		OrderItem i2 = new OrderItem(p2, 14);
		OrderItem i3 = new OrderItem(p3, 6);
		OrderItem i4 = new OrderItem(p4, 12);
		OrderItem i5 = new OrderItem(p5, 2);
		OrderItem i6 = new OrderItem(p6, 1);

		OrderItem[] its = { i1, i2, i3, i4, i5, i6 };
		Order or1 = new Order(its);
		Arrays.sort(its);
		System.out.println(Arrays.toString(its));

		System.out.println("The total price of your invoice is: " + or1.cost() + '\n');

		System.out.println("Product " + p1.getName() + " is contains in invoice is: " + or1.contains(p1) + '\n');
		String typeOfProduct = "Drink";
		System.out.println("Information of products that type is " + '\"' + typeOfProduct + '\"'
				+ " in the invoice are: " + '\n' + Arrays.toString(or1.filter(typeOfProduct)));

	}

}
