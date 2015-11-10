package euler.project.p401.test;

// Testcases computed using brute-force method.
// SIGMA2(1)=1
// SIGMA2(2)=6
// SIGMA2(3)=16
// SIGMA2(4)=37
// SIGMA2(5)=63
// SIGMA2(6)=113
// SIGMA2(10)=469
// SIGMA2(100)=407819
// SIGMA2(1000)=401382971
// SIGMA2(10000)=400757638164
// SIGMA2(100000)=400692683389101

import org.junit.Assert;
import org.junit.Test;

import euler.project.p401.P401Long;

public class Test401Long {

	private static final long M = 1_000_000_000L;

	private static final long[] INPUT = { 1, 2, 3, 4, 5, 6, 10, 100, 1000,
			10000, 100000 };
	private static final long[] RESULT = { 1, 6, 16, 37, 63, 113, 469, 407819,
			401382971, 400757638164L % M, 400692683389101L % M };

	@Test
	public void test() {
		for (int i = 0; i < INPUT.length; i++) {
			long result = P401Long.SIGMA2(INPUT[i], M);
			Assert.assertEquals("SIGMA2", RESULT[i], result);
		}
	}
}
