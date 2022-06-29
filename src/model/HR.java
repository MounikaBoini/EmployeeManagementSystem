package model;

public class HR extends Employee
{
	int comm;
	public HR(int id,String fname,String lname,String dob,String email,String doj,String phn,String desig,int sal,int comm){
		super(id,fname, lname, dob, email, doj, phn, desig, sal);
		this.comm=comm;
	}
	public int getComm() {
		return comm;
	}

	public void setComm(int comm) {
		this.comm = comm;
	}
	
	@Override
	public int getSal() {
		return this.sal;
	}
}