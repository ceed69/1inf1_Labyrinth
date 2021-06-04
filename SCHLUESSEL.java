import java.awt.*;
import javax. swing. *;
public class SCHLUESSEL
{   
    private JFrame fenster;

    /** Anzeigegröße für das Rumpfelement */
    private static final int groesse = OBERFLAECHE. RasterGroesseGeben ();

    /** Interna */
    private int x;
    private int y;
    private JComponent anzeige;
    public SCHLUESSEL(){
        fenster = OBERFLAECHE. FensterGeben ();
        anzeige = new JComponent () {
            // Stellt das Rumpfelement auf dem Fenster dar.
            public void paintComponent (Graphics g)
            {
                g. clearRect (0, 0, groesse, groesse);
                g. setColor (Color. red);
                g. fillRect (0, 0, groesse - 1, groesse - 1);
                g. setColor (new Color (50, 200, 0));
            }

        };
        anzeige. setVisible (true);
        anzeige. setSize (groesse, groesse);
        fenster. add (anzeige, 0);
        PositionSetzen (0, 0);
    }

    public void PositionSetzen (int x, int y)
    {
        this. x = x;
        this. y = y;
        anzeige. setLocation (OBERFLAECHE. FensterBreiteGeben () / 2 + x * groesse, OBERFLAECHE. FensterHoeheGeben () / 2 + y * groesse);
    }

    /**
     * Gibt den X-Wert der Position des Kopfelements.
     * @return x-Position
     */
    int XPositionGeben ()
    {
        return x;
    }

    /**
     * Gibt den Y-Wert der Position des Kopfelements.
     * @return y-Position
     */
    int YPositionGeben ()
    {
        return y;
    }

    /**
     * Entfernt die Figur aus der Anzeige
     */
    public void Entfernen ()
    {
        (OBERFLAECHE. FensterGeben ()). remove (anzeige);
        (OBERFLAECHE. FensterGeben ()). repaint();
    }
}
