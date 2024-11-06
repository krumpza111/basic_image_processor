public class Greyscale extends Transformation {

    @Override
    /**
     * Subclass that makes all colors greyscale by adding them all together
     */
    protected RGBColor do_transform(int x, int y, RGBColor originalColor, RGBImage image) {
        int grey = originalColor.getRed() + originalColor.getGreen() + originalColor.getBlue();
        return new RGBColor(grey, grey, grey);
    }
}
