import java.awt.*;
import java.util.*;
import java.util.List;
/**
 * Write a description of class colorlab here.
 *
 * sarayu suresh
 * 11/10/21
 */
public class ColorLab
{
    Picture apic;
    public ColorLab(String fileName) 
    {
        apic = new Picture(fileName);
    }
    
    public void maxBlue()
    {
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
        Pixel[] pixels = apic.getPixels();
        
        
        for (Pixel spot: pixels)
        {
            spot.setRed(255);
        }    
        apic.explore();
        
    }
    
    public void maxGreen()
    {

        Pixel[] pixels = apic.getPixels();
        
        
        for (Pixel spot: pixels)
        {
            spot.setGreen(255);
        }    
        apic.explore();
        
    }
    
    public void negate()
    {
        Pixel[] pixels = apic.getPixels();
        
        
        for (Pixel spot: pixels)
        {
            int r = spot.getRed();
            int g = spot.getGreen();
            int b = spot.getBlue();
            
            r = 255 - r;
            g = 255 - g;
            b = 255 - b;
            
            spot.setColor(new Color(r, g, b));
        }    
        apic.explore();
    }
    
    public void adjustRed(double factor)
    {
        Pixel[] pixels = apic.getPixels();
        
        for (Pixel spot: pixels)
        {
            int r = spot.getRed();
            r = (int) (r * factor);
            spot.setRed(r);
        }
        apic.explore();
    }
    
    public void adjustGreen(double factor)
    {
        Pixel[] pixels = apic.getPixels();
        
        for (Pixel spot: pixels)
        {
            int g = spot.getGreen();
            g = (int) (g * factor);
            spot.setGreen(g);
        }
        apic.explore();
    }
    
    public void adjustBlue(double factor)
    {
        Pixel[] pixels = apic.getPixels();
        
        for (Pixel spot: pixels)
        {
            int b = spot.getBlue();
            b = (int) (b * factor);
            spot.setBlue(b);
        }
        apic.explore();
    }
    
    public void grayScale()
    {
        Pixel[] pixels = apic.getPixels();
        
        for (Pixel spot: pixels)
        {
           int r = spot.getRed();
           int g = spot.getGreen();
           int b = spot.getBlue();
           
           int avg = (int) (r + g + b)/3;
           
           spot.setColor(new Color(avg, avg, avg));
        }
        
        apic.explore();
    }
    
    public void lighten()
    {
        Pixel[] pixels = apic.getPixels();
        
        for (Pixel spot: pixels)
        {
           int r = spot.getRed();
           int g = spot.getGreen();
           int b = spot.getBlue();
           
           spot.setRed(r + 50);
           spot.setGreen(g + 50);
           spot.setBlue(b + 50); 
           
        }
        
        apic.explore();
    }
    
    public void darken()
    {
        Pixel[] pixels = apic.getPixels();
        
        for (Pixel spot: pixels)
        {
           int r = spot.getRed();
           int g = spot.getGreen();
           int b = spot.getBlue();
           
           spot.setRed(r - 50);
           spot.setGreen(g - 50);
           spot.setBlue(b - 50); 
           
        }
        
        apic.explore();
    }
    
    public void changeColors(double redAmount, double greenAmount, double blueAmount)
    {
        Pixel[] pixels = apic.getPixels();
        
        for (Pixel spot: pixels)
        {
           int r = spot.getRed();
           int g = spot.getGreen();
           int b = spot.getBlue();
           
           spot.setRed((int)(r + redAmount));
           spot.setGreen((int) (g + greenAmount));
           spot.setBlue((int) (b + blueAmount));
           
        }
        
        apic.explore();
    }
    
    public void blueify()
    {
        Pixel[] pixels = apic.getPixels();
        
        for (Pixel spot: pixels)
        {
           int r = spot.getRed();
           int g = spot.getGreen();
           int b = spot.getBlue();
           
           if (r > 130 && r < 250 && g > 110 && g < 200 && b > 80 && b<170)
           {
               spot.setColor(Color.blue);
           }
        }
        
        apic.explore();
    }
    
    public void colorify()
    {
        Pixel[] pixels = apic.getPixels();        
        
        for (Pixel spot: pixels)
        {
           int r = spot.getRed();
           int g = spot.getGreen();
           int b = spot.getBlue();
           
           if (r > 50 && r < 110 && g > 50 && g < 110 && b > 50 && b<110)
           {
               spot.setColor(Color.red);
           }
        }
        
        apic.explore();
    }
    
    public void swap2()
    {
        Pixel[] pixels = apic.getPixels();        
        
        for (Pixel spot: pixels)
        {
           int r = spot.getRed();
           int g = spot.getGreen();
           int b = spot.getBlue();
           
           spot.setColor(new Color(g, r, b));
           
        }
        
        apic.explore();
    }
    
    public void swap3()
    {
        Pixel[] pixels = apic.getPixels();        
        
        for (Pixel spot: pixels)
        {
           int r = spot.getRed();
           int g = spot.getGreen();
           int b = spot.getBlue();
           
           spot.setColor(new Color(g, b, r));
           
        }
        
        apic.explore();
    }
    
    public static void main (String[] args)
    {        
        ColorLab p = new ColorLab("images/selfie.jpg");
        p.maxBlue();
        
        ColorLab p1 = new ColorLab("images/selfie.jpg");
        p1.maxRed();
        
        ColorLab p2 = new ColorLab("images/selfie.jpg");
        p2.maxGreen();
        
        ColorLab p3 = new ColorLab("images/selfie.jpg");
        p3.negate();
        
        ColorLab p4 = new ColorLab("images/selfie.jpg");
        p4.adjustRed(2);
        
        ColorLab p5 = new ColorLab("images/selfie.jpg");
        p5.adjustGreen(2);
        
        ColorLab p6 = new ColorLab("images/selfie.jpg");
        p6.adjustBlue(2);
        
        ColorLab p7 = new ColorLab("images/selfie.jpg");
        p7.grayScale();
        
        ColorLab p8 = new ColorLab("images/selfie.jpg");
        p8.lighten();
        
        ColorLab p9 = new ColorLab("images/selfie.jpg");
        p9.darken();
        
        ColorLab p10 = new ColorLab("images/selfie.jpg");
        p10.colorify();
        
        ColorLab p11 = new ColorLab("images/selfie.jpg");
        p11.swap2();
        
        ColorLab p12 = new ColorLab("images/selfie.jpg");
        p12.swap3();
    }    
    }

