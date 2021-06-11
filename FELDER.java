public class FELDER
{
    WAND wand;
    WAND[][] arrwand = new WAND[22] [22];

    public SCHLUESSEL schluessel;
    public SCHLUESSEL[][] arrschluessel = new SCHLUESSEL[22][22];

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

    boolean hat_schluessel(int x, int y){
        if(arrschluessel ==null){
            return false;
        }
        else{
            return true;
        }
    }
}
