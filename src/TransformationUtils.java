public class TransformationUtils {
    /**
     * Utility to produce multiple transformations on the same image
     */
    public static void transformMany(Transformation [] transformations, RGBImage image, String outputFile) {
        for (int i = 0; i < transformations.length; i++) {
            image = transformations[i].transform(image);
        }
        RGBImageUtil.saveImage(image, outputFile);
    }

    /**
     * Cleaner function that strips all null values from the transformations array
     */
    public static Transformation[] cleaner(Transformation [] transformations) {
        Transformation [] fixedArray = new Transformation[0];
        for (int i = 0; i < transformations.length; i++) {
            if (transformations[i] == null) {
                Transformation [] newArray = new Transformation[i];
                for (int j = 0; j < i; j++) {
                    newArray[j] = transformations[j];
                }
                fixedArray = newArray;
                i = transformations.length;
            }
        }
        return fixedArray;
    }
}
