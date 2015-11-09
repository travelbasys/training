package euler.project.p401;

import java.util.Date;

public class P401Run {

	public static void main(String[] args) {
		runSIGMA2(1_000_000_000_000_000L);
		// 400685634386532129948866931891753981281632621
	}

	private static void runSIGMA2(long n) {
		Date d0 = new Date(), d1;
		System.out.print("SIGMA2(" + n + ")=");
		System.out.println(P401Big.SIGMA2(n));
		d1 = new Date();
		System.out.println((d1.getTime() - d0.getTime()) + " ms");
		return;
	}

}