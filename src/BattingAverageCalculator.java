import java.util.Scanner;

/**
 * Calculate the batting average and slugging % for one or more baseball or
 * softball players.
 * 
 * @author Yasmin
 *
 */
public class BattingAverageCalculator {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Welcome to Batting Average Calculator!");

		System.out.print("Enter number of times at bat: ");
		final int ARRAY_SIZE = scan.nextInt();
		int[] atBats = new int[ARRAY_SIZE];

		System.out.println("0=out, 1=single, 2=double, 3=triple, 4=home run");
		for (int i = 0; i < atBats.length; i++) {
			System.out.print("Result for at-bat " + i + ": ");
			atBats[i] = scan.nextInt();
		}

		System.out.printf("Batting average: %.3f\n", calculateBattingAverage(atBats));
		System.out.printf("Slugging Percentage: %.3f\n", calculateSlugging(atBats));
	}

	/**
	 * Calculates the batting average: number of at-bats for which the player earned
	 * at least one base divided by the total number of at-bats.
	 * 
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
