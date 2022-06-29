package db;

import java.sql.*;

import model.*;

public class EmployeeDAO {
		private String url;
		private Connection con;
		private PreparedStatement stmt;
		public void connect() throws ClassNotFoundException, SQLException
		{
				Class.forName("com.mysql.jdbc.Driver");//loading driver
				url="jdbc:mysql://localhost:3306/test";
			    con=DriverManager.getConnection(url, "root", "cloud");//creating connection
		}
		//insert employee data
	    void insert(Employee e) throws SQLException
		{
				stmt=con.prepareStatement("insert into employee values(?,?,?,?,?,?,?,?,?)");
				stmt.setInt(1, e.getId());
				stmt.setString(2, e.getFname());
				stmt.setString(3, e.getLname());
				stmt.setString(4, e.getDob());
				stmt.setString(5, e.getEmail());
				stmt.setString(6, e.getDoj());
				stmt.setString(7, e.getPhn());
				stmt.setString(8, e.getDesig());
				stmt.setInt(9, e.getSal());
				stmt.executeUpdate();
			
		}
		
		//sales manager insert incentives
		public void insertSM(SalesManager s) throws ClassNotFoundException, SQLException {
		try {
			this.connect();
			this.insert(s);
			stmt=con.prepareStatement("insert into incentives values(?,?)");
			stmt.setInt(1, s.getId());
			stmt.setInt(2, s.getIncen());
			stmt.executeUpdate();
		} 
		finally {
			stmt.close();
			con.close();
		 }
		}
		//HR insert commission
		public void insertHR(HR h) throws ClassNotFoundException, SQLException {
		try {
			this.connect();
			this.insert(h);
			stmt=con.prepareStatement("insert into commission values(?,?)");
			stmt.setInt(1, h.getId());
			stmt.setInt(2, h.getComm());
			stmt.executeUpdate();
		} 
		finally {
			stmt.close();
			con.close();
		}
		}
		//Admin insert allowance
		public void insertAdmin(Admin a) throws ClassNotFoundException, SQLException {
		try {
			this.connect();
			this.insert(a);
			stmt=con.prepareStatement("insert into allowance values(?,?)");
			stmt.setInt(1, a.getId());
			stmt.setInt(2, a.getAllow());
			stmt.executeUpdate();
		} 
		finally {
			stmt.close();
			con.close();
		}
		}				
		//validate employee id already present or not
		public String validate(int id) throws SQLException, ClassNotFoundException
		{
			try {
				this.connect();
				stmt=con.prepareStatement("select Firstname,Lastname from employee where id=?");
				stmt.setInt(1, id);
				ResultSet rs=stmt.executeQuery();
				if(rs.next()) {
					return rs.getString("Firstname")+" "+rs.getString("Lastname");
				 }
				}
			finally {
				stmt.close();
				con.close();
			}
			return null;	
		}
		//validate before deleting
		public String validateDelete(int id) throws SQLException, ClassNotFoundException
		{
			try {
				this.connect();
				stmt=con.prepareStatement("select Designation from employee where id=?");
				stmt.setInt(1, id);
				ResultSet rs=stmt.executeQuery();
				if(rs.next()) {
					return rs.getString("Designation");
				 }
				}
			finally {
				stmt.close();
				con.close();
			}
			return null;	
		}
		//deleting records
		public void deleteRecord(int id) throws SQLException {
			stmt=con.prepareStatement("delete from employee where id=?");
			stmt.setInt(1, id);
			stmt.executeUpdate();
		}
		//delete record of sales manager
		public void deleteSM(int id) throws SQLException, ClassNotFoundException {
			try {
				this.connect(); 
				stmt=con.prepareStatement("delete from incentives where id=?");
				stmt.setInt(1, id);
				stmt.executeUpdate();
				this.deleteRecord(id);
			}
			finally {
				stmt.close();
				con.close();
			}
		}
		//delete record of HR
		public void deleteHR(int id) throws SQLException, ClassNotFoundException {
			try {
				this.connect(); 
				stmt=con.prepareStatement("delete from commission where id=?");
				stmt.setInt(1, id);
				stmt.executeUpdate();
				this.deleteRecord(id);
			}
			finally {
				stmt.close();
				con.close();
			}
		}
		//delete record of admin
		public void deleteAdmin(int id) throws SQLException, ClassNotFoundException {
			try {
				this.connect(); 
				stmt=con.prepareStatement("delete from allowance where id=?");
				stmt.setInt(1, id);
				stmt.executeUpdate();
				this.deleteRecord(id);
			}
			finally {
				stmt.close();
				con.close();
			}
		}
		
