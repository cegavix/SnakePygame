package Controller;

import Model.FoodModel;
import Model.SnakeModel;
import View.MusicPlayer;
import View.FrameView;
import Utils.ImageUtil;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.net.MalformedURLException;

/**
 * 
 *  GameController
 * @Description This class initialises FoodModel and SnakeModel
 * @Author Sigurður Sigurðardóttir Modified
 * @version 2.0 Changed name from 'Play' to 'Controller' to better fit MVC Pattern
 */ 

public class GameController extends FrameView implements MouseListener //Used to be play
{
	private SnakeModel.MySnake m_mySnake = new SnakeModel.MySnake(100, 100);
	private FoodModel m_food = new FoodModel();//controller, initialise
	int RECTANGLE_X = 395;
	int RECTANGLE_Y = 300;
	public Rectangle m_playButton = new Rectangle(RECTANGLE_X, RECTANGLE_Y, 100, 50);
	public boolean m_gameState = false;




	@Override
	public void keyPressed(KeyEvent e)
	{
		super.keyPressed(e);
		getM_mySnake().keyPressed(e, getM_mySnake());
	}

	@Override
		public void paint(Graphics g) {
		super.paint(g);
		render(g);

		if(m_gameState == true)
			game(g);
	}
	/**
	 * @Author Constance Vielma
	 * This method loads the start screen for when gamestate is not true.
	 * @param g The graphics painted onto the window included text and a PlayButton
	 */
	public void render(Graphics g)
	{
		Graphics2D g2d = (Graphics2D) g;
		int TITLE_XCOORD = 355;
		int PLAY_X_OFFSET = 20;
		int PLAY_Y_OFFSET = 35;
		g.drawImage(ImageUtil.m_images.get("UI-background2"), 0, 0, null);
		Font fnt0 = new Font("arial",Font.BOLD, 50);
		g.setFont(fnt0);
		g.setColor((Color.black));
		g.drawString("Snakee", TITLE_XCOORD, WINDOW_HEIGHT/2);
		g2d.draw(m_playButton);
		g.setFont(new Font("arial",Font.BOLD, 30));
		g.drawString("Play", m_playButton.x + PLAY_X_OFFSET , m_playButton.y + PLAY_Y_OFFSET);
	}
	/**
	 * @Author Constance Vielma
	 * This method loads the graphics for the gameState. It is only called when gameState is true.
	 * @param g The graphics painted onto the window.
	 */
	public void game(Graphics g){
		g.drawImage(ImageUtil.m_images.get("UI-background"), 0, 0, null); //view


		if (getM_mySnake().isExists()) //if snake is not dead,
		{
			getM_mySnake().draw(g); //draw snake,from controller
			if (getM_food().isExists()) //if food exists
			{
				getM_food().draw(g);
				getM_food().eaten(getM_mySnake()); //check if eaten
			} else {
				setM_food(new FoodModel());
			}
		} else {
			Image newImage = ImageUtil.m_images.get("end-Scene");
			Image buff = newImage.getScaledInstance(WINDOW_WIDTH, WINDOW_HEIGHT, Image.SCALE_DEFAULT);
			g.drawImage(buff, 0, 0, null);
			MusicPlayer.makeMusicPlay("src/main/resources/gameover.mp3");
		}
		drawScore(g);
	}

	/** @Author Constance Vielma
	 * @param: Graphics g is the object that displays the 'Score' image and all its attributes
	 * Sets style for the score and gets score for the GameObject
	 */
	public void drawScore(Graphics g) //View
	{

		g.setFont(new Font(Font.SERIF, Font.BOLD, 30));
		g.setColor(Color.GREEN);
		g.drawString("SCORE : " + getM_mySnake().getScore(), 20, 40);
	}

	/**
	 * Getter for snake
	 * @return
	 */
	public SnakeModel.MySnake getM_mySnake() {
		return m_mySnake;
	}
	/**
	 * Setter for snake
	 *
	 */
	public void setM_mySnake(SnakeModel.MySnake m_mySnake) {
		this.m_mySnake = m_mySnake;
	}

	public FoodModel getM_food() {
		return m_food;
	}

	public void setM_food(FoodModel m_food) {
		this.m_food = m_food;
	}
	public void mouseClicked(MouseEvent e) {
		int mx = e.getX();
		int my = e.getY();

		//public Rectangle playButton = new Rectangle(WINDOW_WIDTH/2 - 40, WINDOW_HEIGHT/2 + 20, 100, 50)
		if (mx >= WINDOW_WIDTH/2 - 40 && mx <= WINDOW_WIDTH/2 + 60){
			if(my>= WINDOW_HEIGHT/2 + 20 && my <= WINDOW_HEIGHT/2 +70){
				m_gameState = true;
			}
		}
	}

	/**
	 * @Author Constance Vielma
	 * @param args
	 * Main  prompts user for name and displays their name before calling to load the JFrame for the start screen
	 * and play the music
	 *
	 */
	public static void main(String[] args) {
		String name = JOptionPane.showInputDialog(getInstance(), "Enter player name:");
		JOptionPane.showMessageDialog(null,"Welcome, "+ name + "!","Snakee",1);
		new GameController().loadFrame();
		MusicPlayer.makeMusicPlay("src/main/resources/frogger.mp3");
	}

	@Override
	public void mousePressed(MouseEvent e) {

	}

	@Override
	public void mouseReleased(MouseEvent e) {

	}

	@Override
	public void mouseEntered(MouseEvent e) {

	}

	@Override
	public void mouseExited(MouseEvent e) {

	}


}
