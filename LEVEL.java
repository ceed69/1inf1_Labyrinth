import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files

public class LEVEL  
{
    SPIELER spieler;  
    RANDSYMBOL randsymbol;
    FELDER felder;
    int x = 0;
    int y = 0;
    int Schlüsselx;
    int Schlüssely;

    int Tuerx;
    int Tuery;
    public LEVEL(int levelNummer){
        //Neue Oberfläche machen
        randsymbol = new RANDSYMBOL();
        //LEVEL Einlesen
        Level_lesen();
        //Spieler und Felder einfügen
        felder.paint();
        //Key Listener hinzufügen
        OBERFLAECHE. FensterGeben (). addKeyListener (new KeyAdapter() {
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
                felder.kannBewegen(spieler.spieler.XPositionGeben(),spieler.spieler.YPositionGeben(),spieler.spieler.AusrichtungGeben())){
                    spieler.Bewegen();}
                break;
            case KeyEvent. VK_LEFT:
                spieler. RichtungSetzen ('W');
                if(spieler.spieler.XPositionGeben() != randsymbol.XMinGeben() && 
                felder.kannBewegen(spieler.spieler.XPositionGeben(),spieler.spieler.YPositionGeben(),spieler.spieler.AusrichtungGeben())){
                    spieler.Bewegen();}
                break;
            case KeyEvent. VK_RIGHT:
                spieler. RichtungSetzen ('O');
                if(spieler.spieler.XPositionGeben() != randsymbol.XMaxGeben()&& 
                felder.kannBewegen(spieler.spieler.XPositionGeben(),spieler.spieler.YPositionGeben(),spieler.spieler.AusrichtungGeben())){
                    spieler.Bewegen();}
                break;
            case KeyEvent. VK_UP:
                spieler. RichtungSetzen ('N');
                if(spieler.spieler.YPositionGeben() != randsymbol.YMinGeben() && 
                felder.kannBewegen(spieler.spieler.XPositionGeben(),spieler.spieler.YPositionGeben(),spieler.spieler.AusrichtungGeben())){
                    spieler.Bewegen();}
                break;
            default:
                //System. out. println ("Taste: " + (0 + (int) welche));
        }
        if(spieler.spieler.YPositionGeben() + 11 == Schlüssely){
            if(spieler.spieler.XPositionGeben() + 11 == Schlüsselx){
                Schlüssel_entfernen(Schlüsselx, Schlüssely);
            }
        }

        if(spieler.spieler.YPositionGeben() + 11 == Tuery){
            if(spieler.spieler.XPositionGeben() + 11 == Tuerx){
                //System. out. println ("1");
                Tuer_oeffnen(Tuerx, Tuery);
            }
        }
        //felder.lichtup();
        //felder.lichtup();
        light(spieler.spieler.XPositionGeben() + 11, spieler.spieler.YPositionGeben() + 11);
        //lichter adden ^^

    }

    void Level_lesen(){ 
        felder = new FELDER();
        try {
            File myObj = new File("LVL/Level_1.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();

                for(int i = 0; i < data.length(); i++){  
                    x = i;

                    switch(data.charAt(i)){
                        case '#':
                            felder.neue_Wand(x,y);
                            break;
                        case ' ':
                            //felder.neues_Licht(x, y);
                            break;
                        case 'S':
                            spieler = new SPIELER (x - 11, y -11, 'O');

                            break;
                        case 'K':
                            felder.neuer_Schluessel(x, y);
                            Schlüsselx = x;
                            Schlüssely = y;
                            //felder.neues_Licht(x, y);
                            break;
                            case'T':
                            felder.neue_Tuer(x,y);
                            Tuerx = x;
                            Tuery = y;
                    }
                }  
                y = y +1;
                //System.out.println(" ");
            }
            myReader.close();
            //felder.lichtup();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    void Spieler_machen(int x, int y){
        System.out.println(" "+ x +" "+ y);
        spieler = new SPIELER (x, y, 'O');
    }

    void Schlüssel_entfernen(int x, int y){
        felder.arrschluessel[x][y].Entfernen ();
        felder.arrschluessel[x][y] = null;
    }

    void Tuer_oeffnen(int x, int y){
            if(felder.hat_schluessel() == true){
            //System. out. println ("2");
            felder.arrtuer[x][y].oeffnen();
            //felder.arrtuer[x][y] = null;
        }
        
    
    }

    void light(int x,int y){
        int radius = 2;
        for(int xrad = 0-radius; xrad < radius + 1; xrad++){
            for(int yrad = 0-radius; yrad < radius + 1; yrad++){
                if (x + xrad >= 0 && y + yrad >= 0){
                    if(x + xrad <= 21 && y + yrad <= 21){
                        if(felder.arrlicht[x + xrad][y + yrad] == null){

                        }
                        else{felder.arrlicht[x + xrad][y + yrad].Entfernen();
                            felder.arrlicht[x + xrad][y + yrad] = null;
                        }
                    }}
            }
        }
    }
}
