package voxSpell.GUI;

import javax.swing.JPanel;
import javax.swing.JTextPane;

import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Font;
import javax.swing.SwingConstants;

import voxSpell.achievements.Achievement;
import voxSpell.quiz.ButtonSound;
import voxSpell.quiz.Quiz;

import java.awt.Insets;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

/**
 * Class representing the screen that appears at the end of a quiz, with the score, ability to view the list tested, and any achievements unlocked.
 * @author atag549
 * Last Modified: 21 October, 2016
 *
 */
public class EndOfQuiz extends JPanel {
	private JButton button;
	private JLabel congratulatoins;
	private JTextPane achievements;
	private Quiz _quiz;
	private JLabel score;
	private JLabel list;
	private JButton viewAchievements;
	private JButton viewWords;

	/**
	 * Create the panel.
	 */

	public EndOfQuiz(Quiz quiz) {
		_quiz = quiz;
		setBackground(GUI.background);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{30, 0, 20, 0, 30, 0};
		gridBagLayout.rowHeights = new int[]{20, 0, 10, 0, 30, 0, 100, 50, 0, 30, 0, 30, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		//Congratulations label
		congratulatoins = new JLabel("Congratulations");
		congratulatoins.setHorizontalAlignment(SwingConstants.CENTER);
		congratulatoins.setForeground(GUI.foreground);
		congratulatoins.setFont(new Font(GUI.FONT, Font.BOLD, 72));
		GridBagConstraints gbc_congratulatoins = new GridBagConstraints();
		gbc_congratulatoins.gridwidth = 3;
		gbc_congratulatoins.insets = new Insets(0, 0, 5, 0);
		gbc_congratulatoins.gridx = 1;
		gbc_congratulatoins.gridy = 1;
		add(congratulatoins, gbc_congratulatoins);
		
		//Label saying score
		score = new JLabel("You scored " + _quiz.getScore() +" out of " + _quiz.getNumberOfWords());
		score.setHorizontalAlignment(SwingConstants.CENTER);
		score.setForeground(GUI.foreground);
		score.setFont(new Font(GUI.FONT, Font.PLAIN, 48));
		GridBagConstraints gbc_score = new GridBagConstraints();
		gbc_score.gridwidth = 5;
		gbc_score.insets = new Insets(0, 0, 5, 0);
		gbc_score.gridx = 0;
		gbc_score.gridy = 3;
		add(score, gbc_score);
		
		//Achievements view, if any were unlocked
		if(_quiz.getNewAchievements().size() != 0){
			list = new JLabel("Achievements Unlocked");
			list.setIcon(new ImageIcon(GUI.PATH+"/achievements.png"));
			list.setHorizontalAlignment(SwingConstants.CENTER);
			list.setForeground(GUI.foreground);
			list.setFont(new Font(GUI.FONT, Font.PLAIN, 36));
			GridBagConstraints gbc_list = new GridBagConstraints();
			gbc_list.gridwidth = 2;
			gbc_list.insets = new Insets(0, 0, 5, 5);
			gbc_list.gridx =1;
			gbc_list.gridy = 4;
			add(list, gbc_list);

			achievements = new JTextPane();
			achievements.setEditable(false);
			StringBuilder textAchievements = new StringBuilder();
			for(Achievement i : quiz.getNewAchievements()){
				textAchievements.append(i + "\n");
			}
			achievements.setAlignmentX(CENTER_ALIGNMENT);
			achievements.setText(textAchievements.toString());
			achievements.setForeground(GUI.foreground);
			achievements.setFont(new Font(GUI.FONT, Font.PLAIN, 24));
			achievements.setCaretColor(GUI.foreground);
			achievements.setBackground(GUI.background);
			GridBagConstraints gbc_achievements = new GridBagConstraints();
			gbc_achievements.insets = new Insets(0, 0, 5, 5);
			gbc_achievements.fill = GridBagConstraints.BOTH;
			gbc_achievements.gridx = 1;
			gbc_achievements.gridy = 5;
			add(achievements, gbc_achievements);
			new ButtonSound("well-done.wav").execute();
		}
		//Menu button
		button = new JButton("Back To Menu");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GUI.getInstance().setContentPane(new MainMenu());
			}
		});
		
				viewAchievements = new JButton("View Achievements");
				viewAchievements.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						GUI.getInstance().setContentPane(new AchievementScreen());
					}
				});
				viewAchievements.setForeground(GUI.foreground);
				viewAchievements.setFont(new Font(GUI.FONT, Font.PLAIN, 28));
				viewAchievements.setBackground(GUI.background);
				GridBagConstraints gbc_viewAchievements = new GridBagConstraints();
				gbc_viewAchievements.insets = new Insets(0, 0, 5, 5);
				gbc_viewAchievements.gridx = 1;
				gbc_viewAchievements.gridy = 8;
				add(viewAchievements, gbc_viewAchievements);
		//View Words Button
		viewWords = new JButton("View Words");
		viewWords.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new WordListView(_quiz.getWordlist());
			}
		});
		viewWords.setForeground(GUI.foreground);
		viewWords.setFont(new Font(GUI.FONT, Font.PLAIN, 28));
		viewWords.setBackground(GUI.background);
		GridBagConstraints gbc_viewWords = new GridBagConstraints();
		gbc_viewWords.fill = GridBagConstraints.HORIZONTAL;
		gbc_viewWords.insets = new Insets(0, 0, 5, 5);
		gbc_viewWords.gridx = 3;
		gbc_viewWords.gridy = 8;
		add(viewWords, gbc_viewWords);
		button.setForeground(GUI.foreground);
		button.setFont(new Font(GUI.FONT, Font.PLAIN, 28));
		button.setBackground(GUI.background);
		GridBagConstraints gbc_button = new GridBagConstraints();
		gbc_button.insets = new Insets(0, 0, 5, 5);
		gbc_button.gridx = 3;
		gbc_button.gridy = 10;
		add(button, gbc_button);
	}
}