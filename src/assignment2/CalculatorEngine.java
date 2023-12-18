/*
    File name: CalculatorEngine.java 
 	  Student Numebr :Sreelakshmi Odatt Venu
  Student Number:041093516
 	Course: CST8284 – OOP
 	Assignment: Assignment 2
  Due Date: November 26 2023
 	Professor: Veda Vasavi Erukulla
 	Professor: Veda Vasavi Erukulla
 	Purpose:  This class is for  the equations of the calculator .
*/
package assignment2;

/**
 * This class is for calculating the equation.
 * 
 * @author Sreelakshmi Odatt Venu
 * @version 1.0
 * @since 17.0.7
 * @see java.lang.ArithmeticException
 */
public class CalculatorEngine {

	/**
	 * Executes an operation with the user specified operator and two given
	 * numbers.
	 * 
	 * @param number1  The first number.
	 * @param operator The operators (+, -, *, /).
	 * @param number2  The second number.
	 * @return The result of the calculation.
	 */
	public int calculate(int number1, String operator, int number2) {
		switch (operator) {
		case "+":
			return add(number1, number2);
		case "-":
			return subtract(number1, number2);
		case "*":
			return multiply(number1, number2);
		case "/":
			return divide(number1, number2);
		default:
			return 0;
		}
	}

	/**
	 * Calcualtion to adds two numbers.
	 * 
	 * @param number1 The first number.
	 * @param number2 The second number.
	 * @return The result by calcualting the sum of number1 and number2.
	 */

	private int add(int number1, int number2) {
		return number1 + number2;
	}

	/**
	 * Calcualtion to subtract the second number from the first number.
	 * 
	 * @param number1 The first number.
	 * @param number2 The second number.
	 * @return The result by subtracting number2 from number1.
	 */
	private int subtract(int number1, int number2) {
		return number1 - number2;
	}

	/**
	 * Calcualtion to multiply two numbers.
	 * 
	 * @param number1 The first number.
	 * @param number2 The second number.
	 * @return The result by the calculating the product of number1 and number2.
	 */

	private int multiply(int number1, int number2) {
		return number1 * number2;
	}

	/**
	 * Calcualtion to divide the first number by the second number.
	 * 
	 * @param number1 The number1 as the numerator.
	 * @param number2 The number2 as the denominator.
	 * @return The result by the division of the first number by the second number2.
	 */

	private int divide(int number1, int number2) {
		try {
			return number1 / number2;
		} catch (ArithmeticException e) {
			System.out.println("Error: Cannot divide by zero! Result is invalid , returning zero.");
			return 0;
		}
	}
}
