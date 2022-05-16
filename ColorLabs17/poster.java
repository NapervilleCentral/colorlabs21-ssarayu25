import java.awt.*;
import java.util.*;
import java.util.List;
/**
 * Write a description of class filter here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class poster
{
    public static void main  (String args [])
    {
        Picture blank = new Picture("images\\canvas.jpg");
        Picture og = new Picture("images\\canvas.jpg");
        Picture blue = new Picture("images\\og.jpg");
        Picture sepia = new Picture("images\\og.jpg");
        Picture mirror = new Picture("images\\og.jpg");
        Picture rainbow = new Picture("images\\og.jpg");
        Picture recursive = new Picture("images\\og.jpg");
        
        addBlue(blue);
        sepiaTone(sepia);
        mirrorHorizontal(mirror);
        rainbow(rainbow);
        Picture recursive1 = recursive(recursive, 5);
        
        
        copyTo(og, blank, 0, 0);
        copyTo(blue, sepia, 3376, 6000);
        blank.explore();
        
        
    }
    
    public static void copyTo(Picture s, Picture t, int h1, int w1)
    {
          int width; int height;
          Pixel target;
          Pixel source;
          int h = s.getHeight() - 1;
          int w = s.getWidth() - 1;
            for (int r = w1; r < w + w1; r++)
          {
              for (int c = h1; c < h + h1; c++)
              {
                  target = t.getPixel(r, c);
                  source = s.getPixel(r, c);
                  target.setColor(source.getColor());
                }
            }
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
              apix.setColor(new Color((int) (r * 0.8), (int) (g * 0.8), (int) (b * 0.8)));
               }
           else
           {
               if ((int)(r*1.2) < 255 && (int) (g * 1.2) < 255 && (int)(b * 1.2) < 255)
               {
                   apix.setColor(new Color((int) (r* 1.2), (int) (g* 1.2), (int) (b* 1.2)));
                }
               else
               {
                   apix.setColor(new Color(255, 255, 255));
                }
            }
        }
    }
    public static void rainbow(Picture pic)
    {
        Pixel[] pixels = pic.getPixels();
        
        for (Pixel spot: pixels)
        {
           int r = spot.getRed();
           int g = spot.getGreen();
           int b = spot.getBlue();
           
           int avg = (int) (r + g + b)/3; //gray scale
           //sets color based on which of the 4 categories the average rbg falls into
           if (avg < 51) 
               spot.setColor(new Color(235,156,156));
           else if (avg < 102)
               spot.setColor(new Color(233,245,150));
           else if (avg < 153)
               spot.setColor(new Color(131,213,130));
           else if (avg < 204)
                spot.setColor(new Color(140,140,239));
           else 
               spot.setColor(new Color(245,149,224));
        }
    }
    
    
}