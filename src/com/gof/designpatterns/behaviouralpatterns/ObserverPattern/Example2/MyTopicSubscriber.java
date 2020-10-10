package com.gof.designpatterns.behaviouralpatterns.ObserverPattern.Example2;

public class MyTopicSubscriber implements Observer {
    
    private String name;
    private Subject topic;
     
    public MyTopicSubscriber(String nm){
        this.name=nm;
    }
    @Override
    public void update() {
        String msg = (String) topic.getUpdate(this);
        if(msg == null){
            System.out.println(name+":: No new message");
        }else
        System.out.println(name+":: Consuming message::"+msg);
    }
 
    @Override
    public void setSubject(Subject sub) {
        this.topic=sub;
    }
 
}
/*Notice the implementation of update() method where it’s calling Subject getUpdate() method to get the message to consume. We could have avoided this call by passing message as argument to update() method.

Here is a simple test program to consume our topic implementation.
*/