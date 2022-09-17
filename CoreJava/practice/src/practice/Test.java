package practice;

import java.util.Random;
import java.util.Scanner;

public class Test {
	Philospher[] philosphers;
	Fork[] fork;
	Thread[] threads;
	int num;
	Scanner sc;
	public static void main(String[] args)
	{
		Test obj=new Test();
		obj.init();
		obj.startthinking();
		
	}
	public void init()
	{
		sc=new Scanner(System.in);
		System.out.println("dinning philospher rpoblem");
		try
		{
			System.out.println("enter the number of philospher");
			num=sc.nextInt();
			if(num<2)
			{
				System.out.println("philospher number must be grater than 1");
				return;
			}
		}
		catch(Exception e)
		{
			System.out.println("u must enter a positive integre");
		}
		philosphers=new Philospher[num];
		fork=new Fork[num];
		threads=new Thread[num];
		for(int i=0;i<num;i++)
		{
			philosphers[i]=new Philospher(i+1);
			fork[i]= new Fork(i+1);
		}
	}
	public void startthinking()
	{
		for(int i=0;i<num;i++)
		{
			final int index=i;
			threads[i]=new Thread(new Runnable() {
				public void run() {
					try
					{
						philosphers[index].start(fork[index],(index -1 > 0)? fork[index-1]:fork[num-1]);
					}
					catch(InterruptedException e)
					{
						e.printStackTrace();
					}
				}
			});
			threads[i].start();
		}
	}
	public class Philospher
	{
		private int philospherid;
		private Fork left,right;
		Philospher(int philospherid)
		{
			this.philospherid=philospherid;
		}
		public void start(Fork left,Fork right) throws InterruptedException
		{
			this.left=left;
			this.right=right;
			while(true)
			{
				if(new Random().nextBoolean())
					eat();
				else
					think();
			}
		}
		public void think() throws InterruptedException
		{
			System.out.println("the philospher is"+philospherid+"is now thinking");
			Thread.sleep(new Random().nextInt(1000)+100);
			System.out.println("The philospher is"+philospherid+"has stopped thinking");
		}
		public void eat() throws InterruptedException
		{
			boolean rightpick=false;
			boolean leftpick=false;
			System.out.println("the philospher "+philospherid+"is now hungry and want to eat");
			System.out.println("the philospher "+philospherid+"is now picking up the fork"+left.forkid);
			leftpick=left.pickup(philospherid);
			if(!leftpick)
			{
				return;
			}
			System.out.println("the philospher "+philospherid+"is now picking up the fork"+right.forkid);
			rightpick=right.pickup(philospherid);
			if(!rightpick)
			{
				left.free();
				return;
			}
			System.out.println("the philospher "+philospherid+"is now eating");
			Thread.sleep(new Random().nextInt(1000)+100);
			left.free();
			right.free();
			System.out.println("the philospher "+philospherid+"is now stopped eating free for forks");
			
		}
		
	}
	public class Fork
	{
		private int forkid;
		private boolean status;
		Fork(int forkid)
		{
		this.forkid=forkid;
		this.status=true;
		}
		public synchronized void free() throws InterruptedException
		{
			status=true;
		}
		public synchronized boolean pickup(int philospherid) throws InterruptedException
		{
			int counter=0;
			int waituntil=new Random().nextInt(10)+5;
			while(!status)
			{
				Thread.sleep(new Random().nextInt(100)+50);
				counter++;
				if(counter>waituntil)
				{
					return false;
				}
			
			}
			status=false;
			return true;
		}
		
	
	}
	

}
