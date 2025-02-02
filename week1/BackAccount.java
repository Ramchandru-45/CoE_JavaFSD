package techm;

public class BackAccount extends Thread {

	String user;
	int Balance=100;
	
	public BackAccount(String user) {
		super();
		this.user = user;
		start();
	}
	public void deposit(double amount) {
		this.Balance+=amount;
	}
	public String withdraw(double amount) {
		if(this.Balance-amount<100) {
			return "Low Balance";
		}
		else {
			this.Balance-=amount;
			return "Amount withdrawn";
		}
	}
	
	public void run() {
		if(this.user.equals("Arun")) {
			deposit(200);
			System.out.println(withdraw(100));
			
		}
		else {
			deposit(500);
			System.out.println(withdraw(200));
			
		}
	}
	public static void main(String[] args) {
		BackAccount ba=new BackAccount("Arun");
		BackAccount ba1=new BackAccount("Surya");
		
		
	}

}
