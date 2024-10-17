import java.io.IOException;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

public class readWrite {

    public static void main(String[] args) {
        try {
            BufferedImage img = ImageIO.read(new File("images.jpg"));
            System.out.println("read succssfull");

            BufferedImage grayImage = new BufferedImage(img.getWidth(), img.getHeight(), BufferedImage.TYPE_BYTE_GRAY);

            // Copy the color image into the grayscale image
            for (int x = 0; x < img.getWidth(); x++) {
                for (int y = 0; y < img.getHeight(); y++) {
                    int rgb = img.getRGB(x, y);
                    grayImage.setRGB(x, y, rgb);
                }
            }

            ImageIO.write(grayImage, "png", new File("out.png"));
            System.out.println("write success");

        } catch (IOException e) {
            System.out.println(e);
        }
    }

}