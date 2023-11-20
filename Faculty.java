/**
 * 
 */
package lab9;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

/**
 * TASK 1
 * @author hp
 *
 */
public class Faculty {
	private String name;
	private String address;
	private List<Course> courses;

	/**
	 * @param name
	 * @param address
	 * @param courses
	 * 
	 *                Example:
	 * 
	 *                Faculty f1 = new Falculty("Cong nghe thong tin",
	 *                "fit.hcmuaf.edu.vn",lc1)
	 * 
	 */
	public Faculty(String name, String address, List<Course> courses) {
		super();
		this.name = name;
		this.address = address;
		this.courses = courses;
	}

	//This is the method getMaxPracticalCourse() to return the course have max student
	public Course getMaxPracticalCourse() {
		Course result = null;
		for (int i = 0; i < courses.size(); i++) {
			if (result == null && courses.get(i).getType().equals("TH")) {
				result = courses.get(i);

			}
			//hasMoreStudentThan is the method in class Course.
			if (courses.get(i).getType().equals("TH") && !result.hasMoreStudentThan(courses.get(i))) {
				result = courses.get(i);
			}
		}
		return result;
	}

	//This is the method groupStudentByYear() to return the list of student sorted by yearthey entered school.
	public Map<Integer, List<Student>> groupStudentByYear() {
		Map<Integer, List<Student>> result = new HashMap<>();
		Set<Student> listOfStudent = new HashSet<>();

		for (Course course : courses) {
			listOfStudent.addAll(course.getStudents());
		}

		for (Student student : listOfStudent) {
			int year = student.getYear();
			result.computeIfAbsent(year, k -> new ArrayList<>()).add(student);//computeIfAbsent the method in Map class
		}

		return result;
	}

	//This is the method filterCourses to return the courses have the type same with the type input
	public Set<Course> filterCourses(String type) {
		Set<Course> result = new TreeSet<>(new Comparator<Course>() {

			@Override
			public int compare(Course o1, Course o2) {
				int countComparison = o2.getStudents().size() - o1.getStudents().size();
				if (countComparison != 0) {
					return countComparison;
				} else {
					return o1.getId().compareTo(o2.getId());
				}
//				return Integer.compare(o2.getStudents().size(), o1.getStudents().size());

			}
		});
		for (Course course : courses) {
			if (course.getType().equals(type)) {
				result.add(course);
			}
		}
		return result;
	}

//	@Override
//	public String toString() {
//		return "Faculty [name=" + name + ", address=" + address + ", courses=" + courses + "]";
//	}

}
