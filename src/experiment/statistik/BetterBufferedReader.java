package experiment.statistik;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;

/**
 * eine Erweiterung des <code>BufferedReader</code> um eine bequeme
 * {@link skipLines} Methode.
 * 
 * @author isenbuegel
 *
 */

public class BetterBufferedReader extends BufferedReader {
	private BetterBufferedReader() {
		super(null);
	}

	/**
	 * erzeugt eine Instanz der Klasse.
	 * 
	 * @param in 
	 * 	ein ...
	 */
	public BetterBufferedReader(Reader in) {
		super(in);
	}

	/**
	 * liest eine gegebene Anzahl von Zeilen aus dem Inputstrom und ignoriert diese.
	 * 
	 * @param count
	 * 		Anzahl von zu lesenden Zeilen.
	 * 
	 * @throws IOException
	 * 		wenn Lesefehler.
	 */
	public void skipLines(int count) throws IOException {
		for (int i = 0; i < count; i++) {
			readLine();
		}
	}
}
