package View;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.advanced.*;

/**
 * The class allows the program to play music continuously while the game is played on a thread
 * @see AdvancedPlayer This method allows us to continuously play the music, whereas the standard Player did not
 */

public class MusicPlayer extends Thread
{
	private String m_filename;
	public AdvancedPlayer m_player;

	/**
	 *
	 * @param filename The string name for the location of the audio file that will contain the background music
	 *                 for the game
	 * Changes the file name of the current MusicPlayer to be that of the game audio
	 */
	public MusicPlayer(String filename)
	{
		this.m_filename = filename;
	}


	public void play()
	{
		boolean[] main = {true};
		/**
		 * Starts the thread that will hold the music playing process, Allows the music to play whilst
		 * the game is being carried out
		 */
		new Thread()
		{
			@Override
			public void run()
			{
				super.run();
				
				if(m_filename == "src/main/resources/frogger.mp3") {
					try {
						do {
							FileInputStream buff = new FileInputStream(m_filename);
							m_player = new AdvancedPlayer(buff);
							m_player.play();
						}
						while (true);

					} catch (Exception e) {
						System.out.println(e);
					}
				} else if (m_filename == "src/main/resources/point.mp3"){


					FileInputStream buff = null;
					try {
						buff = new FileInputStream(m_filename);
					} catch (FileNotFoundException e) {
						throw new RuntimeException(e);
					}
					try {
						m_player = new AdvancedPlayer(buff);
					} catch (JavaLayerException e) {
						throw new RuntimeException(e);
					}
					try {
						m_player.play();
					} catch (JavaLayerException e) {
						throw new RuntimeException(e);
					}
				}

			}
		}.start();
	}

	/**
	 * Initialises this instance of the music. Can be used for point winning
	 * or for the background theme.
	 * Renamed from 'getMusicPlay' as it is not a getter
	 * @param filename This is the string that holds the filepath of the audio file
	 */

	public static void makeMusicPlay(String filename)
	{
		MusicPlayer musicPlayer = new MusicPlayer(filename);
		musicPlayer.play();
	}
}
