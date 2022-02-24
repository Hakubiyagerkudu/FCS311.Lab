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
	

	@Override
	public Object getRearElement() {
		// TODO Auto-generated method stub
		return null;
	}
}


















