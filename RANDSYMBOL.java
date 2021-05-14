import java.awt.*;
import javax. swing. *;

/**
 * Der Rand um das Spielfeld.
 * Das Fenster wird bei Bedarf generiert.
 *
 * @author Albert Wiedemann
 * @version 1.0
 */
class RANDSYMBOL
{
    /** Das Anzeigefenster. */
    private JFrame fenster;

    /** Anzeigegröße für das Rumpfelement */
    private static final int groesse = OBERFLAECHE. RasterGroesseGeben ();

    /** Interna */
    private JComponent anzeige;
    private int xMin, xMax, yMin, yMax;
    /**
     * Standardkonstruktor für Objekte der Klasse RANDSYMBOL.
     * Er erzeugt einen grauen Rand um das Spielfeld.
     * Es wird die maximale Spielfeldgröße ermittelt
     * Das Fenster wird bei Bedarf angelegt.
     */
    RANDSYMBOL()
    {
        this (OBERFLAECHE. FensterBreiteGeben () / groesse - 2, OBERFLAECHE. FensterHoeheGeben () / groesse - 2);
    }

    /**
     * Standardkonstruktor für Objekte der Klasse RANDSYMBOL.
     * Er erzeugt einen grauen Rand um das Spielfeld.
     * Das Fenster wird bei Bedarf angelegt.
     * @param breite gewünschte Breite des Spielfelds
     * @param hoehe gewünschte Höhe des Spielfelds
     */
    RANDSYMBOL(int breite, int hoehe)
    {
        fenster = OBERFLAECHE. FensterGeben ();
        anzeige = new JComponent () {
            // Stellt das Rumpfelement auf dem Fenster dar.
            public void paintComponent (Graphics g)
            {
                g. setColor (OBERFLAECHE.SteifenFarbeGeben());
                int [] xKoord = {0, getWidth (), getWidth (), 0, 0, groesse, groesse, getWidth () - groesse, getWidth () - groesse, groesse, 0};
                int [] yKoord = {0, 0, getHeight (), getHeight (), 0, groesse, getHeight () - groesse, getHeight () - groesse, groesse, groesse, 0};
                g. fillPolygon(xKoord, yKoord, xKoord.length);
            }
        };
        anzeige. setVisible (true);
        fenster. add (anzeige, 0);
        GroesseSetzen (breite, hoehe);
    }

    /**
     * Setzt die Breite und Hoehe des Randelements.
     * Die Maximalkoordinaten des Spielfelds werden ermittelt.
     * @param breite Spielfeldbreite in Kästchen
     * @param hoehe Spielfeldhöhe in Kästchen
     */
    void GroesseSetzen (int breite, int hoehe)
    {
        xMax = breite / 2 - 1;
        yMax = hoehe / 2 - 1;
        if (breite % 2 == 0)
        {
            xMin = - xMax - 1;
        }
        else
        {
            xMin = -xMax - 2;
        }
        if (hoehe % 2 == 0)
        {
            yMin = - yMax - 1;
        }
        else
        {
            yMin = -yMax - 2;
        }
        anzeige. setSize ((breite+2)*groesse, (hoehe+2)*groesse);
        anzeige. setLocation (OBERFLAECHE. FensterBreiteGeben () / 2 - (breite / 2 + 1 + breite % 2) * groesse, OBERFLAECHE. FensterHoeheGeben () / 2 - (hoehe / 2 + 1 + hoehe % 2) * groesse);
    }

    /**
     * Entfernt die Figur aus der Anzeige
     */
    void Entfernen ()
    {
        (OBERFLAECHE. FensterGeben ()). remove (anzeige);
        (OBERFLAECHE. FensterGeben ()). repaint();
    }

    /**
     * Meldet die maximale x-Koordinate des Spielfelds.
     * @return maximale x-Koordinate
     */
    int XMaxGeben ()
    {
        return xMax;
    }

    /**
     * Meldet die minimale x-Koordinate des Spielfelds.
     * @return minimale x-Koordinate
     */
    int XMinGeben ()
    {
        return xMin;
    }

    /**
     * Meldet die maximale y-Koordinate des Spielfelds.
     * @return maximale y-Koordinate
     */
    int YMaxGeben ()
    {
        return yMax;
    }

    /**
     * Meldet die minimale y-Koordinate des Spielfelds.
     * @return minimale y-Koordinate
     */
    int YMinGeben ()
    {
        return yMin;
    }
}

