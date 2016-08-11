package notAnotherApprovalDay;

import java.util.LinkedList;
import java.util.Queue;

public class Admin_D implements Runnable{
	Queue<Student> buffer = new LinkedList<Student>();
	boolean doneGivingPassword;
	public Admin_D(Queue<Student> buffer){
		this.buffer = buffer;
		Thread thread = new Thread(this, "Admin_D");
		thread.start();
	}
	
	
	public void run(){
		genPassword();
	}
	
	
	public void genPassword(){
		while(!buffer.isEmpty()){
			Student std = buffer.remove();
			std.setPassword(createPwd(std.getID()));
			std.gotPwd();
		}
		doneGivingPassword = true;
	}
	public String createPwd(String ID){
		return "DUPWD"+ID;
	}
	public boolean doneTask(){
		return doneGivingPassword;
	}
}
