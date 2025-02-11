package code;

import java.sql.SQLException;

public class Main {

	public static void main(String[] args) {
		LogPage lp=new LogPage();
		try {
			lp.signIn();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Closing");
	}

}
