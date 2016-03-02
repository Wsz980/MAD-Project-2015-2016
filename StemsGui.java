package exam.stems;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
//========================================== //

public class StemsGui extends JPanel implements ActionListener {

	int numcorrect = 0;
	int numincorrect = 0;
	String stateStr;
	String capStr1;
	String capStr2;
	String capStr3;
	String capStr4;
	String answ;
	int dataSize;
	int qnum;
	String startStr;
	String[] capitals = new String[4];

	int ifile = 0;
	int currentPrev = -10;
	
	boolean correctbl;
	boolean choiceBtnPress;
	boolean currentFlag;
	boolean notnum;

	
	private int current = 0;

	int cpvalue = 0;
	JTextField inputUML = new JTextField(20);

	JButton choiceBtn1 = new JButton("1");
	JButton choiceBtn2 = new JButton("2");
	JButton choiceBtn3 = new JButton("3");
	JButton choiceBtn4 = new JButton("4");
	JButton randomtest = new JButton("Random");
	JButton submit = new JButton("Submit");
	JButton next = new JButton("Next");
	JButton again = new JButton("Again");
	JButton random = new JButton("Random");
	JButton back = new JButton("Back");
	JButton reset = new JButton("Reset");
	
	//lists---
	JRadioButton list1 = new JRadioButton("List 1");
	JRadioButton list2 = new JRadioButton("List 2");
	JRadioButton list3 = new JRadioButton("List 3");
	JRadioButton list4 = new JRadioButton("List 4");
	JRadioButton list5 = new JRadioButton("List 5");
	JRadioButton list6 = new JRadioButton("List 6");
	JRadioButton list7 = new JRadioButton("List 7");
	JRadioButton list8 = new JRadioButton("List 8");
	JRadioButton list9 = new JRadioButton("List 9");
	JRadioButton list10 = new JRadioButton("List 10");
	JRadioButton list11 = new JRadioButton("List 11");
	JRadioButton list12 = new JRadioButton("List 12");
	JRadioButton list13 = new JRadioButton("List 13");
	JRadioButton list14 = new JRadioButton("List 14");
	JRadioButton list15 = new JRadioButton("List 15");
	
	boolean tc1 = false;
	boolean tc2 = false;
	boolean tc3 = false;
	boolean tc4 = false;
	boolean submit1 = false;


	public StemsGui() {

		getStateCapital(ifile);

		setLayout(null);

		addTexfield();

		addButton();
		
		addRadioButton();
	}



	private void getStateCapital(int ifile) {

		Stems stems = new Stems(current, ifile);
		dataSize = stems.getDataSize();
		stateStr = stems.getState();
		answ = stems.answ();
		capitals = stems.choiceArr;
		qnum = current + 1; //stems.getdataArray();
		
//		capStr1 = stems.getCapital();
//		capStr2 = stems.getCapital2();
//		capStr3 = stems.getCapital3();
//		capStr4 = stems.getCapital4();
//
//		String answer = answ;
//		capitals[0] = capStr1;
//		capitals[1] = capStr2;
//		capitals[2] = capStr3;
//		capitals[3] = capStr4;

	}


	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(Color.RED);

		try {
		BufferedImage wp = ImageIO.read(this.getClass().getResource("blank.png"));
		JLabel wIcon = new JLabel(new ImageIcon(wp));
		g.drawImage(wp, 170, 185, 20, 20, null);
		g.drawImage(wp, 0, 0, 500, 500, null);
		} catch (Exception e) {
		System.out.println("Problem1!");
		}


		g.setFont(new Font("TimesRoman", Font.PLAIN, 25));
		g.setColor(Color.black);
		g.drawString(qnum + ".", 10, 50);
		
		g.setFont(new Font("TimesRoman", Font.PLAIN, 25));
		g.setColor(Color.black);
		g.drawString(stateStr, 50, 50);

		g.setFont(new Font("TimesRoman", Font.PLAIN, 11));
		g.setColor(Color.black);
		g.drawString(capitals[0], 90, 100);

		g.setFont(new Font("TimesRoman", Font.PLAIN, 11));
		g.setColor(Color.black);
		g.drawString(capitals[1], 90, 170);

		g.setFont(new Font("TimesRoman", Font.PLAIN, 11));
		g.setColor(Color.black);
		g.drawString(capitals[2], 90, 240);

