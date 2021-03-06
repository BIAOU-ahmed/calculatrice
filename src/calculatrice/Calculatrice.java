package calculatrice;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.border.LineBorder;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.UIManager;
import java.awt.SystemColor;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.CardLayout;
import java.awt.Font;

public class Calculatrice {

	private JFrame frame;

	Calculate calculate = new Calculate();
	 double memorieValue = 0;
	 boolean isValueInMemorie = false;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Calculatrice window = new Calculatrice();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}





	/**
	 * Create the application.
	 */
	public Calculatrice() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 448, 610);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel panel = new JPanel();
		panel.setBackground(UIManager.getColor("SplitPaneDivider.draggingColor"));
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);

		JPanel panel_calcul = new JPanel();
		panel_calcul.setBackground(UIManager.getColor("Table.selectionBackground"));
		panel_calcul.setBounds(14, 78, 405, 99);
		panel.add(panel_calcul);
		panel_calcul.setLayout(new CardLayout(0, 0));

		JLabel calcul_display = new JLabel("");
		calcul_display.setFont(new Font("Tahoma", Font.BOLD, 26));
		calcul_display.setHorizontalAlignment(SwingConstants.RIGHT);
		panel_calcul.add(calcul_display, "name_58360375741700");
		calcul_display.setBackground(Color.RED);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.BLACK);
		panel_1.setBounds(150, 22, 133, 38);
		panel.add(panel_1);

		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.DARK_GRAY);
		panel_2.setBounds(0, 188, 419, 352);
		panel.add(panel_2);
		panel_2.setLayout(null);

		JButton btnNewButton = new JButton("MRC");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (calculate.isOn) {
					if (isValueInMemorie) {
						calcul_display.setText("" + memorieValue);
					}

				}
			}
		});
		btnNewButton.setBounds(10, 11, 73, 55);
		panel_2.add(btnNewButton);
		btnNewButton.setBackground(Color.LIGHT_GRAY);

		JButton btnMplus = new JButton("M+");
		btnMplus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (calculate.isOn) {
					memorieValue += Double.parseDouble(calcul_display.getText());
					isValueInMemorie = true;
				}

			}

		});
		btnMplus.setBounds(93, 11, 73, 55);
		panel_2.add(btnMplus);
		btnMplus.setBackground(Color.LIGHT_GRAY);

		JButton btnMMoins = new JButton("M-");
		btnMMoins.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (calculate.isOn) {
					memorieValue -= Double.parseDouble(calcul_display.getText());
					isValueInMemorie = true;
				}
			}
		});
		btnMMoins.setBounds(176, 11, 73, 55);
		panel_2.add(btnMMoins);
		btnMMoins.setBackground(Color.LIGHT_GRAY);

		JButton btnCe = new JButton("CE");
		btnCe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				calcul_display.setText("");

			}
		});
		btnCe.setBounds(259, 11, 73, 55);
		panel_2.add(btnCe);
		btnCe.setBackground(Color.LIGHT_GRAY);

		JButton btnOnc = new JButton("ON-C");
		btnOnc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!calculate.isOn) {
					calculate.setOn(true);
					panel_calcul.setBackground(Color.green);

				}
				calcul_display.setText("");
				calculate.setResult("");
				calculate.changeCurrentOpe(0);

			}
		});
		btnOnc.setBounds(342, 11, 73, 55);
		panel_2.add(btnOnc);
		btnOnc.setBackground(Color.RED);

		JButton btn_7 = new JButton("7");
		btn_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				calculate.addNumber(calcul_display,  btn_7.getText());

			}
		});
		btn_7.setBounds(10, 80, 73, 55);
		panel_2.add(btn_7);
		btn_7.setBackground(Color.LIGHT_GRAY);

		JButton btn_8 = new JButton("8");
		btn_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				calculate.addNumber(calcul_display,  btn_8.getText());

			}
		});
		btn_8.setBounds(93, 80, 73, 55);
		panel_2.add(btn_8);
		btn_8.setBackground(Color.LIGHT_GRAY);

		JButton btn_9 = new JButton("9");
		btn_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				calculate.addNumber(calcul_display,  btn_9.getText());

			}
		});
		btn_9.setBounds(176, 80, 73, 55);
		panel_2.add(btn_9);
		btn_9.setBackground(Color.LIGHT_GRAY);

		JButton btn_pct = new JButton("%");
		btn_pct.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!calcul_display.getText().isEmpty()) {
					Double d = Double.parseDouble(calcul_display.getText()) / 100;

					calcul_display.setText("" + d);
				}

			}
		});
		btn_pct.setBounds(259, 80, 73, 55);
		panel_2.add(btn_pct);
		btn_pct.setBackground(Color.LIGHT_GRAY);

		JButton btn_racine = new JButton("\u221A");
		btn_racine.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				if (!calcul_display.getText().isEmpty()) {
					Double d = Math.sqrt(Double.parseDouble(calcul_display.getText()));

					calcul_display.setText("" + d);
				}

			}
		});
		btn_racine.setBounds(342, 80, 73, 55);
		panel_2.add(btn_racine);
		btn_racine.setBackground(Color.LIGHT_GRAY);

		JButton btn_4 = new JButton("4");
		btn_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				calculate.addNumber(calcul_display,  btn_4.getText());

			}
		});
		btn_4.setBounds(10, 146, 73, 55);
		panel_2.add(btn_4);
		btn_4.setBackground(Color.LIGHT_GRAY);

		JButton btn_5 = new JButton("5");
		btn_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				calculate.addNumber(calcul_display,  btn_5.getText());

			}
		});
		btn_5.setBounds(93, 146, 73, 55);
		panel_2.add(btn_5);
		btn_5.setBackground(Color.LIGHT_GRAY);

		JButton btn_6 = new JButton("6");
		btn_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				calculate.addNumber(calcul_display,  btn_6.getText());

			}
		});
		btn_6.setBounds(176, 146, 73, 55);
		panel_2.add(btn_6);
		btn_6.setBackground(Color.LIGHT_GRAY);

		JButton btnX = new JButton("x");
		btnX.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				calculate.doOperation(calcul_display,3);
			}
		});
		btnX.setBounds(259, 146, 73, 55);
		panel_2.add(btnX);
		btnX.setBackground(Color.LIGHT_GRAY);

		JButton btn_division = new JButton("\u00F7");
		btn_division.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				calculate.doOperation(calcul_display,4);
			}
		});
		btn_division.setBounds(342, 146, 73, 55);
		panel_2.add(btn_division);
		btn_division.setBackground(Color.LIGHT_GRAY);

		JButton btn_1 = new JButton("1");
		btn_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				calculate.addNumber(calcul_display,  btn_1.getText());

			}
		});
		btn_1.setBounds(10, 212, 73, 55);
		panel_2.add(btn_1);
		btn_1.setBackground(Color.LIGHT_GRAY);

		JButton btn_2 = new JButton("2");
		btn_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				calculate.addNumber(calcul_display,  btn_2.getText());

			}
		});
		btn_2.setBounds(93, 212, 73, 55);
		panel_2.add(btn_2);
		btn_2.setBackground(Color.LIGHT_GRAY);

		JButton btn_3 = new JButton("3");
		btn_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				calculate.addNumber(calcul_display,  btn_3.getText());

			}
		});
		btn_3.setBounds(176, 212, 73, 55);
		panel_2.add(btn_3);
		btn_3.setBackground(Color.LIGHT_GRAY);

		JButton btn_addition = new JButton("+");
		btn_addition.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				calculate.doOperation(calcul_display,1);
			}
		});
		btn_addition.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btn_addition.setBounds(259, 212, 73, 121);
		panel_2.add(btn_addition);
		btn_addition.setBackground(Color.LIGHT_GRAY);

		JButton btn_soustration = new JButton("-");
		btn_soustration.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				calculate.doOperation(calcul_display,2);
			
			}
		});
		btn_soustration.setBounds(342, 212, 73, 55);
		panel_2.add(btn_soustration);
		btn_soustration.setBackground(Color.LIGHT_GRAY);

		JButton btn_result = new JButton("=");
		btn_result.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (calculate.isOn()) {
					if (!calculate.result.equals("") || !calcul_display.getText().isEmpty()) {

//						if (calcul_display.getText().equals("0") && currentOperator == 4) {
//							calcul_display.setFont(new Font("Tahoma", Font.BOLD, 18));
//							calcul_display.setText("Nous ne pouvons pas diviser par z�ro");
//						} else {
//						
//						}
						if (!calculate.isOperatorPressed()) {
							calculate.operation(calcul_display, 0);
							calcul_display.setText(calculate.result);
						} else {
							calculate.currentOperator = 0;
						}

					}
				}
			}
		});
		btn_result.setBounds(342, 278, 73, 55);
		panel_2.add(btn_result);
		btn_result.setBackground(Color.LIGHT_GRAY);

		JButton btn_0 = new JButton("0");
		btn_0.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				calculate.addNumber(calcul_display,  btn_0.getText());

			}
		});
		btn_0.setBounds(10, 278, 73, 55);
		panel_2.add(btn_0);
		btn_0.setBackground(Color.LIGHT_GRAY);

		JButton btn_point = new JButton(".");
		btn_point.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (calculate.isOn()) {

					if (calculate.isOperatorPressed()) {

						calcul_display.setText("");
					}

					String value = calcul_display.getText();
					if (calcul_display.getText().indexOf('.') == -1) {
						value = calcul_display.getText() + btn_point.getText();
						if (calcul_display.getText().isEmpty()) {
							value = "0" + btn_point.getText();
						}

						if (calculate.isOperatorPressed()) {

							value = "0.";
						}
					}
					calculate.setOperatorPressed(false);
					calcul_display.setText(value);
				}

			}
		});
		btn_point.setBounds(93, 278, 73, 55);
		panel_2.add(btn_point);
		btn_point.setBackground(Color.LIGHT_GRAY);

		JButton btn_signe = new JButton("+/-");
		btn_signe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (calculate.isOn()) {
					String value = calcul_display.getText();
					if (calcul_display.getText().indexOf('-') == -1) {
						value = "-";
						if (!calculate.isOperatorPressed()) {

							value = "-" + calcul_display.getText();
						}

					} else {
						value = "-";
						if (!calculate.isOperatorPressed()) {

							value = calcul_display.getText().replace("-", "");
						}

					}
					calculate.setOperatorPressed(false);
					calcul_display.setText(value);
				}

			}

		});
		btn_signe.setBounds(176, 278, 73, 55);
		panel_2.add(btn_signe);
		btn_signe.setBackground(Color.LIGHT_GRAY);
	}
}
