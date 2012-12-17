import java.util.List;
import java.util.PriorityQueue;


public class Student {

	private int id;
	private float totalUnits;
	private PriorityQueue<Lecture> desiredClasses = new PriorityQueue<Lecture>();
	private PriorityQueue<Lecture> failedClasses = new PriorityQueue<Lecture> ();
	
	public Student(int theId, float units, List<Lecture> classes){
		this.id = theId;
		this.totalUnits = units;
		// TODO add the classes in priority order to PQueue
	}
	
	public int getId(){
		return this.id;
	}
	
	public float getUnits(){
		return this.totalUnits;
	}
	
	public Lecture getNextClass(){
		return null;
		// TODO get the top element of priority queue and remove it
	}
	
	public int hashCode(){
		return this.id;
	}
}
