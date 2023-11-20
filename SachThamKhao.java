/**
 * 
 */
package lab9;

import java.util.List;

/**
 * @author hp
 *
 */
public class SachThamKhao extends AnPham{
	private String linhVuc;
	private List<ChuongSach> dsChuongSach;
	/**
	 * @param tieuDe
	 * @param soTrang
	 * @param namXuatBan
	 * @param tacGia
	 * @param giaTien
	 * @param linhVuc
	 * @param dsChuongSach
	 */
	public SachThamKhao(String tieuDe, int soTrang, int namXuatBan, String tacGia, double giaTien, String linhVuc,
			List<ChuongSach> dsChuongSach) {
		super(tieuDe, soTrang, namXuatBan, tacGia, giaTien);
		this.linhVuc = linhVuc;
		this.dsChuongSach = dsChuongSach;
	}
	/**
	 * @return the linhVuc
	 */
	public String getLinhVuc() {
		return linhVuc;
	}
	/**
	 * @return the dsChuongSach
	 */
	public List<ChuongSach> getDsChuongSach() {
		return dsChuongSach;
	}
	
	public int getLongestChapterPages() {
		int result =0;
		for (ChuongSach chuongSach : dsChuongSach) {
			if(chuongSach.getSoTrang()>result) {
				result=chuongSach.getSoTrang();
			}
		}
		return result;
	}
	@Override
	public String toString() {
		return "SachThamKhao [" + linhVuc +", " + dsChuongSach + "]";
	}

}
