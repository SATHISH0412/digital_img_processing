import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

public class RGBtoCMYK {

    public static float[] rgbToCMYK(Color color) {
        float r = color.getRed() / 255.0f;
        float g = color.getGreen() / 255.0f;
        float b = color.getBlue() / 255.0f;

        float k = 1 - Math.max(r, Math.max(g, b));
        float c = (k == 1) ? 0 : (1 - r - k) / (1 - k);
        float m = (k == 1) ? 0 : (1 - g - k) / (1 - k);
        float y = (k == 1) ? 0 : (1 - b - k) / (1 - k);

        return new float[]{c, m, y, k};
    }

    public static void main(String[] args) {
        try {
            // Load the input image
            BufferedImage img = ImageIO.read(new File("images.jpg"));
            int width = img.getWidth();
            int height = img.getHeight();

            // Create an output image for CMYK
            BufferedImage cmykImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

            for (int x = 0; x < width; x++) {
                for (int y = 0; y < height; y++) {
                    Color color = new Color(img.getRGB(x, y));
                    float[] cmyk = rgbToCMYK(color);

                    int cyan = (int) (cmyk[0] * 255);    // Scale cyan
                    int magenta = (int) (cmyk[1] * 255); // Scale magenta
                    int yellow = (int) (cmyk[2] * 255);  // Scale yellow
                    cmykImage.setRGB(x, y, new Color(cyan, magenta, yellow).getRGB());
                }
            }

            // Save the CMYK image
            ImageIO.write(cmykImage, "png", new File("output_cmyk.png"));
            System.out.println("CMYK conversion completed. Output saved as output_cmyk.png.");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
