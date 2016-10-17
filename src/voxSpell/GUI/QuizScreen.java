package voxSpell.GUI;

import javax.swing.JPanel;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Font;
import javax.swing.SwingConstants;

import voxSpell.quiz.NewQuiz;
import voxSpell.quiz.Quiz;
import voxSpell.quiz.Settings;

import javax.swing.JTextField;
import java.awt.Insets;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.UIManager;

/**
 * Class representing the quiz screen created for the project
 * Generated GUI with WindowBuilder
 * @author atag549
 *
 */
public class QuizScreen extends JPanel {
	private JTextField spellingBar;
	private JLabel wordNumberLabel;
	private JLabel scoreLabel;
	private JLabel titleLabel ;
	private JButton relisten;
	private JButton submit;
	private String title;
	private Quiz quiz;
	private JButton start;
	private JButton menu;
	private JButton changeVoice;
	/**
	 * Create the panel.
	 */
	public QuizScreen(String title) {
		this.title = "Press Start!";
		GUI.getInstance().getFrame().setSize(800, 600);
		
		setBackground(GUI.background);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{100, 0, 190, 20, 190, 0, 100, 0};
		gridBagLayout.rowHeights = new int[]{30, 40, 20, 0, 0, 0, 50, 50, 50, 0, 10, 0, 30, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		//Title label
		titleLabel = new JLabel(this.title);
		titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		titleLabel.setForeground(GUI.foreground);
		titleLabel.setFont(new Font(GUI.FONT, Font.BOLD, 72));
		GridBagConstraints gbc_titleLabel = new GridBagConstraints();
		gbc_titleLabel.gridwidth = 7;
		gbc_titleLabel.insets = new Insets(0, 0, 5, 0);
		gbc_titleLabel.fill = GridBagConstraints.HORIZONTAL;
		gbc_titleLabel.gridx = 0;
		gbc_titleLabel.gridy = 1;
		add(titleLabel, gbc_titleLabel);
		
		//Label showing what word you're on
		wordNumberLabel = new JLabel("Word 1 of " + Settings.getInstance().getQuizSize());
		wordNumberLabel.setHorizontalAlignment(SwingConstants.CENTER);
		wordNumberLabel.setForeground(GUI.foreground);
		wordNumberLabel.setFont(new Font(GUI.FONT, Font.PLAIN, 36));
		GridBagConstraints gbc_wordNumberLabel = new GridBagConstraints();
		gbc_wordNumberLabel.fill = GridBagConstraints.HORIZONTAL;
		gbc_wordNumberLabel.gridwidth = 7;
		gbc_wordNumberLabel.insets = new Insets(0, 0, 5, 0);
		gbc_wordNumberLabel.gridx = 0;
		gbc_wordNumberLabel.gridy = 3;
		add(wordNumberLabel, gbc_wordNumberLabel);
		
		scoreLabel = new JLabel("Score: 0");
		scoreLabel.setHorizontalAlignment(SwingConstants.CENTER);
		scoreLabel.setForeground(GUI.foreground);
		scoreLabel.setFont(new Font(GUI.FONT, Font.PLAIN, 36));
		GridBagConstraints gbc_scoreLabel = new GridBagConstraints();
		gbc_scoreLabel.fill = GridBagConstraints.HORIZONTAL;
		gbc_scoreLabel.gridwidth = 7;
		gbc_scoreLabel.insets = new Insets(0, 0, 5, 0);
		gbc_scoreLabel.gridx = 0;
		gbc_scoreLabel.gridy = 5;
		add(scoreLabel, gbc_scoreLabel);
		
		start = new JButton("START");
		start.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				enableButtons();
				start.setEnabled(false);
				start.setVisible(false);
				setUp("New Quiz");
			}
		});
		start.setFont(new Font("Century Schoolbook L", Font.PLAIN, 28));
		start.setBackground(new Color(102, 0, 51));
		start.setForeground(Color.WHITE);
		GridBagConstraints gbc_menu = new GridBagConstraints();
		gbc_menu.fill = GridBagConstraints.HORIZONTAL;
		gbc_menu.gridwidth = 7;
		gbc_menu.insets = new Insets(0, 0, 5, 0);
		gbc_menu.gridx = 0;
		gbc_menu.gridy = 6;
		add(start, gbc_menu);
		//Spelling JTextField
		spellingBar = new JTextField();
		spellingBar.setFont(new Font("Dialog", Font.PLAIN, 20));
		GridBagConstraints gbc_spellingBar = new GridBagConstraints();
		gbc_spellingBar.gridwidth = 4;
		gbc_spellingBar.insets = new Insets(0, 0, 5, 5);
		gbc_spellingBar.fill = GridBagConstraints.BOTH;
		gbc_spellingBar.gridx = 1;
		gbc_spellingBar.gridy = 7;
		add(spellingBar, gbc_spellingBar);
		spellingBar.setColumns(10);
		//Relisten Button
		relisten = new JButton("Relisten");
		relisten.setBackground(GUI.background);
		relisten.setIcon(new ImageIcon(GUI.PATH + "/sound.png"));
		relisten.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				quiz.sayWord();
			}
		});
		relisten.setForeground(GUI.foreground);
		relisten.setFont(new Font(GUI.FONT, Font.PLAIN, 28));
		GridBagConstraints gbc_relisten = new GridBagConstraints();
		gbc_relisten.fill = GridBagConstraints.BOTH;
		gbc_relisten.insets = new Insets(0, 0, 5, 5);
		gbc_relisten.gridx = 5;
		gbc_relisten.gridy = 7;
		add(relisten, gbc_relisten);
		
		//Submit Button
		submit = new JButton("Submit");
		submit.setBackground(GUI.background);
		submit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				quiz.checkSpelling(spellingBar.getText());
				spellingBar.setText("");
				start.setEnabled(false);
				start.setVisible(false);
			}
		});
		GUI.getInstance().getFrame().getRootPane().setDefaultButton(submit);
		submit.setForeground(GUI.foreground);
		submit.setFont(new Font(GUI.FONT, Font.PLAIN, 28));
		GridBagConstraints gbc_submit = new GridBagConstraints();
		gbc_submit.gridwidth = 5;
		gbc_submit.fill = GridBagConstraints.HORIZONTAL;
		gbc_submit.insets = new Insets(0, 0, 5, 5);
		gbc_submit.gridx = 1;
		gbc_submit.gridy = 9;
		add(submit, gbc_submit);
		
		//Back to Menu button
		menu = new JButton("Back to Menu");
		menu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GUI.getInstance().setContentPane(new MainMenu());
			}
		});
		menu.setForeground(GUI.foreground);
		menu.setFont(new Font(GUI.FONT, Font.PLAIN, 28));
		menu.setBackground(GUI.background);
		gbc_menu = new GridBagConstraints();
		gbc_menu.insets = new Insets(0, 0, 5, 5);
		gbc_menu.gridx = 2;
		gbc_menu.gridy = 11;
		add(menu, gbc_menu);
		
		//Change voice button
		changeVoice = new JButton("Change Voice");
		changeVoice.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Options(quiz).setVisible(true);
			}
		});
		changeVoice.setForeground(GUI.foreground);
		changeVoice.setFont(new Font(GUI.FONT, Font.PLAIN, 28));
		changeVoice.setBackground(GUI.background);
		GridBagConstraints gbc_changeVoice = new GridBagConstraints();
		gbc_changeVoice.insets = new Insets(0, 0, 5, 5);
		gbc_changeVoice.gridx = 4;
		gbc_changeVoice.gridy = 11;
		add(changeVoice, gbc_changeVoice);
		disableButtons();
	}
	/**
	 * Code that sets up all the things for this UI, from Assignments 3 and 2
	 */
	private void setUp(String title){
		this.title = title;
		titleLabel.setText(this.title);
		quiz = new NewQuiz(this);
		quiz.sayWord();
		
	}
	/**
	 * Updates the word number you are on in the given quiz
	 * @param number
	 * @param total
	 */
	public void updateWordNumber(int number, int total){
		wordNumberLabel.setText("Word " + number+ " of " + (quiz.getNumberOfWords()));
	}
	public void updateScore(int score){
		scoreLabel.setText("Score: " + score);
	}
	public void disableButtons(){
		submit.setEnabled(false);
		relisten.setEnabled(false);
	}
	public void enableButtons(){
		submit.setEnabled(true);
		relisten.setEnabled(true);
	}
	public void endQuiz(){
		GUI.getInstance().setContentPane(new EndOfQuiz(quiz));
	}


}