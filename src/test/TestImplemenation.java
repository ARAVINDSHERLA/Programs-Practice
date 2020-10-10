package test;

public class TestImplemenation implements TestInterface {

	public String firstContract(){
		return "Aravind";
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		TestImplemenation test=new TestImplemenation();
		System.out.println(test.firstContract());
	}

}
