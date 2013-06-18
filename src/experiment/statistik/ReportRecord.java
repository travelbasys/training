package experiment.statistik;

/**
 * Repr�sentiert eine Zeile (Record) eines Statistikreports.
 * 
 * 
 * @author isenbuegel
 * 
 */
public class ReportRecord {

	/**
	 * Das Datum ...
	 */
	public String datum;

	/**
	 * Das gew�hlte Men�. Beispiel: 4001, 3185, ...
	 */
	public String menu;

	/**
	 * Der Men�typ: RBSweb oder webService.
	 */
	public String menuTyp;

	/**
	 * Die Textbezeichnung des gew�hlten Men�s, z.B. "Auftragsstatistik" f�r
	 * 8006.
	 */
	public String menuText;

	/**
	 * Die Stunde, in der die Abrufe erfolgten. "10" bedeutet Abrufe von 10:00
	 * bis 10:59 Uhr.
	 */
	public String stunde;

	/**
	 * Die Anzahl der Abrufe an dem gegebenen Tag in der gegebenen Stunde.
	 */
	public int anzStunde;

	/**
	 * stellt das aktuelle Objekt in der Form "Datum; Men�; ..." dar.
	 * 
	 * <p>
	 * Beispiel: <code>01.01.2012;3101;RBSweb;Anzeigen Ran/RBE;8;4</code>
	 * </p>
	 */
	public String toString() {

		return datum + "; " + menu + "; " + menuTyp + "; " + menuText + "; "
				+ stunde + "; " + anzStunde;
	}
}
