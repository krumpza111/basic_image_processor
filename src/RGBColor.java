/**
 * Represents colors as red, green, blue integers
 */
public class RGBColor {
    private final int red, green, blue;

    public RGBColor(int red, int green, int blue) {
        this.red = clamp(red);
        this.green = clamp(green);
        this.blue = clamp(blue);
    }

    public int getRed() {
        return red;
    }

    public int getGreen() {
        return green;
    }

    public int getBlue() {
        return blue;
    }

    @Override
    /**
     * Represents color as a string
     */
    public String toString() {
        return "(" + red + ", " + green + ", " + blue + ")";
    }

    @Override
    /**
     * Checks if two colors are equal
     */
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RGBColor rgbColor = (RGBColor) o;
        return red == rgbColor.red && green == rgbColor.green && blue == rgbColor.blue;
    }

    /**
     * Color values need to be restricted between 0 and 255, this functions ensures they remain in this range
     * @param colorVal red, green, or blue color value
     * @return min/max of 0 to 255 range
     */
    public static int clamp(int colorVal) {
        if (colorVal < 0) {
            return 0;
        } else if (colorVal > 255) {
            return 255;
        } else {
            return colorVal;
        }
    }

    /**
     * Compute "distance" between two colors
     * Note: Only an approcimation -- good enough for representing relationships between colors
     * @param c1 a (non-null) RGBColor
     * @param c2 a (non-null) RGBColor
     * @return a distance value greater than zero. If two numbers equal each other the function will return 0,
     *          smaller values mean colors are more similar, larger values and less similar
     */
    public static double distance(RGBColor c1, RGBColor c2) {
        return Math.sqrt(Math.pow(c1.red - c2.red, 2) + Math.pow(c1.green - c2.green, 2) + Math.pow(c1.blue - c2.blue, 2));
    }

    /**
     * Cleans array, removing all null values from the array
     * @param colors - RGBColor array
     * @return RGBColor array that has no null values
     */
    public static RGBColor[] cleaner(RGBColor [] colors) {
        RGBColor [] fixedArray = new RGBColor[0];
        for (int i = 0; i < colors.length; i++) {
            if (colors[i] == null) {
                RGBColor [] newArray = new RGBColor[i];
                for (int j = 0; j < i; j++) {
                    newArray[j] = colors[j];
                }
                fixedArray = newArray;
                i = colors.length;
            }
        }
        return fixedArray;
    }
}
