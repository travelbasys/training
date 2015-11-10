package euler.project.p401;

import static euler.util.Math.sumsq;

public class P401Long {

	public static long SIGMA2(long n, long M) {
		long sum = 0L;
		long sqrtN = (long) Math.floor(Math.sqrt(n));

		// Avoid some computations in the loop:
		// dd = d*d
		// ssq = sumsq(d-1, M)
		long dd = 1L;
		long ssq = 0L;	
		
		for (long d = 1; d <= sqrtN; d++) {
			long q = n / d;

			sum = (sum + dd * ((q - d) % M) + sumsq(q, M) - ssq) % M;

			ssq = (ssq + dd) % M;
			dd = (dd + d + d + 1) % M;
		}
		
		while (sum < 0)
			sum += M;
		
		return sum;
	}
}