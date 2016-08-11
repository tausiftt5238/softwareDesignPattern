package notAnotherApprovalDay;

import java.util.Date;
import java.util.LinkedList;
import java.util.Queue;

public class Teacher implements Runnable{
	
	Thread thread;
	String name;
	int countOfRequest;
	Date date = new Date();
	
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
			synchronized(buffer){
				if(buffer.isEmpty()){
					if(Main.countStudent == 0 && Main.start){
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
					System.out.printf("%s giving permission to student %s at %s\n", name, temp, date);
					givePermission(temp);
					Admin_B.addToQueue(temp);
					Main.decreaseCount(buffer);
					if(countOfRequest == 1){
						countOfRequest = 0;
						try {
							//Thread.sleep(1000);
							buffer.wait();
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
						buffer.notify();
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
