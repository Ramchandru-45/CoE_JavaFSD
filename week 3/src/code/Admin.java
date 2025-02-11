package code;

import java.util.Scanner;

public class Admin {

	private int id;
	private String username;
	
	public Admin(int id,String username) {
		this.id=id;
		this.username=username;
	}
	
	public void AdminPage() {
		Scanner sc=new Scanner(System.in);
		boolean login=true;
		while(login) {
			System.out.println("Admin:  "+this.id+" "+this.username);
			System.out.println("\n1.Manage Accountants\n2.Logout");
			int option=sc.nextInt();
			if(option==1) {
				Accountants as=new Accountants();
				System.out.println("\n1.Add new Accountant\n"
						+ "2.View Existing Accountant\n"
						+ "3.Edit accountant details\n"
						+ "4.Delete Accountant\n"
						+ "Select choice");
				int choice=sc.nextInt();
				switch(choice) {
				case 1:{
					System.out.println("Name\tEmail\tPhone");
					String[] s=sc.nextLine().split("[ ]+");
					as.addAccountant(s);
					as=new Accountants();
					break;
				}
				case 2:{
					as.viewAccountants();
					break;
				}
				case 3:{
					System.out.print("Enter id to edit record");
					as.editAccountant(sc.nextInt());
					break;
				}
				case 4:{
					System.out.print("Enter id to delete record");
					as.deleteAccountant(sc.nextInt());
					break;
				}
				default:System.err.println("Invalid choice");
				}
			}
			else {
				login=false;
			}
			sc.close();
		}
	}
}
