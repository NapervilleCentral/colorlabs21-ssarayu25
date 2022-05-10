/**
 * Write a description of class filter here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class filter
{
    /**
     * Constructor for objects of class filter
     */
    public filter()
    {
        
    }
    
    public static void main  (String args [])
    {
        Picture pic = new Picture("images\\og.jpg");
        blue(pic);
        pic.explore();
    }
    
    public static void blue(Picture pic)
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
                  spot.setRed(spot.getRed() - 40);
                  spot.setBlue(spot.getBlue() + 40);
                  
                }
            }
    }
    
    
}

    
