package math;

import test.TestInterface;
public class TestImplemenatation implements TestInterface{
  public String name="First";
	
	public String firstContract(){
		return name+"Aravind";
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		TestImplemenatation test=new TestImplemenatation();
		System.out.println(test.firstContract());
	}

}
