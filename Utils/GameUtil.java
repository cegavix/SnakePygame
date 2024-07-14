package Utils;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.net.URL;

import javax.imageio.ImageIO;

/**
 * This class handles the images appearance to allow for the appearance of a
 * rotating snake
 */
public class GameUtil
{
	/**
	 * This rotates the image
	 * @param bufferedImage the image which it is rotating
	 * @param degree amount by which to rotate bufferedImage
	 * @return the image that the method has rotated
	 */
	public static Image rotateImage(final BufferedImage bufferedImage, final int degree)
	{
	int w = bufferedImage.getWidth();
	int h = bufferedImage.getHeight();
	int t = bufferedImage.getColorModel().getTransparency();

	BufferedImage i;
	Graphics2D graphics2d;


	graphics2d = (i = new BufferedImage(w, h, t)).createGraphics();
	graphics2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);

	graphics2d.rotate(Math.toRadians(degree), w / 2, h / 2);
	graphics2d.drawImage(bufferedImage, 0, 0, null);
	graphics2d.dispose();

	return i;

	}
}
