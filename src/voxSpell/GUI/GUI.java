package voxSpell.GUI;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.File;

import javax.swing.JFrame;
import javax.swing.JLabel;

import voxSpell.quiz.Lists;
import voxSpell.quiz.Settings;

//import voxSpell.quiz.Lists;

/**
 * Assignment 2 for Softeng 206- creating a GUI spelling aid
 * Updated for assignment 3 (so we don't save word lists we can't really use)
 * 
 * @author atag549
 * Modified 21 September, 2016
 *
 */

//Must also be able to tell when the window is closing to save everything from the GUI
public class GUI implements WindowListener{
	public static final String PATH = new File(System.getProperty("java.class.path")).getAbsoluteFile().getParentFile().toString() + "/.media";
	public static int NUMBER_OF_LEVELS;
	private static Dimension _frameSize;
	private static int _level;
	protected static final String FONT="Century Schoolbook L";
	protected static Color background = new Color(51, 0, 51);
	protected static Color foreground = new Color(204, 204, 204);

	//From: http://stackoverflow.com/questions/7140248/get-system-default-font
	public static final Font TITLE_FONT = new Font(new JLabel().getName(), 1, 20);
	private JFrame _frame = null;
	private static GUI _gui = null;
	public static void main(String[] args) {
		//Schedule a job for the event-dispatching thread:
		//creating and showing this application's GUI.	
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				GUI.getInstance().createAndShowGUI();
			}
		});
	}
	/**
	 * Private constructor for singleton GUI class
	 */
	private GUI(){
		//Create and set up the window.
		Lists.getInstance().setWordList(new File(PATH+"/sample-words.txt"));
		Settings.getInstance();
		_frame = new JFrame("VOXSPELL");
		_frame.setResizable(false);
		_frame.addWindowListener(this);
		_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		NUMBER_OF_LEVELS=Lists.getInstance().getNumberOfLevels();
	}
	/**
	 * Switches the theme from light to dark
	 */
	protected void changeTheme(){
		Color temp = background;
		background  = foreground;
		foreground = temp;
	}
	
	protected void setLevel(int level){
		_level = level;
	}
	private void createAndShowGUI() {
		//Set up the content pane.
		_frameSize = new Dimension(800,500);
		_frame.setSize(_frameSize);
		_frame.setVisible(true);
		setContentPane(new MainMenu());

	}
	public static int getLevel(){
		return _level;
	}
	public static void increaseLevel(){
		_level++;
	}
	public static GUI getInstance(){
		if (_gui == null){
			_gui = new GUI();
		}
		return _gui;
	}
	public static Dimension getFrameSize(){
		return _frameSize;
	}
	protected JFrame getFrame(){
		return _frame;
	}
	protected void setContentPane(Container c){
		/*if(c instanceof MainMenu){
			_frame.setSize(1000, 500);
		}else{		
			_frame.setSize(800, 600);
		}*/
		_frame.getContentPane().removeAll();
		_frame.setLocation(5, 5);
		_frame.setContentPane(c);
		_frame.pack();
	}

	@Override
	public void windowActivated(WindowEvent arg0) {
		// TODO Auto-generated method stub

	}
	@Override
	public void windowClosing(WindowEvent arg0) {
		Lists.getInstance().writeAllStats();
	}
	@Override
	public void windowDeactivated(WindowEvent arg0) {
		// TODO Auto-generated method stub

	}
	@Override
	public void windowDeiconified(WindowEvent arg0) {
		// TODO Auto-generated method stub

	}
	@Override
	public void windowIconified(WindowEvent arg0) {
		// TODO Auto-generated method stub

	}
	@Override
	public void windowOpened(WindowEvent arg0) {
		// TODO Auto-generated method stub

	}
	@Override
	public void windowClosed(WindowEvent e) {		
	}


}
