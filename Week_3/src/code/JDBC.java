package code;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
public class JDBC {

	Connection con;
	public JDBC() throws SQLException,ClassNotFoundException{
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/java","root","MySql@18113");
		
	}
	
	public  Object checkUser(String table,String username,String password) throws InvalidCredentialError,SQLException{
		String query="select * from "+table;
		ResultSet rs=con.prepareStatement(query).executeQuery();
		while(rs.next()) {
			if(rs.getString("password").equals(password)) {
				return (table.equals("admin"))?new Admin(rs.getInt("id"),rs.getString("username")):
					new Accountant(rs.getInt("id"), rs.getString("name"), rs.getString("email"), rs.getInt("phone"));
			}
		}
		throw new InvalidCredentialError();
		
	}
	
	public List<Accountant> loadAccountant() throws SQLException{
		String query="select id,name,email,phone from Accountant";
		ResultSet rs=con.prepareStatement(query).executeQuery();
		List<Accountant> al=new ArrayList<>();
		while(rs.next()) {
			al.add(new Accountant(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4)));
		}
		return al;
	}
	public List<Student> loadStudent() throws SQLException{
		String query="select id,name,email,course,fee,paid,due,address,phone from Student";
		ResultSet rs=con.prepareStatement(query).executeQuery();
		List<Student> al=new ArrayList<>();
		while(rs.next()) {
			al.add(new Student(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),
					rs.getDouble(5),rs.getDouble(6),rs.getDouble(7),rs.getString(8),rs.getInt(9)));
		}
		return al;
	}
	
	public int addAccountant(String name,String email,int phone) throws SQLException{
		String query="insert into accountant(id,name,email,phone,password) values (id,"+"\'"+name+"\',\'"+email+"\',"+phone+",'default');";
		con.prepareStatement(query).executeUpdate();
		ResultSet rs=con.prepareStatement("select id from accountant where email=\'"+email+"\';").executeQuery();
		rs.next();
		return rs.getInt(1);
	}
	
	public void editAccountant(int id) throws SQLException{
		
	}
	
	public void deleteAccountant(int id) throws SQLException{
		String query="delete from accountant where id="+id;
		con.prepareStatement(query).executeUpdate();
	}
	
	public int addStudent(String name,String email,String course,double fee,double paid,double due,String address,int phone) throws SQLException{
		String query="insert into accountant values(id,"+name+","+email+","+course+","+fee+","+paid+","+due+
				","+address+","+phone+");";
		con.prepareStatement(query).executeUpdate();
		ResultSet rs=con.createStatement().executeQuery("select id from accountant where email=\'"+phone+"\';");
		rs.next();
		return rs.getInt(1);
	}
	
	public void editStudent(int id) throws SQLException{
		
	}

	public void deleteStudent(int id) throws SQLException{
		String query="delete from Student where id="+id;
		con.prepareStatement(query).executeUpdate();
	}
}
