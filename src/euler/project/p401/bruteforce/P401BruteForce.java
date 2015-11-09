package euler.project.p401.bruteforce;

import java.math.BigInteger;

public class P401BruteForce {

	public static BigInteger SIGMA2(long n) {
		BigInteger sum = BigInteger.ZERO;
		for (long i = 1; i <= n; i++) {
			for (long k = 1; k <= i; k++) {
				if (i % k == 0)
					sum = sum.add(BigInteger.valueOf(k * k));
			}
		}
		return sum;
	}

}