package notAnotherApprovalDay;

import java.util.TimerTask;
import java.util.concurrent.ExecutorService;

public class myTimerTask extends TimerTask{
	String ID;
	ExecutorService executor;
	public myTimerTask(String ID , ExecutorService executor){
		this.ID = ID;
		this.executor = executor;
	}
	
	@Override
	public void run() {
		executor.execute(new Student(ID));
		
		
	}

}
