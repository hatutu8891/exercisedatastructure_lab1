/**
 * 
 */
package lab9;

import java.util.Comparator;

/**
 * TASK 2
 * @author hp
 *
 */
public abstract class AnPham {
	protected String tieuDe;
	protected int soTrang;
	protected int namXuatBan;
	protected String tacGia;
	protected double giaTien;

	/**
	 * @param tieuDe
	 * @param soTrang
	 * @param namXuatBan
	 * @param tacGia
	 * @param giaTien
	 */
	public AnPham(String tieuDe, int soTrang, int namXuatBan, String tacGia, double giaTien) {
		super();
		this.tieuDe = tieuDe;
		this.soTrang = soTrang;
		this.namXuatBan = namXuatBan;
		this.tacGia = tacGia;
		this.giaTien = giaTien;
	}


	public String getType() {
		if (this instanceof TapChi) {
			return "Tap Chi";
		} else if (this instanceof SachThamKhao) {
			return "Sach Tham Khao";
		} else {
			return "";
		}
	}

	public boolean isSameTypeAndAuthor(AnPham other) {

		return this.getType().equals(other.getType()) && this.tacGia.equals(other.tacGia);
	}

	protected abstract int getLongestChapterPages();



	
	public static class TitleComparator implements Comparator<AnPham>{
		@Override
		public int compare(AnPham o1, AnPham o2) {
			return o1.tieuDe.compareTo(o2.tieuDe);
		}
		
	}
	
	public static class YearComparator implements Comparator<AnPham>{

		@Override
		public int compare(AnPham o1, AnPham o2) {
			return o2.namXuatBan-o1.namXuatBan;
		}
		
	}

	@Override
	public String toString() {
		return "AnPham [tieuDe=" + tieuDe + ", soTrang=" + soTrang + ", namXuatBan=" + namXuatBan + ", tacGia=" + tacGia
				+ ", giaTien=" + giaTien + "]";
	}
	
}
