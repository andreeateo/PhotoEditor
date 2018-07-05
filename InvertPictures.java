
/**
 * InvertPictures lets you choose an image, invert / negate, and then save it.
 * 
 * @author Andreea Teodor
 * @version 2017-AUG-08
 */

import java.io.*;
import edu.duke.*;
public class InvertPictures {

    public ImageResource invert(ImageResource inImage){
        ImageResource outImage = new ImageResource(inImage.getWidth(), inImage.getHeight());
        for (Pixel pixel: outImage.pixels()){
            Pixel inPixel = inImage.getPixel(pixel.getX(), pixel.getY());
            int invRed = (255 - inPixel.getRed());
            int invBlue = (255 - inPixel.getBlue());
            int invGreen = (255 - inPixel.getGreen());
            
            pixel.setRed(invRed);
            pixel.setBlue(invBlue);
            pixel.setGreen(invGreen);
        }
        return outImage;
    }
    public void selectAndConvert(){
        DirectoryResource dr = new DirectoryResource();
        for(File f : dr.selectedFiles()){
            ImageResource image = new ImageResource(f);
            String fname = image.getFileName();
            ImageResource inv = invert(image);
            String newName = "inverted-" + fname;
            inv.setFileName(newName);
            inv.draw();
            inv.save();
            
        
        }
    
    }
}
