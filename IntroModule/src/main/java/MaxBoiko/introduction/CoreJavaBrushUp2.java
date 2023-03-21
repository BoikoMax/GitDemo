package main.java.MaxBoiko.introduction;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CoreJavaBrushUp2 {

	public static void main(String[] args) {
		
		int[] arr = {1, 2, 4, 8, 12, 15, 17, 19, 124, 246, 341, 522};
		
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] % 2 == 0) {
				System.out.println(arr[i]);
				//break;
			}
			else {
				System.out.println(arr[i] + " is not multiple of 2");
			}
		}
		
		ArrayList<String> newArray = new ArrayList<String>();
		newArray.add("Max");
		newArray.add("Boiko");
		newArray.add("Student");
		newArray.add("Selenium");
		newArray.remove(1);
		System.out.println(newArray.get(0));
		
		for (int i = 0; i < newArray.size(); i++) {
			System.out.println(newArray.get(i));
		}
		
		System.out.println("*************");
		
		for (String var : newArray) {
			System.out.println(var);
		}
		
		System.out.println(newArray.contains("Max"));
		
		//convert array into ArrayList
		
		String[] name = {"Max", "Boiko", "student"};
		List<String> newName = Arrays.asList(name);
		System.out.println(newName.contains("BlaBlaBla"));
		System.out.println(newName.contains("Boiko"));
		
	}

}
