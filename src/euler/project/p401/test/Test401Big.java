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

import java.math.BigInteger;

import org.junit.Assert;
import org.junit.Test;

import euler.project.p401.P401Big;

public class Test401Big {

	private static final long[] INPUT = { 1, 2, 3, 4, 5, 6, 10, 100, 1000,
			10000, 100000 };
	private static final BigInteger[] RESULT = { BigInteger.valueOf(1),
			BigInteger.valueOf(6), BigInteger.valueOf(16),
			BigInteger.valueOf(37), BigInteger.valueOf(63),
			BigInteger.valueOf(113), BigInteger.valueOf(469),
			BigInteger.valueOf(407819), BigInteger.valueOf(401382971),
			BigInteger.valueOf(400757638164L),
			BigInteger.valueOf(400692683389101L) };

	@Test
	public void test() {
		for (int i = 0; i < INPUT.length; i++) {
			Assert.assertEquals("SIGMA2", RESULT[i], P401Big.SIGMA2(INPUT[i]));
		}
	}
}
