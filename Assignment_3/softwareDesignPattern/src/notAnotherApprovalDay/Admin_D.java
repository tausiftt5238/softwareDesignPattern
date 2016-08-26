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
		Notify();
	}
	
	
	public void Notify(){
		while(!buffer.isEmpty()){
			Student std = buffer.remove();
			std.setPassword(createPwd(std.getID()));
			std.update();
		}
		doneGivingPassword = true;
	}
	public String createPwd(String ID){
		KeyGen pw = new KeyGen();
		pw.add(new KeyGen());
		pw.add(new KeyGen());
		return pw.operate() + ID;
	}
	public boolean doneTask(){
		return doneGivingPassword;
	}
}
