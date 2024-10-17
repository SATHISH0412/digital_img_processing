import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.IOException;
import java.io.File;

public class gray {

    public static void main(String[] args) {
        try {

            BufferedImage img = ImageIO.read(new File("images.jpg"));
            System.out.println("success");

            BufferedImage grayimg = new BufferedImage(img.getWidth(), img.getHeight(), BufferedImage.TYPE_BYTE_GRAY);

            for (int x = 0; x < img.getWidth(); x++) {
                for (int y = 0; y < img.getHeight(); y++) {
                    int rgb = img.getRGB(x, y);
                    grayimg.setRGB(x, y, rgb);

                }
            }

            ImageIO.write(grayimg, "png", new File("twogray.png"));
            System.out.println("write success");

        } catch (IOException e) {
            System.out.println("error" + e);
        }

    }
}