import java.lang.Math;

/**
 * Class representing a vertically mirrored image
 */
public class Mirror extends Transformation{

    private RGBImage mirror;

    /**
     * Constructor -- used to make  RGBImage with the same width and height as the original
     */
    public Mirror (RGBImage image) {
        this.mirror = new RGBImage(image.getWidth(), image.getHeight());
    }

    public RGBImage getMirror () {
        return this.mirror;
    }

    @Override
    /**
     * Subclass of transformation which inverses each row while keeping the same x coordinates
     * @param x -- x position, will be reversed
     * @param y -- y position
     * @param originalColor -- original RGB value in the image
     * @param image -- Image being converted, most transformations don't need this if they don't require image dimensions
     * @return mirrored image
     */
    protected RGBColor do_transform(int x, int y, RGBColor originalColor, RGBImage image) {
        int mirroredY = image.getHeight() - 1 - y;
        if (mirroredY < 0 || mirroredY >= image.getWidth()) {
            throw new IllegalArgumentException("Invalid y coordinate");
        }
        mirroredY = Math.abs(mirroredY);
        return image.getColor(x, mirroredY);
    }

}
