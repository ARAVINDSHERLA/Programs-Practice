package com;


import java.util.Date;
public final class ImmutableTest
{
	private String firstName;
	private String lastName;
	private Date dob;

	public ImmutableTest( String firstName,
	  String lastName, Date dob)
	{
		this.firstName = firstName;
		this.lastName = lastName;
		this.dob = new Date( dob.getTime() );
	}
	public String getFirstName()
	{
		return firstName;
	}
	public String getLastName()
	{
		return lastName;
	}
	public Date getDOB()
	{
		return new Date( this.dob.getTime() );
	}
	
	public static void main(String[] args)
	{
		ImmutableTest test=new ImmutableTest("David", "O'Meara", new Date());
	}
	}

