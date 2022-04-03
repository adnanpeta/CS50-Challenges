package myProject;

// this application prompts the user for a credit card number and then reports whether it is a valid American Express, MasterCard, or Visa card number

import java.util.Scanner;

public class CardCheck {
	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);
		System.out.print("Input credit card number: ");
		long card = s.nextLong();
		s.close();

		// credit card number length varies between 13 and 16 digits 
		if (getLength(card) < 13 || getLength(card) > 16) {
			System.out.println("INVALID");
			return;
		}

		int sum = luhnAlgorithm(card);
		int firstTwoDigits = getFirstTwoDigits(card);

		if (sum % 10 == 0 && (firstTwoDigits == 34 || firstTwoDigits == 37)) {
			System.out.println("AMERICAN EXPRESS");
			return;
		}
		if (sum % 10 == 0 && !(firstTwoDigits < 51) && !(firstTwoDigits > 55)) {
			System.out.println("MASTERCARD");
			return;
		}
		if (sum % 10 == 0 && firstTwoDigits / 10 == 4) {
			System.out.println("VISA");
			return;
		} else {
			System.out.println("INVALID");
		}
	}

	private static int getFirstTwoDigits(long card) {
		while (card > 99) {
			card /= 10;
		}
		return (int) card;
	}

	// most cards use an algorithm invented by Hans Peter Luhn of IBM, name Luhn's Algorithm
	// for more information: https://www.wikiwand.com/en/Luhn_algorithm
	private static int luhnAlgorithm(long card) {
		int sum1 = 0, sum2 = 0;
		while (card > 0) {
			int x = (int) (card % 10); // calculating the last digit of the credit card number
			card /= 10;
			sum1 += x;

			int y = (int) ((card % 10) * 2);    // multiply every other digit by 2, starting with the number’s
												// second-to-last digit and then add those products’ digits together
			card /= 10;
			int digit1 = y % 10;
			int digit2 = y / 10;
			sum2 = sum2 + digit1 + digit2;
		}
		return sum1 + sum2;
	}
	
	private static int getLength(long card) {
		int counter = 0;
		while (card > 0) {
			card /= 10;
			counter++;
		}
		return counter;
	}

}
