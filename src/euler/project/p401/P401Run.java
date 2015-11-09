package euler.project.p401;

import java.util.Date;

public class P401Run {

	public static void main(String[] args) {
		runSIGMA2(1_000_000_000_000_000L);
		// 400685634386532129948866931891753981281632621
	}

	private static void runSIGMA2(long n) {
		System.out.println("");
		System.out.println(new Date());
		System.out.print("SIGMA2(" + n + ")=");

		System.out.println(P401Big.SIGMA2(n));
		System.out.println(new Date());
		return;
	}

}