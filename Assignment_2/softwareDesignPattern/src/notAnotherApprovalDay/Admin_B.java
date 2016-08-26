package notAnotherApprovalDay;

import java.util.LinkedList;
import java.util.Queue;

public class Admin_B implements Runnable{
	
	Teacher[] teachers;
	Thread t;
	boolean checkPermission[];
	public static Queue<Student> buffer = new LinkedList<Student>();
	public Admin_B(Teacher[] teachers){
		this.teachers = teachers;
		checkPermission = new boolean[80];
		t = new Thread(this, "Admin_B");
		t.start();
	}
	
	public static synchronized void addToQueue(Student std){
		buffer.add(std);
	}
	public static void verify(){
		synchronized(buffer){
			try {
				buffer.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	public void run(){
		for(int i = 0 ; i < 6 ; i++){
			teachers[i].join();
		}
		Queue <Student> tempBuf = new LinkedList<Student>();
		while(!buffer.isEmpty()){
			Student std = buffer.remove();
			int count = 0;
			if(checkPermission[Integer.parseInt(std.getID())]){
				std.stop();
			}
			checkPermission[Integer.parseInt(std.getID())] = true;
			for(int i = 0 ; i < 3; i ++){
				if(std.checkPermission(i)) count++;
			}
			if(count == 1) tempBuf.add(std);
			else{
				std.update();
			}
		}
		Admin_D D = new Admin_D(tempBuf);
		while(!D.doneTask()) Thread.yield();
		synchronized(buffer){
			buffer.notifyAll();
		}
	}
	
	
}
