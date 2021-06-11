import java. awt. *;
import javax. swing. *;  

public class OBERFLAECHE
{
    /** Diese Werte kann man bearbeiten um das Fenster zu verändern bitte andere Variablen nicht ändern */

    /** Anzeigegröße für eine Rasterkachel */
    private static final int rasterGroesse = 40;
    /** Höhe des Anzeigefensters */
    private static final int hoeheFenster = rasterGroesse*24;
    /** Breite des Anzeigefensters */
    private static final int breiteFenster = rasterGroesse*24;
    /** Name des Anzeigefensters */
    private static final String titelFenster = "Labyrinth";
    /** Farbe des Hintegrundes */
    private static final Color farbeHintergrund = new Color (145,100,100);
    /** Farbe der Streifen und des Randes */
    private static final Color farbeStreifen = new Color (0, 0, 0); 

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
        fenster. getContentPane (). setBackground (farbeHintergrund);
        Insets i = fenster.getInsets();
        fenster. setSize (breiteFenster, hoeheFenster + i.top);         // Ausgleich für Fenstertitel
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

    static Color SteifenFarbeGeben(){
        return farbeStreifen;
    }
}
