package notAnotherApprovalDay;

import java.util.LinkedList;
import java.util.Queue;

public class Teacher implements Runnable{
	
	Thread thread;
	String name;
	int countOfRequest;
	
	static Queue<Student> buffer = new LinkedList<Student>();
	
	public static void requestPassword(Student std){
		synchronized(buffer){
			buffer.add(std);
			buffer.notifyAll();
		}
	}
	
	public Teacher(String name){
		thread = new Thread(this, name);
		thread.start();
		this.name = name;
	}
	
	public void run(){
		while(true){
			System.out.println("Starting: " + name);
			synchronized(buffer){
				if(buffer.isEmpty()){
					if(Main.countStudent == 0){
						buffer.notifyAll();
						break;
					}
					try {
						buffer.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					//continue;
				}
				else{
					Student temp = buffer.remove();
					countOfRequest++;
					System.out.println("Student no. " + temp);
					System.out.println("from " + name);
					givePermission(temp);
					Main.decreaseCount(buffer);
					if(countOfRequest >= 3){
						countOfRequest = 0;
						Thread.yield();
					}
				}
			}
		}
	}
	public void givePermission(Student std){
		
	}
	
	public void join(){
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
