/**
 * 
 */
package com;

/**
 * PatternBox: "Client" implementation.
 * <ul>
 *   <li>requests the Singleton to get its unique instance.</li>
 * </ul>
 * 
 * @author Dirk Ehms, <a href="http://www.patternbox.com">www.patternbox.com</a>
 * @author Arvind
 */
public class Client {

	/** 
	 * Default constructor
	 */
	public Client() {
		super();
	}

	/** 
	 * This is just an example how to use the Singleton pattern. This operation
	 * must be customized based on your application needs.
	 */
	public void useSingleton() {
		// TODO: Customize this method based on your application needs.
		Singleton singleton = Singleton.getUniqueInstance();
		// call a Singleton method
		singleton.doSomething();
	}
	
	public static void main(String[] args){
		new Client().useSingleton();
		
		System s=null;
		s.out.println("aravind 232");
	
	
	}

}
