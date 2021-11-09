import java.awt.*;
import java.util.*;
import java.util.List;
/**
 * Write a description of class katiewall here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class katiewall
{
    public static void main (String[] args)
    {
        Picture katie = new Picture("images/KatieFancy.jpg");
        
        katie.explore();
        Pixel[] pixels;

        pixels = katie.getPixels();
        
        for (Pixel spot: pixels)
        {
            int r = spot.getRed();
            int g = spot.getGreen();
            int b = spot.getBlue();
            
            if (r <= 150 && r >=130 && g >= 135 && g <= 150 && b <= 135 && b >= 125)
                spot.setColor(new Color(224,176,255));
            
        }
        katie.explore();
    }
}
