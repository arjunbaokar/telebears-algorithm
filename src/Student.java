import java.util.Arrays;
import java.util.HashSet;
public class Student {

	private int id;
    /** Class choices, with most desired at index 0. */
	private int[] choices;
	private byte units;
	private String[] majors;
    /** Which class he's currently trying to get into.
      * Starts at 0, then increases each time he picks a class. */
	private int prio;
	private HashSet<Class> schedule;

	public Student(int id, int[] choices, byte units, String[] majors) {
		this.id = id;
		this.choices = choices;
		this.majors = majors;
		this.units = units;
		prio = 0;
		schedule = new HashSet<Class>();
	}

	public byte getUnits() {
		return units;
	}

	public String[] getMajors() {
		return majors;
	}

	public int getID() {
		return id;
	}

	public String toString() {
		return "ID: " + id + " Units: " + units + " Majors:" + Arrays.toString(majors) + " Choices: " + Arrays.toString(choices);
			//+ "\n    " + schedule;
	}

    /** Returns his next choice.  For example
     *  If his class choices are [class324, class 149, class 6969]
     *  This will return class324 the first time the method is called
     *  class149 the next time, and so on.
     */
	public int getNextClassChoice() {
		if (prio >= choices.length) {
			return -1;
		}
		return choices[prio++];
	}
	
	public void addToSchedule(Class c) {
		schedule.add(c);
	}
	
	public void removeFromSchedule(Class c) {
		schedule.remove(c);
	}
}
