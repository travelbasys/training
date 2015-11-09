package euler.util;

import java.math.BigInteger;

public class Math {
	// private static final BigInteger BIG6 = BigInteger.valueOf(6);

	public static BigInteger sumsqs(long j, long k) {
		return sumsq(k).subtract(sumsq(j - 1));
	}

	/**
	 * Compute 1*1 + 2*2 + 3*3 + ... + n*n .
	 * 
	 * @param n
	 *            Any non-negative integer.
	 * @return The value of n*(n+1)*(2*n+1)/6 .
	 */
	public static BigInteger sumsq(long n) {
		long n1 = n + 1, n2 = n + n1;

		// Divide early to keep numbers small.
		switch ((int) (n % 6)) {
		case 0:
			n = n / 6;
			break;
		case 1:
			n1 = n1 / 2;
			n2 = n2 / 3;
			break;
		case 2:
			n = n / 2;
			n1 = n1 / 3;
			break;
		case 3:
			n = n / 3;
			n1 = n1 / 2;
			break;
		case 4:
			n = n / 2;
			n2 = n2 / 3;
			break;
		case 5:
			n1 = n1 / 6;
			break;
		}
		return BigInteger.valueOf(n).multiply(BigInteger.valueOf(n1))
				.multiply(BigInteger.valueOf(n2));
	}

}