		//select a SM record
		public SalesManager selectRecordSM(int id) throws SQLException, ClassNotFoundException
		{
			try {
				this.connect();
				stmt=con.prepareStatement("select * from employee where id=?");
				stmt.setInt(1, id);
				ResultSet rs=stmt.executeQuery();
				stmt=con.prepareStatement("select Incentive from incentives where id=?");
				stmt.setInt(1, id);
				ResultSet rs1=stmt.executeQuery();
				if(rs.next() && rs1.next()) {
					SalesManager sm=new SalesManager(rs.getInt("id"),rs.getString("Firstname"),rs.getString("Lastname"),rs.getString("Dob"),rs.getString("Email"),rs.getString("Doj"),rs.getString("PhoneNo"),rs.getString("Designation"),rs.getInt("Salary"),rs1.getInt("Incentive"));
					return sm;
				}
				}
			finally {
				stmt.close();
				con.close();
			}
			return null;	
		}
		//select a HR record
		public HR selectRecordHR(int id) throws SQLException, ClassNotFoundException
		{
			try {
				this.connect();
				stmt=con.prepareStatement("select * from employee where id=?");
				stmt.setInt(1, id);
				ResultSet rs=stmt.executeQuery();
				stmt=con.prepareStatement("select commission from commission where id=?");
				stmt.setInt(1, id);
				ResultSet rs1=stmt.executeQuery();
				if(rs.next() && rs1.next()) {
					HR hr=new HR(rs.getInt("id"),rs.getString("Firstname"),rs.getString("Lastname"),rs.getString("Dob"),rs.getString("Email"),rs.getString("Doj"),rs.getString("PhoneNo"),rs.getString("Designation"),rs.getInt("Salary"),rs1.getInt("commission"));
					return hr;
				}
				}
			finally {
				stmt.close();
				con.close();
			}
			return null;	
		}
		//select a admin record
		public Admin selectRecordAdmin(int id) throws SQLException, ClassNotFoundException
		{
			try {
				this.connect();
				stmt=con.prepareStatement("select * from employee where id=?");
				stmt.setInt(1, id);
				ResultSet rs=stmt.executeQuery();
				stmt=con.prepareStatement("select allowance from allowance where id=?");
				stmt.setInt(1, id);
				ResultSet rs1=stmt.executeQuery();
				if(rs.next() && rs1.next()) {
					Admin a=new Admin(rs.getInt("id"),rs.getString("Firstname"),rs.getString("Lastname"),rs.getString("Dob"),rs.getString("Email"),rs.getString("Doj"),rs.getString("PhoneNo"),rs.getString("Designation"),rs.getInt("Salary"),rs1.getInt("allowance"));
					return a;
				}
				}
			finally {
				stmt.close();
				con.close();
			}
			return null;	
		}
		//update employee
			    void update(Employee e) throws SQLException
				{
						stmt=con.prepareStatement("update employee set Firstname=?,Lastname=?,Dob=?,Email=?,Doj=?,PhoneNo=?,Designation=?,Salary=? where id=?");
						stmt.setString(1, e.getFname());
						stmt.setString(2, e.getLname());
						stmt.setString(3, e.getDob());
						stmt.setString(4, e.getEmail());
						stmt.setString(5, e.getDoj());
						stmt.setString(6, e.getPhn());
						stmt.setString(7, e.getDesig());
						stmt.setInt(8, e.getSal());
						stmt.setInt(9, e.getId());
						stmt.executeUpdate();
					
				}
				//sales manager update incentives
				public void updateSM(SalesManager s) throws ClassNotFoundException, SQLException {
				try {
					this.connect();
					this.update(s);
					stmt=con.prepareStatement("update incentives set Incentive=? where id=?");
					stmt.setInt(1, s.getIncen());
					stmt.setInt(2, s.getId());
					stmt.executeUpdate();
				} 
				finally {
					stmt.close();
					con.close();
				 }
				}
				//HR update commission
				public void updateHR(HR h) throws ClassNotFoundException, SQLException {
				try {
					this.connect();
					this.update(h);
					stmt=con.prepareStatement("update commission set commission=? where id=?");
					stmt.setInt(1, h.getComm());
					stmt.setInt(2, h.getId());
					stmt.executeUpdate();
				} 
				finally {
					stmt.close();
					con.close();
				}
				}
				//Admin update allowance
				public void updateAdmin(Admin a) throws ClassNotFoundException, SQLException {
				try {
					this.connect();
					this.update(a);
					stmt=con.prepareStatement("update allowance set allowance=? where id=?");
					stmt.setInt(1, a.getAllow());
					stmt.setInt(2, a.getId());
					stmt.executeUpdate();
				} 
				finally {
					stmt.close();
					con.close();
				}
			 }
		//select all records from employee table
			public ResultSet selectAll() throws SQLException, ClassNotFoundException 
			{
					this.connect();
					stmt=con.prepareStatement("select * from employee");
					ResultSet rs=stmt.executeQuery(); 
					return rs;
			}
			//closing resources
			public void closeResource() throws SQLException {
				stmt.close();
				con.close();
			}
}
