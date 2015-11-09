package euler.project.p401;

import static euler.util.Math.sumsq;

import java.math.BigInteger;

public class P401Big {

	public static BigInteger SIGMA2(long N) {
		BigInteger sum = BigInteger.ZERO;
		long sqrtN = (long) Math.floor(Math.sqrt(N));

		long dd = 1; 
		for (long d = 1; d <= sqrtN; d++) {
			long q = N / d;
			
			sum = sum.add(BigInteger.valueOf(dd).multiply(BigInteger.valueOf(q - d)))
					.add(sumsq(q)).subtract(sumsq(d-1));
			
			dd = dd + d +d + 1;
		}
		return sum;
	}

}