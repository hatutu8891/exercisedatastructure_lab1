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
public class TestFaculty {
	public static void main(String[] args) {
		Student s1 = new Student("001", "Nguyen Minh Hai", 2019);
		Student s2 = new Student("002", "Bui Minh Tan", 2019);
		Student s3 = new Student("003", "Ha Trong Cuong", 2019);
		Student s4 = new Student("011", "Nguyen Minh Trung", 2020);
		Student s5 = new Student("012", "Nguyen Hoang Khang", 2020);
		Student s6 = new Student("013", "Truong Trong Kim", 2020);
		Student s7 = new Student("014", "Pham Tien Vinh", 2020);
		Student s8 = new Student("021", "Phan Ngoc Hoa", 2021);
		Student s9 = new Student("022", "Le Minh Chinh", 2021);
		Student s10 = new Student("023", "Ly Anh Hoa", 2021);
		Student s11 = new Student("024", "Le Huu Liem", 2021);
		Student s12 = new Student("031", "Hoang Trong Nhan", 2022);
		Student s13 = new Student("032", "Lai Van An", 2022);
		Student s14 = new Student("033", "Ngo Gia Man", 2022);
		Student s15 = new Student("034", "Nguyen Van Sinh", 2022);
		Student s16 = new Student("041", "Giang Gia Kiet", 2023);
		Student s17 = new Student("042", "Nguyen Gia Minh", 2023);
		Student s18 = new Student("043", "Ho Thi Vy", 2023);
		Student s19 = new Student("044", "Vuong My Nhan", 2023);
		Student s20 = new Student("045", "Hoang Hai Tho", 2023);

		List<Student> ls1 = new ArrayList<>();
		ls1.add(s16);
		ls1.add(s17);
		ls1.add(s18);
		ls1.add(s19);
		ls1.add(s20);
		ls1.add(s13);
		ls1.add(s8);

		List<Student> ls2 = new ArrayList<>();
		ls2.add(s12);
		ls2.add(s13);
		ls2.add(s14);
		ls2.add(s15);
		ls2.add(s8);

		List<Student> ls3 = new ArrayList<>();
		ls3.add(s12);
		ls3.add(s13);
		ls3.add(s14);
		ls3.add(s15);

		List<Student> ls4 = new ArrayList<>();
		ls4.add(s8);
		ls4.add(s9);
		ls4.add(s10);
		ls4.add(s11);
		ls4.add(s1);

		List<Student> ls5 = new ArrayList<>();
		ls5.add(s8);
		ls5.add(s9);
		ls5.add(s10);
		ls5.add(s11);

		List<Student> ls6 = new ArrayList<>();
		ls6.add(s4);
		ls6.add(s5);
		ls6.add(s6);
		ls6.add(s7);

		List<Student> ls7 = new ArrayList<>();
		ls7.add(s1);
		ls7.add(s2);
		ls7.add(s3);

		Course c1 = new Course("A01", "Lap trinh co ban", "TH", ls1, "Nguyen Van A");
		Course c2 = new Course("A02", "Lap trinh nang cao", "TH", ls2, "Ha Thi B");
		Course c3 = new Course("A03", "Cau truc may tinh", "LT", ls3, "Pham Thi C");
		Course c4 = new Course("A04", "Cau truc du lieu", "TH", ls4, "Nguyen Van D");
		Course c5 = new Course("A05", "Toan roi rac", "LT", ls5, "Pham Thi C");
		Course c6 = new Course("A06", "Nhap mon tri tue nhan tao", "TH", ls6, "Nguyen Van D");
		Course c7 = new Course("A07", "Lap trinh mang may tinh nang cao", "TH", ls7, "Nguyen Van D");

		List<Course> lc1 = new ArrayList<>();
		lc1.add(c1);
		lc1.add(c2);
		lc1.add(c3);
		lc1.add(c4);
		lc1.add(c5);
		lc1.add(c6);
		lc1.add(c7);

		Faculty f1 = new Faculty("Cong nghe thong tin", "fit.hcmuaf.edu.vn", lc1);

		// This is the testcase of getMaxPracticalCourse method
		System.out.println("This is the test of getMaxPracticalCourse method " + "\n" + f1.getMaxPracticalCourse());

		// This is the testcase of groupStudentByYear method
		System.out.println("This is the test of groupStudentByYear method " + "\n" + f1.groupStudentByYear());

		// This is the testcase of filterCourses method
		System.out.println("This is the test of filterCourses method " + "\n" + f1.filterCourses("LT"));
	}

}
