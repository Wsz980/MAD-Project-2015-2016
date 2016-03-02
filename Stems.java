package exam.stems;


import java.util.ArrayList;
import java.util.Scanner;


import util.In;

public class Stems {
	// not used
	int mindrawRecieve;
;
	
	private String stateSelect;
	private String capitalSelect1;
	private String capitalSelect2;
	private String capitalSelect3;
	private String capitalSelect4;
	private String answ;
	private int dataSize;
	private int dataArray;
	
	public String[] choiceArr = new String[4];
	
	public Stems(int current, int ifile) {
	//Test();
	String path = "data/StemData/";
	String[] arrFilename= {
			"stem01.txt",
			"stem02.txt",
			"stem03.txt",
			"stem04.txt",
			"stem05.txt",
			"stem06.txt",
			"stem07.txt",
			"stem08.txt",
			"stem09.txt",
			"stem10.txt",
			"stem11.txt",
			"stem12.txt",
			"stem13.txt",
			"stem14.txt",
			"stem15.txt"
			};
	
	ArrayList<String> datalist = inputData(path + arrFilename[ifile]);

	ArrayList<String> states = getQuestion(datalist);
	ArrayList<String> capitals = getAwnser(datalist);
	
	   select(current, states, capitals);
	}

	public void select(int current, 
			ArrayList<String> states, 
			ArrayList<String> capitals) {		
						
			
			dataSize = states.size();
			
			int in1;
			if(current < 0 || current > dataSize){
				in1 = (int) (Math.random() * dataSize);
			} else {
			    in1 = current;
			}
	
				int i1 = in1;  //(int) (Math.random() * (double) (stateSize));	
				
				int i2 = (int) (Math.random() * (double) (dataSize));
				while(i2 == i1) {
					i2 = (int) (Math.random() * (double) (dataSize));
				}
				
				int i3 = (int) (Math.random() * (double) (dataSize));
				while(i3 == i1 || i3 == i2) {
					i3 = (int) (Math.random() * (double) (dataSize));
				}
				
				int i4 = (int) (Math.random() * (double) (dataSize));
				while(i4 == i1 || i4 == i2 || i4 == i3) {
					i4 = (int) (Math.random() * (double) (dataSize));
				}
				
				int i5 = (int) (Math.random() * (double) (dataSize));
				while(i5 == i1 || i5 == i2 || i5 == i3 || i5 == i4) {
					i5 = (int) (Math.random() * (double) (dataSize));
				}
				
				int[] choiceValue = new int[4];
				
				choiceValue[0] = i2;
				choiceValue[1] = i3;
				choiceValue[2] = i4;
				choiceValue[3] = i5;
				
				int ianswer = (int) (Math.random() * (double) (choiceValue.length));
				int ianswerValue = choiceValue[ianswer];
				choiceValue[ianswer] = in1;
				
				stateSelect = states.get(choiceValue[ianswer]);
				answ =  capitals.get(choiceValue[ianswer]);
				dataArray =  ianswerValue;
				
				for(int ii=0; ii<4; ii++) {
				    choiceArr[ii] = capitals.get(choiceValue[ii]);
				}
	//			capitalSelect1 =  capitals.get(i1);
	//			capitalSelect2 =  capitals.get(i2);
	//			capitalSelect3 =  capitals.get(i3);
	//			capitalSelect4 =  capitals.get(i4);
	
						
	//			ArrayList<String> cp = new ArrayList<String>();
	//			cp.add(capitalSelect1);
	//			cp.add(capitalSelect2);
	//			cp.add(capitalSelect3);
	//			cp.add(capitalSelect4);
	
	
		}
        
	public ArrayList<String> inputData (String fileName) {
		In inCapi = new In(fileName);
		
		ArrayList<String> dataArrList = new ArrayList<String>();
		int icp = 0;
		while(inCapi.hasNextLine()) {
			dataArrList.add(inCapi.readLine());
		  icp++;
		}
		return dataArrList;
	}

	public ArrayList<String> getQuestion(ArrayList<String> dataArrList) {
		ArrayList<String> qArrList = new ArrayList<String>();
		for(int ii=0; ii<dataArrList.size(); ii++) {
			String sss=dataArrList.get(ii);
			String[] sssArr = sss.split("\\s+");
			qArrList.add(sssArr[0]);
		}
		return qArrList;
	}
	
	public ArrayList<String> getAwnser(ArrayList<String> dataArrList) {
		ArrayList<String> aArrList = new ArrayList<String>();
		
		for(int ii=0; ii<dataArrList.size(); ii++) {
			String sss=dataArrList.get(ii);
			String[] sssArr = sss.split("\\s+");
			
			String ansStr = sssArr[1];
			for(int jj=2; jj<sssArr.length; jj++) {
			   ansStr = ansStr + " " + sssArr[jj];
			}
			
			aArrList.add(ansStr);
		}
		return aArrList;
	}	

	public int getDataSize() {
		return dataSize;
	}
	
	public String[] getChoiceArr() {
		return choiceArr;
	}
	


	public String getState() {
		return stateSelect;
	}

	public String answ() {
		return answ;
	}
	
	public int getdataArray() {
		return dataArray;
	}
	// ------------------------------------- //
	
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
	
	// ----------------------------------------------------------- //
	
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
	
	
	public String[] inputp1(String filep1) {
		In inState = new In(filep1);	
		String[] states = new String[25];
		int ist = 0;
		while(inState.hasNextLine()) {
		  states[ist] = inState.readLine();
		  ist++;
		}
		return states;
	}
	
	public static void main(String[] args) {
		//Stems tests = new Stems(1);

	}

}
