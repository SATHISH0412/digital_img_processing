import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

import java.awt.Color;

import java.awt.image.BufferedImage;

public class CMY {

    public static   float[] rgbtocmyk(Color color){

        float r=color.getRed()/255;
        float g = color.getGreen()/255;
        float b = color.getBlue()/255;
        
        float k =1-  Math.max(r, Math.max(g,b));
        float c=(k==1)?0:(1-r-k)/(1-k);
        float m=(k==1)?0:(1-g-k)/(1-k);
        float y=(k==1)?0:(1-b-k)/(1-k);

        return new float[]{c,m,y,k};

    }
    public static void main(String[] args) {
        
        try {
            BufferedImage img = ImageIO.read(new File("images.jpg"));

            int height = img.getHeight();
            int width = img.getWidth();
            
            BufferedImage cymlimage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

            for(int x=0; x<width;x++ ){
                for(int y = 0; y<height;y++){

                 Color color =  new Color(img.getRGB(x, y) ); 
                 float[] col = rgbtocmyk(color);

                 int cyan =(int)(col[0]*255);
                 int megeta =(int)(col[1]*255);
                 int yellow =(int)(col[2]*255);

                 cymlimage.setRGB(x, y, new Color(cyan,megeta,yellow).getRGB());
                    
                }
            }

        ImageIO.write(cymlimage, "png", new File("cymkimg.png"));
            
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
}
