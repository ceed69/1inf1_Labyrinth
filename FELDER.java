public class FELDER
{
    WAND wand;
    WAND[][] arrwand = new WAND[22] [22];

    public SCHLUESSEL schluessel;
    public SCHLUESSEL[][] arrschluessel = new SCHLUESSEL[22][22];

    
    public TUER tuer;
    public TUER [][] arrtuer = new TUER[22][22];
    

    LICHT licht;
    LICHT[][] arrlicht = new LICHT[22][22];

    public FELDER()
    {
        paint();
    }

    public void neue_Wand(int x, int y){
        arrwand[x][y] = new WAND();
    }

    public void neuer_Schluessel(int x, int y){
        arrschluessel[x][y] = new SCHLUESSEL();
    }

    
    public void neue_Tuer(int x, int y){
        arrtuer[x][y] = new TUER();
    }
    

    public void neues_Licht(int x, int y){
        arrlicht[x][y] = new LICHT();
    }

    void paint(){
        for (int x1 = 0; x1 < arrwand. length; x1++){
            for (int y1 = 0; y1 < arrwand. length; y1++)
            {if(arrwand[x1][y1] != null){
                    arrwand[x1][y1].PositionSetzen(x1 -11,y1-11);
                }
                else{}
            }
        }

        for (int x2 = 0; x2 < arrschluessel. length; x2++){
            for (int y2 = 0; y2 < arrschluessel. length; y2++)
            {if(arrschluessel[x2][y2] != null){
                    arrschluessel[x2][y2].PositionSetzen(x2 -11,y2-11);
                }
                else{}
            }
        }
        for (int x2 = 0; x2 < arrtuer. length; x2++){
            for (int y2 = 0; y2 < arrtuer. length; y2++)
            {if(arrtuer[x2][y2] != null){
                    arrtuer[x2][y2].PositionSetzen(x2 -11,y2-11);
                }
                else{}
            }
        }

    }

    public void lichtup(){
        for (int x2 = 0; x2 < arrlicht.length; x2++){
            for (int y2 = 0; y2 < arrlicht.length; y2++)
            {if(arrlicht[x2][y2] != null){
                    //arrlicht[x2][y2].Entfernen();
                    //neues_Licht(x2,y2);
                    //arrlicht[x2][y2].PositionSetzen(x2 -11,y2-11);
                }
                else{
                    neues_Licht(x2,y2);
                    arrlicht[x2][y2].PositionSetzen(x2 -11,y2-11);
                }
                //arrlicht[x2][y2].PositionSetzen(x2 -11,y2-11);

            }
        }
        
    }

    boolean kannBewegen(int x, int y, char richtung){
        x = x+11;
        y = y+11;
        switch (richtung)
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
        if(arrwand[x][y] != null){
            return false;
        }
        else{
            return true;
        }
    }

    boolean hat_schluessel(){
        if(arrschluessel.length == 0){
            return true;
        }
        else{
            return false;
        }
    }
    public void purge(){
    for (int x1 = 0; x1 < arrwand. length; x1++){
            for (int y1 = 0; y1 < arrwand. length; y1++)
            {
            if(arrwand[x1][y1] != null){
                    arrwand[x1][y1].Entfernen();
                    arrwand[x1][y1] = null;
                }
            
            
            else if(arrschluessel[x1][y1] != null){
                    arrschluessel[x1][y1].Entfernen();
                    arrschluessel[x1][y1] = null;
                }
            else if(arrtuer[x1][y1] != null){
                    arrtuer[x1][y1].Entfernen();
                    arrtuer[x1][y1] = null;
                }
            else if(arrlicht[x1][y1] != null){
                    arrlicht[x1][y1].Entfernen();
                    arrlicht[x1][y1] = null;
                }
                else{}
            }
        }
    }
}
