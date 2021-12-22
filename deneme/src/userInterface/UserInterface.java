package userInterface;


//import converter services
import converterServiceEN.ConverterServiceEN;
import converterServiceTR.ConverterServiceTR;
import converterServiceNumEN.ConverterServiceNumEN;
import converterServiceNumTR.ConverterServiceNumTR;


import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class UserInterface extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField input1;
	private JTextField input2;
	private JTextField output;

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
		
		JLabel lblNewLabel = new JLabel("First Number");
		lblNewLabel.setBounds(15, 50, 92, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Second Number");
		lblNewLabel_1.setBounds(15, 80, 92, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Result");
		lblNewLabel_2.setBounds(15, 110, 92, 14);
		contentPane.add(lblNewLabel_2);
		
		input1 = new JTextField();
		input1.setBounds(117, 47, 396, 20);
		contentPane.add(input1);
		input1.setColumns(10);
		
		input2 = new JTextField();
		input2.setBounds(117, 77, 396, 20);
		input2.setColumns(10);
		contentPane.add(input2);
		
		output = new JTextField();
		output.setBounds(117, 107, 396, 20);
		output.setEditable(false);
		output.setColumns(10);
		contentPane.add(output);
		
		
		// Add button
		JButton btnAddition = new JButton("Addition");
		btnAddition.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				// get inputs and convert word to numbers
				String first_number_string = ConverterServiceNumEN.convertWordsToNumber(input1.getText());
				String second_number_string = ConverterServiceNumEN.convertWordsToNumber(input2.getText());
				
				// parse int and calculate sum
				int first_number_int = Integer.parseInt(first_number_string);
				int second_number_int = Integer.parseInt(second_number_string);
				int sum_int = first_number_int + second_number_int;
				
				// get sum and convert number to word
				String sum_string = ConverterServiceEN.convertNumberToWords(sum_int);
				
				// display output
				output.setText(sum_string);
				
				
				/*
				 * ConverterService test methodlarý
				 * 
				System.out.println("number to word EN = "+ ConverterServiceEN.convertNumberToWords(2915));
				System.out.println("number to word TR = "+ ConverterServiceTR.convertNumberToWords(2915));
				System.out.println("word to number EN = "+ ConverterServiceNumEN.convertWordsToNumber("two thousand nine hundred fifteen"));
				System.out.println("word to number TR = "+ ConverterServiceNumTR.convertWordsToNumber("iki bin dokuz yüz on beþ"));
				*/
			}
		});
		btnAddition.setBounds(117, 138, 92, 23);
		contentPane.add(btnAddition);
		
		// Sub button
		JButton btnSubtraction = new JButton("Subtraction ");
		btnSubtraction.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				// get inputs and convert word to numbers
				String first_number_string = ConverterServiceNumEN.convertWordsToNumber(input1.getText());
				String second_number_string = ConverterServiceNumEN.convertWordsToNumber(input2.getText());
				
				// parse int and calculate sum
				int first_number_int = Integer.parseInt(first_number_string);
				int second_number_int = Integer.parseInt(second_number_string);
				int sum_int = first_number_int - second_number_int;
				
				// get sum and convert number to word
				String sum_string = ConverterServiceEN.convertNumberToWords(sum_int);
				
				// display output
				output.setText(sum_string);
				
			}
		});
		btnSubtraction.setBounds(217, 138, 89, 23);
		contentPane.add(btnSubtraction);
		
		// Mul button
		JButton btnMultiplication = new JButton("Multiplication ");
		btnMultiplication.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				// get inputs and convert word to numbers
				String first_number_string = ConverterServiceNumEN.convertWordsToNumber(input1.getText());
				String second_number_string = ConverterServiceNumEN.convertWordsToNumber(input2.getText());
				
				// parse int and calculate sum
				int first_number_int = Integer.parseInt(first_number_string);
				int second_number_int = Integer.parseInt(second_number_string);
				int sum_int = first_number_int * second_number_int;
				
				// get sum and convert number to word
				String sum_string = ConverterServiceEN.convertNumberToWords(sum_int);
				
				// display output
				output.setText(sum_string);
			}
		});
		btnMultiplication.setBounds(316, 138, 92, 23);
		contentPane.add(btnMultiplication);
		
		// Div button
		JButton btnDivision = new JButton("Division");
		btnDivision.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				// get inputs and convert word to numbers
				String first_number_string = ConverterServiceNumEN.convertWordsToNumber(input1.getText());
				String second_number_string = ConverterServiceNumEN.convertWordsToNumber(input2.getText());
				
				// parse int and calculate sum
				int first_number_int = Integer.parseInt(first_number_string);
				int second_number_int = Integer.parseInt(second_number_string);
				int sum_int = first_number_int / second_number_int;
				
				// get sum and convert number to word
				String sum_string = ConverterServiceEN.convertNumberToWords(sum_int);
				
				// display output
				output.setText(sum_string);
			}
		});
		btnDivision.setBounds(411, 138, 102, 23);
		contentPane.add(btnDivision);
	}
}
