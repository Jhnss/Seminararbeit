// Hauptklasse für Benutzeroberfläche:

/*
 Johannes Schuster
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GUI extends JFrame implements ActionListener
{

	public JTextField jTextField;
    public JButton jButton;
    public JMenuItem jMenuItem1;
    public JMenuItem jMenuItem2;
    public JMenuItem jMenuItem3;
    public JLabel ueberschrift1;
    public JLabel ueberschrift2;
    public JLabel genauesPi;
    public JLabel genaehertesPi;
    public JLabel info3;
    public JLabel info2;
    public JLabel info1;
    public JLabel bild;
    public JMenuBar jMenuBar;
    public JMenu jMenu;
    public JComboBox jComboBox;
    public ENGINE engine;
    
    public static void main(String[] args){
		new GUI();
	}
    
   public GUI()
    {
	   setBackground(Color.WHITE);
       initGUI();
       engine = new Montecarlo();
    }

    public void initGUI(){
    	//erstellen der graphischen Elemente:
    	
    	//Fenster 
    	setTitle("Arten der Berechnung von Pi");
        setSize(750,600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLayout(null);
        setIconImage(Toolkit.getDefaultToolkit().getImage("ark.png"));
        
        
        //Überschrift
        ueberschrift2 = new JLabel("Monte-Carlo Verfahren");
        ueberschrift2.setLocation(295,30);
        ueberschrift2.setSize(400,40);
        ueberschrift2.setFont(new Font("Arial",Font.ITALIC, 15));
        
        ueberschrift1 = new JLabel("Arten der Berechnung von PI");
        ueberschrift1.setLocation(235,0);
        ueberschrift1.setSize(400,40);
        ueberschrift1.setFont(new Font("Arial",Font.BOLD, 20));
        
        //Pi Werte
        genaehertesPi = new JLabel("Ihr Wert für Pi ist:");
        genaehertesPi.setLocation(130,470);
        genaehertesPi.setSize(550,40);
        genaehertesPi.setFont(new Font("Arial",Font.BOLD, 13));
        genauesPi = new JLabel("Genauer Wert für Pi:  3.1415926535897932384626433832795028841971");
        genauesPi.setLocation(130,500);
        genauesPi.setSize(450,20);
        
        //Info
        info3 = new JLabel("Benötigte Zeit: ");
        info3.setLocation(10,280);
        info3.setSize(450,20);
        
        info2 = new JLabel("Verhältnis von Treffern zu Punkte: ");
        info2.setLocation(10,240);
        info2.setSize(450,20);
        
        info1 = new JLabel("Anzahl generierter Punkte: ");
        info1.setLocation(10,200);
        info1.setSize(200,20);
 
        //Menüleiste
        jMenuBar = new JMenuBar();
        setJMenuBar(jMenuBar); 
        JMenu auswahlMenue = new JMenu("Auswahl");
        jMenuBar.add(auswahlMenue); 
        jMenuItem1 = new JMenuItem("Archimedes");
        jMenuItem1.addActionListener(this);
        auswahlMenue.add(jMenuItem1);
        jMenuItem2 = new JMenuItem("Monte-Carlo");
        jMenuItem2.addActionListener(this);
        auswahlMenue.add(jMenuItem2);  
        jMenuItem3 = new JMenuItem("Arkustangens");
        jMenuItem3.addActionListener(this);
        auswahlMenue.add(jMenuItem3); 
        
        //"Losbutton"
        jButton = new JButton("Los");
        jButton.setBackground(new Color(255, 0, 0));
        jButton.setForeground(new Color(255,250,244));
        jButton.setFont(new Font("Arial",Font.BOLD, 30));
        jButton.setSize(150,40);
        jButton.addActionListener(this);
        jButton.setLocation(75,400);
        
        //Eingabefeld
        jTextField = new JTextField();
        jTextField.setSize(100,20);
        jTextField.setLocation(200,200);
        
        //Auswahlbox
		jComboBox = new JComboBox (new String[] {"arctan(1)", "4 x arctan(1/5)-arctan(1/239)"});
		jComboBox.setSize(200,20);
		jComboBox.setLocation(40,240);
		jComboBox.addActionListener(this);
        
        
        //Bild
        bild = new JLabel(new ImageIcon("mone.png"));
        bild.setLocation(300,100);
        bild.setSize(450,368);

  
        add(ueberschrift1);
        add(ueberschrift2);
        add(genauesPi);
        add(genaehertesPi);
        add(info3);
        add(info2);
        add(info1);
        add(jButton);
        add(jTextField);
        add(bild);
        
        setVisible(true);
    	
    }
 
    // Festlegung, was bei Benutzereingaben getan wird
    public void actionPerformed(ActionEvent e) 
    { 
    	if(e.getSource() == jButton){
    		System.gc();
    		if(jTextField.getText().isEmpty()) genaehertesPi.setText("Bitte etwas eingeben!");
    		else{ 
    			
    			
    			try{
    				if(Double.parseDouble(jTextField.getText()) <= 0) genaehertesPi.setText("Bitte positive Zahl eingeben!");
    				else{
    			genaehertesPi.setText("Ihr Wert für Pi ist:  " + engine.rechnen(Double.parseDouble(jTextField.getText())));
    			info2.setText(engine.getInfo());
    			info3.setText("Benötigte Zeit: " + String.valueOf(engine.getTime(Double.parseDouble(jTextField.getText()))) + " ns");
    			}
    			}
    			catch(NumberFormatException u){
    				genaehertesPi.setText("Bitte positive Zahl eingeben!");
    			}
    			
    		}
    			
    	}
    	if(e.getSource() == jMenuItem1){
    		engine = new Archimedes();
    		ueberschrift2.setText("Methode von Archimedes");
    		info1.setText("Iterationen:");
    		info2.setText("Anzahl der Ecken des Polygons:");
    		info3.setText("Benötigte Zeit:");
    		remove(bild);
    		bild = new JLabel(new ImageIcon("arch.png"));
    		bild.setLocation(300,100);
            bild.setSize(450,368);
            add(bild);
            remove(jComboBox);
            repaint();
    		
    	}
    	if(e.getSource() == jMenuItem2){
    		engine = new Montecarlo();
    		ueberschrift2.setText("Monte-Carlo Verfahren");
    		info1.setText("Anzahl generierter Punkte: ");
    		info2.setText("Verhältnis von Treffern zu Punkte: ");
    		info3.setText("Benötigte Zeit:");
    		remove(bild);
    		bild = new JLabel(new ImageIcon("mone.png"));
    		bild.setLocation(300,100);
            bild.setSize(450,368);
            add(bild);
            remove(jComboBox);
            repaint();
    			
    	}
    	if(e.getSource() == jMenuItem3){
    		engine = new Arkustangens(this);
    		ueberschrift2.setText("Arkustangensmethode");
    		info1.setText("Wahl von n:");
    		info2.setText("");
    		info3.setText("Benötigte Zeit:");
    		add(jComboBox);
    		remove(bild);
    		bild = new JLabel(new ImageIcon("ark.png"));
    		bild.setLocation(300,100);
            bild.setSize(450,368);
            add(bild);
            repaint();
    		
    			
    	}
    	
    }
    
}
