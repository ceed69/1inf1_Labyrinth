import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files
public class LESEN
{
    int x = 0;
    int y = 0;
    FELDER felder;
    public LESEN()
    {
        felder = new FELDER();
            try {
      File myObj = new File("Level_1.txt");
      Scanner myReader = new Scanner(myObj);
      while (myReader.hasNextLine()) {
        String data = myReader.nextLine();
        y = y +1;
                for(int i = 0; i < data.length(); i++){  
            //System.out.print(data.charAt(i) + " ");  
            x = i;
            //System.out.print(x + " ");
            //System.out.print(y + " ");
            //System.out.print("[-]");
            felder.neue_Wand(x,y);
        }  
        //System.out.println(" ");
      }
      myReader.close();
      felder.paint();
    } catch (FileNotFoundException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }
}
}
