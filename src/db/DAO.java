package db;

import java.sql.*;

import model.Manager;

public class DAO {
		private String url;
		private Connection con;
		private PreparedStatement stmt;
		public void connect() throws ClassNotFoundException, SQLException
		{
				Class.forName("com.mysql.jdbc.Driver");//loading driver
				url="jdbc:mysql://localhost:3306/test";
			    con=DriverManager.getConnection(url, "root", "cloud");//creating connection
		}
		public void insert(Manager m) throws SQLException, ClassNotFoundException
		{
			try {
				this.connect();
				stmt=con.prepareStatement("insert into manager values(?,?)");
				stmt.setString(1, m.getUsername());
				stmt.setString(2, m.getPass());
				stmt.executeUpdate();
			} 
			finally {
				stmt.close();
				con.close();
			}
		}
		public Manager Validate(Manager m) throws SQLException, ClassNotFoundException
		{
			try {
				 this.connect();
				stmt=con.prepareStatement("select Username,password from manager where Username=? and password=?");
				stmt.setString(1, m.getUsername());
				stmt.setString(2, m.getPass());
				ResultSet rs=stmt.executeQuery();
				if(!rs.next())
				{
					m=null;
				}	
			} 
			finally {
				stmt.close();
				con.close();
			}
			return m;
		}
}
