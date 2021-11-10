import java.awt.*;
import java.util.*;
import java.util.List;
/**
 * Write a description of class colorlab here.
 *
 * sarayu suresh
 * 11/10/21
 */
public class colorlab
{
    public void maxBlue()
    {
        //public void maxBlue()
        Picture apic = new Picture("images\\beach.jpg");
        Pixel[] pixels = apic.getPixels();
        
        apic.explore();
        
        for (Pixel spot: pixels)
        {
            spot.setBlue(255);
        }    
        apic.explore();

    } 
    
    public void maxRed()
    {
        //public void maxRed();
        Picture apic = new Picture("images\\beach.jpg");

        Pixel[] pixels = apic.getPixels();
        
        apic.explore();
        
        for (Pixel spot: pixels)
        {
            spot.setRed(255);
        }    
        apic.explore();
        
    }
    
    public void maxGreen()
    {
        //public void maxGreen();
        Picture apic = new Picture("images\\beach.jpg");

        Pixel[] pixels = apic.getPixels();
        
        apic.explore();
        
        for (Pixel spot: pixels)
        {
            spot.setGreen(255);
        }    
        apic.explore();
        
    }
    
    public void negate()
    {
        //public void negate();
        Picture apic = new Picture("images\\beach.jpg");

        Pixel[] pixels = apic.getPixels();
        
        apic.explore();
        
        for (Pixel spot: pixels)
        {
            int r = spot.getRed();
            int g = spot.getGreen();
            int b = spot.getBlue();
            
            r = 225 - r;
            g = 225 - g;
            b = 225 - b;
        }    
        apic.explore();
    }
    
    
}
