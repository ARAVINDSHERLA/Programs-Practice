package com.concurrent.ExecutorFrameworkPractice.concurreny;


class A1 implements Runnable {
	private int counter = 0;
	
	public void run() {
	counter++;
	System.out.println("Running A1 -> " + counter);
	}
	}

	class B1 extends Thread {
	private int counter = 0;
	
	public void run() {
	counter++;
	System.out.println("Running B1 -> " + counter);
	}
	}

	public class ThreadDemo {
	public static void main(String[] args) throws InterruptedException {
	A1 a = new A1(); // Create runnable instance
	B1 b = new B1(); // Create Thread instance

	new Thread(a).start();
	Thread.sleep(1000);
	new Thread(a).start();
	Thread.sleep(1000);
	new Thread(a).start();
	Thread.sleep(1000);

	new B1().start();
	Thread.sleep(1000);
	new B1().start();
	Thread.sleep(1000);
	new B1().start();
	}
	}