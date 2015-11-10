package euler.project.p401;

import static euler.util.Math.sumsq;

import java.math.BigInteger;

public class P401Big {

	public static BigInteger SIGMA2(long N) {
		BigInteger sum = BigInteger.ZERO;
		long sqrtN = (long) Math.floor(Math.sqrt(N));

		// Avoid some computations in the loop:
		// dd = d*d
		// bigDD = BigInteger.valueOf(d*d)
		// ssq = sumsq(d-1)
		long dd = 1; 
		BigInteger bigDD = BigInteger.ONE;
		BigInteger ssq = BigInteger.ZERO;
		for (long d = 1; d <= sqrtN; d++) {
			long q = N / d;
			
			sum = sum.add(bigDD.multiply(BigInteger.valueOf(q - d)))
					.add(sumsq(q)).subtract(ssq);
			
			ssq = ssq.add(bigDD);
			dd = dd + d +d + 1;
			bigDD = BigInteger.valueOf(dd);
		}
		return sum;
	}

}