package model;

public abstract class Employee
{
	int id,sal;
	String fname,lname,dob,doj,email,phn,desig;
	
	Employee(int id,String fname,String lname,String dob,String email,String doj,String phn,String desig,int sal)
	{
		this.id=id;
		this.fname=fname;
		this.lname=lname;
		this.dob=dob;
		this.email=email;
		this.doj=doj;
		this.phn=phn;
		this.sal=sal;
		this.desig=desig;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public String getDoj() {
		return doj;
	}
	public void setDoj(String doj) {
		this.doj = doj;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhn() {
		return phn;
	}
	public void setPhn(String phn) {
		this.phn = phn;
	}
	public String getDesig() {
		return desig;
	}
	public void setDesig(String desig) {
		this.desig = desig;
	}
	public void setSal(int sal) {
		this.sal = sal;
	}
	abstract public int getSal();
	
}
 
