package Utils;


import javax.imageio.ImageIO;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

/**
 * This class manages the images used in game and loads them from memory into a hashmap.
 */
public class ImageUtil
{
	public static Map<String, Image> m_images = new HashMap<>();
	public static Image getImage(String imagePath)
	{
		URL u = GameUtil.class.getClassLoader().getResource(imagePath);
		BufferedImage i = null;
		try
		{
			i = ImageIO.read(u);
		} catch (Exception e)
		{
			System.err.println("ERROR: Image not found !\n");
			e.printStackTrace();
		}

		return i;
	}

	static
	{
		// snake
		m_images.put("snake-head-right", getImage("snake-head-right.png"));
		m_images.put("snake-body", getImage("snake-body.png"));

		// obstacles
		m_images.put("0", getImage("food-kiwi.png"));
		m_images.put("1", getImage("food-lemon.png"));
		m_images.put("2", getImage("food-litchi.png"));
		m_images.put("3", getImage("food-mango.png"));
		m_images.put("4", getImage("food-apple.png"));
		m_images.put("5", getImage("food-banana.png"));
		m_images.put("6", getImage("food-blueberry.png"));
		m_images.put("7", getImage("food-cherry.png"));
		m_images.put("8",getImage("food-durian.png"));
		m_images.put("9", getImage("food-grape.png"));
		m_images.put("10", getImage("food-grapefruit.png"));
		m_images.put("11", getImage("food-peach.png"));
		m_images.put("12", getImage("food-pear.png"));
		m_images.put("13", getImage("food-orange.png"));
		m_images.put("14", getImage("food-pineapple.png"));
		m_images.put("15", getImage("food-strawberry.png"));
		m_images.put("16", getImage("food-watermelon.png"));
		//MyFrame layout and images

		m_images.put("Snake-logo", getImage("snakelogo.png")); //doc: Added
		m_images.put("UI-background", getImage("UI-background.png"));
		m_images.put("UI-background2", getImage("UI-background2.png")); //doc: ADDITION
		m_images.put("end-Scene", getImage("game-scene-01.jpg"));//doc: VIOLATION 3 Fixed.


	}
}
