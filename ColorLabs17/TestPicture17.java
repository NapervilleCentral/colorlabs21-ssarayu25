/**
 * Kevin Hayes
 * Test Picture Classes
 *
 * @author (Kevin Hayes)
 * @version (10-19-2016)
 */
import java.awt.*;
import java.util.*;
import java.util.List; // resolves problem with java.awt.List and java.util.List
public class TestPicture17
{

    /**
     * main method, to test the picture
     *
     */
  public static void main(String[] args)
  {
      //opens picture using a dialog box
      /**/
     //String fileName = FileChooser.pickAFile();
     //Picture pictObj = new Picture(fileName);
     //pictObj.explore();

     //opens a pictue using a path
     //Picture apic = new Picture("C:\\Users\\khayes\\Favorites\\Documents\APCS- Java\chap03\Curriclum 2013\Picture Color labs\images\\beach.jpg");
     
     //Picture loads allof the pixels into an array using a relative path
     Picture apic = new Picture("images\\beach.jpg");
     Picture ferris1 = new Picture("images/2000 ferris wheel2.jpg");
     Picture ferris2 = new Picture("images/2000 ferris wheel2.jpg");
     Picture ferris3 = new Picture("images/2000 ferris wheel2.jpg");
     Picture somepic = new Picture("images/robot.jpg");

     //apic.explore();
     ferris1.explore(); //SOP for pictures
     //somepic.explore();
     
     
     //makes an array of pixels
     Pixel[] pixels;
     //gets pixels from picture and assigns to pixels array
     pixels = ferris1.getPixels();
    
     //how many pixels or how large array
    System.out.println("This is a large array"+pixels.length  );


    /**/
        //access each index
    System.out.println("Pixel 17: " + pixels[17]);
    pixels[17].setColor(Color.red); //make a change
    //ferris1.explore();
    
    //access each pixel by picture
    Pixel spot = ferris1.getPixel(100,100);
    Pixel spot2 = ferris1.getPixel(50,50);
    
    spot.setColor(new Color(255,99,71));
    spot2.setColor(new Color(225,0,0));
    
    System.out.println();
    System.out.println(spot);
    
    //ferris1.explore();
    //ferris2.explore();
/*
    pixels[17].setColor(Color.blue);
    spot.setColor(new Color(252,252,252));
    pixels[500034].setColor(Color.blue);

    ferris1.explore();
/*
   // loop to access indexes of array or collection

    //for each loop spot  is a ?
    for (Pixel spot : pixels)
    System.out.println( spot );


   
 /**/

 /**
  * Method to clear red from picture
  * @param none
  * @return none
  */
 /**/
 int count = 0;
 

 
    for (Pixel spot3 : pixels)
        {
            //set the red value of the current pixel to the new value
            //if (count%10 == 0)
            //    spot3.setColor(Color.green);
            int r = spot3.getRed();
            spot3.setRed(r*2);
            
            int g = spot3.getGreen();
            spot3.setGreen(g/5);
            count ++;
            
            int b = spot3.getBlue(0);
            spot3.setBlue((int)(b*Math.random()*1));
        }
    //ferris1.explore();
    
    ferris2.explore();
    pixels = ferris2.getPixels();
    for (Pixel spot4: pixels)
    {
        int r = spot4.getRed();
        int g = spot4.getGreen();
        int b = spot4.getBlue();
        
        if (r < 5 && g < 5 && b < 5)
           {
               r = 200;
               b = 255;
               g = 200;
           }
    }
    ferris2.explore();
/**/
 /**
  * Method to reduce red from picture by a factor of n
  * @param none
  * @return none
  */

/**
int value;
final double  FACTOR = .5;
    for (Pixel pixelObj : pixels)
    {

        //get the redvalue
        value = pixelObj.getRed();
        //System.out.println(value);

        //decrease the red value by 50%
        
        //set the red value of the current pixel to the new value
        

    }
    // use new picture when changing or it will make changes to 
    // pic you already changed
    ferris1.explore();
    ferris2.explore();

  /**/ 
    //write/save a picture as a file
    ferris1.write("images/ferris11.jpg");

    /**/
  }//main
}//class
