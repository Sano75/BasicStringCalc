package BSC;

import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Point;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;


public class GuiCalc extends JFrame {
	
	//********************************
	
	public double Calculate(String equation) {
		if(equation.contains("+")) {
			return processAdd(equation);
		}
		if(equation.contains("-")) {
			return processSubtract(equation);
			}				
		if(equation.contains("*")) {
			return processMuliply(equation);
		}
		if(equation.contains("%")) {
			return processModulus(equation);
		}
		if(equation.contains("/")) {
			return processDivide(equation);			
		}		
		
		if(equation.matches("[0-9]+")) {
			return Double.parseDouble(equation);
		}
		if(equation.matches("[0-9].+")) {
			return Double.parseDouble(equation);
		}
		
		return Double.NaN;
	}

	
	private double processDivide(String equation) {
		String[] components = equation.split("/");
		
		double result = Double.parseDouble(components[0]);
		
		for (int i= 1; i<components.length; i++) {
			result /= Double.parseDouble(components[i]);
		}
		return result;
	}
	
	private double processSubtract(String equation) {
		String[] components = equation.split("-");
		
		return Calculate(components[0])- Calculate(components[1]);
		}		
	
	private double processMuliply(String equation) {
		String[] components = equation.split("\\*");
		double result = 1.0;
		for(String component : components) {
			result *= Calculate(component);
		}
		return result;
	}	
	
	private double processModulus(String equation) {
		String[] components = equation.split("\\%");
		return Calculate(components[0]) % Calculate(components[1]);
	}
	
	private double processAdd(String equation) {
		String[] components = equation.split("\\+");
		double result = 0.0;
		for(String component : components) {
			result += Calculate(component);
		}
		return result;
	}
	
	
	
	//***************************
	

	private JPanel contentPane;
	private JTextField txtFResult;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GuiCalc frame = new GuiCalc();
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
	public GuiCalc() {
		setLocation(new Point(500, 350));
		setResizable(false);
		setType(Type.UTILITY);
		setTitle("Basic String Calculator");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 536, 429);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtFResult = new JTextField();
		txtFResult.setForeground(new Color(0, 0, 128));
		txtFResult.setBackground(new Color(230, 230, 250));
		txtFResult.setEditable(true);
		txtFResult.setHorizontalAlignment(SwingConstants.RIGHT);
		txtFResult.setFont(new Font("Tahoma", Font.BOLD, 22));
		txtFResult.setBounds(10, 11, 504, 60);
		contentPane.add(txtFResult);
		txtFResult.setColumns(10);
		
