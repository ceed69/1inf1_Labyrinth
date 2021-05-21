public class FELDER
{
 /**   WAND wand;
    WAND[][] arrwand = new WAND[22] [22];
    public FELDER()
    {
        arrwand[5][8] = new WAND();
    }
    void paint(){
        for (int x = 0; x < arrwand. length; x++){
            for (int y = 0; y < arrwand. length; y++)
            {arrwand [x][y]. PositionSetzen (11-x, 11-y);}}
    }**/
    TEST test;
    TEST[][] arrwand = new TEST[22] [22];
    public FELDER()
    {
        arrwand[5][8] = new TEST();
    }
   void paint(){
        for (int x = 0; x < arrwand. length; x++){
            for (int y = 0; y < arrwand. length; y++)
            {if(arrwand[x][y].lebt == true){
                arrwand[x][y].position(x,y);
            }
            else{}
        }
   }
}
}
