/*
    File: CalculatorInput.java 
  Student Numebr :Sreelakshmi Odatt Venu
  Student Number:041093516
  	Course: CST8284 – OOP
 	Assignment: Assignment 2
  Due Date: November 26 2023
 	Professor: Veda Vasavi Erukulla
 	Purpose: This is the CalculatorInut Class used for authenticate the user input.
*/
package assignment2;

import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.Stack;

/**
 * This class is for checking the user input of an equation.
 * 
 * @author Sreelakshmi Odatt Venu
 * @version 1.0
 * @since 17.0.7
 * @see java.util.NoSuchElementException
 * @see java.util.Scanner
 * @see java.util.Stack
 * @see java.util.InputMismatchException
 * 
 */

public class CalculatorInput {

	/**
	 * Checks whether the input equation is correct and providesthe result. and also
	 * displays the errors if any occurs and if no errors found , then displays the
	 * result of the equation.
	 * 
	 * @return boolean for this equation.
	 */
	public boolean checkEquation() {
		try {
			Scanner keyboard = new Scanner(System.in);

			int number1, number2;
			String operator, equals, userInput;
			boolean isnumber1Zero = false;

			userInput = keyboard.nextLine();
			Scanner input = new Scanner(userInput);

			/**
			 * the try-catch blocks if the equation is missing or the first input is not a
			 * number .
			 */
			try {
				number1 = input.nextInt();

				if (number1 == 0) {
					isnumber1Zero = true;
				}
			} catch (NoSuchElementException e) {
				System.out.println(
						"Error: Equation incomplete. First Number is not a number or  First number is missing!. (NoSuchElementException)");
				return true;
			}

			/**
			 * the try-catch blocks for the operator
			 */
			try {
				operator = input.next();

				if (!operator.matches("[+\\-*/]")) {
					if (isnumber1Zero == true && operator.equals("=")) {
						System.out.println("Program exiting.");
						return false;
					}
					System.out.println("Error: Invalid operator. Valid operators are +, -, /, and * . ! (InputMismatchException)");
					return true;
				}
			} catch (NoSuchElementException e) {
				System.out.println("Error: Equation incomplete. Operator is missing!.(NoSuchElementException)");
				return true;
			}

			/**
			 * the try-catch for the number2
			 */
			try {
				try {
					number2 = input.nextInt();
				} catch (NoSuchElementException e) {
					System.out.println("Error: Second number is missing!.(NoSuchElementException)");
					return true;
				}

			} catch (InputMismatchException e) {
				System.out.println("Error: Second number is not a valid integer!.(InputMismatchException)");
				return true;

			}

			/**
			 * the try-catch for the equals
			 */
			try {
				equals = input.next();

				if (!equals.equals("=")) {

					/**
					 * For the extra challege where the calculator permits equations of any length,
					 * such as 2 + 3 - 5 * 7 / 2 =
					 */
					if (equals.matches("[+\\-*/]")) {

						/**
						 * Creating the stacks for the numbers
						 */

						Stack<Integer> numbers = new Stack<>();
						/**
						 * Creating the stacks for the operators
						 */
						Stack<String> operators = new Stack<>();

						/**
						 * changes the user input into an array with the whitespace as the delimiter
						 */
						String[] items = userInput.split("\\s+");

						for (String item : items) {
							if (item.matches("\\d+")) {
								/**
								 * If it is a number, then convert to an integer and pushes it onto the numbers
								 * stack
								 * 
								 */

								numbers.push(Integer.parseInt(item));
							} else if (item.matches("[+\\-]")) {
								/**
								 * If the item is an addition or subtraction operator , then it will process the
								 * one with the higher precedence operator before pushing the current one.
								 */
								while (!operators.isEmpty() && hasPrecedence(item, operators.peek())) {

									calculateAndPush(numbers, operators);
								}

								/**
								 * Pushes current operator on to the top of the stack
								 */
								operators.push(item);
							} else if (item.matches("[*/]")) {
								// If the item is a multiplication or division operator
								while (!operators.isEmpty() && hasPrecedence(item, operators.peek())) {
									// Process higher precedence operators before pushing the current one
									calculateAndPush(numbers, operators);
								}

								/**
								 * Pushes current operator on to the top of the stack
								 */
								operators.push(item);

							}
							/**
							 * If the last item in the equation is an equal to operator, then it is the end
							 * of the calculation .
							 */
							else if (item.equals("=")) {

								break;
							} else {
								/**
								 * To print An error message when it is not a valid number, operator, or equal
								 * operator
								 */
								System.out.println("Error: Invalid input: " + item);
								return true;
							}
						}

						while (!operators.isEmpty()) {
							calculateAndPush(numbers, operators);
						}

						System.out.println("The answer is: " + numbers.pop());

						return true;
					}
					return true;
				}
			} catch (NoSuchElementException e) {
				System.out.println("Error: Equation incomplete. Equation must end with =.!(NoSuchElementException)");
				return true;
			}

			/**
			 * instantiate a new object , stores the answer in the result variable and
			 * display it .
			 */
			CalculatorEngine calculatorEngine = new CalculatorEngine();
			int result = calculatorEngine.calculate(number1, operator, number2);
			System.out.println("The answer is: " + result);

			return true;
		} catch (Exception e) {
			System.out.println("Something happened with the program!(Exception)" + e.getMessage());
			return true;
		}
	}

	/**
	 * 
	 * Determines the precedence of the operator.
	 * 
	 * @param op The operator.
	 * @return The integer which represents the precedence of the operator
	 */
	private int precedence(String op) {
		switch (op) {
		case "+":
		case "-":
			return 1; // Lowest precedence
		case "*":
		case "/":
			return 2; // Medium precedence

		}
		return 0; // Default precedence if the operator is not fouund
	}

	/**
	 * Determines if the precedence of the first operator is less than or equal to
	 * the precedence of the second operator.
	 * 
	 * @param op1 The first operator.
	 * @param op2 The second operator.
	 * @return true if the first operatorr has lower or equal to precedence and
	 *         false vice versa.
	 */
	private boolean hasPrecedence(String op1, String op2) {
		/**
		 * To check if the precedence of the first operator is less than or equal to the
		 * precedence of the second operator.
		 */
		if (precedence(op1) <= precedence(op2)) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * do the required calculation and then pushes it onto the numbers stack .
	 * 
	 * @param numbers   stack of the numbers.
	 * @param operators stack of the operators.
	 */
	private void calculateAndPush(Stack<Integer> numbers, Stack<String> operators) {
		// Pop the top two numbers and the operator from their respective stacks
		int number2 = numbers.pop();
		int number1 = numbers.pop();
		String operator = operators.pop();

		CalculatorEngine calculatorEngine = new CalculatorEngine();
		int result = calculatorEngine.calculate(number1, operator, number2);

		/**
		 * Pushes the output to the numbers stack
		 */
		numbers.push(result);
	}

}
