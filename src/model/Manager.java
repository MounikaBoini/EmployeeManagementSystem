package model;

public class Manager {
		String username,pass;
		public Manager(String u,String p)
		{
			this.username=u;
			this.pass=p;
		}
		public String getUsername() {
			return username;
		}
		public void setUsername(String username) {
			this.username = username;
		}
		public String getPass() {
			return pass;
		}
		public void setPass(String pass) {
			this.pass = pass;
		}
		
}
