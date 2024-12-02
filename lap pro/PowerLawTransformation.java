import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

public class PowerLawTransformation {

    public static void main(String[] args) {
        try {
            // Read the input image
            BufferedImage img = ImageIO.read(new File("input.jpg"));
            int width = img.getWidth();
            int height = img.getHeight();

            // Create a new image to store the transformed image
            BufferedImage powerLawImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

            // Parameters for power-law transformation
            double gamma = 0.5; // You can change the gamma value
            double c = 1.0;     // Scaling constant, often set to 1

            // Apply power-law (gamma) transformation to each pixel
            for (int x = 0; x < width; x++) {
                for (int y = 0; y < height; y++) {
                    // Get the pixel's color
                    Color color = new Color(img.getRGB(x, y));

                    // Normalize the pixel values to [0, 1]
                    double red = color.getRed() / 255.0;
                    double green = color.getGreen() / 255.0;
                    double blue = color.getBlue() / 255.0;

                    // Apply the power-law transformation
                    red = c * Math.pow(red, gamma);
                    green = c * Math.pow(green, gamma);
                    blue = c * Math.pow(blue, gamma);

                    // Scale back to [0, 255] and clamp the values
                    int newRed = (int) (Math.min(255, Math.max(0, red * 255)));
                    int newGreen = (int) (Math.min(255, Math.max(0, green * 255)));
                    int newBlue = (int) (Math.min(255, Math.max(0, blue * 255)));

                    // Set the new color in the output image
                    powerLawImage.setRGB(x, y, new Color(newRed, newGreen, newBlue).getRGB());
                }
            }

            // Save the power-law transformed image
            ImageIO.write(powerLawImage, "jpg", new File("power_law_transformed_image.jpg"));

            System.out.println("Power-law (gamma) transformation completed successfully!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
