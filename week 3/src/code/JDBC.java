package code;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
public class JDBC {

	Connection con;
	public JDBC() {
		try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/java","root","MySql@18113");
//		if(con!=null) {
//			System.out.println("Connection Establised");
//		}
//		else {
//			System.err.println("Connetion is null");
//		}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public Object checkUser(String table,String username,String password) throws Exception{
		
		ResultSet rs=con.createStatement().executeQuery("select * from "+table+" where username="+username);
		if(rs.next()==false || !rs.getString("password").equals(password)) throw new InvalidCredentialError();
		if(table.equals("admin"))
			return new Admin(rs.getInt("id"),rs.getString("username"));
		else if(table.equals("accountant"))
			return new Accountant(rs.getInt("id"),rs.getString("name"),rs.getString("email"),rs.getString("phone"));
		else
			return null;
	}
	
	public void addRow(int table,String[] s) throws Exception{
		if(table==1) {
			con.createStatement().executeUpdate("insert into accountant values( id,"+s[0]+","+s[1]+","+s[2]+",1234)");
		}
		else {
			con.createStatement().executeUpdate("insert into student values( id,"+s[0]+","+s[1]+","+s[2]+","+Double.parseDouble(s[3])+","+Double.parseDouble(s[4])
			+","+(Double.parseDouble(s[3]) - Double.parseDouble(s[4]))+","+s[5]+","+s[6]+")");
		}
	}
	public void editRow(int id) {
		
	}
	public void deleteRow(int table,int id) throws Exception{
		if(table==1) {
			con.createStatement().executeUpdate("delete from accountant where id="+id);
		}
		else {
			con.createStatement().executeUpdate("delete from student where id="+id);
		}
	}
	public ResultSet getDetails(String table) throws Exception{
		return con.createStatement().executeQuery("select * from "+table);
	}
	public ResultSet getDue() throws Exception{
		return con.createStatement().executeQuery("select * from student where due!=0.0");
	}
}
