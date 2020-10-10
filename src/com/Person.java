package com;

class TestRuntimeException extends RuntimeException
{ 
	 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public String exceptionMessage;
	public TestRuntimeException(String message)
	{
	 	exceptionMessage=message;
	}
	public String toString()
	{
		return exceptionMessage;
	}
}


public class Person {
	  private String name;

	  public Person(String name) {
	    /*if (name == null)
	      throw new IllegalArgumentException();*/
           /*if (name==null)
        	   throw new TestRuntimeException("Null Pointer");*/
	    this.name = name;
	  }

	  public String getName()throws TestRuntimeException {
		  if (name==null)
       	   throw new TestRuntimeException("Null Pointer");
	    return name;
	  }

	  public String getFullName()
	  {
		  return getName();
	  }
	  
	  
	  public static void main(String... args) {
	    Person person = new Person(null); // bug is detected here
	   // System.out.println(person.getName().length());
	    System.out.println(person.getFullName().length());
	  }
	}