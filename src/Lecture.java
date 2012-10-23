
public class Lecture {

	private int maxCapacity;
	private int[] students;
	private int ccn;
	private int currentEnrollment = 0;

	public Lecture(int ccn, int max){
		this.maxCapacity = max;
		this.ccn = ccn;
		students = new int[maxCapacity];
	}

	public boolean addStudent(Student s){
		int spot = this.getEmptySpot();
		if (spot != -1){
			students[spot] = s.getId();
			currentEnrollment++;
			return true;
		}
		return false;
	}

	public void removeStudent(Student s){
		for (int i = 0; i < students.length; i++){
			if (students[i] == s.getId()){
				students[i] = 0;
				currentEnrollment--;
			}
		}
	}

	public int[] getStudents(){
		return this.students;
	}

	public int getCCN(){
		return this.ccn;
	}

	public int getCurrentEnrollment(){
		return this.currentEnrollment;
	}

	public int getMaxCapacity(){
		return this.maxCapacity;
	}

	private int getEmptySpot(){
		if (this.hasEmptySpot()){


		}
		return -1;
	}

	private boolean hasEmptySpot(){
		return currentEnrollment < maxCapacity;
	}

}
