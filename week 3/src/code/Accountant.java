package code;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Accountant {
	private int id;
	private String name;
	private String email;
	private String phone;
	Students ss;
	public Accountant(int id, String name, String email, String phone) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.phone = phone;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public void AccountantPage() {
		Scanner sc=new Scanner(System.in);
		while(true) {
			System.out.println("Accountant:  "+this.id+" "+this.name);
			System.out.println("\n1.Manage Students\n2.Check Due Fee\n3.Logout");
			int option=sc.nextInt();
			if(option==1) {
				if(ss==null)ss=new Students();
				System.out.println("\n1.Add new Student\n"
						+ "2.View Existing Students\n"
						+ "3.Edit Student details\n"
						+ "4.Delete Student\n"
						+ "Select choice");
				int choice=sc.nextInt();
				switch(choice) {
				case 1:{
					System.out.println("Name\t Email\t course\t fee\t paid\taddress\t phone");
					String [] s=sc.nextLine().trim().split("[ ]+");
					ss.addStudent(s);
					ss=new Students();
					break;
				}
				case 2:{
					ss.viewStudents();
					ss=new Students();
					break;
				}
				case 3:{
					ss.editStudent();
					ss=new Students();
					break;
				}
				case 4:{
					ss.deleteStudent();
					ss=new Students();
					break;
				}
				default:System.err.println("Invalid choice");
				}
			}
			else if(option==2) {
				if(ss==null)new Students();
			}
			else 
				sc.close();return;
		}
	}
}
class Accountants{
	
	static List<Accountant> accl;
	static JDBC jdbc;
	public Accountants() {
		Runnable r=this::load;
		Thread t=new Thread(r);
		t.start();
		jdbc=new JDBC();
	}
	public void load() {
		accl=new ArrayList<>();
		JDBC sql=new JDBC();
		try {
			ResultSet rs=sql.getDetails("accountant");
			while(rs.next()) {
				accl.add(new Accountant(rs.getInt("id"), rs.getString("name"), rs.getString("email"), rs.getString("phone")));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public boolean addAccountant(String[] s) {
		try {
			jdbc.addRow(1,s);
		} catch (Exception e) {
			return false;
		}
		return true;
	}
	public boolean deleteAccountant(int id) {
		try {
			jdbc.deleteRow(1,id);
		} catch (Exception e) {
			return false;
		}
		return true;
	}
	public void viewAccountants() {
		try {
			jdbc.getDetails("accountant");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void editAccountant(int id) {
		jdbc.editRow(id);
	}

}