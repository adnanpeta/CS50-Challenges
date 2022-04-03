package myProject;
// this application encrypts a text using Caesar's formula by shifting each letter therein by a number of places, "key" in this instance
import java.util.Scanner;

public class CaesarCipher {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int key;
		System.out.print("Insert text to be encrypted: ");
		String text = s.nextLine();

		System.out.print("Choose key: ");

		if(s.hasNextInt()) {
		    key = s.nextInt();
		} else {
			System.out.println("Not a valid key, encryption failed");
			return;
		}
		s.close();
		System.out.print("Encrypted text: ");
		for (int i = 0; i < text.length(); i++) {
			System.out.print(getCipher(text.charAt(i), key));
		}
	}

	private static char getCipher(char letter, int key) {
		if (Character.isUpperCase(letter)) {
			return (char) ((letter - 'A' + key) % 26 + 'A');
		} else if (Character.isLowerCase(letter)) {
			return (char) ((letter - 'a' + key) % 26 + 'a');
		} else
			return letter;
	}

}
