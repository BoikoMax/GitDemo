package main.java.MaxBoiko.introduction;

public class CoreJavaBrushUp1 {

	public static void main(String[] args) {
		
		int num = 5;
		String website = "Ancestry";
		char letter = 'a';
		double dec = 16.99;
		boolean myWallet = true;
		
		System.out.println(num + " " + website + " " + letter);
		
		//Arrays
		
		//1
		int[] arr = new int[5];
		arr[0] = 1;
		arr[1] = 2;
		arr[2] = 3;
		arr[3] = 4;
		arr[4] = 5;
		
		//2
		int[] arr2 = {1, 2, 3, 4, 5};
		
		System.out.println(arr[0]);
		System.out.println(arr2[1]);
		
		//for loop
		
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
		
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr2[i]);
		}
		
		String[] name = {"Max", "Boiko", "student"};
		
		for (int i = 0; i < name.length; i++) {
			System.out.println(name[i]);
		}
		
		for (String someName : name) {
			System.out.println(someName);
		}

	}

}
