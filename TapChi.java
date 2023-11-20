/**
 * 
 */
package lab9;

/**
 * @author hp
 *
 */
public class TapChi extends AnPham {
	private String tenTapChi;

	/**
	 * @param tieuDe
	 * @param soTrang
	 * @param namXuatBan
	 * @param tacGia
	 * @param giaTien
	 * @param tenTapChi
	 */
	public TapChi(String tieuDe, int soTrang, int namXuatBan, String tacGia, double giaTien, String tenTapChi) {
		super(tieuDe, soTrang, namXuatBan, tacGia, giaTien);
		this.tenTapChi = tenTapChi;
	}

	public boolean isPublishedTenYearsAgo(int year) {

		return year - namXuatBan == 10;
	}

	@Override
	protected int getLongestChapterPages() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String toString() {
		return "TapChi [tenTapChi=" + tenTapChi + "]";
	}

}
