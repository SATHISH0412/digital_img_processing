import java.awt.image.BufferedImage;
import java.awt.Color;
import java.awt.Graphics;
import java.io.IOException;
import java.io.File;
import javax.imageio.ImageIO;

public class rgbExt {
    public static void main(String[] args) {
        
        try {
            BufferedImage img = ImageIO.read(new File("images.jpg"));
            System.out.println("read successfull");

            int width = img.getWidth();
            int height = img.getHeight();

            BufferedImage redimg = new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);
            BufferedImage blueimg = new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);
            BufferedImage greenimg = new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);


            for (int x=0; x<img.getWidth();x++){
                for(int y=0;y<img.getHeight();y++){
                    Color rgb = new Color(img.getRGB(x, y));

                    int red= rgb.getRed();
                    int green = rgb.getGreen();
                    int blue = rgb.getBlue();

                    redimg.setRGB(x, y,new Color(red,0,0).getRGB());
                    blueimg.setRGB(x, y,new Color(0,green,0).getRGB());
                    greenimg.setRGB(x, y,new Color(0,0,blue).getRGB());

                    
                }

            }
             BufferedImage combine = new BufferedImage( width*3, height,BufferedImage.TYPE_INT_RGB);

            Graphics g = combine.getGraphics();
            g.drawImage(redimg,0, 0, null);
            g.drawImage(greenimg, width, 0, null);
            g.drawImage(blueimg,width*2,0,null);
            g.dispose();



            ImageIO.write(combine,"png",new File("rgbextract.png"));
            System.out.println("write sucess");

            
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }


    }
}
