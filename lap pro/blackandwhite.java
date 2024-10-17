import java.io.File;
import java.io.IOException;
import java.awt.Image;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;


public class blackandwhite {
    public static void main(String[] args) {

        try{

            BufferedImage img = ImageIO.read(new File("images.jpg"));
            System.out.println("read success");

            int theshold =100;

            BufferedImage blackimg = new BufferedImage(img.getWidth(),img.getHeight(),BufferedImage.TYPE_BYTE_BINARY);

            for(int x = 0 ; x< img.getWidth();x++){
                for(int y = 0;y< img.getHeight();y++){
                    
                    int rgb = img.getRGB(x, y);

                    int red = (rgb >> 16) & 0xff;
                    int green = (rgb >> 8) & 0xff;
                    int blue = rgb & 0xff;

                    int gray  = (red + green + blue)/3;

                    if(gray<theshold){
                        blackimg.setRGB(x, y,0xFF000000);
                    }
                    else{
                        blackimg.setRGB(x, y, 0xFFFFFFFF);
                    }

                }
            }




            ImageIO.write(blackimg, "png", new File("black.png"));
            System.out.println("write success1");

        }catch(IOException e){

            System.out.println("error" + e);

        }
        
    }
}
