/**
 * Class that defines the border transformation, a colored border added onto the image matrix
 */
public class AddBorder extends Transformation{
    private int width;
    private RGBColor borderColor;

    /**
     * Constructor -- Default constructor, makes a non-exsistant border
     */
    public AddBorder() {
        width = 0;
        borderColor = null;
    }

    /**
     * Contructor -- Used when given user inputted width and color value
     * @param width width/thickness of the border
     * @param borderColor RGBColor value to become the border's color
     */
    public AddBorder(int width, RGBColor borderColor) {
        this.width = width;
        this.borderColor = borderColor;
    }

    public int getWidth() {
        return this.width;
    }

    public RGBColor getBorderColor() {
        return this.borderColor;
    }

    /**
     * Transform subclass that 7
     * @param x -- x position
     * @param y -- y position
     * @param originalColor -- original RGB value in the image
     * @param image -- Image being converted, most transformations don't need this if they don't require image dimensions
     * @return converted color value
     */
    protected RGBColor do_transform(int x, int y, RGBColor originalColor, RGBImage image) {
        if((x < this.width || x >= image.getWidth() - this.width) || (y < this.width || y >= image.getWidth() - this.width)) {
            return borderColor;
        }
        return new RGBColor(originalColor.getRed(), originalColor.getGreen(), originalColor.getBlue());
    }
}
