package code;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class Admin {

	private int id;
	private String username;
	List<Accountant> acl;
	public Admin(int id,String username) {
		this.id=id;
		this.username=username;
	}
	
	public void AdminPage() throws SQLException,ClassNotFoundException{
		JDBC db=new JDBC();
		acl=db.loadAccountant();
		Scanner sc=new Scanner(System.in);
		while(true) {
			System.out.println("Admin:  "+this.id+" "+this.username);
			System.out.println("\n1.Manage Accountants\n2.Logout");
			int option=sc.nextInt();
			if(option==1) {
				System.out.println("\n1.Add new Accountant\n"
						+ "2.View Existing Accountant\n"
						+ "3.Edit accountant details\n"
						+ "4.Delete Accountant\n"
						+ "Select choice");
				int choice=sc.nextInt();
				switch(choice) {
				case 1:{
					System.out.print("Enter name: ");
					String name=sc.next();
					System.out.print("Enter email: ");
					String email=sc.next();
					System.out.print("Enter phone: ");
					int phone=Integer.parseInt(sc.next());
					int id=db.addAccountant(name,email,phone);
					acl.add(new Accountant(id,name, email, phone));
					
					break;
				}
				case 2:{
					System.out.println("Accountant Record");
					for(Accountant a:acl) {
						System.out.println(a);
					}
					break;
				}
				case 3:{
					
					break;
				}
				case 4:{
					System.out.print("Enter id to delete: ");
					int id=sc.nextInt();
					for(Accountant a:acl) {
						if(a.getId()==id) {
							acl.remove(a);
							db.deleteAccountant(id);
						}
					}
					break;
				}
				default:System.err.println("Invalid choice");
				}
			}
			else {
				sc.close();
				return;
			}
		}
	}
}
