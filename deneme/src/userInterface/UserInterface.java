package userInterface;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.SpringLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class UserInterface extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textInput1;
	private JTextField textInput2;
	private JTextField textOutput;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserInterface frame = new UserInterface();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public UserInterface() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 550, 320);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel input1 = new JLabel("First Number");
		input1.setBounds(15, 50, 92, 14);
		contentPane.add(input1);
		
		JLabel input2 = new JLabel("Second Number");
		input2.setBounds(15, 80, 92, 14);
		contentPane.add(input2);
		
		JLabel output = new JLabel("Result");
		output.setBounds(15, 110, 92, 14);
		contentPane.add(output);
		
		textInput1 = new JTextField();
		textInput1.setBounds(117, 47, 396, 20);
		contentPane.add(textInput1);
		textInput1.setColumns(10);
		
		textInput2 = new JTextField();
		textInput2.setBounds(117, 77, 396, 20);
		textInput2.setColumns(10);
		contentPane.add(textInput2);
		
		textOutput = new JTextField();
		textOutput.setBounds(117, 107, 396, 20);
		textOutput.setEditable(false);
		textOutput.setColumns(10);
		contentPane.add(textOutput);
		
		JButton btnAddition = new JButton("Addition");
		btnAddition.setBounds(117, 138, 92, 23);
		contentPane.add(btnAddition);
		
		JButton btnSubtraction = new JButton("Subtraction ");
		btnSubtraction.setBounds(217, 138, 89, 23);
		contentPane.add(btnSubtraction);
		
		JButton btnMultiplication = new JButton("Multiplication ");
		btnMultiplication.setBounds(316, 138, 92, 23);
		contentPane.add(btnMultiplication);
		
		JButton btnDivision = new JButton("Division");
		btnDivision.setBounds(411, 138, 102, 23);
		contentPane.add(btnDivision);
	}
}
