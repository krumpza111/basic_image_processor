/**
 * Class that represents an image as a 2d matrix of RGB values
 */
public class RGBImage {
    private RGBColor[][] data;

    /**
     * Constructor -- used when you already haev image data
     * @param data 2d image matrix
     */
    public RGBImage(RGBColor[][] data) {
        this.data = data;
    }

    /**
     * Constructor -- used to request a copy of an image
     * Note: Image will be fully separate from the original image
     * @param other RGBImage to be copied
     */
    public RGBImage(RGBImage other) {
        this.data = new RGBColor[other.getWidth()][other.getHeight()];
        for (int x = 0; x < getWidth(); x++) {
            for (int y = 0; y < getHeight(); y++) {
                setColor(x, y, other.getColor(x, y));
            }
        }
    }

    /**
     * Creates an empty image (all black)
     * @param width width of image (int)
     * @param height height of image (int)
     */
    public RGBImage(int width, int height) {
        RGBColor black = new RGBColor(0, 0, 0);
        this.data = new RGBColor[width][height];
        for (int x = 0; x < getWidth(); x++) {
            for (int y = 0; y < getHeight(); y++) {
                setColor(x, y, black);
            }
        }
    }

    /**
     * gets the width of the image
     */
    public int getWidth() {
        return data.length;
    }

    /**
     * gets the height of the image
     */
    public int getHeight() {
        return data[0].length;
    }

    /**
     * get the color at a given (x, y) coordinate in the image data
     * @param x an integer representing horizontal position
     * @param y an integer representing vertical position
     * @return an RGBColor indicating the color at specified (x, y) position
     */
    public RGBColor getColor(int x, int y) {
        /*if (0 <= x && x < getWidth() && 0 <= y && y < getHeight()) {
            return data[x][y];
        } else {
            return null;
        } */
        return data[x][y];
    }

    /**
     * Change color at given positioning
     * If invalid x, y values are given the image will not change
     * @param x an integer representing horizontal position
     * @param y an integer representing vertical position
     * @param color Color to be changed to
     */
    public void setColor(int x, int y, RGBColor color) {
        if (0 <= x && x < getWidth() && 0 <= y && y < getHeight()) {
            data[x][y] = color;
        }
    }
}
