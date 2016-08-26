package notAnotherApprovalDay;

public class Teacher_A extends Teacher{
	
	public Teacher_A(String name){
		super(name);
	}
	
	public void givePermission(Student std){
		std.setPermission(0);
	}
}
