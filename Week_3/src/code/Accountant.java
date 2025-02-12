package code;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class Accountant {
	private int id;
	private String name;
	private String email;
	private int phone;
	List<Student> sl;
	public Accountant(int id, String name, String email, int phone) {
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

	public int getPhone() {
		return phone;
	}

	public void setPhone(int phone) {
		this.phone = phone;
	}
	
	@Override
	public String toString() {
		
		return "id="+id+" name="+name+" email="+email+" phone="+phone;
	}
	
	public void AccountantPage() throws SQLException,ClassNotFoundException{
		Scanner sc=new Scanner(System.in);
		JDBC db=new JDBC();
		sl=db.loadStudent();
		while(true) {
			System.out.println("Accountant:  "+this.id+" "+this.name);
			System.out.println("\n1.Manage Students\n2.Check Due Fee\n3.Logout");
			int option=sc.nextInt();
			if(option==1) {
				System.out.println("\n1.Add new Student\n"
						+ "2.View Existing Students\n"
						+ "3.Edit Student details\n"
						+ "4.Delete Student\n"
						+ "Select choice");
				int choice=sc.nextInt();
				switch(choice) {
				case 1:{
					System.out.print("Name: ");
					String name=sc.next();
					System.out.print("Email: ");
					String email=sc.next();
					System.out.print("Course: ");
					String course=sc.next();
					System.out.print("Fee: ");
					double fee=sc.nextDouble();
					System.out.print("paid: ");
					double paid=sc.nextDouble();
					System.out.print("Adress: ");
					String address=sc.nextLine();
					System.out.print("phone: ");
					int phone=Integer.parseInt(sc.next());
					int id=db.addStudent(name, email, course, fee, paid, fee-paid, address, phone);
					sl.add(new Student(id, name, email, course, fee, paid, fee-paid, address, phone));
					break;
				}
				case 2:{
					System.out.println("Student Record");
					for(Student s:sl) {
						System.out.println(s);
					}
					break;
				}
				case 3:{
					
					break;
				}
				case 4:{
					System.out.print("Enter id to delete Student");
					int id=sc.nextInt();
					for(Student s:sl) {
						if(s.getId()==id) {
							sl.remove(s);
							db.deleteStudent(id);
						}
					}
					break;
				}
				default:System.err.println("Invalid choice");
				}
			}
			else if(option==2) {
				
			}
			else 
				sc.close();return;
		}
	}
}
