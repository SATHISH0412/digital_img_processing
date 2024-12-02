import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import java.awt.Color;
import java.io.IOException;

public class Histogram {
    public static void main(String[] args) {
        try {
            // Load the input image
            BufferedImage img = ImageIO.read(new File("images.jpg"));
            int width = img.getWidth();
            int height = img.getHeight();
            int totalPixels = width * height;

            // Arrays for histogram, cumulative histogram (CHF), and equalized values
            int[] histogram = new int[256];
            int[] CHF = new int[256];
            int[] equalized = new int[256];

            // Step 1: Compute the histogram
            for (int x = 0; x < width; x++) {
                for (int y = 0; y < height; y++) {
                    // Convert RGB to grayscale using luminance formula
                    Color color = new Color(img.getRGB(x, y));
                    int gray = color.getRed();
                    histogram[gray]++;
                }
            }

            // Step 2: Compute the cumulative histogram (CHF)
            CHF[0] = histogram[0];
            for (int i = 1; i < 256; i++) {
                CHF[i] = CHF[i - 1] + histogram[i];
            }

            // Step 3: Normalize the CHF to generate the equalized values
            int chfMin = CHF[0];
            for (int i = 0; i < 256; i++) {
                equalized[i] = (int) (((CHF[i] - chfMin) / (float) (totalPixels - chfMin)) * 255);
            }

            // Step 4: Apply the equalized values to create the new image
            BufferedImage histoImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
            for (int x = 0; x < width; x++) {
                for (int y = 0; y < height; y++) {
                    // Convert RGB to grayscale again for mapping
                    Color color = new Color(img.getRGB(x, y));
                    int gray = (int) (0.299 * color.getRed() + 0.587 * color.getGreen() + 0.114 * color.getBlue());
                    int newGray = equalized[gray];
                    // Set the new grayscale value as RGB
                    histoImage.setRGB(x, y, new Color(newGray, newGray, newGray).getRGB());
                }
            }

            // Step 5: Save the output image
            ImageIO.write(histoImage, "png", new File("histo.png"));
            System.out.println("Histogram equalization completed successfully. Output saved as histo.png.");

        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
