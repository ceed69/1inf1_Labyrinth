import java. awt. *;
import javax. swing. *;

/**
 * Verwaltet das Ausgabefenster.
 * 
 * @author Albert Wiedemann
 * @version 1.0
 */
class OBERFLAECHE
{
    /** Diese Werte kann man bearbeiten um das Fenster zu verändern bitte andere Variablen nicht ändern */
    
    /** Anzeigegröße für eine Rasterkachel */
    private static final int rasterGroesse = 40;
    /** Höhe des Anzeigefensters */
    private static final int hoeheFenster = 600;
    /** Breite des Anzeigefensters */
    private static final int breiteFenster = 600;
    /** Name des Anzeigefensters */
    private static final String titelFenster = "Labyrinth";
    
    /** --------------------------------------------------------------------------------------------- */
    
    private static OBERFLAECHE o = null;
    private JFrame fenster = null;

    /**
     * Baut die Bedienoberfläche auf
     */
    public OBERFLAECHE ()
    {
        fenster = new JFrame (titelFenster);
        fenster. setResizable (false);
        fenster. setVisible (true);
        fenster. setLayout (null);
        fenster. getContentPane (). setBackground (new Color (240, 240, 240));
        Insets i = fenster.getInsets();
        fenster. setSize (breiteFenster, hoeheFenster + i.top);         // Ausgleich für Fenstertitel
        JComponent hintergrund = new JComponent ()
        {
             /**
             * Zeichnet das Hintergrundmuster.
             */
            public void paintComponent (Graphics g)
            {
                g. setColor (Color. black);
                for (int i = 1; i <= hoeheFenster / (rasterGroesse * 2); i++)
                {
                    g. drawLine (0, hoeheFenster / 2 + i * rasterGroesse, breiteFenster - 1, hoeheFenster / 2 + i * rasterGroesse);
                    g. drawLine (0, hoeheFenster / 2 - i * rasterGroesse, breiteFenster - 1, hoeheFenster / 2 - i * rasterGroesse);
                }
                for (int i = 1; i <= breiteFenster / (rasterGroesse * 2); i++)
                {
                    g. drawLine (breiteFenster / 2 + i * rasterGroesse, 0, breiteFenster / 2 + i * rasterGroesse, hoeheFenster - 1);
                    g. drawLine (breiteFenster / 2 - i * rasterGroesse, 0, breiteFenster / 2 - i * rasterGroesse, hoeheFenster - 1);
                }
                g. setColor (Color. black);
                g. drawLine (0, hoeheFenster / 2, breiteFenster - 1, hoeheFenster / 2);
                g. drawLine (breiteFenster / 2, 0, breiteFenster / 2, hoeheFenster - 1);
            }
        };
        hintergrund. setVisible (true);
        hintergrund. setSize (breiteFenster, hoeheFenster);
        hintergrund. setLocation (0, 0);
        fenster. add (hintergrund);
    }

    /**
     * Gibt das Ausgabefenster zurück und erzeugt es gegebenenfalls.
     * @return Ausgabefenster
     */
    static JFrame FensterGeben ()
    {
        if (o == null)
        {
            o = new OBERFLAECHE ();
        }
        return o. fenster;
    }

    /**
     * Gibt die Rastergröße zurück.
     * @return Ausgabefenster
     */
    static int RasterGroesseGeben ()
    {
        return rasterGroesse;
    }

    /**
     * Gibt die Breite des Fensters zurück.
     * @return Fensterbreite
     */
    static int FensterBreiteGeben ()
    {
        return breiteFenster;
    }

    /**
     * Gibt die Höhe des Fensters zurück.
     * @return Fensterhöhe
     */
    static int FensterHoeheGeben ()
    {
        return hoeheFenster;
    }
}

