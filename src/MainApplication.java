import java.math.BigDecimal;
import java.util.HashMap;

public class MainApplication {
	public static void main(String[] args) throws Exception {
		runTaskOne();
		System.out.println("-------");
		runTaskTwo();
		System.out.println("-------");
		runTaskThree();
	}


	public static void runTaskOne() {
		TaskOne t1 = new TaskOne();
		System.out.println("Example proof : " + t1.calculateMonthlyRepayment(
				new BigDecimal(500000),
				4.45,
				30,
				false)
		);
		System.out.println("Task 1 Basic  : " + t1.calculateMonthlyRepayment(
				new BigDecimal(400000),
				4.00,
				30,
				false)
		);

		System.out.println("Task 1 Adv    : A maximum of " + t1.getMaximumRateAllowed(
				new BigDecimal(400000),
				30,
				1500) + "%.");

	}

	public static void runTaskTwo() {
		TaskTwo t2 = new TaskTwo();


		System.out.println("Task 2 Basic : " + t2.checkDigit(0, "2987654321"));

		HashMap<Integer, Integer> distributionBuckets = new HashMap<Integer, Integer>();
		distributionBuckets.put(0, 0);
		distributionBuckets.put(1, 0);
		distributionBuckets.put(2, 0);
		distributionBuckets.put(3, 0);
		distributionBuckets.put(4, 0);
		distributionBuckets.put(5, 0);
		distributionBuckets.put(6, 0);
		distributionBuckets.put(7, 0);
		distributionBuckets.put(8, 0);
		distributionBuckets.put(9, 0);

		System.out.println("Task 2 Advanced ");
		t2.calculateValueDistribution(distributionBuckets);

	}

	private static void runTaskThree() throws Exception {
		TaskThree t3 = new TaskThree();
//		System.out.println("Task 3 Basic : " + t3.getHundredthPrime());
		String encryptedString = t3.encrypt("Hello Worldista!");
		String decryptedString = t3.decrypt(encryptedString);
		System.out.println("Task 3 Adv [Encrypt]  : " + encryptedString);
		System.out.println("Task 3 Adv [Decrypt]  : " + decryptedString);

	}

}
