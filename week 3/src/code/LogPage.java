package code;

import java.sql.SQLException;
import java.util.Scanner;

public class LogPage {
	public JDBC jdbc;
	public void signIn() throws SQLException{
		Scanner sc=new Scanner(System.in);
		while(true) {
			System.out.println("Sign In");
			System.out.println("1.Admin\n2.Accountant");
			int choice=sc.nextInt();
			switch(choice) {
			case 1:{
				if(jdbc==null) 
					jdbc=new JDBC();
				System.out.print("Enter Username: ");
				String username=sc.next().trim();
				System.out.print("Enter password: ");
				String password=sc.next();
				try {
					Admin a=(Admin)jdbc.checkUser("admin",username,password);
					if(a==null) throw new InvalidCredentialError();
				} catch (Exception e) {
					System.err.println("Invalid credential");
				}
				
				break;
			}
			case 2:{
				if(jdbc==null)
					jdbc=new JDBC();
				System.out.print("Enter Username: ");
				String username=sc.next().trim();
				System.out.print("Enter password: ");
				String password=sc.next();
				try {
					Accountant a=(Accountant)jdbc.checkUser("accountant",username,password);
					if(a==null) throw new InvalidCredentialError();
				} catch (Exception e) {
					System.err.println("invalid credentials");
				}
				break;
			}
			default:{
				System.out.println("Invalid input");
				jdbc.con.close();
				sc.close();
				return;
			}
			}
		}
	}
}
