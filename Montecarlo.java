// Klasse zu Berechnung mithilfe der Monte-Carlo-Methode:

public class Montecarlo implements ENGINE {
	private double zählervariableFuerInnenliegendePunkte;
	private double punkte;
	public String rechnen(double punkte){
		
		zählervariableFuerInnenliegendePunkte = 0;
		this.punkte = punkte;
		
		for(int i=0;i<punkte;i++){	
			if((Math.pow(Math.random(),2)) + (Math.pow(Math.random(),2)) <= 1){
			zählervariableFuerInnenliegendePunkte++;
			}
		}
		double ergebnis = 4* zählervariableFuerInnenliegendePunkte / punkte;
		return String.valueOf(ergebnis);
	
	}
	
	public String getInfo(){
		if(punkte <= 0) return "Verhältnis von Treffern zu Punkte:";
		return "Verhältnis von Treffern zu Punkte: " + String.valueOf((int) zählervariableFuerInnenliegendePunkte) +"/"+ String.valueOf((int) punkte);
	
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
