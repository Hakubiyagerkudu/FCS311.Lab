package FCS311Lab;

import java.util.Scanner;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		lab1 bool  = new lab1(10);
		boolean exit = false;
		String inputValue;
		
		Scanner king = new Scanner(System.in);
		System.out.println("How many number input? Enter your number: ");
		int n = king.nextInt();
		for(int k=0;k<n;k++)
		{
			bool.put(king.nextInt());			
		}
		bool.showQueue();
		command();
		
		try {
			while(exit==false)
			{
				System.out.print("\nCommand bicheerei: ");
				inputValue = king.next();
				
				switch(inputValue) {
				case "last": System.out.println(bool.getLastElement());
					break;
				case "first": System.out.println(bool.getFrontElement());
					break;
				case "empty":	System.out.println(bool.isEmpty());
					break;
				case "add":	System.out.println("How many number input? Enter your number: ");
				int p = king.nextInt();
				for(int k=0;k<p;k++)
				{
					bool.put(king.nextInt());			
				}
				System.out.println("Succesful!");
					break;
				case "remove":	bool.remove(); System.out.println("\nFirst element successfully removed!");
					break;
				case "show": 	System.out.println("Recent Queue: "); bool.showQueue();
					break;
				}
			}
		}catch(Exception e) {
			System.out.println(e);
		}
			
	}
	public static void command() {
		System.out.println("\n\n---- Command ----\n");
		System.out.println(" last   :  suuliin elementiig harah");
		System.out.println(" first  :  ehnii elementiig harah");
		System.out.println(" empty  :  hooson eshiig harah");
		System.out.println(" add    :  element nemeh");
		System.out.println(" remove :  element ustgah");
		System.out.println(" show   :  queue harah");
	}

	


}
