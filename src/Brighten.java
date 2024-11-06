/**
 * Class that defines a brightness object which changes the images brightness
 */
public class Brighten extends Transformation {
    private int brightnessLevel;

    //Default Constructor
    public Brighten (){
        brightnessLevel = 0;
    }

    /**
     * Constructor -- used when given user input
     * @param brightnessLevel
     */
    public Brighten (int brightnessLevel) {
        this.brightnessLevel = brightnessLevel;
    }

    public int getBrightness() {
        return this.brightnessLevel;
    }

    @Override
    /**
     * Subclass where the colors in the image are added with the brightness value giving the desired brightness while keeping
     *  color values bounded
     */
    protected RGBColor do_transform(int x, int y, RGBColor originalColor, RGBImage image) {
        int [] colors = {originalColor.getRed() + this.brightnessLevel, originalColor.getGreen() + this.brightnessLevel, originalColor.getBlue() + this.brightnessLevel};
        // Upper and lower limits for color values
        for (int i = 0; i < 3; i++) {
            colors[i] = RGBColor.clamp(colors[i]);
        }
        return new RGBColor(colors[0], colors[1], colors[2]);
    }
}
