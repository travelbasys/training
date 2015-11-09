package euler.util;

import java.math.BigInteger;

public class Math {
	private static final BigInteger BIG6 = BigInteger.valueOf(6);

	public static BigInteger sumsqs(long j, long k) {
		return sumsq(k).subtract(sumsq(j - 1));
	}

	/**
	 * Computes the sum of all k**2 where k=1 to n.
	 * 
	 * @param n
	 *            Any non-negative integer.
	 * @return The value of n*(n+1)*(2*n+1)/6 .
	 */
	public static BigInteger sumsq(long n) {
		long n1 = n + 1, n2 = n + n1;
		return BigInteger.valueOf(n).multiply(BigInteger.valueOf(n1))
				.multiply(BigInteger.valueOf(n2)).divide(BIG6);
	}

}
