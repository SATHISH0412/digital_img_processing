import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.awt.Graphics2D;
import java.awt.AlphaComposite;

public class foreandback {

    public static void main(String[] args) {

        try {
            BufferedImage fore = ImageIO.read(new File("girl.png"));
            BufferedImage back = ImageIO.read(new File("da.jpg"));


            BufferedImage combined = new BufferedImage(back.getWidth()  , back.getHeight(),BufferedImage.TYPE_INT_RGB);

            Graphics2D g = combined.createGraphics();

            g.drawImage(back,0,0,null);
            g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER,1.0f));
            g.drawImage(fore, 100,50, null);
            g.dispose();


            ImageIO.write(combined, "png", new File("combine.png"));
            System.out.println("write success");

        } catch (IOException e) {

            System.out.println(e);
        }

    }
}