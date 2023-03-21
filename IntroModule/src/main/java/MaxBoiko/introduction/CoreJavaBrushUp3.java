package main.java.MaxBoiko.introduction;

public class CoreJavaBrushUp3 {

	public static void main(String[] args) {
		
		// string is an object //literal
		String s = "Max";
		
		//new
		String s1 = new String("Some text here");
		
		String s5 = "Max Boiko Student";
		String[] splittedString = s5.split("Boiko");
		
		for (int i = 0; i < splittedString.length; i++) {
			System.out.println(splittedString[i]);
			System.out.println(splittedString[i].trim());
		}
		
		for (int j = 0; j < s5.length(); j++) {
			System.out.println(s5.charAt(j));
		}
		
		for (int j = s5.length()-1; j >= 0; j--) {
			System.out.println(s5.charAt(j));
		}
		
		

	}

}
