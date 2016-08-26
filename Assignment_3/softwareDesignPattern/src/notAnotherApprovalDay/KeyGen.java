package notAnotherApprovalDay;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class KeyGen {
	private String randomString;
	private Random r;
	List <KeyGen> ls;
	
	public KeyGen(){
		r = new Random();
		
		ls = new ArrayList<KeyGen>();
		randomString = "";
		
		randomString += (char)('a' + r.nextInt(26));
		randomString += (char)('a' + r.nextInt(26));
	}
	
	public void add(KeyGen e){
		ls.add(e);
	}
	public void remove(KeyGen e){
		ls.remove(e);
	}
	public String toString(){
		return randomString;
	}
	public String operate(){
		String tempString = "" + randomString;
		for(KeyGen k : ls){
			tempString += k;
		}
		return tempString;
	}
}
