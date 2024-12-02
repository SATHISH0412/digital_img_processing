import java.io.File;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.awt.image.Kernel;
import java.awt.image.ConvolveOp;


public class sharpen {

    public static void main(String[] args) {
try {
    
    BufferedImage img = ImageIO.read(new File("images.jpg"));
    System.out.println("read successfull");

    float[] smoothening={
        1/9f,1/9f,1/9f,1/9f,1/9f,1/9f,1/9f,1/9f,1/9f
    };

  
    Kernel kernel = new Kernel(3, 3, smoothening);
    ConvolveOp convolveOp = new ConvolveOp(kernel, ConvolveOp.EDGE_NO_OP, null);
    BufferedImage outputImage = convolveOp.filter(img, null);


    ImageIO.write(outputImage, "png", new File("sharpen.jpg"));
    System.out.println("success");
} 

catch (Exception e) {
    System.out.println(e);
        
    }
}
}