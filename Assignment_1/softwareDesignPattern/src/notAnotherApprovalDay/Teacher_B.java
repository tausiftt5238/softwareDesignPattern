package notAnotherApprovalDay;

public class Teacher_B extends Teacher{
	
	public Teacher_B(String name){
		super(name);
	}
	
	public void givePermission(Student std){
		std.setPermission(1);
	}
}
