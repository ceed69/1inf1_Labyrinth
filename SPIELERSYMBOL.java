import java.awt.*;
import java. awt. geom. *;
import javax. swing. *;

public class SPIELERSYMBOL 
{ 
    /** Das Anzeigefenster. */
    private JFrame fenster;

    /** Anzeigegröße für das Rumpfelement */
    private static final int groesse = OBERFLAECHE. RasterGroesseGeben ();

    /** Interna */
    private static int radius = groesse / 4;
    private int x;
    private int y;
    public char ausrichtung;
    private JComponent anzeige;

    SPIELERSYMBOL()
    {
        fenster = OBERFLAECHE. FensterGeben ();
        anzeige = new JComponent () {
            // Stellt das Rumpfelement auf dem Fenster dar.
            public void paintComponent (Graphics g)
            {
                AffineTransform old;
                Graphics2D g2;
                g2 = (Graphics2D) g;
                old = g2. getTransform ();
                switch (ausrichtung)
                {
                    case 'N':
                    g2. transform (AffineTransform. getRotateInstance (Math. toRadians (270), groesse / 2, groesse / 2));
                    g2. transform (AffineTransform. getTranslateInstance(-groesse, 0));
                    break;
                    case 'S':
                    g2. transform (AffineTransform. getRotateInstance (Math. toRadians (90), groesse / 2, groesse / 2));
                    break;
                    case 'W':
                    g2. transform (AffineTransform. getRotateInstance (Math. toRadians (180), groesse / 2, groesse / 2));
                    g2. transform (AffineTransform. getTranslateInstance(-groesse, 0));
                    break;
                    default:
                    //nix
                }
                g. setColor (Color. yellow);
                g. fillRect (0, 0, groesse / 2, groesse - 1);
                g. fillArc (0, 0, groesse - 1, groesse - 1, -90, 180);
                g. setColor (Color. white);
                g. fillOval (groesse / 2 - 8, 4, 8, 8);
                g. fillOval (groesse / 2 - 8, groesse - 12, 8, 8);
                g. setColor (new Color (50, 200, 0));
                g. drawLine (0, 0, groesse / 2, 0);
                g. drawLine (1, 1, groesse / 2, 1);
                g. drawLine (0, 0, 0, groesse - 1);
                g. drawLine (1, 1, 1, groesse - 3);
                g. drawLine (0, groesse - 1, groesse / 2, groesse - 1);
                g. drawLine (1, groesse - 2, groesse / 2, groesse - 2);
                g. drawArc (0, 0, groesse - 1, groesse - 1, -90, 180);
                g. drawArc (1, 1, groesse - 3, groesse - 3, -90, 180);
                g. drawOval (groesse / 2 - 8, 4, 8, 8);
                g. drawOval (groesse / 2 - 8, groesse - 12, 8, 8);
                g. setColor (Color. black);
                g. fillOval (groesse / 2 - 6, 6, 4, 4);
                g. fillOval (groesse / 2 - 6, groesse - 10, 4, 4);
                g. setColor (new Color (200, 0, 0));
                g. drawLine (groesse, groesse / 2 - 1, groesse * 5 / 4, groesse / 2 - 1);
                g. drawLine (groesse, groesse / 2, groesse * 5 / 4, groesse / 2);
                g. drawLine (groesse, groesse / 2 + 1, groesse * 5 / 4, groesse / 2 + 1);
                g. drawLine (groesse * 5 / 4, groesse / 2, groesse * 6 / 4, groesse * 3 / 4);
                g. drawLine (groesse * 5 / 4, groesse / 2 + 1, groesse * 6 / 4, groesse * 3 / 4 + 1);
                g. drawLine (groesse * 5 / 4, groesse / 2, groesse * 6 / 4, groesse * 1 / 4);
                g. drawLine (groesse * 5 / 4, groesse / 2 - 1, groesse * 6 / 4, groesse * 1 / 4 - 1);
                g2. setTransform (old);
            }
        };
        anzeige. setVisible (true);
        ausrichtung = 'O';
        x = 0;
        y = 0;
        fenster. add (anzeige, 0);
        Anordnen ();
    }

    /**
     * Ordnet das Element gemäß Ausrichtung und Position so an, dass die Zunge "über das Kästchen raus hängt".
     */
    private void Anordnen ()
    {
        switch (ausrichtung)
        {
            case 'O':
            anzeige. setSize (groesse * 2, groesse);
            anzeige. setLocation (OBERFLAECHE. FensterBreiteGeben () / 2 + x * groesse, OBERFLAECHE. FensterHoeheGeben () / 2 + y * groesse);
            break;
            case 'W':
            anzeige. setSize (groesse * 2, groesse);
            anzeige. setLocation (OBERFLAECHE. FensterBreiteGeben () / 2 + (x - 1) * groesse, OBERFLAECHE. FensterHoeheGeben () / 2 + y * groesse);
            break;
            case 'S':
            anzeige. setSize (groesse, groesse * 2);
            anzeige. setLocation (OBERFLAECHE. FensterBreiteGeben () / 2 + x * groesse, OBERFLAECHE. FensterHoeheGeben () / 2 + y * groesse);
            break;
            case 'N':
            anzeige. setSize (groesse, groesse * 2);
            anzeige. setLocation (OBERFLAECHE. FensterBreiteGeben () / 2 + x * groesse, OBERFLAECHE. FensterHoeheGeben () / 2 + (y - 1) * groesse);
            break;
        }
    }

    /**
     * Setzt die Position des Kopfelements. Der Ursprung liegt in der Mitte des
     * Fensters, die y-Achse zeigt nach unten. (x /y) bedeutet das
     * Kästchen rechts unterhalb der Gitterlinien.
     * @param x x-Position
     * @param y y-Position
     */
    void PositionSetzen (int x, int y)
    {
        this. x = x;
        this. y = y;
        Anordnen ();
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
     * Setzt die Ausrichtung des Kopfelements.
     * @param ausrichtung Ausrichtung des Kopfelements.
     */
    void AusrichtungSetzen (char ausrichtung)
    {
        this. ausrichtung = ausrichtung;
        Anordnen ();
    }

    /**
     * Setzt die Ausrichtung des Kopfelements.
     * @eturn Ausrichtung des Kopfelements.
     */
    char AusrichtungGeben ()
    {
        return ausrichtung;
    }

    /**
     * Entfernt die Figur aus der Anzeige
     */
    void Entfernen ()
    {
        (OBERFLAECHE. FensterGeben ()). remove (anzeige);
        (OBERFLAECHE. FensterGeben ()). repaint();
    }
}
