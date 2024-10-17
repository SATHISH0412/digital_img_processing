import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import java.awt.image.Kernel;
import java.awt.image.ConvolveOp;

public class sharpen {

    public static void main(String[] args) {
        try {
            // Load the input image
            File input = new File("images.jpg");
            BufferedImage image = ImageIO.read(input);

            // Define a sharpening kernel (3x3 matrix)
            float[] sharpenKernel = {
                0.0f, -1.0f,  0.0f,
                -1.0f,  5.0f, -1.0f,
                0.0f, -1.0f,  0.0f
            };

            // Apply the convolution filter using the kernel
            Kernel kernel = new Kernel(3, 3, sharpenKernel);
            ConvolveOp convolveOp = new ConvolveOp(kernel, ConvolveOp.EDGE_NO_OP, null);
            BufferedImage outputImage = convolveOp.filter(image, null);

            // Save the sharpened image
            File output = new File("output92.jpg");
            ImageIO.write(outputImage, "jpg", output);

            System.out.println("Sharpening applied successfully!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
