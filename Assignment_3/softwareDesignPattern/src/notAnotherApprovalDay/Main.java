package notAnotherApprovalDay;

import java.util.Queue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
	
	public static int countStudent;
	public static boolean start;
	
	public static void main(String args[]) throws InterruptedException{
		Teacher teachers[] = new Teacher[6];
		for(int i = 0 ; i < 6 ; i += 3){
			teachers[i]  = new Teacher_A("A_" + i);
			teachers[i+1] = new Teacher_C("C_" + (i+1));
			teachers[i+2] = new Teacher_E("E_" + (i+2));
		}
		
		new Admin_B(teachers);
		
		ExecutorService executor = Executors.newCachedThreadPool();
		new  Scheduler(executor);
		
		executor.shutdown();
		
		System.out.println("done");
	}
	public static void decreaseCount(Queue<Student> buffer){
		synchronized(buffer){
			countStudent--;
			if(countStudent == 0) buffer.notifyAll();
		}
		
	}
}
