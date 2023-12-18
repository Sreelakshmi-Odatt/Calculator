/*
   File: Calculator.java 
   Student Numebr :Sreelakshmi Odatt Venu
  Student Number:041093516
 	Course: CST8284 – OOP
 	Assignment: Assignment 2
  Due Date: November 26 2023
 	Professor: Veda Vasavi Erukulla
 	Purpose: This is the Calculator.java for printing the first informations and is the driver class for this program..
*/
package assignment2;

/**
 * This calculator is used to run the program in which users input their
 * equation and then show the requiered calculation results.
 * 
 * @author Sreelakshmi Odatt Venu
 * @version 1.0
 * @since 17.0.7
 */
public class Calculator {

	/**
	 * entry point of the program
	 * 
	 * @param args the command line arguments passed to the program.
	 */
	public static void main(String[] args) {

		System.out.println("Welcome to the Assignment 2 CST8284 calculator.");
		System.out.println("Written by Sreelakshmi Odatt Venu");
		System.out.println("Student Number:041093516");
		System.out.println();
		System.out.println();
		System.out.println("Equations are in the form number_1 operator number_2 =");
		System.out.println("Where number_1 and number_2 must be integers, ");
		System.out.println("The operator is one of  these +, -, / or *");
		System.out.println();
		System.out.println("Enter 0 = to quit the program.");
		System.out.println();
		System.out.println();
		CalculatorInput calculatorInput = new CalculatorInput();

		while (true) {

			System.out.print("Enter the equation:");

			if (!calculatorInput.checkEquation()) {
				break;
			}
		}
	}

}
