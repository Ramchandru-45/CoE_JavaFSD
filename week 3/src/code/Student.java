package code;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Student {
	
	private int id;
	private String name;
	private String email;
	private String course;
	private double fee;
	private double paid;
	private double due;
	private String address;
	private String phone;
	public Student(int id, String name, String email, String course, double fee, double paid, double due,
			String address, String phone) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.course = course;
		this.fee = fee;
		this.paid = paid;
		this.due = due;
		this.address = address;
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
	public String getCourse() {
		return course;
	}
	public void setCourse(String course) {
		this.course = course;
	}
	public double getFee() {
		return fee;
	}
	public void setFee(double fee) {
		this.fee = fee;
	}
	public double getPaid() {
		return paid;
	}
	public void setPaid(double paid) {
		this.paid = paid;
	}
	public double getDue() {
		return due;
	}
	public void setDue(double due) {
		this.due = due;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	
}

class Students{
	Scanner sc=new Scanner(System.in);
	static List<Student> sl;
	JDBC jdbc;
	public Students() {
		Runnable r=this::load;
		Thread t=new Thread(r);
		t.start();
		jdbc=new JDBC();
	}
	public void load() {
		sl=new ArrayList<>();
		JDBC sql=new JDBC();
		try {
			ResultSet rs=sql.getDetails("student");
			while(rs.next()) {
				sl.add(new Student(rs.getInt("id"), rs.getString("name"), rs.getString("email"), rs.getString("course"),
						rs.getDouble("fee"),rs.getDouble("paid"),rs.getDouble("due"),rs.getString("address"),rs.getString("phone")));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public boolean addStudent(String[] s) {
		try {
			jdbc.addRow(2, s);
		} catch (Exception e) {
			return false;
		}
		return true;
	}
	public boolean deleteStudent() {
		try {
			jdbc.deleteRow(2, sc.nextInt());
		} catch (Exception e) {
			return false;
		}
		return true;
	}
	public void viewStudents() {
		try {
			jdbc.getDetails("student");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void editStudent() {
		System.out.print("Enter id to edit record");
		jdbc.editRow(sc.nextInt());
	}
	public void getDueStudents() {
		try {
			jdbc.getDue();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}