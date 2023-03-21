package main.java.MaxBoiko.introduction;

public class MethodsDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		MethodsDemo demo = new MethodsDemo();
		//demo.getData();
		String someName = demo.getData();
		System.out.println(someName);
		MethodsDemo2 demo2 = new MethodsDemo2();
		demo2.getUserData();
		getData2();

	}
	
	public String getData() {
		System.out.println("Hello World");
		return "Max Boiko Student";
	}
	
	public static String getData2() {
		System.out.println("Hello World");
		return "Max Boiko Student";
	}

}
