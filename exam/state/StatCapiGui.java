package exam.state;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


import util.In;

//========================================== //

public class StatCapiGui extends JPanel implements ActionListener {

	// String[] states = In.readStrings("statefile.txt");
	// String[] capitals = In.readStrings("capitalfile.txt");
	String stateStr;
	String capStr1;
	String capStr2;
	String capStr3;
	String capStr4;
	String answ;
	String startStr;
	String[] capitals = new String[4];

	boolean correctbl;

	private int mindraw = 1;

	// int stateSize = states.length;
	// for(int i = 0; i < stateSize(); i++) {
	int cpvalue = 0;
	JTextField inputUML = new JTextField(20);

	JButton tr1 = new JButton("1");
	JButton tr2 = new JButton("2");
	JButton tr3 = new JButton("3");
	JButton tr4 = new JButton("4");
	JButton randomtest = new JButton("Random");
	JButton submit = new JButton("Submit");
	JButton next = new JButton("Next");
	JButton again = new JButton("Again");
	JButton random = new JButton("Random");
	JButton back = new JButton("Back");
	static boolean tc1 = false;
	static boolean tc2 = false;
	static boolean tc3 = false;
	static boolean tc4 = false;
	static boolean randomtest2 = false;
	static boolean submit1 = false;


	public StatCapiGui() {

		getStateCapital();

		setLayout(null);

		inputUML.setBounds(20, 409, 100, 30);
		inputUML.addActionListener(this);
		add(inputUML);

		tr1.setBounds(20, 70, 50, 50);
		// tr1.setLocation(200, 200);
		// tr1.setLocation (200, 200);
		// tr1.setSize(100, 100);
		// tr1.setLocation(200, 200);

		tr1.addActionListener(this);
		add(tr1);

		tr2.setBounds(20, 140, 50, 50);
		tr2.addActionListener(this);
		add(tr2);

		tr3.setBounds(20, 210, 50, 50);
		tr3.addActionListener(this);
		add(tr3);

		tr4.setBounds(20, 280, 50, 50);
		tr4.addActionListener(this);
		add(tr4);

//		randomtest.setBounds(200, 280, 100, 50);
//		randomtest.addActionListener(this);
//		add(randomtest);

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

	}

	// not used
	public static int mindraw() {
		int mindraw = 1;
		return mindraw;
	}
	
	public static boolean isNumeric(String str)
	{
	  return str.matches("-?\\d+(\\.\\d+)?");  //match a number with optional '-' and decimal.
	}

