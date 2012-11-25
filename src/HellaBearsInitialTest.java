import java.util.*;

public class HellaBearsInitialTest {

    public static final boolean CAN_DEBUG = false;

	public static void main(String[] args) {
		LinkedList<Student> s = new LinkedList<Student>();
		int[] classes = new int[]{10,20,30,40,50};

		/// This next chunk of code initialized the students, giving each a pseudorandom set of classes as priorities
		int temp, a, b;
        Random r = new Random(69);
		for (int i = 0; i < 20; i++) {
			for (int j = 0; j < 69; j++) {
				a = (int)(r.nextDouble()*5);
				b = (int)(r.nextDouble()*5);
				temp = classes[a];
				classes[a] = classes[b];
				classes[b] = temp;
			}
			
			s.add(new Student(100 * i + 1000, new int[]{classes[0],classes[1],classes[2]} , (byte)(r.nextDouble()*120), new String[]{""}));
		}
		
		
		/// This chunk initializes classes that are exactly big enough to fit all the students
		
		HashMap<Integer, Class> classlist = new HashMap<Integer, Class>();
		classlist.put(10, new Class(10, 5, "EE"));
		classlist.put(20, new Class(20, 5, "MATH"));
		classlist.put(30, new Class(30, 4, "PHYSICS"));
		classlist.put(40, new Class(40, 3, "ENGLISH"));
		classlist.put(50, new Class(50, 3, "CS"));

        /// Sort the students
		run(classlist, s);
		
		/// Just to look at the classes and students and make sure nothing is horribly disfigured

		System.out.println("classlist:");
		for (Class c: classlist.values()) {
			System.out.println(" " + c);
		}

		debugPrint("\nStudents:");
		for (Student c: s) {
			debugPrint(" " + c);
		}
		
	}

	/** Takes in a hash map of classes mapped by ccn and a linked list of students.
     *  Algorithm:  adds students to their next priority class (starting with first), then each class dumps off
     *  all the unwanted students.  This then repeats until all the students are put somewhere.
     */
	private static void run(HashMap<Integer, Class> classlist, LinkedList<Student> studentlist) {
		int ccn;
		Student s;
		LinkedList<Student> losers;
		while(studentlist.size() > 0){
			
            /** These next 2 loops are not even part of the algorithm. */
			debugPrint("classlist:");
			for (Class c: classlist.values()) {
				debugPrint(" " + c);
			}
			debugPrint("\nStudents:");
			for (Student c: studentlist) {
				debugPrint(" " + c);
			}
			
            // Basically the meat of the adapted stable marriage algorithm is right here

            // Adds each student to the first class he hasn't already been kicked out of.
			while (studentlist.size() > 0) {
				s = studentlist.pop();
				ccn = s.getNextClassChoice();
				classlist.get(ccn).addStudent(s);
			}
            // Each class kicks off all the unwanted students and puts them back in studentlist
			for (Class c: classlist.values()) {
				losers = c.reject();
				if (losers != null) {
					studentlist.addAll(losers);
				}
			}
		}
	}

    /** Will print certain statements only if the final variable is true. */
    public static void debugPrint(String s) {
        if (CAN_DEBUG)
            System.out.println(s);
    }
}
