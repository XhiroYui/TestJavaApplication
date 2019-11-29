import java.math.BigDecimal;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Base64;

class TaskThree {

	int getHundredthPrime() {
		Lcg lcg = new Lcg(65536,137, 1, 0);

		ArrayList<Integer> primeListOfLCG = new ArrayList<>();
		while (primeListOfLCG.size() != 100) {
			int currentNumber = Math.toIntExact(lcg.next());
			if (isPrime(currentNumber)) {
				primeListOfLCG.add(currentNumber);
			}
		}

//		for (int i = 0; i < primeListOfLCG.size(); i++) {
//			System.out.println((i+1) + " - " + primeListOfLCG.get(i));
//		}
		return primeListOfLCG.get(primeListOfLCG.size()-1);
	}

	String encrypt(String plainText) throws Exception {
		Lcg lcg = new Lcg(256, 11, 1, 0);
		byte[] bytes = plainText.getBytes(StandardCharsets.UTF_8);
		int len = bytes.length;
		byte[] xors = new byte[len];
		for (int ix = 0; ix < len; ix += 1) {
			int lcgNext = Math.toIntExact(lcg.next());
			xors[ix] = (byte) ((int) bytes[ix] ^ (lcgNext));
		}
		return new String(Base64.getEncoder().encode(xors), StandardCharsets.UTF_8);
	}


	String decrypt(String base64EncodedValue) throws Exception {
		Lcg lcg = new Lcg(256, 11, 1, 0);
		byte[] decodedString = Base64.getDecoder().decode(base64EncodedValue);
		byte[] xors = new byte[decodedString.length];
		for (int ix = 0; ix < decodedString.length; ix += 1) {
			int lcgNext = Math.toIntExact(lcg.next());
			xors[ix] = (byte) ((int) decodedString[ix] ^ (lcgNext));
		}
		return new String(xors);
	}

	private boolean isPrime(int n) {
		int i, m = 0, flag = 0;
		m = n / 2;
		if (n == 0 || n == 1) {
			return false;
		} else {
			for (i = 2; i <= m; i++) {
				if (n % i == 0) {
					flag = 1;
					break;
				}
			}
			return flag == 0;
		}
	}
}
