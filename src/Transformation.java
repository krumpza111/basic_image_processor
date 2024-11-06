/**
 * Parent class for other transformations
 */
public class Transformation {

    /**
     * Create a new image based on the provided RGBImage which will include the transformation.
     * The transformation image will have its rgb values altered
     * Subclasses redefine the transformation to take effect
     * @param image
     * @return
     */
    public RGBImage transform(RGBImage image) {
        RGBImage retVal = new RGBImage(image.getWidth(), image.getHeight());
        System.out.println(image.getHeight());
        System.out.println(image.getWidth());
        for ( int x = 0; x < image.getWidth(); x++) {
            for (int y = 0; y < image.getHeight(); y++) {
                retVal.setColor(x, y, do_transform(x, y, image.getColor(x, y), image));
            }
        }
        return retVal;
    }

    /**
     * Defines a transformation
     * @param x -- x position
     * @param y -- y position
     * @param originalColor -- original RGB value in the image
     * @param image -- Image being converted, most transformations don't need this if they don't require image dimensions
     * @return the new color for this location in the image
     */
    protected RGBColor do_transform(int x, int y, RGBColor originalColor, RGBImage image) {
        return new RGBColor(originalColor.getGreen(), originalColor.getBlue(), originalColor.getRed());
    }
}
