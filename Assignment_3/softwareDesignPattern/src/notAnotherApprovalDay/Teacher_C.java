package notAnotherApprovalDay;

public class Teacher_C extends Teacher{
	
	public Teacher_C(String name){
		super(name);
	}
	
	public void givePermission(Student std){
		std.setPermission(1);
	}
}
