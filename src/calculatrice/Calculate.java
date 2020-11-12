/**
 * 
 */
package calculatrice;

import java.awt.Font;
import java.util.Arrays;

import javax.swing.JLabel;

/**
 * @author ahmed
 *
 */
public class Calculate {

	boolean isOn = false;

	int currentOperator = 0;
	String result;
	boolean operatorPressed = false;

	public Calculate() {

	}

	/**
	 * @return the isOn
	 */
	public boolean isOn() {
		return isOn;
	}

	/**
	 * @param isOn the isOn to set
	 */
	public void setOn(boolean isOn) {
		this.isOn = isOn;
	}

	/**
	 * @return the currentOperator
	 */
	public int getCurrentOperator() {
		return currentOperator;
	}

	/**
	 * @param currentOperator the currentOperator to set
	 */
	public void setCurrentOperator(int currentOperator) {
		this.currentOperator = currentOperator;
	}

	/**
	 * @return the result
	 */
	public String getResult() {
		return result;
	}

	/**
	 * @param result the result to set
	 */
	public void setResult(String result) {
		this.result = result;
	}

	/**
	 * @return the operatorPressed
	 */
	public boolean isOperatorPressed() {
		return operatorPressed;
	}

	/**
	 * @param operatorPressed the operatorPressed to set
	 */
	public void setOperatorPressed(boolean operatorPressed) {
		this.operatorPressed = operatorPressed;
	}

	public void operation(JLabel calcul_display, int newOperator) {
		operatorPressed = true;
		System.out.println(currentOperator +"opê");
		switch (currentOperator) {
		case 0: {
			resume(calcul_display, newOperator);
			break;
		}
		case 1: {
			addition(calcul_display, newOperator);
			break;
		}
		case 2: {
			subtraction(calcul_display, newOperator);
			break;
		}
		case 3: {
			multiplication(calcul_display, newOperator);
			break;
		}
		case 4: {
			division(calcul_display, newOperator);
			break;
		}
		default:
			System.out.println("error");
		}
	}

	public void resume(JLabel calcul_display, int newOperator) {

		System.out.println(result + "0 debut");

		result = "" + Double.parseDouble(calcul_display.getText());

		System.out.println(result);
		cheickType(calcul_display, newOperator);

		System.out.println(result + "0 fin");
	}

	public void addition(JLabel calcul_display, int newOperator) {

		System.out.println(result + "1");
		Double d = Double.parseDouble(result) + Double.parseDouble(calcul_display.getText());
		result = "" + d;

		cheickType(calcul_display, newOperator);
	}

	public void subtraction(JLabel calcul_display, int newOperator) {

		Double d = Double.parseDouble(result) - Double.parseDouble(calcul_display.getText());
		result = "" + d;
		cheickType(calcul_display, newOperator);
	}

	public void division(JLabel calcul_display, int newOperator) {

		Double d = Double.parseDouble(result) / Double.parseDouble(calcul_display.getText());
		result = "" + d;
		cheickType(calcul_display, newOperator);

		
	}

	public void multiplication(JLabel calcul_display, int newOperator) {

		Double d = Double.parseDouble(result) * Double.parseDouble(calcul_display.getText());
		result = "" + d;

		cheickType(calcul_display, newOperator);
	}

	public void cheickType(JLabel calcul_display, int newOperator) {

		String value = result.replace(".", ",");
		String[] arrOfStr = value.split(",");
		System.out.println(Arrays.toString(arrOfStr));
		try {
			if (arrOfStr[1].equals("0")) {
				result = arrOfStr[0];
			}
			changeCurrentOpe(newOperator);
		} catch (ArrayIndexOutOfBoundsException e) {
			calcul_display.setFont(new Font("Tahoma", Font.BOLD, 18));
			result = "Nous ne pouvons pas diviser par zéro";
			currentOperator = 0;

		}

		calcul_display.setText(result);

	}

	public void changeCurrentOpe(int newOperator) {

		currentOperator = newOperator;

	}
	
	public void addNumber(JLabel calcul_display, String number) {
		if (isOn()) {
			if (calcul_display.getText().equals("0")) {
				calcul_display.setText("");
			}

			String value = number;
			if (!isOperatorPressed()) {

				value = calcul_display.getText() + number;
			}
			setOperatorPressed(false);
			calcul_display.setText(value);
		}
	}
	
	public void doOperation(JLabel calcul_display, int newOper) {
		if (isOn()) {
			if (!result.equals("") || !calcul_display.getText().isEmpty()) {

				if (!isOperatorPressed()) {
					operation(calcul_display, newOper);
				} else {
					currentOperator = newOper;
				}
			}

		}
	}

}
