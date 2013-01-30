package experiment.hostStatistik;


public class ReportRecord {

	public String d;
	public String menu;
	public String menuTyp;
	public String menuText;
	public String stunde;
	public int anzStunde;

	public String toString(){
		
		return d + "; " + menu +"; " +menuTyp +"; " + menuText +"; " + stunde +"; " + anzStunde;
	}
}
