package model;

public class Admin extends Employee
{
	int allow;
	public Admin(int id,String fname,String lname,String dob,String email,String doj,String phn,String desig,int sal,int allow) {
		super(id,fname, lname, dob, email, doj, phn, desig, sal);
		this.allow=allow;
	}
	
	public int getAllow() {
		return allow;
	}

	public void setAllow(int allow) {
		this.allow = allow;
	}

	@Override
	public int getSal() {
		return this.sal;
	}
	
	
}

