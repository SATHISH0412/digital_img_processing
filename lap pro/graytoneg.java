import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class graytoneg {
    public static void main(String[] args) {

        try {
            BufferedImage img = ImageIO.read(new File("twogray.png"));
            System.out.println("read success");

            BufferedImage negimg = new BufferedImage(img.getWidth(), img.getHeight(), BufferedImage.TYPE_BYTE_GRAY);

            for (int x = 0; x < img.getWidth(); x++) {
                for (int y = 0;y< img.getHeight(); y++) {
                    int gray = img.getRGB(x, y) & 0xff;
                    int negative = 255 - gray;
                    int newneg =  (negative<< 16) |  (negative<<8) | negative;
                    negimg.setRGB(x, y, newneg);

                }
            }

            ImageIO.write(negimg,"png", new File("gratne.png"));
            System.out.println("write success");

        } catch (IOException e) {
            System.out.println("error:" + e);

        }

    }

}
