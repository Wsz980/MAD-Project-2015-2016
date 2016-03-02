package exam.state;


import java.util.ArrayList;
import java.util.Scanner;


import util.In;

public class StatCapi {
	// not used
	int mindrawRecieve;
; 
	
	private static String stateSelect;
	private String capitalSelect1;
	private String capitalSelect2;
	private String capitalSelect3;
	private String capitalSelect4;
	private String answ;
	
	public StatCapi(int mindraw) {
	//Test();
	select(mindraw);
	}
	
	public void randomGet(int randomtestGet) {
	select(randomtestGet);
		
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

	private void getDraw(){
	// not used
	mindrawRecieve = StatCapiGui.mindraw();
	
	}

	public void StatCap() {
		String[] states = In.readStrings("stemfirst.txt");
		String[] capitals = In.readStrings("stemsecond.txt");
		// String[] states = {
		// "Alabama","Alaska","Arizona","Arkansas","California","Colorado","Connecticut ",
		// "Delaware","Florida","Georgia","Hawaii","Idaho","Illinois","Indiana","Iowa",
		// "Kansas","Kentucky","Louisiana","Maine","Maryland","Massachusetts","Michigan","Minnesota",
		// "Mississippi","Missouri","Montana","Nebraska","Nevada","New Hampshire","New Jersey",
		// "New Mexico","New York","North Carolina","Ohio","Oklahoma","Oregon","Pennsylvania","Rhode Island",
		// "South Carolina","South Dakota","South Dakota","Tennessee","Texas","Utah","Vermont",
		// "Virginia","Washington","West Virginia","Wisconsin","Wyoming" };
		// String[] capitals =
		// {"Montgomery","Juneau","Phoenix","Little Rock","Sacramento","Denver","Hartford","Dover",
		// "Tallahassee","Atlanta","Honolulu","Boise","Springfield","Indianapolis","Des Moines",
		// "Topeka","Frankfort","Baton Rouge","Augusta","Annapolis","Boston","Lansing","St. Paul",
		// "Jackson","Jefferson City","Helena","Lincoln","Carson City","Concord","Trenton",
		// "SantaFe","Albany","Raleigh","Bismarck","Columbus","Oklahoma City","Salem","Harrisburg",
		// "Providence","Columbia","Pierre","Nashville","Austin","Salt Lake City","Montpelier",
		// "Richmond","Olympia","Charleston","Madison","Cheyenne"};

		System.out.println("Randomly Generated");
		System.out.println("Yes / No");
		Scanner random = new Scanner(System.in);
		String randomStr = random.next();

//		System.out.println("Minimum Num - ");
		Scanner input1 = new Scanner(System.in);
//		int in1 = input1.nextInt();
		int in1 = mindrawRecieve;
//		System.out.println("Maximum Num - ");
//		Scanner input2 = new Scanner(System.in);
//		int in2 = input2.nextInt();
		int in2 = in1 + 4;
		
		System.out.println("Test (F)orwards or or (B)ackwards");
		Scanner rev = new Scanner(System.in);
		String rev2 = rev.next();

		if (rev2.equals("B") || rev2.equals("b")) {
			for (int i = in1 - 1; i < in2; i++) {
				abc3(capitals, states, i);
			}
			
		} else {

			if (randomStr.equals("Yes") || randomStr.equals("yes")) {
				for (int i = 0; i < in2 - in1 + 1; i++) {
					int ii = (int) (Math.random() * (double) (in2 - in1) + in1);
					abc(states, capitals, ii);
				}
			} else {
				for (int i = in1 - 1; i < in2; i++) {
					abc(states, capitals, i);
				}
			}

		}

	}

	public String getState() {
		return stateSelect;
	}
	public String getCapital() {
		return capitalSelect1;
	}
	public String getCapital2() {
		return capitalSelect2;

	}	
	public String getCapital3() {
		return capitalSelect3;
	}
	public String getCapital4() {
		return capitalSelect4;
	}
	public String answ() {
		return answ;
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

	
	private void optionStaCap(String[] states, String[] capitals, int i) {
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
	
	public void select(int mindraw) {
		In inState = new In("data/StatCapData/statefile.txt");
		
		String[] states = new String[50];
		int ist = 0;
		while(inState.hasNextLine()) {
		  states[ist] = inState.readLine();
		  ist++;
		}
		
		In inCapi = new In("data/StatCapData/capitalfile.txt");
		
		String[] capitals = new String[50];
		int icp = 0;
		while(inCapi.hasNextLine()) {
		  capitals[icp] = inCapi.readLine();
		  icp++;
		}
		
//		System.out.println("Please select a starting number between 1 and 50");
//		Scanner input1 = new Scanner(System.in);
		int in1;
		if(mindraw <= 0 || mindraw > 46){
			in1 = (int) (Math.random() * 46.0);
		} else {
		    in1 = mindraw - 1;
		}
		int in2 = in1 + 4;

		int stateSize = states.length;
		int capitalSize = capitals.length;



			int i1 = (int) (Math.random() * (double) (in2 - in1) + in1);	
			
			int i2 = (int) (Math.random() * (double) (in2 - in1) + in1);
			while(i2 == i1) {
				i2 = (int) (Math.random() * (double) (in2 - in1) + in1);
			}
			
			int i3 = (int) (Math.random() * (double) (in2 - in1) + in1);
			while(i3 == i1 || i3 == i2) {
				i3 = (int) (Math.random() * (double) (in2 - in1) + in1);
			}
			
			int i4 = (int) (Math.random() * (double) (in2 - in1) + in1);
			while(i4 == i1 || i4 == i2 || i4 == i3) {
				i4 = (int) (Math.random() * (double) (in2 - in1) + in1);
			}
			
			int ianswer = (int) (Math.random() * (double) (in2 - in1) + in1);

			
//			System.out.println("The state is " + states[ianswer]);
			
			capitalSelect1 =  capitals[i1];
			capitalSelect2 =  capitals[i2];
			capitalSelect3 =  capitals[i3];
			capitalSelect4 =  capitals[i4];
			
			stateSelect = states[ianswer];
					
			ArrayList<String> cp = new ArrayList<String>();
			cp.add(capitals[i1]);
			cp.add(capitals[i2]);
			cp.add(capitals[i3]);
			cp.add(capitals[i4]);

			//int jj = (int) (Math.random() * 4);
			
//			System.out.println();
//			System.out.println("The choices are");
//			System.out.println(i1);
//			System.out.println(i2);
//			System.out.println(i3);
//			System.out.println(i4);
//			for(int ii = 0; ii < cp.size(); ii++) {
//				int iip = ii + 1;
//				System.out.println(iip + " " + cp.get(ii));
//			}

			

			
//			Scanner input2 = new Scanner(System.in);
//			int janswer = input1.nextInt() ;
			
			
			// String choice1 = nums[0];
			// String choice2 = nums[1];
			// String chioce3 = nums[2];
			// String choice4 = nums[3];
			//int r = (int) (Math.random());

//			if (capitals[ianswer].equals(cp.get(janswer - 1))){
//			System.out.println("Correct");
//			}else{
//			System.out.println("Inorrect, the correct answer is " + capitals[ianswer]);
//			}
			answ =  capitals[ianswer];
	}
		
		
	
	
	
	
	public static void main(String[] args) {
		StatCapi tests = new StatCapi(1);

	}

}
