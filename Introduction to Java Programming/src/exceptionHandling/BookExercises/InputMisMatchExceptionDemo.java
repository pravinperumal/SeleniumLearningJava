package exceptionHandling.BookExercises;

import java.util.Scanner;

public class InputMisMatchExceptionDemo {
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		boolean continueInput = true;
		
		do {
			try {
				System.out.println("Enter an integer: ");
				int number1 = input.nextInt();
				System.out.println("The number entered is: "+number1);
				continueInput = false;				
				
			} catch (Exception e) {
				System.out.println("Try again. Incorrect input. An integer is required.");
				input.nextLine();
			}			
		} while (continueInput);
	}

}
