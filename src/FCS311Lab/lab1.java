package FCS311Lab;

import java.util.Scanner;


public class lab1 implements Queue {

	int front;
	int last;
	Object[] queue;
	
	public lab1(int initialCapacity)
	{
		if(initialCapacity < 1)
		{
				throw new IllegalArgumentException
					("initialCapacity must be >= 1");			
		}
		queue = new Object [initialCapacity + 1];
	}
	
	public lab1()
	{
		this(10);
	}
	
	public boolean isEmpty()
	{
		return front==last;
	}
	
	public Object getFrontElement()
	{
		if(isEmpty())
			return null;
		else
			return queue[(front+1) % queue.length];
	}
	
	public Object getLastElement()
	{
		if(isEmpty())
			return null;
		else
			return queue[last];
	}
	
	public void put(Object theElement)
	{
		if((last+1) % queue.length == front)
		{
			Object[] newQueue = new Object[2*queue.length];
			int start = (front+1) % queue.length;
			if(start<2)
				System.arraycopy(queue, start, newQueue, 0, queue.length-1);
			else
			{
				System.arraycopy(queue, start, newQueue, 0, queue.length-start);
				System.arraycopy(queue, 0, newQueue, queue.length-start, last+1);
			}
			front = newQueue.length-1;
			last = queue.length-2;
			queue = newQueue;
		}
		last = (last+1) % queue.length;
		queue[last] = theElement;
	}
	
	public Object remove() {
		if(isEmpty())
			return null;
		front = (front+1)%queue.length;
		Object frontElement = queue[front];
		queue[front] = null;
		return frontElement;
	}
	
	public void showQueue()
	{
		if(front==last)
		{
			System.out.printf("\nQueue is empty\n");
			return;
		}
		for(int i=front; i<last; i++)
		{
			System.out.printf("%d ", queue[i+1]);
		}
		return;
	}
	
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

	@Override
	public Object getRearElement() {
		// TODO Auto-generated method stub
		return null;
	}
}


















