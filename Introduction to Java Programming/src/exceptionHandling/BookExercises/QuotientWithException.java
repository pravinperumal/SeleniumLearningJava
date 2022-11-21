package exceptionHandling.BookExercises;

import java.util.Scanner;

public class QuotientWithException {
	
	public static int quotient(int number1, int number2) {
		if (number2 == 0) 
			throw new ArithmeticException("An arithmetic exception occured. \nDivisor cannot be zero");
 
		return number1/number2;
	}
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		System.out.println("Enter 2 integers: ");
		int number1 = input.nextInt();
		int number2 = input.nextInt();
		
		try {
			int result = quotient(number1, number2);
			System.out.println(number1 + " / "+number2+" equals "+result);
		} catch (Exception ae) {
			ae.printStackTrace();
			System.out.println(ae.getMessage());
		}
	}

}
