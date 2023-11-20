/**
 * 
 */
package lab9;

/**
 * @author hp
 *
 */
public class ChuongSach {
	private String title;
	private int soTrang;
	/**
	 * @param title
	 * @param soTrang
	 */
	public ChuongSach(String title, int soTrang) {
		super();
		this.title = title;
		this.soTrang = soTrang;
	}
	/**
	 * @return the soTrang
	 */
	public int getSoTrang() {
		return soTrang;
	}
	@Override
	public String toString() {
		return "[" + title + ", " + soTrang + "]";
	}
	
	

}
