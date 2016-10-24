package voxSpell.GUI;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Font;
import javax.swing.SwingConstants;

import voxSpell.help.HelpScreen;
import voxSpell.quiz.Lists;

import java.awt.Insets;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Collections;
import java.awt.event.ActionEvent;
import javax.swing.UIManager;
/**
 * This is the class representing the statistics screen designed for my 206 project
 * @author atag549
 * Last Modified: 21 October, 2016
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
	protected JButton menu;
	private JLabel wordsTested;
	private JLabel overallAccuracy;
	private JLabel totalWordsTested;
	private JLabel help;

	/**
	 * Create the panel.
	 */
	public StatisticsScreen() {
		setBackground(GUI.background);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{30, 0, 50, 300, 20, 0, 30, 0};
		gridBagLayout.rowHeights = new int[]{30, 0, 20, 0, 20, 0, 20, 20, 20, 20, 20, 0, 0, 30, 0, 30, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);

		//Statistics title
		title = new JLabel("Statistics");
		title.setVerticalAlignment(SwingConstants.BOTTOM);
		title.setHorizontalAlignment(SwingConstants.CENTER);
		title.setForeground(GUI.foreground);
		title.setFont(new Font(GUI.FONT, Font.BOLD, 72));
		GridBagConstraints gbc_title = new GridBagConstraints();
		gbc_title.gridwidth = 7;
		gbc_title.insets = new Insets(0, 0, 5, 0);
		gbc_title.gridx = 0;
		gbc_title.gridy = 1;
		add(title, gbc_title);

		//Level label for combobox
		levelLabel = new JLabel("Level");
		levelLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		levelLabel.setForeground(GUI.foreground);
		levelLabel.setFont(new Font(GUI.FONT, Font.PLAIN, 36));
		GridBagConstraints gbc_levelLabel = new GridBagConstraints();
		gbc_levelLabel.fill = GridBagConstraints.HORIZONTAL;
		gbc_levelLabel.insets = new Insets(0, 0, 5, 5);
		gbc_levelLabel.gridx = 1;
		gbc_levelLabel.gridy = 3;
		add(levelLabel, gbc_levelLabel);

		//Combobox for choosing the level to see stats of
		chooseLevel = new JComboBox<String>();
		ArrayList<String> levelsWithStats = Lists.getInstance().getLevelsWithStats();
		Collections.sort(levelsWithStats);
		for(String list: levelsWithStats){
			chooseLevel.addItem(list);
		}
		chooseLevel.setFont(new Font(GUI.FONT, Font.BOLD, 28));
		GridBagConstraints gbc_chooseLevel = new GridBagConstraints();
		gbc_chooseLevel.fill = GridBagConstraints.HORIZONTAL;
		gbc_chooseLevel.insets = new Insets(0, 0, 5, 5);
		gbc_chooseLevel.gridx = 3;
		gbc_chooseLevel.gridy = 3;
		add(chooseLevel, gbc_chooseLevel);

		//Submit button for the level
		submitLevel = new JButton("View");
		if(levelsWithStats.size() == 0){
			submitLevel.setEnabled(false);
		}
		submitLevel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String accuracyValue = ""+Lists.getInstance().getAccuracy((String)chooseLevel.getSelectedItem());
				if(accuracyValue.length() > 4){
					accuracyValue = accuracyValue.substring(0, 4);
				}
				accuracy.setText("Accuracy: "+ accuracyValue + "%");
				wordsTested.setText("Words Tested from Level: " + Lists.getInstance().getWordsTested((String)chooseLevel.getSelectedItem()));
			}
		});
		submitLevel.setForeground(GUI.foreground);
		submitLevel.setFont(new Font(GUI.FONT, Font.PLAIN, 28));
		submitLevel.setBackground(GUI.background);
		GridBagConstraints gbc_submitLevel = new GridBagConstraints();
		gbc_submitLevel.insets = new Insets(0, 0, 5, 5);
		gbc_submitLevel.gridx = 5;
		gbc_submitLevel.gridy = 3;
		add(submitLevel, gbc_submitLevel);

		//Label with the number of words tested from the level
		wordsTested = new JLabel("Words Tested from Level: ");
		wordsTested.setHorizontalAlignment(SwingConstants.RIGHT);
		wordsTested.setForeground(GUI.foreground);
		wordsTested.setFont(new Font(GUI.FONT, Font.PLAIN, 36));
		GridBagConstraints gbc_wordsTested = new GridBagConstraints();
		gbc_wordsTested.anchor = GridBagConstraints.WEST;
		gbc_wordsTested.gridwidth = 5;
		gbc_wordsTested.insets = new Insets(0, 0, 5, 5);
		gbc_wordsTested.gridx = 1;
		gbc_wordsTested.gridy = 5;
		add(wordsTested, gbc_wordsTested);

		//Level accuracy label
		accuracy = new JLabel("Accuracy: ");
		accuracy.setHorizontalAlignment(SwingConstants.RIGHT);
		accuracy.setForeground(GUI.foreground);
		accuracy.setFont(new Font(GUI.FONT, Font.PLAIN, 36));
		GridBagConstraints gbc_accuracy = new GridBagConstraints();
		gbc_accuracy.anchor = GridBagConstraints.WEST;
		gbc_accuracy.gridwidth = 5;
		gbc_accuracy.insets = new Insets(0, 0, 5, 5);
		gbc_accuracy.gridx = 1;
		gbc_accuracy.gridy = 6;
		add(accuracy, gbc_accuracy);

		//Label saying the current streak length
		currentStreak = new JLabel("Current Streak: " + Lists.getInstance().getStreak());
		currentStreak.setHorizontalAlignment(SwingConstants.RIGHT);
		currentStreak.setForeground(GUI.foreground);
		currentStreak.setFont(new Font(GUI.FONT, Font.PLAIN, 36));
		GridBagConstraints gbc_currentStreak = new GridBagConstraints();
		gbc_currentStreak.anchor = GridBagConstraints.WEST;
		gbc_currentStreak.gridwidth = 5;
		gbc_currentStreak.insets = new Insets(0, 0, 5, 5);
		gbc_currentStreak.gridx = 1;
		gbc_currentStreak.gridy = 8;
		add(currentStreak, gbc_currentStreak);

		//Label saying the longest streak length
		longestStreak = new JLabel("Longest Streak: " + Lists.getInstance().getLongestStreak());
		longestStreak.setHorizontalAlignment(SwingConstants.RIGHT);
		longestStreak.setForeground(GUI.foreground);
		longestStreak.setFont(new Font(GUI.FONT, Font.PLAIN, 36));
		GridBagConstraints gbc_longestStreak = new GridBagConstraints();
		gbc_longestStreak.anchor = GridBagConstraints.WEST;
		gbc_longestStreak.gridwidth = 5;
		gbc_longestStreak.insets = new Insets(0, 0, 5, 5);
		gbc_longestStreak.gridx = 1;
		gbc_longestStreak.gridy = 9;
		add(longestStreak, gbc_longestStreak);

		//Label saying the total number of words tested
		totalWordsTested = new JLabel("Total Number of Words Tested: " + Lists.getInstance().getWordsAttempted());
		totalWordsTested.setHorizontalAlignment(SwingConstants.RIGHT);
		totalWordsTested.setForeground(GUI.foreground);
		totalWordsTested.setFont(new Font(GUI.FONT, Font.PLAIN, 36));
		GridBagConstraints gbc_totalWordsTested = new GridBagConstraints();
		gbc_totalWordsTested.gridwidth = 3;
		gbc_totalWordsTested.anchor = GridBagConstraints.WEST;
		gbc_totalWordsTested.insets = new Insets(0, 0, 5, 5);
		gbc_totalWordsTested.gridx = 1;
		gbc_totalWordsTested.gridy = 11;
		add(totalWordsTested, gbc_totalWordsTested);

		//Overall accuracy label
		overallAccuracy = new JLabel("Overall Accuracy: " + getOverallAccuracy() + "%");
		overallAccuracy.setHorizontalAlignment(SwingConstants.RIGHT);
		overallAccuracy.setForeground(GUI.foreground);
		overallAccuracy.setFont(new Font(GUI.FONT, Font.PLAIN, 36));
		GridBagConstraints gbc_overallAccuracy = new GridBagConstraints();
		gbc_overallAccuracy.anchor = GridBagConstraints.WEST;
		gbc_overallAccuracy.gridwidth = 3;
		gbc_overallAccuracy.insets = new Insets(0, 0, 5, 5);
		gbc_overallAccuracy.gridx = 1;
		gbc_overallAccuracy.gridy = 12;
		add(overallAccuracy, gbc_overallAccuracy);

		//Main menu button
		menu = new JButton("Back to Menu");
		menu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GUI.getInstance().setContentPane(new MainMenu());
			}
		});
		menu.setForeground(GUI.foreground);
		menu.setFont(new Font(GUI.FONT, Font.PLAIN, 28));
		menu.setBackground(GUI.background);
		GridBagConstraints gbc_menu = new GridBagConstraints();
		gbc_menu.gridwidth = 2;
		gbc_menu.insets = new Insets(0, 0, 5, 5);
		gbc_menu.gridx = 1;
		gbc_menu.gridy = 14;
		add(menu, gbc_menu);
		
		//Help button
		help = new JLabel("");
		help.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				new HelpScreen();
			}
		});
		help.setIcon(new ImageIcon(GUI.PATH + "/help.png"));
		help.setHorizontalAlignment(SwingConstants.RIGHT);
		help.setFont(new Font(GUI.FONT, Font.PLAIN, 28));
		help.setBackground(GUI.background);
		GridBagConstraints gbc_help = new GridBagConstraints();
		gbc_help.insets = new Insets(0, 0, 0, 5);
		gbc_help.gridx = 5;
		gbc_help.gridy = 14;
		add(help, gbc_help);

	}
	/***
	 * Method return the overall accuracy as a string
	 * @return
	 */
	private String getOverallAccuracy(){
		String accuracyValue = ""+Lists.getInstance().getAccuracy();
		if(accuracyValue.length() > 4){
			accuracyValue = accuracyValue.substring(0, 4);
		}
		return accuracyValue;
	}

}
