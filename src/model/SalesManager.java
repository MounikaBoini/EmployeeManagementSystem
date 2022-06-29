package model;

public class SalesManager extends Employee
{
	int incen;
	public SalesManager(int id,String fname,String lname,String dob,String email,String doj,String phn,String desig,int sal,int incen) {
		super(id,fname, lname, dob, email, doj, phn, desig, sal);
		this.incen=incen;
	}
	public void setIncen(int incen) {
		this.incen = incen;
	}
	public int getIncen() {
		return incen;
	}
	
	@Override
	public int getSal() {
		return this.sal;
	}
	
}
