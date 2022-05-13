import java.awt.*;
import java.util.*;
import java.util.List;
/**
 * Write a description of class filter here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class filter
{
 
    public static void main  (String args [])
    {
        Picture pic = new Picture("images\\og.jpg");
        //Picture apic = recursive(pic, 5);
        contrast(pic);
        pic.explore();
    }
    
    public static void addBlue(Picture pic)
    {
          int width; int height;
          Pixel spot;
          int h = pic.getHeight() - 1;
          int w = pic.getWidth() - 1;
          for (int r = 0; r < w; r++)
          {
              for (int c = 0; c < h; c++)
              {
                  spot = pic.getPixel(r, c);
                  spot.setRed(spot.getRed() - 100);
                  spot.setBlue(spot.getBlue() + 100);
                }
            }
    }
    
    public static void grayScale(Picture pic)
    {
        
        Pixel[] markspixs = pic.getPixels();
       
       for (Pixel apix: markspixs)
       {
           int r = apix.getRed();
           int g = apix.getGreen();
           int b = apix.getBlue();
           
           int avg = (int) (r + g + b)/3;
           
           apix.setColor(new Color(avg, avg, avg));
        }   
        
    }
    
    public static void sepiaTone(Picture pic)
    {
       grayScale(pic);
        Pixel[] markspixs = pic.getPixels();
       
       for (Pixel apix: markspixs)
       {
           int r = apix.getRed();
           if (r < 63)
           {
               apix.setRed((int) (r * 1.1));
               apix.setBlue((int) (r * 0.9));
            }
           else if (r < 192)
           {
               apix.setRed((int) (r * 1.15));
               apix.setBlue((int) (r * 0.85));
            }
           else 
           {
               apix.setRed((int) (r * 1.08));
               apix.setBlue((int) (r * 0.93));
            }
           
           
        }   
    }
    
    public static void mirrorHorizontal(Picture mypic)
    {
      int width; int height;
      Pixel up;
      Pixel down;
      int h = mypic.getHeight() - 1;
      int w = mypic.getWidth() - 1;
      for (int r = 0; r < w/2; r++)
      {
          for (int c = 0; c < h; c++)
          {
              up = mypic.getPixel(r , c);
              down = mypic.getPixel (r, h - c );
              down.setColor(up.getColor());
            }
        }
     }
    
    public static Picture recursive(Picture pic, int x)
    {
         if (x == 0)
         {
            return pic;
         }
         Picture copy = new Picture (pic);
          int width; int height;
          Pixel spot; Pixel spot1;
          int h = pic.getHeight() - 1;
          int w = pic.getWidth() - 1;
          for (int r = w, r1 = w; r > 0; r--)
          {
              for (int c = h, c1 = h; c > 0; c--)
              {
                 if (c%2 == 0 )
                 {
                      spot = pic.getPixel(r, c);
                      spot1 = copy.getPixel(r1, c1);
                      spot1.setColor(spot.getColor());
                      c1--;
                   }
                }
              if (r%2 == 0)
              {
                  r1--;
                }
            }
            
          return recursive(copy, x-1);
    }
    
    public static void contrast(Picture pic)
    {
        Pixel[] markspixs = pic.getPixels();
       
       for (Pixel apix: markspixs)
       {
           int r = apix.getRed();
           int g = apix.getGreen();
           int b = apix.getBlue();
           int avg = (r + b + g)/3;
           if (avg < 125)
           {
               if (r < 10 || g < 10 || b < 10)
               {
                   apix.setColor(new Color(0, 0, 0));
                }
               else
               {
                   apix.setColor(new Color(r - 10, g-10, b -10));
                }
            }
           else
           {
               if (r > 240 || g > 240 || b > 240)
               {
                   apix.setColor(new Color(250, 250, 250));
                }
               else
               {
                apix.setColor(new Color(r + 10, g + 10, b + 10));
               }
            }
        }
        
    }
}


    
