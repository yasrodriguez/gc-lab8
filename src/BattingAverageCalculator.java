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
	 * Asks for the number of batters. It then calls methods to collect at bats for
	 * each batter, calculate the batting average and slugging percentage for each
	 * batter. It also prints stat results for each batter.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		System.out.println("Welcome to Batting Average Calculator!");
		System.out.println();

		int numOfBatters = Validator.getInt(scan, "Enter number of batters: ", 1, Integer.MAX_VALUE);
		int[][] batterStats = new int[numOfBatters][];
		System.out.println();

		collectAtBats(scan, batterStats);

		for (int i = 0; i < batterStats.length; i++) {
			System.out.printf("Batter %d   batting average: %.3f   slugging percentage: %.3f\n", i + 1,
					calculateBattingAverage(batterStats[i]), calculateSlugging(batterStats[i]));
		}

		System.out.println();

		System.out.println("Goodbye!");
	}

	/**
	 * Collects each batter's at bats and adds them to the batterStats array.
	 * 
	 * @param scan
	 *            Scanner object to use when collecting input
	 * @param batterStats
	 *            multidimensional array containing the batters along with their
	 *            empty stats
	 */
	private static void collectAtBats(Scanner scan, int[][] batterStats) {
		for (int i = 0; i < batterStats.length; i++) {

			int atBats = Validator.getInt(scan, "Batter # " + (i + 1) + ", enter number of times at bat: ", 1,
					Integer.MAX_VALUE);
			batterStats[i] = new int[atBats];
			System.out.println();

			System.out.println("0=out, 1=single, 2=double, 3=triple, 4=home run");
			for (int j = 0; j < batterStats[i].length; j++) {
				batterStats[i][j] = Validator.getInt(scan, "Result for at-bat " + j + ": ", 0, 4);
			}
			System.out.println();
		}
	}

	/**
	 * Calculates the batting average for one batter: number of at-bats for which
	 * the batter earned at least one base divided by the total number of at-bats.
	 * 
	 * @param atBats
	 *            bats for a player
	 * @return batting average for the batter
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
	 * Calculates the slugging percentage for one batter: number of bases earned
	 * divided by total number of at-bats.
	 * 
	 * @param atBats
	 *            bats for a player
	 * @return slugging percentage for the batter
	 */
	public static double calculateSlugging(int[] atBats) {
		int sum = 0;

		for (int bat : atBats) {
			sum += bat;
		}
		return (double) sum / atBats.length;
	}
}
