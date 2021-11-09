import java.awt.*;
import java.util.*;
import java.util.List;
/**
 * Write a description of class grayscale here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class grayscale
{
   public static void main(String[] args)
   {
       
       Picture apic = new Picture("images\\beach.jpg");
       Picture ferris1 = new Picture("images/2000 ferris wheel2.jpg");
       Pixel[] markspixs = apic.getPixels();
       /**
        * Method to change the picture to gray scale
        * Gray a rgb value all the same
        * what value would u set to all rgb
        */
       ferris1.explore();
       for (Pixel apix: markspixs)
       {
           int r = apix.getRed();
           int g = apix.getGreen();
           int b = apix.getBlue();
           
           int avg = (int) (r + g + b)/3;
           
           apix.setColor(new Color(avg, avg, avg));
        }   
        
        ferris1.explore();
    }
}