		g.setFont(new Font("TimesRoman", Font.PLAIN, 11));
		g.setColor(Color.black);
		g.drawString(capitals[3], 90, 310);

		if (correctbl) {
			if (choiceBtnPress){
				if(currentFlag){
			numcorrect = numcorrect + 1;
			choiceBtnPress = false;
			currentFlag = false;
				}
			}
			correct(g);
			correctcount(g);
			incorrectcount(g);
			currentFlag = false;
		} else {
			if (choiceBtnPress){
				if(currentFlag){
			numincorrect = numincorrect + 1;
			choiceBtnPress = false;
			currentFlag = false;
				}
			}
			correctcount(g);
			incorrect(g);
			incorrectcount(g);
		}
		if (notnum) {
			g.setFont(new Font("TimesRoman", Font.PLAIN, 15));
			g.setColor(Color.black);
			g.drawString("Please use a number", 40, 460);
		}
}

	
	private boolean checkAnswer(int ii) {
		if (capitals[ii].equals(answ)) {
			return true;
		} else {
			return false;
		}
	}

	public void actionPerformed(ActionEvent e) {
		Object src = e.getSource();
		
		boolean getList = true;

		// startStr = inputUML.getText();
		// textArea.append(text + newline);
		// textField.selectAll();

		if (src == choiceBtn1) {
			boolean ca = checkAnswer(0);
			if(currentPrev != current){
			currentFlag = true;
			currentPrev = current;
			}
			if (ca) {
				correctbl = true;
			} else {
				correctbl = false;
			}
			tc1 = true;
			tc2 = false;
			tc3 = false;
			tc4 = false;
			getList = false;
			choiceBtnPress = true;
			notnum = false;

		}
		if (src == choiceBtn2) {
			boolean ca = checkAnswer(1);
			if(currentPrev != current){
			currentFlag = true;
			currentPrev = current;
			}
			if (ca) {
				correctbl = true;
			} else {
				correctbl = false;
			}
			tc1 = false;
			tc2 = true;
			tc3 = false;
			tc4 = false;
			getList = false;
			choiceBtnPress = true;
			notnum = false;

		}
		if (src == choiceBtn3) {
			boolean ca = checkAnswer(2);
			if(currentPrev != current){
			currentFlag = true;
			currentPrev = current;
			}
			if (ca) {
				correctbl = true;
			} else {
				correctbl = false;
			}
			tc1 = false;
			tc2 = false;
			tc3 = true;
			tc4 = false;
			getList = false;
			choiceBtnPress = true;
			notnum = false;

		}
		if (src == choiceBtn4) {
			boolean ca = checkAnswer(3);
			if(currentPrev != current){
			currentFlag = true;
			currentPrev = current;
			}
			if (ca) {
				correctbl = true;
			} else {
				correctbl = false;
			}
			tc1 = false;
			tc2 = false;
			tc3 = false;
			tc4 = true;
			getList = false;
			choiceBtnPress = true;
			notnum = false;

		}
		
		if (src == submit) {
			startStr = inputUML.getText();
			if(isNumeric(startStr)) {
				current = Integer.parseInt(startStr) - 1;
				notnum = false;
				getStateCapital(ifile);
			}else{
				notnum = true;
			}
			tc1 = false;
			tc2 = false;
			tc3 = false;
			tc4 = false;
			getList = false;

		}
		
		if (src == next) {
			startStr = inputUML.getText();
			if(isNumeric(startStr) || startStr.equals("") ) {
				notnum = false;
				if (current >= dataSize){
					current = 0;
				}else{
					current = current + 1;	
				}
				getStateCapital(ifile);
			}else{
				notnum = true;
			}

			tc1 = false;
			tc2 = false;
			tc3 = false;
			tc4 = false;
			getList = false;

		}

	
	
		if (src == again) {
			getStateCapital(ifile);
			tc1 = false;
			tc2 = false;
			tc3 = false;
			tc4 = false;
			getList = false;
			currentFlag = true;
			notnum = false;

		}

	
		if (src == back) {
			startStr = inputUML.getText();
			if(isNumeric(startStr) || startStr.equals("") ) {
				notnum = false;
				if (current < 0){
					current = dataSize;
				}else{
					current = current - 1;	
				}
				getStateCapital(ifile);
			}else{
				notnum = true;
			}

			tc1 = false;
			tc2 = false;
			tc3 = false;
			tc4 = false;
			getList = false;

	}
		
		if (src == reset) {
			getStateCapital(ifile);
			numcorrect = 0;
			numincorrect = 0;
			tc1 = false;
			tc2 = false;
			tc3 = false;
			tc4 = false;
			getList = false;
			currentFlag = true;

	}
		



		if (src == random) {
			startStr = inputUML.getText();
			current = -1;
			getStateCapital(ifile);
			tc1 = false;
			tc2 = false;
			tc3 = false;
			tc4 = false;
			getList = false;
			notnum = false;

		}
		
		if (getList){
		  radioBtnListener(getList);
			tc1 = false;
			tc2 = false;
			tc3 = false;
			tc4 = false;
		} else {
		   getList = true;
		}
		
		repaint();
}


	private void radioBtnListener(boolean getList) {
		if (list1.isSelected()) {
			ifile = 0;
			current = 0;
			getStateCapital(ifile);
		}
		if (list2.isSelected()) {
			ifile = 1;
			current = 0;
			getStateCapital(ifile);
		}
		if (list3.isSelected()) {
			ifile = 2;
			current = 0;
			getStateCapital(ifile);
		}
		if (list4.isSelected()) {
			ifile = 3;
			current = 0;
			getStateCapital(ifile);
		}
		if (list5.isSelected()) {
			ifile = 4;
			current = 0;
			getStateCapital(ifile);
		}
		if (list6.isSelected()) {
			ifile = 5;
			current = 0;
			getStateCapital(ifile);
		}
		if (list7.isSelected()) {
			ifile = 6;
			current = 0;
			getStateCapital(ifile);
		}
		if (list8.isSelected()) {
			ifile = 7;
			current = 0;
			getStateCapital(ifile);
		}
		if (list9.isSelected()) {
			ifile = 8;
			current = 0;
			getStateCapital(ifile);
		}
		if (list10.isSelected()) {
			ifile = 9;
			current = 0;
			getStateCapital(ifile);
		}
		if (list11.isSelected()) {
			ifile = 10;
			current = 0;
			getStateCapital(ifile);
		}
		if (list12.isSelected()) {
			ifile = 11;
			current = 0;
			getStateCapital(ifile);
		}
		if (list13.isSelected()) {
			ifile = 12;
			current = 0;
			getStateCapital(ifile);
		}
		if (list14.isSelected()) {
			ifile = 13;
			current = 0;
			getStateCapital(ifile);
		}
		if (list15.isSelected()) {
			ifile = 14;
			current = 0;
			getStateCapital(ifile);
		}

	}





	private void incorrect(Graphics g) {
		if (tc1 || tc2 || tc3 || tc4) {
			g.setFont(new Font("TimesRoman", Font.PLAIN, 15));
			g.setColor(Color.RED);
			g.drawString("Incorrect, the answer is " + answ, 200, 200);
			try {

				BufferedImage wp = ImageIO.read(this.getClass().getResource("cross.png"));
				JLabel wIcon = new JLabel(new ImageIcon(wp));
				g.drawImage(wp, 170, 185, 20, 20, null); 
				} catch (Exception e) {
				System.out.println("Problem1!");
			}
		}
	}

	private void correct(Graphics g) {
		if (tc1 || tc2 || tc3 || tc4) {
			g.setFont(new Font("TimesRoman", Font.PLAIN, 15));
			g.setColor(Color.GREEN);
			g.drawString("Correct", 300, 200);
			try {

				BufferedImage wp = ImageIO.read(this.getClass().getResource("checkmark.png"));
				JLabel wIcon = new JLabel(new ImageIcon(wp));
				g.drawImage(wp, 270, 185, 20, 20, null); 
				} catch (Exception e) {
				System.out.println("Problem1!");
			}
		}
	}
	
	private void correctcount(Graphics g) {
		g.setFont(new Font("TimesRoman", Font.PLAIN, 25));
		g.setColor(Color.GREEN);
		String numcorrectStr = String.valueOf(numcorrect);
		g.drawString(numcorrectStr, 420, 50);
		try {

			BufferedImage wp = ImageIO.read(this.getClass().getResource("checkmark.png"));
			JLabel wIcon = new JLabel(new ImageIcon(wp));
			g.drawImage(wp, 390, 30, 20, 20, null); 
			} catch (Exception e) {
			System.out.println("Problem1!");
		}
	}
	
	private void incorrectcount(Graphics g) {
		g.setFont(new Font("TimesRoman", Font.PLAIN, 25));
		g.setColor(Color.red);
		String numincorrectStr = String.valueOf(numincorrect);
		g.drawString(numincorrectStr, 480, 50);
		try {

			BufferedImage wp = ImageIO.read(this.getClass().getResource("cross.png"));
			JLabel wIcon = new JLabel(new ImageIcon(wp));
			g.drawImage(wp, 450, 30, 20, 20, null); 
			} catch (Exception e) {
			System.out.println("Problem1!");
		}
	}
	

	private void addTexfield() {
		inputUML.setBounds(20, 409, 100, 30);
		inputUML.addActionListener(this);
		add(inputUML);
	}


	private void addButton() {
		choiceBtn1.setBounds(20, 70, 50, 50);
		choiceBtn1.addActionListener(this);
		add(choiceBtn1);

		choiceBtn2.setBounds(20, 140, 50, 50);
		choiceBtn2.addActionListener(this);
		add(choiceBtn2);

		choiceBtn3.setBounds(20, 210, 50, 50);
		choiceBtn3.addActionListener(this);
		add(choiceBtn3);

		choiceBtn4.setBounds(20, 280, 50, 50);
		choiceBtn4.addActionListener(this);
		add(choiceBtn4);

		submit.setBounds(120, 409, 100, 29);
		submit.addActionListener(this);
		add(submit);
		
		next.setBounds(120, 351, 100, 29);
		next.addActionListener(this);
		add(next);
		
		again.setBounds(120, 380, 100, 29);
		again.addActionListener(this);
		add(again);
		
		random.setBounds(20, 380, 100, 29);
		random.addActionListener(this);
		add(random);
		
		back.setBounds(20, 351, 100, 29);
		back.addActionListener(this);
		add(back);
		
		reset.setBounds(390, 9, 103, 20);
		reset.addActionListener(this);
		add(reset);
	}

	
	private void addRadioButton() {
		list1.setBounds(240, 350, 80, 20);
		list1.addActionListener(this);
	    list1.setSelected(true);
		add(list1);
		list2.setBounds(320, 350, 80, 20);
		list2.addActionListener(this);
		add(list2);
		list3.setBounds(400, 350, 80, 20);
		list3.addActionListener(this);
		add(list3);
		list4.setBounds(240, 370, 80, 20);
		list4.addActionListener(this);
		add(list4);
		list5.setBounds(320, 370, 80, 20);
		list5.addActionListener(this);
		add(list5);
		list6.setBounds(400, 370, 80, 20);
		list6.addActionListener(this);
		add(list6);
		list7.setBounds(240, 390, 80, 20);
		list7.addActionListener(this);
		add(list7);
		list8.setBounds(320, 390, 80, 20);
		list8.addActionListener(this);
		add(list8);
		list9.setBounds(400, 390, 80, 20);
		list9.addActionListener(this);
		add(list9);
		list10.setBounds(240, 410, 80, 20);
		list10.addActionListener(this);
		add(list10);
		list11.setBounds(320, 410, 80, 20);
		list11.addActionListener(this);
		add(list11);
		list12.setBounds(400, 410, 80, 20);
		list12.addActionListener(this);
		add(list12);
		list13.setBounds(240, 430, 80, 20);
		list13.addActionListener(this);
		add(list13);
		list14.setBounds(320, 430, 80, 20);
		list14.addActionListener(this);
		add(list14);
		list15.setBounds(400, 430, 80, 20);
		list15.addActionListener(this);
		add(list15);

	    ButtonGroup lists = new ButtonGroup();
	    lists.add(list1);
	    lists.add(list2);
	    lists.add(list3);
	    lists.add(list4);
	    lists.add(list5);
	    lists.add(list6);
	    lists.add(list7);
	    lists.add(list8);
	    lists.add(list9);
	    lists.add(list10);
	    lists.add(list11);
	    lists.add(list12);
	    lists.add(list13);
	    lists.add(list14);
	    lists.add(list15);
	}

	
	public static boolean isNumeric(String str)
	{
	  return str.matches("-?\\d+(\\.\\d+)?");  //match a number with optional '-' and decimal.
	}	
	

	public static void main(String[] args) {
		JFrame jframe = new JFrame("");
		jframe.setTitle("Stems Test");
		jframe.setSize(500, 500);
		jframe.add(new StemsGui());
		// jframe.pack();
		jframe.setLocationRelativeTo(null);
		jframe.setVisible(true);

	}

}