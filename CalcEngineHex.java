import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

/**
 * A graphical user interface for the calculator. No calculation is being
 * done here. This class is responsible just for putting up the display on 
 * screen. It then refers to the "CalcEngine" to do all the real work.
 * 
 * @author Alex Jäger and Nermin Rustic
 * @version 27.05.2021 update 15.06.21
 */
public class UserInterfaceHex extends UserInterface {
	 protected CalcEngineHex calcHex;
	 
	 private JCheckBox h;
	private JButton A, B, C, D, E, F;
	 private int mode = 10;
	 
	public UserInterfaceHex(CalcEngine engine) {
		super(engine);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void makeFrame() {
		frame = new JFrame(calc.getTitle());

		JPanel contentPane = (JPanel) frame.getContentPane();
		contentPane.setLayout(new BorderLayout(8, 8));
		contentPane.setBorder(new EmptyBorder(10, 10, 10, 10));

		display = new JTextField();
		contentPane.add(display, BorderLayout.NORTH);
		
		JPanel buttonPanel = new JPanel(new GridLayout(6, 6));
		A = new JButton("A");
		A.addActionListener(this);
        buttonPanel.add(A);
        A.setEnabled(false);
        B = new JButton("B");
        B.addActionListener(this);
        buttonPanel.add(B);
        B.setEnabled(false);
        C = new JButton("C");
        C.addActionListener(this);
        buttonPanel.add(C);
        C.setEnabled(false);
  		h = new JCheckBox("Hex");
  		h.setSelected(false);
  		buttonPanel.add(h);
        h.addActionListener(this);
        addButton(buttonPanel, "del");
        addButton(buttonPanel, "?");
  		
        D = new JButton("D");
        D.addActionListener(this);
        buttonPanel.add(D);
        D.setEnabled(false);
        E = new JButton("E");
        E.addActionListener(this);
        buttonPanel.add(E);
        E.setEnabled(false);
        F = new JButton("F");
        F.addActionListener(this);
        buttonPanel.add(F);
        F.setEnabled(false);
        buttonPanel.add(new JLabel(" "));
 		addButton(buttonPanel, "(");
 		addButton(buttonPanel, ")");
  
  		addButton(buttonPanel, "7");
  		addButton(buttonPanel, "8");
  		addButton(buttonPanel, "9");
  		buttonPanel.add(new JLabel(" "));
  		buttonPanel.add(new JLabel(" "));
  		addButton(buttonPanel, "^");
  
  		addButton(buttonPanel, "4");
  		addButton(buttonPanel, "5");
  		addButton(buttonPanel, "6");
  		buttonPanel.add(new JLabel(" "));
  		addButton(buttonPanel, "*");
  		addButton(buttonPanel, "/");
  
  		addButton(buttonPanel, "1");
  		addButton(buttonPanel, "2");
  		addButton(buttonPanel, "3");
  		buttonPanel.add(new JLabel(" "));
  		addButton(buttonPanel, "+");
  		addButton(buttonPanel, "-");
  		
  
  		addButton(buttonPanel, "0");
  		buttonPanel.add(new JLabel(" "));
  		buttonPanel.add(new JLabel(" "));
  		buttonPanel.add(new JLabel(" "));
  		buttonPanel.add(new JLabel(" "));
  		addButton(buttonPanel, "=");
       	
		contentPane.add(buttonPanel, BorderLayout.CENTER);

		status = new JLabel(calc.getAuthor());
		contentPane.add(status, BorderLayout.SOUTH);

		frame.pack();
	}
	
	public void actionPerformed(ActionEvent event) {
		String command = event.getActionCommand();
		if (h.isSelected()) {
			mode = 16;
			A.setEnabled(true);
			B.setEnabled(true);
			C.setEnabled(true);
			D.setEnabled(true);
			E.setEnabled(true);
			F.setEnabled(true);
		} else {
			mode = 10;
			A.setEnabled(false);
			B.setEnabled(false);
			C.setEnabled(false);
			D.setEnabled(false);
			E.setEnabled(false);
			F.setEnabled(false);
		}					
		
		if (command.equals("0") || 
			command.equals("1") ||
			command.equals("2") ||
			command.equals("3") ||
			command.equals("4") ||
			command.equals("5") ||
			command.equals("6") ||
			command.equals("7") ||
			command.equals("8") ||
			command.equals("9") ||
			command.equals("A") ||
			command.equals("B") ||
			command.equals("C") ||
			command.equals("D") ||
			command.equals("E") ||
			command.equals("F")) {
			
			//HexLetters to int:
			int number = Integer.parseInt(command, mode);
			calc.numberPressed(number, mode);
				
		} else if (command.equals("+")) {
			calc.plus();
		} else if (command.equals("-")) {
			calc.minus();
		} else if (command.equals("*")) {
			calc.multiply();
		} else if (command.equals("/")) {
			calc.divide();
		} else if (command.equals("^")) {
			calc.modulo();
		} else if (command.equals("=")) {
			calc.equals();
		} else if (command.equals("del")) {
			calc.clear();
		} else if (command.equals("?")) {
			showInfo();
		} else if (command.equals("Hex")) {
			return;// does nothing 
		}
		// else unknown command.
		redisplay();
	}
	
	//Change (int) displayValue to Hex (String) and capitalizes the letter
	private void redisplay() {
		
		if (h.isSelected()) {
			display.setText("" + Integer.toHexString(calc.getDisplayValue()).toUpperCase());
			 
		} else {
			display.setText("" + calc.getDisplayValue());
		}
	}
}
