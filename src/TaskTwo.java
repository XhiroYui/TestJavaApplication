import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class TaskTwo {

	private Pattern pattern = Pattern.compile("^(\\d)(\\d+)$");


	public int checkDigit(int currentSum, String input) {
//		System.out.println("Current Sum : " + currentSum);
//		System.out.println("Current Inp : " + input);

		Matcher matcher = pattern.matcher(input);

		if (matcher.find()) {
			currentSum += Integer.parseInt(matcher.group(1));
			currentSum = processValues(currentSum);
			return checkDigit(currentSum, matcher.group(2));
		} else {
			currentSum += Integer.parseInt(input);
			currentSum = processValues(currentSum);
			return currentSum;
		}

	}

	public void calculateValueDistribution(HashMap<Integer, Integer> distributionBuckets) {
		int i = 1;
		while (i < 1000000) {
			int checkDigit = checkDigit(0, String.valueOf(i));
//			System.out.println("Current i = " + i);
//			System.out.println("Current checkDigit = " + checkDigit);
//			System.out.println("---=-=-=-=-=-=---");
			distributionBuckets.replace(checkDigit,	distributionBuckets.get(checkDigit )+ 1);
			i++;
		}
		distributionBuckets.forEach((key, value) -> System.out.println(key + " <-- Value | Frequency --> " + value));

	}
	/**
	 * Checks if given value is even or odd
	 * @param value The given input
	 * @return true if even, false if odd
	 */
	private boolean checkEven(int value) {
		return value % 2 != 1;
	}

	private int processValues(int currentSum) {
		return checkEven(currentSum) ? currentSum/2 : (currentSum-1)/2;
	}
}
