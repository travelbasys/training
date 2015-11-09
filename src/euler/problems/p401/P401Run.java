package euler.problems.p401;

import java.util.Date;

public class P401Run {

	public static void main(String[] args) {
		runSIGMA2(1); // 1
		runSIGMA2(2); // 6
		runSIGMA2(3); // 16
		runSIGMA2(4); // 37
		runSIGMA2(5); // 63
		runSIGMA2(6); // 113
		runSIGMA2(1_000_000_000_000_000L);
		// 400685634386532129948866931891753981281632621
	}

	private static void runSIGMA2(long N) {
		System.out.println("");
		System.out.println(new Date());
		System.out.print("SIGMA2(" + N + ")=");

		System.out.println(P401BigA.SIGMA2(N));
		System.out.println(new Date());
		return;
	}

}