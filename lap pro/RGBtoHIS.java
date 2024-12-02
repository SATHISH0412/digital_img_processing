import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

public class RGBtoHIS {

    public static float[] rgbToHIS(Color color) {
        float r = color.getRed() / 255.0f;
        float g = color.getGreen() / 255.0f;
        float b = color.getBlue() / 255.0f;

        float min = Math.min(r, Math.min(g, b));
        float intensity = (r + g + b) / 3.0f;
        float saturation = (intensity == 0) ? 0 : 1 - (min / intensity);

        float hue;
        if (r == g && g == b) {
            hue = 0; // Gray or black image
        } else {
            float numerator = 0.5f * ((r - g) + (r - b));
            float denominator = (float) Math.sqrt((r - g) * (r - g) + (r - b) * (g - b));
            hue = (float) Math.toDegrees(Math.acos(numerator / denominator));
            if (b > g) {
                hue = 360 - hue;
            }
        }

        return new float[]{hue, intensity, saturation};
    }

    public static void main(String[] args) {
        try {
            // Load the input image
            BufferedImage img = ImageIO.read(new File("input_image.jpg"));
            int width = img.getWidth();
            int height = img.getHeight();

            // Create an output image for HIS
            BufferedImage hisImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

            for (int x = 0; x < width; x++) {
                for (int y = 0; y < height; y++) {
                    Color color = new Color(img.getRGB(x, y));
                    float[] his = rgbToHIS(color);

                    int hue = (int) (his[0] / 360.0f * 255);  // Normalize hue to [0, 255]
                    int intensity = (int) (his[1] * 255);     // Scale intensity
                    int saturation = (int) (his[2] * 255);    // Scale saturation
                    hisImage.setRGB(x, y, new Color(hue, intensity, saturation).getRGB());
                }
            }

            // Save the HIS image
            ImageIO.write(hisImage, "png", new File("output_his.png"));
            System.out.println("HIS conversion completed. Output saved as output_his.png.");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
