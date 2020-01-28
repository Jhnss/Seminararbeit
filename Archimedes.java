// Klasse zu Berechnung nach Archimedes:

public class Archimedes implements ENGINE {
	int eckenzahl;
	public String rechnen(double schritte){
		int n = 6;
		double untereSchranke = 1;
		
		for(int i=1;i<schritte;i++){
			n = n*2;
			untereSchranke = Math.sqrt(2 - Math.sqrt(4 - Math.pow(untereSchranke,2)));
		}
		double obereSchranke = untereSchranke/(Math.sqrt(1 - Math.pow((untereSchranke/2),2)));
		eckenzahl = n;
		return String.valueOf((n*untereSchranke)/2) + "< \u03C0 <" + String.valueOf((n*obereSchranke)/2);
	
	}
	
	public String getInfo(){ return "Anzahl der Ecken des Polygons:   " + String.valueOf(eckenzahl);}
	public long getTime(double schritte) {
		long zeit = 0;
		for(int i=0;i<10;i++){
			long anfang = System.nanoTime();
			rechnen(schritte);
			long ende = System.nanoTime();
			zeit = zeit + ende-anfang;
			}
		return zeit/10;
	}
}