		JButton btn_add = new JButton("+");
		btn_add.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtFResult.setText(txtFResult.getText() +  "+");
			}
		});
		btn_add.setFont(new Font("Tahoma", Font.BOLD, 20));
		btn_add.setBounds(13, 95, 89, 53);
		contentPane.add(btn_add);
		
		JButton btn_7 = new JButton("7");
		btn_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtFResult.setText(txtFResult.getText() +  "7");
			}
		});
		btn_7.setFont(new Font("Tahoma", Font.BOLD, 16));
		btn_7.setBackground(Color.LIGHT_GRAY);
		btn_7.setBounds(115, 95, 89, 53);
		contentPane.add(btn_7);
		
		JButton btn_8 = new JButton("8");
		btn_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtFResult.setText(txtFResult.getText() +  "8");
			}
		});
		btn_8.setFont(new Font("Tahoma", Font.BOLD, 16));
		btn_8.setBackground(Color.LIGHT_GRAY);
		btn_8.setBounds(217, 95, 89, 53);
		contentPane.add(btn_8);
		
		JButton btn_9 = new JButton("9");
		btn_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtFResult.setText(txtFResult.getText() +  "9");
			}
		});
		btn_9.setFont(new Font("Tahoma", Font.BOLD, 16));
		btn_9.setBackground(Color.LIGHT_GRAY);
		btn_9.setBounds(319, 95, 89, 53);
		contentPane.add(btn_9);
		
		JButton btnClear = new JButton("Clear");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtFResult.setText("");
			}
		});
		btnClear.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnClear.setBounds(425, 95, 89, 53);
		contentPane.add(btnClear);
		
		JButton btnBackSpace = new JButton("<---");
		btnBackSpace.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String backspace = null;
				if(txtFResult.getText().length() >0) {
					StringBuilder strB = new StringBuilder(txtFResult.getText());
					strB.deleteCharAt(txtFResult.getText().length() -1);
					backspace = strB.toString();
					txtFResult.setText(backspace);
				}
				
				
			}
		});
		btnBackSpace.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnBackSpace.setBounds(425, 164, 89, 53);
		contentPane.add(btnBackSpace);
		
		JButton btn_Info = new JButton("Info");
		btn_Info.setFont(new Font("Tahoma", Font.BOLD, 16));
		btn_Info.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtFResult.setText("School project, Created by Sano Gharzani");
			}
		});
		btn_Info.setBounds(425, 234, 89, 53);
		contentPane.add(btn_Info);
		
		JButton btnCalculate = new JButton("Calc");
		btnCalculate.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				String equation = txtFResult.getText();
				
				double result = Calculate(equation);
				txtFResult.setText(equation +" = "+result);				
				
			}
		});
		btnCalculate.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnCalculate.setBounds(425, 309, 89, 53);
		contentPane.add(btnCalculate);
		
		JButton btn_4 = new JButton("4");
		btn_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtFResult.setText(txtFResult.getText() +  "4");
			}
		});
		btn_4.setFont(new Font("Tahoma", Font.BOLD, 16));
		btn_4.setBackground(Color.LIGHT_GRAY);
		btn_4.setBounds(112, 164, 89, 53);
		contentPane.add(btn_4);
		
		JButton btn_5 = new JButton("5");
		btn_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtFResult.setText(txtFResult.getText() +  "5");
			}
		});
		btn_5.setFont(new Font("Tahoma", Font.BOLD, 16));
		btn_5.setBackground(Color.LIGHT_GRAY);
		btn_5.setBounds(214, 164, 89, 53);
		contentPane.add(btn_5);
		
		JButton btn_6 = new JButton("6");
		btn_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtFResult.setText(txtFResult.getText() +  "6");
			}
		});
		btn_6.setFont(new Font("Tahoma", Font.BOLD, 16));
		btn_6.setBackground(Color.LIGHT_GRAY);
		btn_6.setBounds(316, 164, 89, 53);
		contentPane.add(btn_6);
		
		JButton btn_1 = new JButton("1");
		btn_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtFResult.setText(txtFResult.getText() +  "1");
			}
		});
		btn_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		btn_1.setBackground(Color.LIGHT_GRAY);
		btn_1.setBounds(115, 234, 89, 53);
		contentPane.add(btn_1);
		
		JButton btn_2 = new JButton("2");
		btn_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtFResult.setText(txtFResult.getText() +  "2");
			}
		});
		btn_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		btn_2.setBackground(Color.LIGHT_GRAY);
		btn_2.setBounds(217, 234, 89, 53);
		contentPane.add(btn_2);
		
		JButton btn_3 = new JButton("3");
		btn_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtFResult.setText(txtFResult.getText() +  "3");
			}
		});
		btn_3.setFont(new Font("Tahoma", Font.BOLD, 16));
		btn_3.setBackground(Color.LIGHT_GRAY);
		btn_3.setBounds(319, 234, 89, 53);
		contentPane.add(btn_3);
		
		JButton btn_dot_double = new JButton(".");
		btn_dot_double.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtFResult.setText(txtFResult.getText() +  ".");
			}
		});
		btn_dot_double.setFont(new Font("Tahoma", Font.BOLD, 18));
		btn_dot_double.setBackground(Color.LIGHT_GRAY);
		btn_dot_double.setBounds(319, 308, 89, 53);
		contentPane.add(btn_dot_double);
		
		JButton btn_0_Ziro = new JButton("0");
		btn_0_Ziro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				txtFResult.setText(txtFResult.getText() +  "0");
			}
		});
		btn_0_Ziro.setFont(new Font("Tahoma", Font.BOLD, 16));
		btn_0_Ziro.setBackground(Color.LIGHT_GRAY);
		btn_0_Ziro.setBounds(217, 309, 89, 53);
		contentPane.add(btn_0_Ziro);
		
		JButton btn_subtract = new JButton("-");
		btn_subtract.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtFResult.setText(txtFResult.getText() +  "-");
			}
		});
		btn_subtract.setFont(new Font("Tahoma", Font.BOLD, 20));
		btn_subtract.setBounds(10, 164, 89, 53);
		contentPane.add(btn_subtract);
		
		JButton btn_divide = new JButton("/");
		btn_divide.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtFResult.setText(txtFResult.getText() +  "/");
			}
			
		});
		btn_divide.setFont(new Font("Tahoma", Font.BOLD, 20));
		btn_divide.setBounds(10, 234, 89, 53);
		contentPane.add(btn_divide);
		
		JButton btn_multiply = new JButton("*");
		btn_multiply.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtFResult.setText(txtFResult.getText() +  "*");
			}
		});
		btn_multiply.setFont(new Font("Tahoma", Font.BOLD, 20));
		btn_multiply.setBounds(10, 309, 89, 53);
		contentPane.add(btn_multiply);
		
		JLabel lblLinkedin = new JLabel("Linkedin");
		lblLinkedin.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblLinkedin.setForeground(Color.BLUE);
		lblLinkedin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				try {
			         
			        Desktop.getDesktop().browse(new URI("www.linkedin.com/in/sanogharzani"));
			         
			    } catch (IOException | URISyntaxException e1) {
			        e1.printStackTrace();
			    }
			}
		});
		lblLinkedin.setHorizontalAlignment(SwingConstants.CENTER);
		lblLinkedin.setBounds(10, 375, 79, 14);
		contentPane.add(lblLinkedin);
		
		JButton btnModu = new JButton("Modu");
		btnModu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				txtFResult.setText(txtFResult.getText() +  "%");
				
			}
		});
		btnModu.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnModu.setBounds(115, 309, 89, 53);
		contentPane.add(btnModu);
	}
}
