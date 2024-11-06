/**
 * Class that defines a color pallete, an array of RGBColors that alllows the user to alter the colors of the image and
 *  even create image filters
 */
public class ColorPallet extends Transformation {
    private RGBColor[] pallet;

    /**
     * Constructor -- used to set up the RGBColor array
     * @param pallet RGBColor array for colors the user wants to change the image to
     */
    public ColorPallet(RGBColor[] pallet) {
        this.pallet = pallet;
    }

    public RGBColor[] getPallet() {
        return this.pallet;
    }

    @Override
    /**
     * Subclass that alters the images colors by calculating which color is closest to a given pellete color and selecting
     *  that one to maintain the same relational structure from the original image
     */
    protected RGBColor do_transform(int x, int y, RGBColor originalColor, RGBImage image) {
        RGBColor closest = this.pallet[0];
        for (int color = 1; color < pallet.length; color++) {
            if (RGBColor.distance(originalColor, pallet[color]) < RGBColor.distance(originalColor, closest)) {
                closest = pallet[color];
            }
        }
        return closest;
    }
}
