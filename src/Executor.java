import java.util.Scanner;

public class Executor {

	/**
	 * Verifies if the user wants to continue.
	 * 
	 * @param prompt
	 *            the user prompt
	 * @param scan
	 *            the scanner to collect input from
	 * @return true if they enter y, false otherwise
	 */
	public static boolean wantToContinue(String prompt, Scanner scan) {
		String response = "";
		boolean valid = false;

		System.out.println(prompt);
		while (!valid) {
			response = scan.nextLine();

			if (response.equalsIgnoreCase("y") || response.equalsIgnoreCase("n")) {
				valid = true;
			} else {
				System.out.println("You must enter y or n. Please try again.");
			}
		}
		return response.equalsIgnoreCase("y");
	}
}
