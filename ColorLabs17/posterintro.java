import java.awt.*;
import java.util.*;
import java.util.List;
/**
 * Write a description of class posterintro here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class posterintro
{
    
    /**
     * main method, to test the picture
     *
     */
  public static void main(String[] args)
  {
    
     Picture apic = new Picture("images\\wall.jpg");
     
     mirrorVertical(apic);
     apic.explore();
     
    
   
  }//main
  public static void something(Picture mypic)
  {
      int h = mypic.getHeight();
      int w = mypic.getWidth();
      Pixel spot = null;
      for (int r = 0; r < w; r ++)
      {
          for (int c= 0; c < h; c++)
          {
              spot = mypic.getPixel(r, c);
              spot.setBlue(50);
            }
        }
      
    }
  public static void mirrorVertical(Picture mypic)
  {
      int width; int height;
      Pixel leftPixel = null;
      Pixel rightPixel = null;
      int h = mypic.getHeight();
      int w = mypic.getWidth()/2;
      for (int r = 0; r < h; r++)
      {
          for (int c = 0; c < w; c++)
          {
              leftPixel = mypic.getPixel(r , c);
              rightPixel = mypic.getPixel (mypic.getWidth() - r - 1, c);
              rightPixel.setColor(leftPixel.getColor());
            }
        }
      
    }
}
