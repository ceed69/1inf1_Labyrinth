public class SPIELER
{
    SPIELERSYMBOL spieler;
    boolean hatSchluessel = false;
    SPIELER (int x, int y, char richtung)
    {
        spieler = new SPIELERSYMBOL (); 
        spieler. AusrichtungSetzen (richtung);
        spieler. PositionSetzen(x, y);        
    }

    /**
     * Bewegt die Schlange ein Feld in der eingestellten Richtung.
     */
    void Bewegen ()
    {
        int x, xalt;
        int y, yalt;
        x = spieler. XPositionGeben ();
        y = spieler. YPositionGeben ();
        xalt = x;
        yalt = y;
        switch (spieler. AusrichtungGeben())
        {
            case 'O':
            x += 1;
            break;
            case 'N':
            y -= 1;
            break;
            case 'W':
            x -= 1;
            break;
            case 'S':
            y += 1;
            break;
        }
        spieler. PositionSetzen (x, y);
    }

    /**
     * Setzt die Bewegunsrichtung der Schlange.
     * @param richtungNeu (neue) Bewegungsrichtung
     */
    void RichtungSetzen (char richtungNeu)
    {
        spieler. AusrichtungSetzen (richtungNeu);
    }

    void Collision(char richtung){
        switch (richtung)
        {
            case 'O':

            break;
            case 'N':

            break;
            case 'W':

            break;
            case 'S':

            break;
        }

    }
    
    void schluesselAufheben(){
        boolean hatSchluessel = true;
    }
    
    boolean returnHatSchluessel(){
        return hatSchluessel;
    }
    
}
