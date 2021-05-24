import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax. swing. *;

/**
 * Beschreiben Sie hier die Klasse SPIEL.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */
public class SPIEL
{
    // Instanzvariablen - ersetzen Sie das folgende Beispiel mit Ihren Variablen
    SPIELER spieler;
    RANDSYMBOL randsymbol;
    FELDER felder;
    LESEN lesen;
    /**
     * Konstruktor für Objekte der Klasse SPIEL
     */
    public SPIEL()
    {
        randsymbol = new RANDSYMBOL();
        spieler = new SPIELER (0, 0, 'O');
        //felder = new FELDER();
        lesen = new LESEN();
        
        OBERFLAECHE. FensterGeben (). addKeyListener (new KeyAdapter() {
            /**
             * Gibt die Taste an die eigentliche Aktionsmethode weiter.
             * @param e das zugrestellte Ereignis
             */
            public void keyPressed(KeyEvent e)
            {
                TasteGedrueckt ((char) e. getKeyCode ());
            }
        });
    }
    
    void TasteGedrueckt (char welche)
    {
        switch (welche)
        {
          case KeyEvent. VK_DOWN:
            spieler. RichtungSetzen ('S');
            if(spieler.spieler.YPositionGeben() != randsymbol.YMaxGeben() && 
            lesen.felder.kannBewegen(spieler.spieler.XPositionGeben(),spieler.spieler.YPositionGeben(),spieler.spieler.AusrichtungGeben())){
            spieler.Bewegen();}
            break;
          case KeyEvent. VK_LEFT:
            spieler. RichtungSetzen ('W');
            if(spieler.spieler.XPositionGeben() != randsymbol.XMinGeben() && 
            lesen.felder.kannBewegen(spieler.spieler.XPositionGeben(),spieler.spieler.YPositionGeben(),spieler.spieler.AusrichtungGeben())){
            spieler.Bewegen();}
            break;
          case KeyEvent. VK_RIGHT:
            spieler. RichtungSetzen ('O');
            if(spieler.spieler.XPositionGeben() != randsymbol.XMaxGeben()&& 
            lesen.felder.kannBewegen(spieler.spieler.XPositionGeben(),spieler.spieler.YPositionGeben(),spieler.spieler.AusrichtungGeben())){
            spieler.Bewegen();}
            break;
          case KeyEvent. VK_UP:
            spieler. RichtungSetzen ('N');
            if(spieler.spieler.YPositionGeben() != randsymbol.YMinGeben() && 
            lesen.felder.kannBewegen(spieler.spieler.XPositionGeben(),spieler.spieler.YPositionGeben(),spieler.spieler.AusrichtungGeben())){
            spieler.Bewegen();}
            break;
          default:
            //System. out. println ("Taste: " + (0 + (int) welche));
        }
    }
}
