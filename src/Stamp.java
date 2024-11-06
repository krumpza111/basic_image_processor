/**
 * Class which defines the Stamp transformation, an image that is placed "on top" of the original iamge
 */
public class Stamp extends Transformation{
    private RGBImage toStamp;
    public Stamp (RGBImage toStamp) {
        this.toStamp = toStamp;
    }

    public RGBImage getToStamp () {
        return this.toStamp;
    }

    /**
     * Takes x any y positional values, an RGB color, and RGB image and places a "stamp" (image) on top of the original
     *  image at the given coordinates
      */
    protected RGBColor do_transform(int x, int y, RGBColor originalColor, RGBImage image) {
        if (x < toStamp.getWidth() && y < toStamp.getHeight()) {
            int red = (originalColor.getRed() + toStamp.getColor(x, y).getRed()) / 2;
            int green = (originalColor.getGreen() + toStamp.getColor(x, y).getGreen()) / 2;
            int blue = (originalColor.getBlue() + toStamp.getColor(x, y).getBlue()) / 2;
            return new RGBColor(red, green, blue);
        }
        return new RGBColor(originalColor.getRed(), originalColor.getGreen(), originalColor.getBlue());
    }
}
