/**
 * 
 */
package lab9;

import java.util.List;

/**
 * @author hp
 *
 */
public class Course {
	private String id;
	private String title;
	private String type;
	private List<Student> students;
	private String lecturer;

	/**
	 * @param id
	 * @param title
	 * @param type
	 * @param students
	 * @param lecturer
	 * 
	 *                 Example:
	 *
	 *                 Course c1 = new Course("A01","Lap trinh co
	 *                 ban","TH",ls1,"Nguyen Van A"); Course c2 = new
	 *                 Course("A02","Lap trinh nang cao","TH",ls2,"Ha Thi B");
	 *                 Course c3 = new Course("A03","Cau truc may
	 *                 tinh","LT",ls3,"Pham Thi C"); Course c4 = new
	 *                 Course("A04","Cau truc du lieu","TH",ls4,"Nguyen Van D");
	 *                 Course c5 = new Course("A05","Toan roi rac","LT",ls5,"Pham
	 *                 Thi C"); Course c6 = new Course("A06","Nhap mon tri tue nhan
	 *                 tao","TH",ls6,"Nguyen Van D"); Course c7 = new
	 *                 Course("A07","Lap trinh mang may tinh nang
	 *                 cao","TH",ls7,"Nguyen Van D");
	 */
	public Course(String id, String title, String type, List<Student> students, String lecturer) {
		super();
		this.id = id;
		this.title = title;
		this.type = type;
		this.students = students;
		this.lecturer = lecturer;
	}

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * @return the students
	 */
	public List<Student> getStudents() {
		return students;
	}

	public boolean hasMoreStudentThan(Course that) {
		return this.students.size() > that.students.size();
	}

	@Override
	public String toString() {
		return id + ", " + title + ", " + type + ", " + lecturer + "\n" + "The list of students for this course is: "
				+ "\n" + students;

	}

}
