import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;

/**
 * Class for utilities for reading and writing RGBImages
 */
public class RGBImageUtil {
    /**
     * Reads an image from a file
     * @param filename the name and location of the file
     * @return the image
     * @throws RuntimeException -- crashes the code if the file can't be read
     */
    public static RGBImage load(String filename) {
        // Load the image
        BufferedImage img = null;
        try {
            String fullpath = Paths.get(filename).toAbsolutePath().toString();
            System.out.println("Attempting to read file: " + fullpath);
            img = ImageIO.read(new File(fullpath));
        } catch (IOException e) {
            throw new RuntimeException("Cannot load image");
        }

        // RGB Color matrix 'image', uses java libraries to place colors in each pixel
        int width = img.getWidth();
        int height = img.getHeight();
        RGBColor[][] image = new RGBColor[width][height];
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                java.awt.Color c = new java.awt.Color(img.getRGB(x, y));
                RGBColor color = new RGBColor(c.getRed(), c.getGreen(), c.getBlue());
                image[x][y] = color;
            }
        }
        // Return the finished image
        return new RGBImage(image);
    }

    // May or may not work
    public static void showImage(RGBImage img) {
        showImage(getBI(img));
    }

    /**
     * Saves an image
     * Note: MUST be a .png, saves as a .png file
     * @param img the image to save
     * @param filename the filename and location to save
     */
    public static void saveImage(RGBImage img, String filename) {
        try {
            BufferedImage bi = getBI(img);
            String fullpath = Paths.get(filename).toAbsolutePath().toString();
            System.out.println("Attempting to save file");
            File file = new File(fullpath);
            ImageIO.write(bi, "png", file);
        } catch (IOException e) {
            throw new RuntimeException("Error: Couldn't save image");
        }
    }

    /**
     * helper image function for converting between RGBImage and standard java objects
     * @param img Image to be converted
     * @return java object representing the image
     */
    private static BufferedImage getBI(RGBImage img) {
        int width = img.getWidth();
        int height = img.getHeight();
        BufferedImage bi = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                RGBColor color = img.getColor(x, y);
                java.awt.Color c = new java.awt.Color(color.getRed(), color.getGreen(), color.getBlue());
                bi.setRGB(x, y, c.getRGB());
            }
        }
        return bi;
    }

    /**
     * Shows an image
     * Credit to Christopher Collin Hall (website lost)
     */
    private static void showImage(BufferedImage img) {
        JLabel ic = new JLabel(new ImageIcon(img));
        JScrollPane scroller = new JScrollPane(ic);
        JDialog popup = new JDialog();
        popup.getContentPane().setLayout(new FlowLayout());
        popup.getContentPane().add(scroller);
        popup.getContentPane().validate();
        popup.setModal(true);
        popup.pack();
        popup.setVisible(true);
        popup.dispose();
    }
}


