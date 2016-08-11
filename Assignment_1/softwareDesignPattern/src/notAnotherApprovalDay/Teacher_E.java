package notAnotherApprovalDay;

public class Teacher_E extends Teacher{
	
	public Teacher_E(String name){
		super(name);
	}
	
	public void givePermission(Student std){
		std.setPermission(2);
	}
	
}
