Basic java implementation of an Image Processor
It takes an image from the user and converts it into a 2d arrray housing the rgb color of each pixel that we can then manipulate.
A given set of images are included to conveniently test the application. 

Description of Classes:
RGBColor -> RGB color utils for color values 0 - 255.
RGBImage -> Image class for RGBImage constructor, getter and setter methods.
RGBImageUtils -> RGBImage utility functions for loading images into a RGBColor array using awt.color, saving the image, and displaying the image from a buffer.
Transformation -> Main class for initiating transformations on an RGBImage by transforming the RGBColor at each cell/pixel in the array.
TransformationUtils -> Utilities for the Transformation class. Includes transform many for multiple edits at once, and a cleaner function. 

Transformation Classes (extends transformation):
AddBorder: Takes a width and color as input and adds a border to the image.
Brighten: Changes the brightness of an image.
ColorPallete: Changes the colors to closest match to a given RGBColor array. Equivelent to a user-defined filter. 
Greyscale: Applies grey scale to the image.
Mirror: Vertically flips the image.
MirrorH: Horizontally flips the image.
Stamp: A stamp is another image which will be layered on top of the original image at coordinates given by the user.

