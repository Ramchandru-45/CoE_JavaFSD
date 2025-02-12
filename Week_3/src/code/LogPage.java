package code;

import java.sql.SQLException;
import java.util.Scanner;

public class LogPage {
	public JDBC jdbc;
	Admin ad;
	Accountant ac;
	public void signIn() throws SQLException,ClassNotFoundException{
		Scanner sc=new Scanner(System.in);
		while(true) {
			System.out.println("Sign In");
			System.out.println("1.Admin\n2.Accountant");
			int choice=sc.nextInt();
			switch(choice) {
			case 1:{
				
				jdbc=new JDBC();
				System.out.print("Enter Username: ");
				String username=sc.next().trim();
				System.out.print("Enter password: ");
				String password=sc.next().trim();
				try {
					ad=(Admin)jdbc.checkUser("admin",username,password);
					
				} catch (InvalidCredentialError e) {
					System.err.println("Invalid credential: Please try again");
					break;
				}
				ad.AdminPage();
				break;
			}
			case 2:{
				
				jdbc=new JDBC();
				System.out.print("Enter Username: ");
				String username=sc.next().trim();
				System.out.print("Enter password: ");
				String password=sc.next().trim();
				try {
					ac=(Accountant)jdbc.checkUser("accountant",username,password);
					
				} catch (InvalidCredentialError e) {
					System.err.println("Invalid credential: Please try again");
					break;
				}
				ac.AccountantPage();
				break;
			}
			default:{
				System.err.println("Invalid input");
				jdbc.con.close();
				sc.close();
				return;
				}
			}
		}
	}
}
