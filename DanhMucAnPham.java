/**
 * 
 */
package lab9;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * TASK 2
 * @author hp
 *
 */
public class DanhMucAnPham {
	private List<AnPham> dsAnPham;

	/**
	 * @param dsAnPham
	 */
	public DanhMucAnPham(List<AnPham> dsAnPham) {
		super();
		this.dsAnPham = dsAnPham;
	}

	public double calculateTotalPrice() {
		double totalPrice = 0;
		for (AnPham anPham : dsAnPham) {
			totalPrice += anPham.giaTien;
		}
		return totalPrice;
	}

	public AnPham findReferenceBookWithLongestChapter() {
		AnPham result = null;
		int maxChapterPages = 0;
		for (AnPham anPham : dsAnPham) {
			if (anPham.getType().equals("Sach Tham Khao")) {
				int chapterPages = anPham.getLongestChapterPages();
				if (chapterPages > maxChapterPages) {
					maxChapterPages = chapterPages;
					result = anPham;
				}
			}
		}
		return result;
	}

	public boolean containsMagazineWithTitle(String title) {
		for (AnPham anPham : dsAnPham) {
			if (anPham.getType().equals("Tap Chi")) {
				if (anPham.tieuDe.equalsIgnoreCase(title))
					;
				return true;
			}
		}
		return false;
	}

	public List<AnPham> getMagazinesPublishedInYear(int year) {
		List<AnPham> result = new ArrayList<>();
		for (AnPham anPham : dsAnPham) {
			if (anPham.getType().equals("Tap Chi")) {
				if (anPham.namXuatBan == year) {
					result.add(anPham);
				}
			}
		}
		return result;
	}

	public void sortBooksByTitle() {
		Collections.sort(dsAnPham, new AnPham.TitleComparator());
	}

	public void sortBooksByYear() {
		Collections.sort(dsAnPham, new AnPham.YearComparator());
	}

	public Map<Integer, Integer> countPublicationsByYear() {
		Map<Integer, Integer> result = new HashMap<>();
		for (AnPham anPham : dsAnPham) {
			int year = anPham.namXuatBan;
			result.put(year, result.getOrDefault(year, 0) + 1);
		}
		return result;
	}

	@Override
	public String toString() {
		return "DanhMucAnPham [dsAnPham=" + dsAnPham + "]";
	}
	
	
}
