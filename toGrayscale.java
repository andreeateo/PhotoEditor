
/**
 * toGrayscale lets you choose an image, convert it to grayscale, and then save it.
 * 
 * @author Andreea Teodor
 * @version 2017-AUG-08
 */

import java.io.*;
import edu.duke.*;
public class toGrayscale {

    public ImageResource toGrayscale(ImageResource inImage){
        ImageResource outImage = new ImageResource(inImage.getWidth(), inImage.getHeight());
        for (Pixel pixel: outImage.pixels()){
            Pixel inPixel = inImage.getPixel(pixel.getX(), pixel.getY());
            int avg = (inPixel.getRed() + inPixel.getBlue() + inPixel.getGreen())/3;
            
            pixel.setRed(avg);
            pixel.setBlue(avg);
            pixel.setGreen(avg);
        }
        return outImage;
    }
    public void selectAndConvert(){
        DirectoryResource dr = new DirectoryResource();
        for(File f : dr.selectedFiles()){
            ImageResource image = new ImageResource(f);
            String fname = image.getFileName();
            ImageResource inv = toGrayscale(image);
            String newName = "grayscale-" + fname;
            inv.setFileName(newName);
            inv.draw();
            inv.save();
            
        
        }
    
    }
}