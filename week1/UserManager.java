package techm;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

public class UserManager {

	static List<UserManager> um;
	public String name;
	public String email;
	
	public UserManager() {
		super();
		if(um==null) {
			um=new ArrayList<>();
		}
		um.add(this);
	}
	
	public void addUser(String name,String email) {
		this.name=name;
		this.email=email;
	}
	
	public static boolean saveUsersToFile(String filename) {
		try {
			FileOutputStream f=new FileOutputStream(new File(filename));
			for(UserManager i:um) {
				StringBuffer sb=new StringBuffer(i.name+" "+i.email+"\n");
				for(int j=0;j<sb.length();j++) {
					f.write(sb.charAt(j));
				}
			}
			f.close();
			return true;
		}
		catch(Exception e) {
			return false;
		}
	}
	
	public static void loadUsersFromFile(String filename) {
		try {
			FileInputStream f=new FileInputStream(new File(filename));
			f.transferTo(System.out);
			f.close();
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		String filename="C:/Users/ramch/eclipse-workspace/TechM/src/techm/samp.txt";
		UserManager u1=new UserManager();
		u1.addUser("Arun", "arun@gmail.com");
		UserManager u2=new UserManager();
		u2.addUser("Surya", "surya@gmail.com");
		saveUsersToFile(filename);
		loadUsersFromFile(filename);

	}

}
