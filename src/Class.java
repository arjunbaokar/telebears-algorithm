import java.util.*;

public class Class {

	private int ccn;
	private int maxSize;
	private int currentSize;
	/** This is so I don't have to waste time sorting.  Not sure if it's worth the lg n add time though. */
	private TreeSet<Student> students;
	private String department;
	
	public Class(int ccn, int max, String department) {
		this.ccn = ccn;
		maxSize = max;
		currentSize = 0;
		students = new TreeSet<Student>(new Priorities(department));
		this.department = department;
	}

	public void addStudent(Student s) {
        debugPrint("This student was added to this class: " + s + "  " + this);
		currentSize++;
		students.add(s);
		s.addToSchedule(this);
	}

	public boolean isFull() {
		return maxSize <= currentSize;
	}

	public boolean isOver() {
		return maxSize < currentSize;
	}

    /** Takes all the lowest priority students out of the TreeSet and returns them
     */
	public LinkedList<Student> reject() {
		if (! isFull()) {
			return null;
		}
		LinkedList<Student> rejections = new LinkedList<Student>();
		Student s;
		while ( isOver()) {
			s = students.pollFirst();
            debugPrint("This student was removed cause of low priority: " + s);
			rejections.add(s);
			s.removeFromSchedule(this);
			currentSize--;
		}
		return rejections;
	}

	public String toString() {
        String ststring = "";
        for (Student s: students) {
            ststring += s + "\n\t";
        }
		return "Class: " + department + "\t" + ccn + " " + currentSize + "/" + maxSize
			+ "\n\t" + ststring;
	}
	
	public int getCCN() {
		return ccn;
	}

	public boolean equals(Object other) {
		// This is to make sure that no hash set will duplicate a certain ccn
		return ((Class) other).getCCN() == ccn;
	}
	public int hashCode() {
		// This is to make sure that no hash set will duplicate a certain ccn
		return ccn;
	}

    /** This is what TreeSet and Collections.sort will use
     *  to determine how to rank the students for this particular class
     */
	class Priorities implements Comparator {

		private String department;

		public Priorities(String department) {
			this.department = department;
		}

        @Override
		public int compare(Object one, Object two) {
			byte units1 = ((Student) one).getUnits();
			byte units2 = ((Student) two).getUnits();
			// TODO Fill in an algorithm for determining what students are more valuable based on major and other shit
			return units1 - units2;
		}

        @Override
		public boolean equals(Object one, Object two) {
			return compare(one, two) == 0;
		}
	}

    public static void debugPrint(String s) {
        if (HellaBearsInitialTest.CAN_DEBUG)
            System.out.println(s);
    }
}
