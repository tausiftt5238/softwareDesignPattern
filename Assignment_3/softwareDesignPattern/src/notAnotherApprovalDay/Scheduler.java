package notAnotherApprovalDay;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.Timer;
import java.util.concurrent.ExecutorService;

public class Scheduler {
	public Scheduler(ExecutorService executor){
		Timer timer = new Timer(true);
		BufferedReader br = null;
		Scanner s = null;
		
		try {
			 br = new BufferedReader(new FileReader("input"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		int maximumWaitTime = 0;
		String tempLine;
		try {
			while((tempLine = br.readLine()) != null){
				s = new Scanner(tempLine);
				int time = s.nextInt();
				if(maximumWaitTime < time) maximumWaitTime = time;
				while(s.hasNextInt()){	
					Main.start = true;
					Main.countStudent++;
					timer.schedule(new myTimerTask(s.next(), executor), time * 1000 );
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			Thread.sleep(maximumWaitTime * 1000 + 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
