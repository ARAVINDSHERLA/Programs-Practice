package com.vaannila.helloworld;

import java.util.concurrent.BlockingQueue;

public class MyConsumer implements Runnable{
public BlockingQueue queue=null;
	
	public MyConsumer(BlockingQueue queue)
	{
		this.queue=queue;	
	}
	public void run()
	{
		try {
			System.out.println(queue.take());
            System.out.println(queue.take());
            System.out.println(queue.take());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
