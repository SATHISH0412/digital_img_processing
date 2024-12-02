import java.io.File;
import java.io.IOException;
import java.awt.image.BufferedImage;
import java.awt.Color;
import javax.imageio.ImageIO;


public class bitplane {
    public static void main(String[] args) {
        

        try {
            
            BufferedImage img = ImageIO.read(new File("twogray.png"));
            System.out.println("read success");

            BufferedImage[] bitplanes = new BufferedImage[8];

            for (int b = 0 ; b<8;b++){
                bitplanes[b] =  new BufferedImage(img.getWidth(),img.getHeight(),BufferedImage.TYPE_BYTE_GRAY);

            }


            for(int x =0;x<img.getWidth();x++){
                for (int y =0; y<img.getHeight();y++){

                    int red = new Color(img.getRGB(x, y)).getRed();


                    for(int i = 0;i<8;i++){
                        int bit = (red >> i )& 1;
                        int value = bit * 255;

                     bitplanes[i].setRGB(x, y, new Color(value,value,value).getRGB());   
                    }


                }
            }

            for (int j = 0;j<8;j++){

                ImageIO.write(bitplanes[j],"png" ,new File("bitplane"+j+".jpg"));
                System.out.println("write succcess");
            }




        } catch (IOException e) {
           System.out.println(e.getMessage());
        }


    }
    
}
