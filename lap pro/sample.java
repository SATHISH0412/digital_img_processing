import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.File;
import javax.imageio.ImageIO;

public class sample {

    public static void main(String[] args) {

        try {
                                                                                
            BufferedImage img = ImageIO.read(new File("imas.jpg"));
            System.out.println("read success");

            BufferedImage outimg = new BufferedImage(img.getWidth(), img.getHeight(), BufferedImage.TYPE_INT_RGB);

            for (int x = 0; x < img.getWidth(); x++) {
                for (int y = 0; y < img.getHeight(); y++) {
                    Color rgb = new Color(img.getRGB(x, y));

                    int red = 255 - rgb.getRed();
                    int green = 255 - rgb.getGreen();
                    int blue = 255 - rgb.getBlue();

                    Color negative = new Color(red, green, blue);

                    outimg.setRGB(x, y, negative.getRGB());

                }
            }

            ImageIO.write(outimg, "png", new File("outsample.png"));
            System.out.println("write succcess");

        } catch (IOException err) {

            System.out.println("error" + err);

        }
    }

}
