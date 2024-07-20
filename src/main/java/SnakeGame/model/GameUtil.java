package SnakeGame.model;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.net.URL;

import javax.imageio.ImageIO;

/**
 * defines two methods controlling basic images getter {@code getImage} and rotation {@code rotateImage}
 * @author: Jiahe Cai-modified
 * @program: SnakeGame
 */
public class GameUtil
{
	/**
	 * This method process the image to bufferedImage so that all images can be processed equally
	 * @param imagePath the path for image
	 * @arthur Jiahe Cai    
	 * @return the bufferedImage corresponding to the imagePath
	 */
	public static Image getImage(String imagePath)
	{
		URL u = GameUtil.class.getResource(imagePath);
		BufferedImage i = null;
		try
		{
			i = ImageIO.read(u);
		} catch (Exception e)
		{
			e.printStackTrace();
		}

		return i;
	}

	/**
	 * This method use graphics 2d to rotate bufferedImage
	 * @param bufferedImage processed image to be rotated
	 * @param degree how much degree to be rotated in clockwise
	 * @return returns the rotated bufferedImage in the specific degree
	 */
	public static Image rotateImage(final BufferedImage bufferedImage, final int degree)
	{
	int w = bufferedImage.getWidth();
	int h = bufferedImage.getHeight();
	int t = bufferedImage.getColorModel().getTransparency();

	BufferedImage i;
	Graphics2D graphics2d;

	(graphics2d = (i = new BufferedImage(w, h, t)).createGraphics()).setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);

	graphics2d.rotate(Math.toRadians(degree), w / 2, h / 2);
	graphics2d.drawImage(bufferedImage, 0, 0, null);
	graphics2d.dispose();

	return i;

	}
}
