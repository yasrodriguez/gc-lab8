import java.util.Scanner;

/**
 * Calculates the batting average and slugging % for one or more baseball or
 * softball players.
 * 
 * @author Yasmin
 *
 */
public class BattingAverageCalculator {

	/**
	 * Asks the number of at-bats, for each bat asks the number of bases earned by
	 * the batter. Calls methods to calculate the batting average and slugging
	 * percentage.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		boolean keepGoing = true;

		System.out.println("Welcome to Batting Average Calculator!");
		System.out.println();

		while (keepGoing) {
			final int ARRAY_SIZE = Validator.getInt(scan, "Enter number of times at bat: ", 1, Integer.MAX_VALUE);
			int[] atBats = new int[ARRAY_SIZE];
			System.out.println();

			System.out.println("0=out, 1=single, 2=double, 3=triple, 4=home run");
			for (int i = 0; i < atBats.length; i++) {
				System.out.print("Result for at-bat " + i + ": ");
				atBats[i] = Validator.getInt(scan, "Result for at-bat " + i + ": ", 0, 4);
			}
			System.out.println();

			System.out.printf("Batting average: %.3f\n", calculateBattingAverage(atBats));
			System.out.printf("Slugging Percentage: %.3f\n", calculateSlugging(atBats));
			System.out.println();

			keepGoing = Executor.wantToContinue("Another batter? (y/n): ", scan);
		}
		System.out.println("Goodbye!");
	}

	/**
	 * Calculates the batting average: number of at-bats for which the player earned
	 * at least one base divided by the total number of at-bats.
	 * 
	 * @param atBats
	 *            bats for a player
	 * @return batting average
	 */
	public static double calculateBattingAverage(int[] atBats) {
		int count = 0;

		for (int bat : atBats) {
			if (bat > 0) {
				count++;
			}
		}
		return (double) count / atBats.length;
	}

	/**
	 * Calculates the slugging percentage: number of bases earned divided by total
	 * number of at-bats.
	 * 
	 * @param atBats
	 *            bats for a player
	 * @return slugging percentage
	 */
	public static double calculateSlugging(int[] atBats) {
		int sum = 0;

		for (int bat : atBats) {
			sum += bat;
		}
		return (double) sum / atBats.length;
	}
}
