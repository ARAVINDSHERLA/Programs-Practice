package com.fundamentals;

import java.util.concurrent.ArrayBlockingQueue;

import java.util.concurrent.TimeUnit;

public class Broker

{

	/*
	 ArrayBlockingQueue as the data holder. 
	  however, I will explain that the producers are going to place the data in the queue and the 
	  consumers will fetch from the queue in FIFO format. But, if the producers are slow, 
	 the consumers will wait for data to come in and if the array is full, the producers will wait 
	 for it to fill up
	 */
	
public ArrayBlockingQueue<Integer> queue = new ArrayBlockingQueue<Integer>(100);

public Boolean continueProducing = Boolean.TRUE;

public void put(Integer data) throws InterruptedException

{

this.queue.put(data);

}
public Integer get() throws InterruptedException

{
/*
  ‘poll’ function instead of get in the queue. This is to ensure that the consumers will not keep 
  waiting for ever and the waiting will time out after a few seconds. This helps us in inter-communication 
  and kill the consumers 
  when all the data is processed. (Note: try replacing poll with get and you will see some interesting outputs). 
 */
return this.queue.poll(1, TimeUnit.SECONDS);

}

}
