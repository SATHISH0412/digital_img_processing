import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

import java.awt.Color;
import java.awt.image.BufferedImage;



public class contrast {
    public static void main(String[] args) {

        try {

            int rmin =0,rmax=255,gmin=0,gmax=255,bmin=0,bmax=255;
            BufferedImage img = ImageIO.read(new File("twogray.png"));

            BufferedImage contrastimg = new BufferedImage(img.getWidth(), img.getHeight(),BufferedImage.TYPE_INT_RGB);


          /*    for(int x =0;x<img.getWidth();x++){
                for (int y =0; y<img.getHeight();y++){

                    Color rgb = new Color(img.getRGB(x, y));

                    int red = rgb.getRed();
                    int green = rgb.getGreen();
                    int blue = rgb.getBlue();
                  rmin = Math.min(rmin, red);
                    rmax = Math.max(rmax, red);
                    bmin = Math.min(bmin, blue);
                    bmax = Math.max(bmax, blue);
                    gmin = Math.min(gmin, green);
                    gmax = Math.max(gmax, green);

                }}*/ 

            
            for(int x =0;x<img.getWidth();x++){
                for (int y =0; y<img.getHeight();y++){

                   Color rgb = new Color(img.getRGB(x, y));

                   int red =(int) (((rgb.getRed() - rmin)/(float) (rmax - rmin))*255);
                   int green =(int) (((rgb.getGreen() - gmin)/(float) (gmax - gmin))*255);
                   int blue =(int) (((rgb.getBlue() - bmin)/(float) (bmax - bmin))*255);

                 

                    contrastimg.setRGB(x, y, new Color(red,green,blue).getRGB());


                }}

                ImageIO.write(contrastimg,"png", new File("contraseimg.png"));
                System.out.println("write success");

            
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
    
}
