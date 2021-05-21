public class FELDER
{
    WAND wand;
    WAND[][] arrwand = new WAND[22] [22];
    
    public FELDER()
    {
        arrwand[5][8] = new WAND();
        arrwand[5][9] = new WAND();
        arrwand[4][8] = new WAND();
        paint();
    }
    void paint(){
        for (int x = 0; x < arrwand. length; x++){
            for (int y = 0; y < arrwand. length; y++)
            {if(arrwand[x][y] != null){
                arrwand[x][y].PositionSetzen(x -11,y-11);
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
}
