import java.lang.Math;

/**
 * Class representing a horizontalaly mirrored image
 */
public class MirrorH extends Transformation {
    private RGBImage mirror;

    /**
     * Constructor -- used to make  RGBImage with the same width and height as the original
     */
    public MirrorH (RGBImage image) {
        this.mirror = new RGBImage(image.getWidth(), image.getHeight());
    }

    public RGBImage getMirror () {
        return this.mirror;
    }

    @Override
    /**
     * Subclass of transformation which inverses each column while keeping the same y coordinates
     * @param x -- x position
     * @param y -- y position, will be reversed
     * @param originalColor -- original RGB value in the image
     * @param image -- Image being converted, most transformations don't need this if they don't require image dimensions
     * @return mirrored image
     */
    protected RGBColor do_transform(int x, int y, RGBColor originalColor, RGBImage image) {
        int mirroredX = image.getWidth() - 1 - x;
        mirroredX = Math.abs(mirroredX);
        return image.getColor(mirroredX, y);
    }
}
