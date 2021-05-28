import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;

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
 * @author Alex and n-c0de-r
 * @version 27.05.2021
 */
public class UserInterfaceHex extends UserInterface {

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
		addButton(buttonPanel, "A");
        	addButton(buttonPanel, "B");
        	addButton(buttonPanel, "C");
        	buttonPanel.add(new JLabel(" "));
        	buttonPanel.add(new JLabel(" "));
        	buttonPanel.add(new JLabel(" "));
        
        	addButton(buttonPanel, "D");
        	addButton(buttonPanel, "E");
        	addButton(buttonPanel, "F");
       		buttonPanel.add(new JLabel(" "));
        	buttonPanel.add(new JLabel(" "));
        	buttonPanel.add(new JLabel(" "));
        
        	addButton(buttonPanel, "7");
        	addButton(buttonPanel, "8");
        	addButton(buttonPanel, "9");
        	buttonPanel.add(new JLabel(" "));
        	addButton(buttonPanel, "+");
        	addButton(buttonPanel, "del");
        
        	addButton(buttonPanel, "4");
        	addButton(buttonPanel, "5");
        	addButton(buttonPanel, "6");
        	buttonPanel.add(new JLabel(" "));
        	addButton(buttonPanel, "-");
        	addButton(buttonPanel, "?");
        
        	addButton(buttonPanel, "1");
        	addButton(buttonPanel, "2");
        	addButton(buttonPanel, "3");
        	buttonPanel.add(new JLabel(" "));
        	addButton(buttonPanel, "*");
        	buttonPanel.add(new JLabel(" "));
        
        	addButton(buttonPanel, "0");
       		buttonPanel.add(new JLabel(" "));
        	buttonPanel.add(new JLabel(" "));
        	buttonPanel.add(new JLabel(" "));
        	addButton(buttonPanel, "/");
        	addButton(buttonPanel, "=");

		contentPane.add(buttonPanel, BorderLayout.CENTER);

		status = new JLabel(calc.getAuthor());
		contentPane.add(status, BorderLayout.SOUTH);

		frame.pack();
	}

	public void actionPerformed(ActionEvent event) {
		String command = event.getActionCommand();

		if (command.equals("0") || 
			command.equals("1") ||
			command.equals("2") ||
			command.equals("3") ||
			command.equals("4") ||
			command.equals("5") ||
			command.equals("6") ||
			command.equals("7") ||
			command.equals("8") ||
			command.equals("9")) {
			int number = Integer.parseInt(command);
			calc.numberPressed(number);
		} else if (command.equals("+")) {
			calc.plus();
		} else if (command.equals("-")) {
			calc.minus();
		} else if (command.equals("*")) {
			calc.multiply();
		} else if (command.equals("=")) {
			calc.equals();
		} else if (command.equals("C")) {
			calc.clear();
		} else if (command.equals("?")) {
			showInfo();
		}
		// else unknown command.

		redisplay();
	}

	private void redisplay() {
		display.setText("" + calc.getDisplayValue());
	}
}
