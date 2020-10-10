package com.vaannila.helloworld;

import java.util.concurrent.BlockingQueue;

public class MyProducer implements Runnable {

	public BlockingQueue queue=null;
	
	public MyProducer(BlockingQueue queue)
	{
		this.queue=queue;	
	}
	public void run()
	{
		try {
			queue.put("1");
            Thread.sleep(1000);
            queue.put("2");
            Thread.sleep(1000);
            queue.put("3");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
