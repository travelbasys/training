package euler.project.p401;

import java.util.Date;

public class P401BruteForceRun {

	public static void main(String[] args) {
		runSIGMA2(1); // 1
		runSIGMA2(2); // 6
		runSIGMA2(3); // 16
		runSIGMA2(4); // 37
		runSIGMA2(5); // 63
		runSIGMA2(6); // 113
		long n = 10L;
		while (true){
			Date d0 = new Date();
			runSIGMA2(n);
			Date d1 = new Date();
			if( d1.getTime() - d0.getTime() > 10000) break;
			n = n * 10;
		}
	}

	private static void runSIGMA2(long N) {
		System.out.println("");
		System.out.println(new Date());
		System.out.print("SIGMA2(" + N + ")=");

		System.out.println(P401BruteForce.SIGMA2(N));
		System.out.println(new Date());
		return;
	}

}