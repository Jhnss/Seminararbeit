// Klasse zu Berechnung mithilfe der Monte-Carlo-Methode:

public class Montecarlo implements ENGINE {
	private double z�hlervariableFuerInnenliegendePunkte;
	private double punkte;
	public String rechnen(double punkte){
		
		z�hlervariableFuerInnenliegendePunkte = 0;
		this.punkte = punkte;
		
		for(int i=0;i<punkte;i++){	
			if((Math.pow(Math.random(),2)) + (Math.pow(Math.random(),2)) <= 1){
			z�hlervariableFuerInnenliegendePunkte++;
			}
		}
		double ergebnis = 4* z�hlervariableFuerInnenliegendePunkte / punkte;
		return String.valueOf(ergebnis);
	
	}
	
	public String getInfo(){
		if(punkte <= 0) return "Verh�ltnis von Treffern zu Punkte:";
		return "Verh�ltnis von Treffern zu Punkte: " + String.valueOf((int) z�hlervariableFuerInnenliegendePunkte) +"/"+ String.valueOf((int) punkte);
	
	}
	
	public long getTime(double punkte){
		long zeit = 0;
		for(int i=0;i<10;i++){
			long anfang = System.nanoTime();
			rechnen(punkte);
			long ende = System.nanoTime();
			zeit = zeit + ende-anfang;
			}
		return zeit/10;
	}
}
