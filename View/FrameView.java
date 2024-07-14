package View;

import Utils.ImageUtil;

import java.awt.event.*;


import javax.swing.*;

/**
 * 
 * @Project MyFrame
 * @Description This  class implements and initialises MyFrame window alongside its thread for the JFrame.
 * @Author Sigurður Sigurðardóttir & Constance Vielma
 * @version Ekki viss
 */ 


public class FrameView extends JPanel implements KeyListener
{

	private static JFrame window;
	/**
 * This method creates the JFrame window using the singleton pattern to
 * ensure limited access to the frame throughout the Snake application.
 * @return window This returns the only instance of the JFrame window,
 * either by instantiating it for the first time or returning the existing instance/
 */
	public static JFrame getInstance(){

		if(window == null) {
			window = new JFrame();
		}
		return window;
	}

	public static final int WINDOW_WIDTH = 870;
	public static final int WINDOW_HEIGHT = 560;


	public FrameView()
	{
		/**Sets the icon to be snake-logo. Note this doesn't work on MacOS,
		 * but does on Windows.
		 */
		getInstance().setIconImage(ImageUtil.m_images.get("Snake-logo")); //CONVENTION 3 Violation: Fixed
	}
	/**
	 * This method adds JFrame layout information using getInstance()
	 * to retrieve the initialised frame and makes the frame visible
	 * It also calls to the thread to allow for the JVM to perform tasks
	 * while having the window open
	 *Adds listener for Window to close, for keys to be pressed and for start button.
	 */
	public void loadFrame() {

		this.setDoubleBuffered(true);
		getInstance().add(this);
		getInstance().addKeyListener(this);
		getInstance().addMouseListener((MouseListener) this);
		getInstance().setTitle("Snakee");
		getInstance().setSize(WINDOW_WIDTH,WINDOW_HEIGHT); //doc: Fixed magic numbers
		getInstance().setLocationRelativeTo(null);

		getInstance().addWindowListener(new WindowAdapter() //for window closing
		{
			@Override
			public void windowClosing(WindowEvent e)
			{
				super.windowClosing(e);
				System.exit(0);
			}
		});
		getInstance().setIconImage(ImageUtil.m_images.get("Snake-logo"));
		getInstance().setVisible(true);
		new MyThread().start();

	}


	/**
	 * Sets up thread to paint the window to ensure sure window is always open while
	 * other tasks can be performed. If the thread is interrupted for whatever reason the
	 * method catches the exception.
	 *
	 */
	class MyThread extends Thread
	{
		@Override
		public void run()
		{
			super.run();
			while (true)
			{
				repaint();
				try
				{
					sleep(30); //gives other thread opportunity
				} catch (Exception e)
				{
					e.printStackTrace();
				}
			}
		}
	}



	@Override
	public void keyTyped(KeyEvent e)
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e)
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void keyReleased(KeyEvent e)
	{
		// TODO Auto-generated method stub

	}


}
