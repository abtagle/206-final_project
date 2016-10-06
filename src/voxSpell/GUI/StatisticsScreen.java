package voxSpell.GUI;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Font;
import javax.swing.SwingConstants;

import voxSpell.quiz.Lists;

import java.awt.Insets;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.awt.event.ActionEvent;
/**
 * This is the class representing the statistics screen designed for my 206 project
 * @author atag549
 *
 */
public class StatisticsScreen extends JPanel {
	private JLabel title;
	private JLabel levelLabel;
	private JComboBox<String> chooseLevel;
	private JButton submitLevel;
	private JLabel longestStreak;
	private JLabel accuracy;
	private JLabel currentStreak;
	private JButton menu;
	private JLabel wordsTested;
	private JLabel overallAccuracy;
	private JLabel totalWordsTested;

	/**
	 * Create the panel.
	 */
	public StatisticsScreen() {
		setBackground(new Color(51, 0, 51));
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{30, 0, 50, 300, 20, 0, 30, 0};
		gridBagLayout.rowHeights = new int[]{30, 0, 20, 0, 20, 0, 20, 20, 20, 20, 20, 0, 0, 30, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		title = new JLabel("Statistics");
		title.setVerticalAlignment(SwingConstants.BOTTOM);
		title.setHorizontalAlignment(SwingConstants.CENTER);
		title.setForeground(Color.WHITE);
		title.setFont(new Font("Century Schoolbook L", Font.BOLD, 72));
		GridBagConstraints gbc_title = new GridBagConstraints();
		gbc_title.gridwidth = 7;
		gbc_title.insets = new Insets(0, 0, 5, 0);
		gbc_title.gridx = 0;
		gbc_title.gridy = 1;
		add(title, gbc_title);
		
		levelLabel = new JLabel("Level");
		levelLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		levelLabel.setForeground(Color.WHITE);
		levelLabel.setFont(new Font("Century Schoolbook L", Font.PLAIN, 36));
		GridBagConstraints gbc_levelLabel = new GridBagConstraints();
		gbc_levelLabel.fill = GridBagConstraints.HORIZONTAL;
		gbc_levelLabel.insets = new Insets(0, 0, 5, 5);
		gbc_levelLabel.gridx = 1;
		gbc_levelLabel.gridy = 3;
		add(levelLabel, gbc_levelLabel);
		
		chooseLevel = new JComboBox<String>();
		ArrayList<String> levelsWithStats = Lists.getInstance().getLevelsWithStats();
		Collections.sort(levelsWithStats);
		for(String list: levelsWithStats){
			chooseLevel.addItem(list);
		}
		chooseLevel.setFont(new Font("Century Schoolbook L", Font.BOLD, 28));
		GridBagConstraints gbc_chooseLevel = new GridBagConstraints();
		gbc_chooseLevel.fill = GridBagConstraints.HORIZONTAL;
		gbc_chooseLevel.insets = new Insets(0, 0, 5, 5);
		gbc_chooseLevel.gridx = 3;
		gbc_chooseLevel.gridy = 3;
		add(chooseLevel, gbc_chooseLevel);
		
		submitLevel = new JButton("View");
		if(levelsWithStats.size() == 0){
			submitLevel.setEnabled(false);
		}
		submitLevel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				accuracy.setText("Accuracy: "+ Lists.getInstance().getAccuracy((String)chooseLevel.getSelectedItem()) + "%");
				wordsTested.setText("Word Tested from Level: " + Lists.getInstance().getWordsTested((String)chooseLevel.getSelectedItem()));
			}
		});
		submitLevel.setForeground(Color.WHITE);
		submitLevel.setFont(new Font("Century Schoolbook L", Font.PLAIN, 28));
		submitLevel.setBackground(new Color(51, 0, 51));
		GridBagConstraints gbc_submitLevel = new GridBagConstraints();
		gbc_submitLevel.insets = new Insets(0, 0, 5, 5);
		gbc_submitLevel.gridx = 5;
		gbc_submitLevel.gridy = 3;
		add(submitLevel, gbc_submitLevel);
		
		wordsTested = new JLabel("Words Tested from Level: ");
		wordsTested.setHorizontalAlignment(SwingConstants.RIGHT);
		wordsTested.setForeground(Color.WHITE);
		wordsTested.setFont(new Font("Century Schoolbook L", Font.PLAIN, 36));
		GridBagConstraints gbc_wordsTested = new GridBagConstraints();
		gbc_wordsTested.anchor = GridBagConstraints.WEST;
		gbc_wordsTested.gridwidth = 5;
		gbc_wordsTested.insets = new Insets(0, 0, 5, 5);
		gbc_wordsTested.gridx = 1;
		gbc_wordsTested.gridy = 5;
		add(wordsTested, gbc_wordsTested);
		
		accuracy = new JLabel("Accuracy: ");
		accuracy.setHorizontalAlignment(SwingConstants.RIGHT);
		accuracy.setForeground(Color.WHITE);
		accuracy.setFont(new Font("Century Schoolbook L", Font.PLAIN, 36));
		GridBagConstraints gbc_accuracy = new GridBagConstraints();
		gbc_accuracy.anchor = GridBagConstraints.WEST;
		gbc_accuracy.gridwidth = 5;
		gbc_accuracy.insets = new Insets(0, 0, 5, 5);
		gbc_accuracy.gridx = 1;
		gbc_accuracy.gridy = 6;
		add(accuracy, gbc_accuracy);
		
		currentStreak = new JLabel("Current Streak: " + Lists.getInstance().getStreak());
		currentStreak.setHorizontalAlignment(SwingConstants.RIGHT);
		currentStreak.setForeground(Color.WHITE);
		currentStreak.setFont(new Font("Century Schoolbook L", Font.PLAIN, 36));
		GridBagConstraints gbc_currentStreak = new GridBagConstraints();
		gbc_currentStreak.anchor = GridBagConstraints.WEST;
		gbc_currentStreak.gridwidth = 5;
		gbc_currentStreak.insets = new Insets(0, 0, 5, 5);
		gbc_currentStreak.gridx = 1;
		gbc_currentStreak.gridy = 8;
		add(currentStreak, gbc_currentStreak);
		
		menu = new JButton("Back to Menu");
		menu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GUI.getInstance().setContentPane(new MainMenu());
			}
		});
		
		longestStreak = new JLabel("Longest Streak: " + Lists.getInstance().getLongestStreak());
		longestStreak.setHorizontalAlignment(SwingConstants.RIGHT);
		longestStreak.setForeground(Color.WHITE);
		longestStreak.setFont(new Font("Century Schoolbook L", Font.PLAIN, 36));
		GridBagConstraints gbc_longestStreak = new GridBagConstraints();
		gbc_longestStreak.anchor = GridBagConstraints.WEST;
		gbc_longestStreak.gridwidth = 5;
		gbc_longestStreak.insets = new Insets(0, 0, 5, 5);
		gbc_longestStreak.gridx = 1;
		gbc_longestStreak.gridy = 9;
		add(longestStreak, gbc_longestStreak);
		
		totalWordsTested = new JLabel("Total Number of Words Tested: " + Lists.getInstance().getWordsAttempted());
		totalWordsTested.setHorizontalAlignment(SwingConstants.RIGHT);
		totalWordsTested.setForeground(Color.WHITE);
		totalWordsTested.setFont(new Font("Century Schoolbook L", Font.PLAIN, 36));
		GridBagConstraints gbc_totalWordsTested = new GridBagConstraints();
		gbc_totalWordsTested.gridwidth = 3;
		gbc_totalWordsTested.anchor = GridBagConstraints.WEST;
		gbc_totalWordsTested.insets = new Insets(0, 0, 5, 5);
		gbc_totalWordsTested.gridx = 1;
		gbc_totalWordsTested.gridy = 11;
		add(totalWordsTested, gbc_totalWordsTested);
		
		overallAccuracy = new JLabel("Overall Accuracy: " + Lists.getInstance().getAccuracy() + "%");
		overallAccuracy.setHorizontalAlignment(SwingConstants.RIGHT);
		overallAccuracy.setForeground(Color.WHITE);
		overallAccuracy.setFont(new Font("Century Schoolbook L", Font.PLAIN, 36));
		GridBagConstraints gbc_overallAccuracy = new GridBagConstraints();
		gbc_overallAccuracy.anchor = GridBagConstraints.WEST;
		gbc_overallAccuracy.gridwidth = 3;
		gbc_overallAccuracy.insets = new Insets(0, 0, 5, 5);
		gbc_overallAccuracy.gridx = 1;
		gbc_overallAccuracy.gridy = 12;
		add(overallAccuracy, gbc_overallAccuracy);
		menu.setForeground(Color.WHITE);
		menu.setFont(new Font("Century Schoolbook L", Font.PLAIN, 28));
		menu.setBackground(new Color(51, 0, 51));
		GridBagConstraints gbc_menu = new GridBagConstraints();
		gbc_menu.gridwidth = 2;
		gbc_menu.insets = new Insets(0, 0, 0, 5);
		gbc_menu.gridx = 1;
		gbc_menu.gridy = 14;
		add(menu, gbc_menu);

	}

}