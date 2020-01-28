// Klasse zu Berechnung mithilfe des Arkustangens:

public class Arkustangens implements ENGINE {
	public GUI gui;
	public Arkustangens(GUI g){
		gui = g;
	}
	public String rechnen(double n){
		
		double ergebnis1 = 0;
		double ergebnis2 = 0;
		double f = 2*n;
		String box = (String) gui.jComboBox.getSelectedItem();
		if(box.equals("4 x arctan(1/5)-arctan(1/239)")){
		for(int i=1;i<f+1;i=i+2){
			if(i % 4 == 1) ergebnis1 += 4/(i*Math.pow(5,i));
			if(i % 4 == 3) ergebnis1 -= 4/(i*Math.pow(5,i));
			if(i % 4 == 1) ergebnis2 += 1/(i*Math.pow(239,i));
			if(i % 4 == 3) ergebnis2 -= 1/(i*Math.pow(239,i));
			}
		return String.valueOf(4*(ergebnis1 - ergebnis2));
		}
		
		else{
			for(int i=1;i<f+1;i=i+2){

				if(i%4 == 1) ergebnis1 += (double) 1/i;
				
				if(i%4 == 3) ergebnis1 -= (double) 1/i;
				}
			return String.valueOf(4*ergebnis1);
		}
	
	
}

public String getInfo(){ return "";}
public long getTime(double n) {
	long zeit = 0;
	for(int i=0;i<10;i++){
		long anfang = System.nanoTime();
		rechnen(n);
		long ende = System.nanoTime();
		zeit = zeit + ende-anfang;
		}
	return zeit/10;
}
}

