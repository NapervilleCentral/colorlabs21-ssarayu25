import java.awt.*;
import java.util.*;
import java.util.List;
/**
 * @author Sarayu Suresh
 * @version 5/19/22
 */
public class poster
{
    public static void main  (String args [])
    {
        Picture blank = new Picture("images\\canvas.png");
        Picture og = new Picture("images\\og.jpg");
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
        copyTo(blue, blank, 3376, 0);
        copyTo(sepia, blank, 6752, 0);
        copyTo(mirror, blank, 0, 6000);
        copyTo(rainbow, blank, 3376, 6000);
        copyTo(recursive1, blank, 6752, 6000);
        blank.explore();
        
        blank.write("images\\poster.png");
        
    }
    /**
     * copies a photo to a different photo starting at specific coordinate
     * @param source photo, target photo, int x and tnt y coordinate
     */
    public static void copyTo(Picture s, Picture t, int x, int y)
    {
          Pixel target; Pixel source;
          int h = s.getHeight() - 1;
          int w = s.getWidth() - 1;
          for (int r = 0; r < w; r++)
           {
              for (int c = 0; c < h; c++)
              {
                  target = t.getPixel(r+x, c+y);
                  source = s.getPixel(r, c);
                  target.setColor(source.getColor());
                }
            }
    }
    /**
     * increases the blue value and decreases the red value of reach pixel 
     * @param photo to edit
     */
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
  /**
   * changes a color photo to black an white by averaging rgb values
   * @param photo to edit
   */
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
    /**
     * changes a grayscale photo to sepia tones, by changing the r and b values of each pixel
     * @param photo to edit
     */
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
    /**
     * horizontally mirror photo by copying the top half of photo to botton half
     * @param photo to edit
     */
   public static void mirrorHorizontal(Picture mypic)
    {
      int width; int height;
      Pixel up;
      Pixel down;
      int h = mypic.getHeight() - 1;
      int w = mypic.getWidth() - 1;
      for (int r = 0; r < w; r++)
      {
          for (int c = 0; c < h/2; c++)
          {
              up = mypic.getPixel(r , c);
              down = mypic.getPixel (r, h - c );
              down.setColor(up.getColor());
            }
       }
     }
    /**
     * recursively copies the photo onto the bottom right of photo
     * @param photo to edit
     */
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
    /**
     * shepard fairy. changes color to pastel red to purple rainbow color based on shade
     * @param photo to edit
     */
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