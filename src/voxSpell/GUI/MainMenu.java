package voxSpell.GUI;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JToggleButton;

import voxSpell.quiz.Lists;

/**
 * Class representing the main menu written using WindowBuilder for the final assignment of Softeng 206
 * @author atag549
 *
 */
public class MainMenu extends JPanel {

	/**
	 * 
	 */
	private JToggleButton statsButton;
	private JTextArea stats;
	public MainMenu() {
		setBackground(new Color(51, 0, 51));
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{40, 125, 160, 150, 0, 100, 160, 40, 0, 0};
		gridBagLayout.rowHeights = new int[]{30, 0, 0, 30, 0, 30, 0, 30, 0, 100, 0, 30, 40, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel lblNewLabel = new JLabel("ImageHere");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Century Schoolbook L", Font.PLAIN, 18));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 1;
		gbc_lblNewLabel.gridy = 1;
		add(lblNewLabel, gbc_lblNewLabel);
		
		JButton newQuiz = new JButton("New Quiz");
		newQuiz.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GUI.getInstance().setContentPane(new QuizScreen("New Quiz"));
			}
		});
		newQuiz.setForeground(new Color(51, 0, 51));
		newQuiz.setFont(new Font("Century Schoolbook L", Font.PLAIN, 28));
		GridBagConstraints gbc_newQuiz = new GridBagConstraints();
		gbc_newQuiz.gridwidth = 2;
		gbc_newQuiz.fill = GridBagConstraints.HORIZONTAL;
		gbc_newQuiz.insets = new Insets(0, 0, 5, 5);
		gbc_newQuiz.gridx = 5;
		gbc_newQuiz.gridy = 2;
		add(newQuiz, gbc_newQuiz);
		
		JButton review = new JButton("Review");
		review.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GUI.getInstance().setContentPane(new ReviewOptionsScreen());
			}
		});
		review.setForeground(new Color(51, 0, 51));
		review.setFont(new Font("Century Schoolbook L", Font.PLAIN, 28));
		GridBagConstraints gbc_review = new GridBagConstraints();
		gbc_review.fill = GridBagConstraints.HORIZONTAL;
		gbc_review.gridwidth = 2;
		gbc_review.insets = new Insets(0, 0, 5, 5);
		gbc_review.gridx = 5;
		gbc_review.gridy = 4;
		add(review, gbc_review);
		
		JButton achievements = new JButton("Achievements");
		achievements.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		statsButton = new JToggleButton("Show Statistics");
		statsButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(statsButton.isSelected()){
					statsButton.setText("Hide Statistics");
					showStats();
				} else{
					statsButton.setText("Show Statistics");
					stats.setText("");

				}
			}
		});
		statsButton.setForeground(new Color(51, 0, 51));
		statsButton.setFont(new Font("Century Schoolbook L", Font.PLAIN, 28));
		GridBagConstraints gbc_statsButton = new GridBagConstraints();
		gbc_statsButton.fill = GridBagConstraints.BOTH;
		gbc_statsButton.gridwidth = 2;
		gbc_statsButton.insets = new Insets(0, 0, 5, 5);
		gbc_statsButton.gridx = 5;
		gbc_statsButton.gridy = 6;
		add(statsButton, gbc_statsButton);
		achievements.setForeground(new Color(51, 0, 51));
		achievements.setFont(new Font("Century Schoolbook L", Font.PLAIN, 28));
		GridBagConstraints gbc_achievements = new GridBagConstraints();
		gbc_achievements.fill = GridBagConstraints.HORIZONTAL;
		gbc_achievements.gridwidth = 2;
		gbc_achievements.insets = new Insets(0, 0, 5, 5);
		gbc_achievements.gridx = 5;
		gbc_achievements.gridy = 8;
		add(achievements, gbc_achievements);
		
		JButton help = new JButton("Help");
		help.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		stats = new JTextArea();
		stats.setForeground(new Color(255, 255, 255));
		stats.setFont(new Font("Century Schoolbook L", Font.PLAIN, 28));
		
		stats.setBackground(new Color(51, 0, 51));
		GridBagConstraints gbc_stats = new GridBagConstraints();
		gbc_stats.gridwidth = 3;
		gbc_stats.gridheight = 2;
		gbc_stats.insets = new Insets(0, 0, 5, 5);
		gbc_stats.fill = GridBagConstraints.BOTH;
		gbc_stats.gridx = 1;
		gbc_stats.gridy = 10;
		add(stats, gbc_stats);
		help.setForeground(new Color(51, 0, 51));
		help.setFont(new Font("Century Schoolbook L", Font.PLAIN, 28));
		GridBagConstraints gbc_help = new GridBagConstraints();
		gbc_help.fill = GridBagConstraints.HORIZONTAL;
		gbc_help.gridwidth = 2;
		gbc_help.insets = new Insets(0, 0, 5, 5);
		gbc_help.gridx = 5;
		gbc_help.gridy = 10;
		add(help, gbc_help);
		
		JButton options = new JButton("Settings");
		options.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GUI.getInstance().setContentPane(new SettingsScreen());
			}
		});
		options.setForeground(new Color(51, 0, 51));
		options.setFont(new Font("Century Schoolbook L", Font.PLAIN, 28));
		GridBagConstraints gbc_options = new GridBagConstraints();
		gbc_options.gridwidth = 2;
		gbc_options.fill = GridBagConstraints.HORIZONTAL;
		gbc_options.insets = new Insets(0, 0, 5, 5);
		gbc_options.gridx = 5;
		gbc_options.gridy = 11;
		add(options, gbc_options);

	}
	private void showStats(){
		int longestStreak = Lists.getInstance().getLongestStreak();
		int currentStreak = Lists.getInstance().getStreak();
		int wordsRight= Lists.getInstance().getWordsRight();
		int wordsAttempted = Lists.getInstance().getWordsAttempted();
		String accuracy;
		System.out.println(wordsAttempted);
		if(wordsAttempted!=0){
			accuracy = "" +((double)wordsRight/(double)wordsAttempted);
		} else {
			accuracy = "-";
		}
		
		stats.setText("Longest Streak: " + longestStreak + "\nCurrent Streak: " + currentStreak + "\nNumber of Words Right: " + wordsRight + "\nAccuracy: " + accuracy + "%");
	}
}