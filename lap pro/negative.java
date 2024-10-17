import java.io.File;
import java.io.IOException;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.awt.Color;

public class negative {
    public static void main(String[] args) {

        try {
            BufferedImage img = ImageIO.read(new File("images.jpg"));
            System.out.println("read successfull");

            BufferedImage negative = new BufferedImage(img.getWidth(), img.getHeight(), BufferedImage.TYPE_INT_RGB);

            for (int x = 0; x < img.getWidth(); x++) {
                for (int y = 0; y < img.getHeight(); y++) {

                    Color rgb = new Color(img.getRGB(x, y));

                    Color negativeColor = new Color(255 - rgb.getRed(),
                                                    255 - rgb.getGreen(),
                                                    255 - rgb.getBlue());
                    negative.setRGB(x, y, negativeColor.getRGB());

                }
            }

            ImageIO.write(negative, "png", new File("negative.png"));
            System.out.println("write successful");

        } catch (IOException e) {
            System.out.println("error" + e);

        }
    }

}
