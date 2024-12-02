import java.io.IOException;
import java.io.File;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;




public class readWrite{
    public static void main(String [] args){
try{

    BufferedImage img = ImageIO.read(new File("images.jpg"));
    System.out.println("image reading success");

    BufferedImage gray = new BufferedImage(img.getWidth(), img.getHeight(),BufferedImage.TYPE_BYTE_GRAY);

    for (int x = 0 ; x < img.getWidth(); x++){
        for (int y = 0; y < img.getHeight();y++){
            int rgb = img.getRGB(x, y);
            gray.setRGB(x, y, rgb);
        }
    }


    ImageIO.write(gray,"png",new File("newgray.png"));
    System.out.println("gray image created successfull");


}
catch(IOException e){
    System.out.println(e.getMessage());
}



    }
}