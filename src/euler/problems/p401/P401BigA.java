package euler.problems.p401;

import static euler.utils.Math.sumsq;

import java.math.BigInteger;

public class P401BigA {

	public static BigInteger SIGMA2(long N) {
		BigInteger sum = BigInteger.ZERO;
		long sqrtN = (long) Math.floor(Math.sqrt(N));

		for (long d = 1; d <= sqrtN; d++) {
			long q = N / d;
			BigInteger bigD = BigInteger.valueOf(d);
			BigInteger bigDD = bigD.multiply(bigD);

			sum = sum.add(bigDD.multiply(BigInteger.valueOf(q - d)))
					.add(sumsq(q)).subtract(sumsq(d - 1));
		}
		return sum;
	}

}