/**
 * 
 */
package lab9;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hp
 *
 */
public class TestDanhMucAnPham {
	public static void main(String[] args) {
		ChuongSach c1 = new ChuongSach("May tinh", 20);
		ChuongSach c2 = new ChuongSach("CPU", 33);
		ChuongSach c3 = new ChuongSach("Window", 47);
		ChuongSach c4 = new ChuongSach("Phan mem may tinh", 27);
		ChuongSach c5 = new ChuongSach("Linux", 53);
		ChuongSach c6 = new ChuongSach("Centos7", 15);
		
		ChuongSach c7 = new ChuongSach("Array", 53);
		ChuongSach c8 = new ChuongSach("Recursion", 53);
		ChuongSach c9 = new ChuongSach("Algorthims and 2D Array", 153);
		ChuongSach c10 = new ChuongSach("List", 95);
		ChuongSach c11= new ChuongSach("Set", 98);
		ChuongSach c12= new ChuongSach("Map", 80);
		ChuongSach c13= new ChuongSach("Stack and Queue", 96);
		
		ChuongSach c14= new ChuongSach("Giai tich", 135);
		ChuongSach c15= new ChuongSach("Hinh hoc", 112);
		ChuongSach c16= new ChuongSach("De thi", 96);

		List<ChuongSach> lc1 = new ArrayList<>();
		lc1.add(c1);
		lc1.add(c2);
		lc1.add(c3);
		lc1.add(c4);
		lc1.add(c5);
		lc1.add(c6);
		
		List<ChuongSach> lc2 = new ArrayList<>();
		lc2.add(c7);
		lc2.add(c8);
		lc2.add(c9);
		lc2.add(c10);
		lc2.add(c11);
		lc2.add(c12);
		lc2.add(c13);
		
		List<ChuongSach> lc3 = new ArrayList<>();
		lc3.add(c14);
		lc3.add(c15);
		lc3.add(c16);
		

		AnPham t1 = new TapChi("Qua cua be", 97, 2022, "Huong Mai", 35.5, "Me va Be");
		AnPham t2 = new SachThamKhao("Nhap mon he dieu hanh", 198, 2005, "Ta Tran Nhu", 54, "Khoa hoc may tinh", lc1);
		AnPham t3 = new TapChi("Ha Noi nhung mua hoa", 102, 2019, "Van Anh", 25.75, "Thu do");
		AnPham t4 = new TapChi("Tap khi cong song 100 tuoi", 64, 2022, "Hoang Van Nhan", 30, "Suc khoe");
		AnPham t5 = new TapChi("Khu vuon thanh xuan", 55, 2023, "Minh Tuong",7.9, "Muc Tim");
		AnPham t6 = new SachThamKhao("Cau truc du lieu", 630, 2005, "Ta Tran Nhu", 74, "Khoa hoc may tinh", lc2);
		AnPham t7 = new SachThamKhao("On thi THPTQG", 346, 2001, "Hoang Xuan Sinh", 25.5, "Toan hoc", lc3);
		
		List<AnPham> lib = new ArrayList<>();
		lib.add(t1);
		lib.add(t2);
		lib.add(t3);
		lib.add(t4);
		lib.add(t5);
		lib.add(t6);
		lib.add(t7);
		
		//This is the testcase of method getType
		System.out.println(t2.getType());
		
		//This is the testcase of method isSameTypeAndAuthor
		System.out.println(t2.isSameTypeAndAuthor(t6));
		System.out.println(t2.isSameTypeAndAuthor(t7));
		
		DanhMucAnPham dsAnPham=new DanhMucAnPham(lib);
		//This is the testcase of method calculateTotalPrice
		System.out.println(dsAnPham.calculateTotalPrice());
		//This is the testcase of method findReferenceBookWithLongestChapter
		System.out.println(dsAnPham.findReferenceBookWithLongestChapter());
		//This is the testcase of method containsMagazineWithTitle
		System.out.println(dsAnPham.containsMagazineWithTitle("Khu vuon thanh xuan"));
		//This is the testcase of method getMagazinesPublishedInYear
		System.out.println(dsAnPham.getMagazinesPublishedInYear(2022));
		//This is the testcase of method sortBooksByTitle
		dsAnPham.sortBooksByTitle();
		System.out.println(dsAnPham);
		//This is the testcase of method sortBooksByYear
		dsAnPham.sortBooksByYear();
		System.out.println(dsAnPham);
		//This is the testcase of method countPublicationsByYear
		System.out.println(dsAnPham.countPublicationsByYear());
	}

}
