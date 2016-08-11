package notAnotherApprovalDay;

import java.util.Date;

public class Student implements Runnable{
	String ID;
	boolean requestSheet[];
	String password;
	boolean receivedPwd;
	boolean stopThread;
	Date date = new Date();
	
	public Student(String ID){
		this.ID = ID;
		requestSheet = new boolean[3];
	}
	
	@Override
	public void run() {
		request();
		Admin_B.verify();
		if(stopThread) return;
		if(password != null)
			System.out.printf("Student %s received Password: %s\n", ID, password);
		else 
			System.out.println("Student " + ID + " was denied of the service due to cheating.");
		
	}
	public void request(){
		System.out.printf("Student of ID #%s requesting password at %s\n", ID, date);
		Teacher.requestPassword(this);
	}
	public void setPermission(int index){
		requestSheet[index] = true;
	}
	public String toString(){
		return ID;
	}
	public void setPassword(String password){
		this.password = password;
	}
	public String getID(){
		return ID;
	}
	public boolean checkPermission(int index){
		return requestSheet[index];
	}
	public void gotPwd(){
		receivedPwd = true;
	}
	public void stop(){
		stopThread = true;
	}
}
