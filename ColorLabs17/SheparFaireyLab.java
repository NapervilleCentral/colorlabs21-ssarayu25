
/**
 * Write a description of class SheparFaireyLab here.
 * 
 * sarayu suresh 
 * 11/11/21
 */
import java.awt.*;
import java.util.*;
import java.util.List; // resolves problem with java.awt.List and java.util.List

public class SheparFaireyLab
{
    /**
     * main method, to test the picture
     *  
     */
    public static void main(String[] args)
    {
        
         //opens selfie picture 
         
         Picture me = new Picture("images/selfie.jpg");
         Picture me1 = new Picture("images/selfie.jpg");
         Picture me2 = new Picture("images/selfie.jpg");
         
         me.explore();
         
         /**
          * method 1 change 
          * This method uses all four colors in equal amounts. This is easily done by dividing the sorted list of pixels values into four 
          * equally sized groups. The pixels in group 1,2,3 and 4 are colored dark blue, red, light blue and off-white respectively.
          * 
          */
         Pixel[] pixels = me.getPixels();
        
        for (Pixel spot: pixels)
        {
           int r = spot.getRed();
           int g = spot.getGreen();
           int b = spot.getBlue();
           
           int avg = (int) (r + g + b)/3; //gray scale
           //sets color based on which of the 4 categories the average rbg falls into
           if (avg < 64) 
               spot.setColor(new Color(10,42,63));
           else if (avg < 128)
               spot.setColor(new Color(219,21,34));
           else if (avg < 192)
               spot.setColor(new Color(101,147,160));
           else 
               spot.setColor(new Color(255,239,167));
        
           
           
        }
        
        me.explore();
        //me.write("images/selfieedit1.jpg");
         
         /**
          * method 2 change
          * This method colors by intensity and generally won't use the colors in equal amounts. After the sorting, find the smallest and 
          * largest grayscale values in the image and call them s (small) and b (big). Then, divide the interval between s and b into 4 equally 
          * spaced subintervals. Therefore, every pixel in the image has a  value greater or equal to s and less than (b-s)/4 is in group 1. 
          * Note , we don't know how may pixels this will be.  The other groups are formed in a similar way.   Then, as before, the pixels in 
          * group 1,2,3 and 4 are colored dark blue, red, light blue and off-white, respectively.
          * 
          */
        Pixel[] pixels1 = me1.getPixels();
        
        int big = 0;
        int small = 255; 
         
        for (Pixel spot: pixels1)
        {
           int r = spot.getRed();
           int g = spot.getGreen();
           int b = spot.getBlue();
           
           int avg = (int) (r + g + b)/3;
           
           //finding smallest and largest
           if (avg < small)
               small = avg;
           else if (avg > big)
               big = avg;
        }
        
        int rangesize = (big - small)/4;
        
        
        for (Pixel spot: pixels1)
        {
           int r = spot.getRed(); //all are equal only need to grab one
           
           if (r <= (small + rangesize))
               spot.setColor(new Color(10,42,63));
           else if (r <= (small + (rangesize*2)))
               spot.setColor(new Color(219,21,34));
           else if (r <= (small + (rangesize*3)))
               spot.setColor(new Color(101,147,160));
           else if (r <= big)
               spot.setColor(new Color(255,239,167));
        }
        
        me1.explore();
        //me1.write("images/selfieedit2.jpg");
         
         /**
          * custom color palette
          * Choose your own  4 color palette 
          */
         Pixel[] pixels2 = me2.getPixels();
        
        int big1 = 0;
        int small1 = 255; 
         
        for (Pixel spot: pixels2)
        {
           int r = spot.getRed();
           int g = spot.getGreen();
           int b = spot.getBlue();
           
           int avg = (int) (r + g + b)/3;
           
           //finding smallest and largest
           if (avg < small1)
               small1 = avg;
           else if (avg > big1)
               big1 = avg;
        }
        
        int rangesize1 = (big1 - small1)/4;
        
        
        for (Pixel spot: pixels2)
        {
           int r = spot.getRed(); //all are equal only need to grab one
           
           if (r <= (small1 + rangesize1))
               spot.setColor(new Color(75,0,130)); //indigo
           else if (r <= (small1 + (rangesize1*2)))
               spot.setColor(new Color(148,0,211)); //dark violet
           else if (r <= (small1 + (rangesize1*3)))
               spot.setColor(new Color(147,112,219)); //medium purple
           else if (r <= big1)
               spot.setColor(new Color(230,230,250)); //lavender
        }
        
        me2.explore();
        me2.write("images/selfieedit3.jpg");
         
    }//main       
}//class
