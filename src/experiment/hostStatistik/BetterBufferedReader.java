package experiment.hostStatistik;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;

public class BetterBufferedReader extends BufferedReader {
	private BetterBufferedReader() {
		super(null);
	}

	public BetterBufferedReader(Reader in) {
		super(in);
	}

	public void skipLines(int count) throws IOException {
		for (int i = 0; i < count; i++) {
			readLine();
		}
	}
}
