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

    /**
     * Konstruktor für Objekte der Klasse SPIEL
     */
    public SPIEL()
    {
        spieler = new SPIELER (0, 0, 'O');
        
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
            spieler.Bewegen();
            break;
          case KeyEvent. VK_LEFT:
            spieler. RichtungSetzen ('W');
            spieler.Bewegen();
            break;
          case KeyEvent. VK_RIGHT:
            spieler. RichtungSetzen ('O');
            spieler.Bewegen();
            break;
          case KeyEvent. VK_UP:
            spieler. RichtungSetzen ('N');
            spieler.Bewegen();
            break;
          default:
            //System. out. println ("Taste: " + (0 + (int) welche));
        }
    }
}
