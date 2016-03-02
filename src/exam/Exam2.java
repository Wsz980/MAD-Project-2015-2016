package exam;

import java.util.Scanner;


import util.In;

public class Exam2 {

	public Exam2() {
	Test();
		
	}
	public void Test() {
		System.out.println ("Do you want to do States And Capitals (SC) or STEM words (ST)?"); 
		Scanner type = new Scanner(System.in);
		String ty = type.next();
		
		if (ty.equals("SC") || ty.equals("sc") || ty.equals("Sc") || ty.equals("sC")) { 
			StatCap();		
		}
		if (ty.equals("ST") || ty.equals("st") || ty.equals("St") || ty.equals("sT")) { 
			SteRoot();		
		}

	}

	public void StatCap() {
		String[] states = In.readStrings("statefile.txt");
		String[] capitals = In.readStrings("capitalfile.txt");
		
		System.out.println ("Randomly Generated"); 
		System.out.println ("Yes / No"); 
		Scanner random = new Scanner(System.in);
		String randomStr = random.next();		
		
		System.out.println ("Minimum Num - "); 
		Scanner input1 = new Scanner(System.in);
		int in1 = input1.nextInt();

		System.out.println ("Maximum Num - "); 
		Scanner input2 = new Scanner(System.in);
		int in2 = input2.nextInt();
		
		System.out.println ("Test States or Capitals"); 
		Scanner rev = new Scanner(System.in);
		String rev2 = random.next();
		
		if (rev2.equals("Capitals") || rev2.equals("capitals")){
			for (int i = in1 - 1; i < in2; i++) {
			abc3(capitals, states, i);
			}
		}
		

		if (randomStr.equals("Yes") || randomStr.equals("yes")){
		for (int i = 0; i < in2 - in1 + 1; i++) {
		
		int ii = (int) (Math.random() * (double)(in2 - in1) + in1);
		abc(states, capitals, ii);
		}
		
	}else{
	
		for (int i = in1 - 1; i < in2; i++) {

			abc(states, capitals, i);

		}
	}
		

	}

	private void abc(String[] states, String[] capitals, int i) {
		System.out.println(states[i]);

		Scanner input = new Scanner(System.in);
		String answer = input.next();

		if (answer.equals(capitals[i])) {
			System.out.println("Correct");
			System.out.println();
		} else {
			System.out.println("Incorrect");
			System.out.println("Correct Answer - " + capitals[i]);
			System.out.println();

		}
	}
	
	
	private void abc3(String[] capitals, String[] states, int i) {
		System.out.println(capitals[i]);

		Scanner input = new Scanner(System.in);
		String answer = input.next();

		if (answer.equals(states[i])) {
			System.out.println("Correct");
			System.out.println();
		} else {
			System.out.println("Incorrect");
			System.out.println("Correct Answer - " + states[i]);
			System.out.println();

		}
	}
	//111111111111111111111111111111111111111111111111111111111111111111111111111111111111

	public void SteRoot() {
		String[] root = { "ac-","acerb-",
				"acid-" };
		String[] meaning = {"acid","summit","bitter"};

		
		System.out.println ("Minimum  - "); 
		Scanner input1 = new Scanner(System.in);
		int in1 = input1.nextInt();

		System.out.println ("Maximum  - "); 
		Scanner input2 = new Scanner(System.in);
		int in2 = input2.nextInt();

		System.out.println ("Randomly Generated"); 
		System.out.println ("Yes / No"); 
		Scanner random = new Scanner(System.in);
		String randomStr = random.next();
		
		if (randomStr.equals("Yes") || randomStr.equals("yes")){
		for (int i = 0; i < in2 - in1 + 1; i++) {
		
		int ii = (int) (Math.random() * (double)(in2 - in1) + in1);
		abc(root, meaning, ii);
		}
		
	}else{
	
		for (int i = in1 - 1; i < in2; i++) {

			abcd(root, meaning, i);

		}
	}
		

	}

	private void abcd(String[] root, String[] meaning, int i) {
		System.out.println(root[i]);

		Scanner input = new Scanner(System.in);
		String answer = input.next();

		if (answer.equals(meaning[i])) {
			System.out.println("Correct");
			System.out.println();
		} else {
			System.out.println("Incorrect");
			System.out.println("Correct Answer - " + meaning[i]);
			System.out.println();

		}
	}
	
	public static void main(String[] args) {
		Tests tests = new Tests();

	}

}
