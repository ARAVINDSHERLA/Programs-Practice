package com.fundamentals;

/*
 This class is doing the most simplest of things that it can do – adding an integer to the broker.
  Some key areas to note are:
 1. There is a property on Broker which is updated in the end by the producer when its done producing.
  This is also known as the “final” or “poison” entry. This is used by the consumers to know that there
   are no more data coming up
 2. I have used Thread.sleep to simulate that some producers may take more time to produce the data.
  You can tweak this value and see the consumers act 
 */
public class ProducerArray implements Runnable

{

private Broker broker;

public ProducerArray(Broker broker)

{

this.broker = broker;

}

@Override

public void run()

{

try

{

for (Integer i = 1; i < 5 + 1; ++i)

{

System.out.println("Producer produced: " + i);

Thread.sleep(100);

broker.put(i);
}

this.broker.continueProducing = Boolean.FALSE;

System.out.println("Producer finished its job; terminating.");

}

catch (InterruptedException ex)

{

ex.printStackTrace();

}

}

}