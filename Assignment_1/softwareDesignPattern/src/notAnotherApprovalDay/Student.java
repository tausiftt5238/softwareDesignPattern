package notAnotherApprovalDay;

public class Student implements Runnable{
	String ID;
	boolean requestSheet[];
	String password;
	
	public Student(String ID){
		this.ID = ID;
		requestSheet = new boolean[3];
	}
	
	@Override
	public void run() {
		request();
	}
	public void request(){
		System.out.println("Thread for " + ID);
		Teacher.requestPassword(this);
	}
	public void setPermission(int index){
		requestSheet[index] = true;
	}
	public String toString(){
		return ID;
	}
}
