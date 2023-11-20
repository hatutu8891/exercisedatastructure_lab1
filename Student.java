/**
 * 
 */
package lab9;

/**
 * @author hp
 *
 */
public class Student {
	private String id;
	private String name;
	private int year;

	/**
	 * @param id
	 * @param name
	 * @param year
	 * 
	 *             Example: Student s1= new Student("001","Nguyen Minh Hai",2019);
	 *             Student s2= new Student("002","Bui Minh Tan",2019); Student s3=
	 *             new Student("003","Ha Trong Cuong",2019); Student s4= new
	 *             Student("011","Nguyen Minh Trung",2020); Student s5= new
	 *             Student("012","Nguyen Hoang Khang",2020); Student s6= new
	 *             Student("013","Truong Trong Kim",2020); Student s7= new
	 *             Student("014","Pham Tien Vinh",2020); Student s8= new
	 *             Student("021","Phan Ngoc Hoa",2021); Student s9= new
	 *             Student("022","Le Minh Chinh",2021); Student s10= new
	 *             Student("023","Ly Anh Hoa",2021); Student s11= new
	 *             Student("024","Le Huu Liem",2021); Student s12= new
	 *             Student("031","Hoang Trong Nhan",2022); Student s13= new
	 *             Student("032","Lai Van An",2022); Student s14= new
	 *             Student("033","Ngo Gia Man",2022); Student s15= new
	 *             Student("034","Nguyen Van Sinh",2022); Student s16= new
	 *             Student("041","Giang Gia Kiet",2023); Student s17= new
	 *             Student("042","Nguyen Gia Minh",2023); Student s18= new
	 *             Student("043","Ho Thi Vy",2023); Student s19= new
	 *             Student("044","Vuong My Nhan",2023); Student s20= new
	 *             Student("045","Hoang Hai Tho",2023);
	 */
	public Student(String id, String name, int year) {
		super();
		this.id = id;
		this.name = name;
		this.year = year;
	}

	/**
	 * @return the year
	 */
	public int getYear() {
		return year;
	}

	public Student getStudentByYear() {

		return null;
	}

	@Override
	public String toString() {
		return id + ", " + name + ", " + year + "\n";
	}

}
