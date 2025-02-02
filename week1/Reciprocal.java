package techm;

import java.util.Scanner;

public class Reciprocal {
	
	static int a;
	static int b;

	
	public static void processInput() {
		Scanner sc=new Scanner(System.in);
		a=sc.nextInt();
		b=sc.nextInt();
		try {
			
			if(a==0 && b!=0) {
				throw new ReciprocalException();
			}
			System.out.println(b+"/"+a);
		}
		catch(ReciprocalException e) {
			e.print();
		}
		finally {
			System.out.println("End of Program");
			sc.close();
		}
	}
	
	public static void main(String[] args) {
		processInput();

	}

}

class ReciprocalException extends Exception{
	public ReciprocalException() {
		
	}
	
	public void print() {
		System.out.println("divide by zero");
	}
}