	private void getStateCapital() {
		// stateStr = "Question Goes Here";

		StatCapi statcapi = new StatCapi(mindraw);
		stateStr = statcapi.getState();
		capStr1 = statcapi.getCapital();
		capStr2 = statcapi.getCapital2();
		capStr3 = statcapi.getCapital3();
		capStr4 = statcapi.getCapital4();
		answ = statcapi.answ();

		String answer = answ;
		capitals[0] = capStr1;
		capitals[1] = capStr2;
		capitals[2] = capStr3;
		capitals[3] = capStr4;

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

		// startStr = inputUML.getText();
		// textArea.append(text + newline);
		// textField.selectAll();

		if (src == tr1) {
			boolean ca = checkAnswer(0);
			if (ca) {
				correctbl = true;
			} else {
				correctbl = false;
			}
			tc1 = true;
			tc2 = false;
			tc3 = false;
			tc4 = false;
			repaint();
		}
		if (src == tr2) {
			boolean ca = checkAnswer(1);
			if (ca) {
				correctbl = true;
			} else {
				correctbl = false;
			}
			tc1 = false;
			tc2 = true;
			tc3 = false;
			tc4 = false;
			repaint();
		}
		if (src == tr3) {
			boolean ca = checkAnswer(2);
			if (ca) {
				correctbl = true;
			} else {
				correctbl = false;
			}
			tc1 = false;
			tc2 = false;
			tc3 = true;
			tc4 = false;
			repaint();
		}
		if (src == tr4) {
			boolean ca = checkAnswer(3);
			if (ca) {
				correctbl = true;
			} else {
				correctbl = false;
			}
			tc1 = false;
			tc2 = false;
			tc3 = false;
			tc4 = true;
			repaint();

			if (src == randomtest) {
				randomtest2 = true;
				
				if (randomtest2) {
				mindraw = (int) (Math.random() * (double) (46 - 1) + 46);
				repaint();
				}
			}
		}
		if (src == submit) {
			startStr = inputUML.getText();
			if(isNumeric(startStr)) {
			mindraw = Integer.parseInt(startStr);
			}else{
			mindraw = 1;
			}
			getStateCapital();
			tc1 = false;
			tc2 = false;
			tc3 = false;
			tc4 = false;
			repaint();
		}
		
		if (src == next) {
			startStr = inputUML.getText();
			if(isNumeric(startStr)) {
				if (mindraw == 46){
					mindraw = 1;
				}else{
				mindraw = mindraw + 1;	
				}
			}else{
				if (mindraw == 46){
					mindraw = 1;
				}else{
				mindraw = mindraw + 1;	
				}
			}
			getStateCapital();
			tc1 = false;
			tc2 = false;
			tc3 = false;
			tc4 = false;
			repaint();
		}

	
	
		if (src == again) {
			getStateCapital();
			tc1 = false;
			tc2 = false;
			tc3 = false;
			tc4 = false;
			repaint();
		}

	
		if (src == back) {
			startStr = inputUML.getText();
			if(isNumeric(startStr)) {
				if (mindraw == 1){
					mindraw = 46;
				}else{
				mindraw = mindraw - 1;	
				}
			}else{
				if (mindraw == 1){
					mindraw = 46;
				}else{
				mindraw = mindraw - 1;	
				}
			}
			getStateCapital();
			tc1 = false;
			tc2 = false;
			tc3 = false;
			tc4 = false;
			repaint();
	}



		if (src == random) {
			startStr = inputUML.getText();
			mindraw = 0;
			getStateCapital();
			tc1 = false;
			tc2 = false;
			tc3 = false;
			tc4 = false;
			repaint();
		}
}




	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(Color.RED);

		try {

			// int x = getX();
			// int y = getY();

			BufferedImage wp = ImageIO.read(this.getClass().getResource("blank.png"));
			JLabel wIcon = new JLabel(new ImageIcon(wp));
			g.drawImage(wp, 170, 185, 20, 20, null); // see javadoc for more
														// info on the
														// parameters
			g.drawImage(wp, 0, 0, 500, 500, null);
		} catch (Exception e) {
			System.out.println("Problem1!");
		}

		// stringToEdit = GUI.TextField (Rect (10, 10, 200, 20), stringToEdit,
		// 25);

		if (tc1) {

		}
		if (tc2) {
			// g.drawRect(100, 100, 200, 200);

			// g.fillRect(100, 100, 200, 200);

		}
		if (tc3) {

		}
		if (tc4) {

		}

		// / Print ///

		g.setFont(new Font("TimesRoman", Font.PLAIN, 25));
		g.setColor(Color.black);
		g.drawString(stateStr, 10, 50);

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
			correct(g);
		} else {
			incorrect(g);
		}
	}

	private Object Rect(int i, int j, int k, int l) {
		// TODO Auto-generated method stub
		return null;
	}

	private void incorrect(Graphics g) {
		if (tc1 || tc2 || tc3 || tc4) {
			g.setFont(new Font("TimesRoman", Font.PLAIN, 15));
			g.setColor(Color.red);
			g.drawString("Inncorrect, the answer is " + answ, 200, 200);
			try {

				BufferedImage wp = ImageIO.read(this.getClass().getResource("cross.png"));
				// JLabel wIcon = new JLabel(new ImageIcon(wp));
				g.drawImage(wp, 170, 185, 20, 20, null); // see javadoc for more
															// info on the
															// parameters

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

	public static void main(String[] args) {
		JFrame jframe = new JFrame("");
		jframe.setTitle("Test");
		jframe.setSize(500, 500);
		jframe.add(new StatCapiGui());
		// jframe.pack();
		jframe.setLocationRelativeTo(null);
		jframe.setVisible(true);

	}

}
