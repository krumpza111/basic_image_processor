import java.util.Scanner;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        int MAX_LIMIT = 10; // Max limits for arrays
        Transformation[] transformations = new Transformation[MAX_LIMIT]; // Transformations to be applied
        int ti = 0; // index keeping track of current transformation

        System.out.println("==================================================================");
        System.out.println("==================================================================");
        System.out.println("|||||||           Welcome to the Java Image Editor         |||||||");
        System.out.println("==================================================================");
        System.out.println("==================================================================");
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println("Type exit at any time to quit");

        Scanner scan = new Scanner(System.in);
        boolean exit = false;

        // Processing input and output files
        System.out.println("Please input the image file now ");
        String inputFile = scan.nextLine();
        if (inputFile.equals("exit")) {
            exit = true;
        }
        String outputFile = "your_" + inputFile;
        RGBImage img = RGBImageUtil.load(inputFile);

        // START OF PROGRAM LOOP
        System.out.println("Please select an option(s) from the menu");
        System.out.println("Press enter to advance ");
        String nextLine = scan.nextLine();
        while(!exit) {
            if (nextLine.equals("exit")) { // Does user want to exit
                exit = true;
                break;
            }
            if (ti > MAX_LIMIT) { // Is the MAX_LIMIT exceeded?
                System.out.println("Transformation limit reached, sorry. printing resulting image now");
                exit = true;
                break;
            }
            System.out.println("1. Brighten");
            System.out.println("2. Add Border");
            System.out.println("3. Greyscale");
            System.out.println("4. Stamp");
            System.out.println("5. Color Pallet");
            System.out.println("6. Mirror (Vertically)");
            System.out.println("7. Mirror (Horizontally)");
            System.out.println("8. Random");

            // Trying to read input.
            // 1) Make sure input is a number
            // 2) If the user input is a string then ask if they want to exit
            String num = scan.nextLine();
            boolean isInteger = true;
            try {
                int integer = Integer.parseInt(num);
            } catch (NumberFormatException e) {
                isInteger = false;
            }
            int currentCase = 0;
            if (!isInteger) {
                System.out.println("Would you like to exit? Type 'yes' or 'y' now ");
                String userInput = scan.nextLine();
                if (userInput == "yes" || userInput == "y") {
                    exit = true;
                    break;
                }
            } else {
                currentCase = Integer.parseInt(num);
            }

            // User options for transformations
            switch (currentCase) {
                case 1:
                    System.out.println("Please enter the value for brightness level");
                    int bl = scan.nextInt();
                    transformations[ti] = new Brighten(bl);
                    ti++;
                    break;
                case 2:
                    System.out.println("Please enter the border width you would like");
                    int w = scan.nextInt();
                    System.out.println("Now please enter the RGB values for the color of border");
                    System.out.print("Red: ");
                    int r = scan.nextInt();
                    System.out.print("Green: ");
                    int g = scan.nextInt();
                    System.out.print("Blue: ");
                    int b = scan.nextInt();
                    transformations[ti] = new AddBorder(w, new RGBColor(r, g, b));
                    ti++;
                    break;
                case 3:
                        System.out.println("Applying greyscale");
                        transformations[ti] = new Greyscale();
                        ti++;
                        break;
                case 4:
                        System.out.println("Please enter the image file you want to use for the stamp");
                        String stampFile = scan.nextLine();
                        transformations[ti] = new Stamp(RGBImageUtil.load(stampFile));
                        ti++;
                        break;
                case 5:
                    RGBColor [] newPallete = new RGBColor[MAX_LIMIT];
                    int i = 0;
                    System.out.println("Please enter the colors to add to the color pallet you wish to create. Please ensure correct values and maybe use outside resources like w3schools.com");
                    Boolean addColorPallete = true;
                    while(addColorPallete) {
                        System.out.println("Enter red value: ");
                        int red_value = scan.nextInt();
                        System.out.println("Enter green value: ");
                        int green_value = scan.nextInt();
                        System.out.println("Enter blue value: ");
                        int blue_value = scan.nextInt();
                        newPallete[i] = new RGBColor(red_value, green_value, blue_value);
                        i++;
                        System.out.println("Succsessfully added color! Do you want to add another color? Enter yes or no");
                        String userResponse = scan.nextLine();
                        if (userResponse != "yes" || userResponse != "y") {
                            addColorPallete = false;
                        }
                    }
                    newPallete = RGBColor.cleaner(newPallete);
                    transformations[ti] = new ColorPallet(newPallete);
                    break;
                case 6:
                    System.out.println("Mirroring image vertically now");
                    transformations[ti] = new Mirror(img);
                    ti++;
                    break;
                case 7:
                    System.out.println("Mirroring image horizontally now");
                    transformations[ti] = new MirrorH(img);
                    ti++;
                    break;
                case 8:
                    System.out.println("Applying random transformation");
                    Random rand = new Random();
                    int casenumber = rand.nextInt(5);
                    int width = rand.nextInt(80);
                    int red = rand.nextInt(256);
                    int green = rand.nextInt(256);
                    int blue = rand.nextInt(256);
                    int brightnesslevel = rand.nextInt(100 + 100) - 100; //Suppossed to go from range (-100 to 100)
                    switch (casenumber) {
                        case 1:
                            transformations[ti] = new Brighten(brightnesslevel);
                            ti++;
                            break;
                        case 2:
                            transformations[ti] = new AddBorder(width, new RGBColor(red, green, blue));
                            ti++;
                            break;
                        case 3:
                            transformations[ti] = new Greyscale();
                            ti++;
                            break;
                        case 4:
                            transformations[ti] = new ColorPallet(new RGBColor[]{new RGBColor (red, green, blue)});
                            ti++;
                            break;
                    }
                    break;
                default:
                    System.out.println("Have a good day!");
                    exit = true;
                    break;
                }
            }
        // Applies transformations used the transformMany function, will return a new image
        transformations = TransformationUtils.cleaner(transformations);
        TransformationUtils.transformMany(transformations, img, outputFile);
    }
}
