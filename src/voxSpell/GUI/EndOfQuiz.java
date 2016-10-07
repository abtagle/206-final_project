package voxSpell.GUI;

import javax.swing.JPanel;
import javax.swing.JTextPane;

import java.awt.Color;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Font;
import javax.swing.SwingConstants;

import voxSpell.achievements.Achievement;
import voxSpell.quiz.Quiz;

import java.awt.Insets;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class EndOfQuiz extends JPanel {
	private JButton button;
	private JLabel congratulatoins;
	private JTextPane achievements;
	private Quiz _quiz;
	private JLabel score;
	private JLabel list;
	private JButton viewAchievements;

	/**
	 * Create the panel.
	 */

	public EndOfQuiz(Quiz quiz) {
		_quiz = quiz;
		setBackground(new Color(51, 0, 51));
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{30, 0, 30, 0};
		gridBagLayout.rowHeights = new int[]{20, 0, 10, 0, 30, 0, 100, 10, 0, 10, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);

		congratulatoins = new JLabel("Congratulations");
		congratulatoins.setHorizontalAlignment(SwingConstants.CENTER);
		congratulatoins.setForeground(Color.WHITE);
		congratulatoins.setFont(new Font("Century Schoolbook L", Font.BOLD, 72));
		GridBagConstraints gbc_congratulatoins = new GridBagConstraints();
		gbc_congratulatoins.gridwidth = 3;
		gbc_congratulatoins.insets = new Insets(0, 0, 5, 0);
		gbc_congratulatoins.gridx = 0;
		gbc_congratulatoins.gridy = 1;
		add(congratulatoins, gbc_congratulatoins);

		score = new JLabel("You scored " + _quiz.getScore() +" out of " + _quiz.getNumberOfWords());
		score.setHorizontalAlignment(SwingConstants.CENTER);
		score.setForeground(Color.WHITE);
		score.setFont(new Font("Century Schoolbook L", Font.PLAIN, 48));
		GridBagConstraints gbc_score = new GridBagConstraints();
		gbc_score.gridwidth = 2;
		gbc_score.insets = new Insets(0, 0, 5, 0);
		gbc_score.gridx = 1;
		gbc_score.gridy = 3;
		add(score, gbc_score);
		if(_quiz.getNewAchievements().size() != 0){
			list = new JLabel("Achievements Unlocked");
			list.setIcon(new ImageIcon(GUI.PATH+"/achievements.png"));
			list.setHorizontalAlignment(SwingConstants.CENTER);
			list.setForeground(Color.WHITE);
			list.setFont(new Font("Century Schoolbook L", Font.PLAIN, 36));
			GridBagConstraints gbc_list = new GridBagConstraints();
			gbc_list.gridwidth = 2;
			gbc_list.insets = new Insets(0, 0, 5, 5);
			gbc_list.gridx = 0;
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
			achievements.setForeground(Color.WHITE);
			achievements.setFont(new Font("Century Schoolbook L", Font.PLAIN, 24));
			achievements.setCaretColor(new Color(255, 255, 255));
			achievements.setBackground(new Color(51, 0, 51));
			GridBagConstraints gbc_achievements = new GridBagConstraints();
			gbc_achievements.insets = new Insets(0, 0, 5, 5);
			gbc_achievements.fill = GridBagConstraints.BOTH;
			gbc_achievements.gridx = 1;
			gbc_achievements.gridy = 5;
			add(achievements, gbc_achievements);
			
		}

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
		viewAchievements.setForeground(Color.WHITE);
		viewAchievements.setFont(new Font("Century Schoolbook L", Font.PLAIN, 28));
		viewAchievements.setBackground(new Color(51, 0, 51));
		GridBagConstraints gbc_viewAchievements = new GridBagConstraints();
		gbc_viewAchievements.insets = new Insets(0, 0, 5, 5);
		gbc_viewAchievements.gridx = 1;
		gbc_viewAchievements.gridy = 8;
		add(viewAchievements, gbc_viewAchievements);
		button.setForeground(Color.WHITE);
		button.setFont(new Font("Century Schoolbook L", Font.PLAIN, 28));
		button.setBackground(new Color(51, 0, 51));
		GridBagConstraints gbc_button = new GridBagConstraints();
		gbc_button.insets = new Insets(0, 0, 5, 5);
		gbc_button.gridx = 1;
		gbc_button.gridy = 10;
		add(button, gbc_button);

	}
}