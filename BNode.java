/**
 * 
 */
package lab11;

/**
 * @author hp
 *
 */
public class BNode<E extends Comparable<E>> {
	private E data;
	private BNode<E>left;
	private BNode<E>right;
	
	public BNode(E data) {
		this.data=data;
		this.left=null;
		this.right=null;
		
	}

	/**
	 * @param data
	 * @param left
	 * @param right
	 */
	public BNode(E data, BNode<E> left, BNode<E> right) {
		super();
		this.data = data;
		this.left = left;
		this.right = right;
	}

	/**
	 * @return the left
	 */
	public BNode<E> getLeft() {
		return left;
	}

	/**
	 * @param left the left to set
	 */
	public void setLeft(BNode<E> left) {
		this.left = left;
	}

	/**
	 * @return the right
	 */
	public BNode<E> getRight() {
		return right;
	}

	/**
	 * @param right the right to set
	 */
	public void setRight(BNode<E> right) {
		this.right = right;
	}

	/**
	 * @return the data
	 */
	public E getData() {
		return data;
	}

	@Override
	public String toString() {
		return "BNode [data=" + data + ", left=" + left + ", right=" + right + "]";
	}

	
	
	

}
