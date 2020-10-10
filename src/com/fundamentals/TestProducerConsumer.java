package com.fundamentals;

/*
 * TestProducerConsumer.java
 * 
 * 
 */

import java.util.concurrent.ExecutorService;

import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class TestProducerConsumer

{

public static void main(String args[])

{

try

{
	/*
	 * the Broker class which is being used as filing cabinet between the producers and consumers. 
	 */
Broker broker = new Broker();
/*
 using ExecuteService to create a thread pool and manage it. Instead of using the basic Thread implementation,
this is a more effective way as it will handle the exiting and restarting the threads as needed. 
You will also notice that I am using Future class to get the status of the producer thread.
 This class is very effective and will halt my program from further execution. 
 This is a nice way of replacing the “.join” method on the threads. Note:
  I am not using Future very effectively in this example; so you may have to try a few things as you feel fit. 
 */
ExecutorService threadPool = Executors.newFixedThreadPool(3);

threadPool.execute(new ConsumerArray("1", broker));

threadPool.execute(new ConsumerArray("2", broker));

Future producerStatus = threadPool.submit(new ProducerArray(broker));

// this will wait for the producer to finish its execution.

producerStatus.get();
threadPool.shutdown();

}

catch (Exception e)

{

e.printStackTrace();

}

}

}
