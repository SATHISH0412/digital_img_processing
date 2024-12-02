
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import java.util.LinkedList;
import java.util.Queue;

public class RegionGrowing {

    public static void main(String[] args) {
        try {
            BufferedImage input = ImageIO.read(new File("girl.png"));
            int w = input.getWidth(), h = input.getHeight(), seedX = 50, seedY = 50, threshold = 20;

            BufferedImage output = new BufferedImage(w, h, BufferedImage.TYPE_BYTE_GRAY);
            boolean[][] visited = new boolean[w][h];
            int seedIntensity = new Color(input.getRGB(seedX, seedY)).getRed();

            Queue<int[]> queue = new LinkedList<>();
            queue.add(new int[]{seedX, seedY});
            visited[seedX][seedY] = true;

            int[] dx = {0, 0, -1, 1}, dy = {-1, 1, 0, 0};
            while (!queue.isEmpty()) {
                int[] pixel = queue.poll();
                output.setRGB(pixel[0], pixel[1], Color.WHITE.getRGB());
                for (int i = 0; i < 4; i++) {
                    int x = pixel[0] + dx[i], y = pixel[1] + dy[i];
                    if (x >= 0 && x < w && y >= 0 && y < h && !visited[x][y]) {
                        int intensity = new Color(input.getRGB(x, y)).getRed();
                        if (Math.abs(intensity - seedIntensity) <= threshold) {
                            queue.add(new int[]{x, y});
                            visited[x][y] = true;
                        }
                    }
                }
            }

            ImageIO.write(output, "png", new File("region_grown_output.png"));
            System.out.println("Output saved as region_grown_output.png");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
