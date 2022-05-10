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
     Picture mypic = new Picture("images\\temple.jpg");
     Picture apic = new Picture("images\\water.jpg");
     apic.explore();

     copyTo(mypic,apic);
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
      Pixel leftPixel;
      Pixel rightPixel;
      int h = mypic.getHeight() - 1;
      int w = mypic.getWidth() - 1;
      for (int r = 0; r < w/2; r++)
      {
          for (int c = 0; c < h; c++)
          {
              leftPixel = mypic.getPixel(r , c);
              rightPixel = mypic.getPixel (w - r, c );
              rightPixel.setColor(leftPixel.getColor());
            }
        }
    }
    
  public static void templeMirror()
  {
      Picture mypic = new Picture("images\\temple.jpg");
      mypic.explore();

      int width; int height;
      Pixel leftPixel;
      Pixel rightPixel;
      int h = mypic.getHeight() - 1;
      int w = mypic.getWidth() - 1;
      for (int r = 8; r < 251; r++)
      {
          for (int c = 14; c < 132; c++)
          {
              leftPixel = mypic.getPixel(r , c);
              rightPixel = mypic.getPixel (w - r, c );
              rightPixel.setColor(leftPixel.getColor());
            }
        }
      mypic.explore();
    }
    
    
    public static void copyTo(Picture s, Picture t)
    {
        int width; int height;
      Pixel target;
      Pixel source;
      int h = s.getHeight() - 1;
      int w = s.getWidth() - 1;
        for (int r = 0; r < w; r++)
      {
          for (int c = 0; c < h; c++)
          {
              target = t.getPixel(r, c);
              source = s.getPixel(r, c);
              target.setColor(source.getColor());
            }
        }
    }
}
