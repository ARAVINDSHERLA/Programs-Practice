package com.vaannila.helloworld;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	 BlockingQueue queue=new ArrayBlockingQueue(1024);
	 MyProducer producer=new MyProducer(queue);
	 MyConsumer consumer=new MyConsumer(queue);
	 new Thread(producer).start();
	 new Thread(consumer).start();
	 
	}

}
