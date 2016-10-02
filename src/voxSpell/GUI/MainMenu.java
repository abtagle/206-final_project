package voxSpell.GUI;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.GridBagLayout;

import javax.print.DocFlavor.URL;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.io.File;
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
	JTextArea stats;
	/**
	 * 
	 */
	private JToggleButton statsButton;
	public MainMenu() {
		stats = new JTextArea();
		setBackground(new Color(51, 0, 51));
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{40, 125, 160, 150, 0, 60, 160, 40, 10, 0};
		gridBagLayout.rowHeights = new int[]{30, 0, 0, 0, 0, 0, 0, 0, 0, 50, 30, 40, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		

		File f = new File(System.getProperty("java.class.path"));
		File dir = f.getAbsoluteFile().getParentFile();
		String path = dir.toString() + "/welcomeMini.gif";
		ImageIcon icon = new ImageIcon(path);
		JLabel image = new JLabel(icon);
		image.setForeground(new Color(255, 255, 255));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.gridwidth = 5;
		gbc_lblNewLabel.gridheight = 10;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		add(image, gbc_lblNewLabel);
		
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
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon("/afs/ec.auckland.ac.nz/users/a/t/atag549/unixhome/Documents/Softeng_206/Project2/voxSpell/play.png"));
		GridBagConstraints gbc_label_1 = new GridBagConstraints();
		gbc_label_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_label_1.insets = new Insets(0, 0, 5, 5);
		gbc_label_1.gridx = 7;
		gbc_label_1.gridy = 2;
		add(label_1, gbc_label_1);
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
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("/afs/ec.auckland.ac.nz/users/a/t/atag549/unixhome/Documents/Softeng_206/Project2/voxSpell/review.png"));
		GridBagConstraints gbc_label = new GridBagConstraints();
		gbc_label.insets = new Insets(0, 0, 5, 5);
		gbc_label.gridx = 7;
		gbc_label.gridy = 4;
		add(label, gbc_label);
		statsButton.setForeground(new Color(51, 0, 51));
		statsButton.setFont(new Font("Century Schoolbook L", Font.PLAIN, 28));
		GridBagConstraints gbc_statsButton = new GridBagConstraints();
		gbc_statsButton.fill = GridBagConstraints.BOTH;
		gbc_statsButton.gridwidth = 2;
		gbc_statsButton.insets = new Insets(0, 0, 5, 5);
		gbc_statsButton.gridx = 5;
		gbc_statsButton.gridy = 6;
		add(statsButton, gbc_statsButton);
		
		JLabel newQuizIcon = new JLabel("");
		newQuizIcon.setIcon(new ImageIcon("/afs/ec.auckland.ac.nz/users/a/t/atag549/unixhome/Documents/Softeng_206/Project2/voxSpell/stats.png"));
		GridBagConstraints gbc_newQuizIcon = new GridBagConstraints();
		gbc_newQuizIcon.insets = new Insets(0, 0, 5, 5);
		gbc_newQuizIcon.gridx = 7;
		gbc_newQuizIcon.gridy = 6;
		add(newQuizIcon, gbc_newQuizIcon);
		achievements.setForeground(new Color(51, 0, 51));
		achievements.setFont(new Font("Century Schoolbook L", Font.PLAIN, 28));
		GridBagConstraints gbc_achievements = new GridBagConstraints();
		gbc_achievements.fill = GridBagConstraints.HORIZONTAL;
		gbc_achievements.gridwidth = 2;
		gbc_achievements.insets = new Insets(0, 0, 5, 5);
		gbc_achievements.gridx = 5;
		gbc_achievements.gridy = 8;
		add(achievements, gbc_achievements);
		
		JLabel label_2 = new JLabel("");
		label_2.setIcon(new ImageIcon("/afs/ec.auckland.ac.nz/users/a/t/atag549/unixhome/Documents/Softeng_206/Project2/voxSpell/achievements.png"));
		GridBagConstraints gbc_label_2 = new GridBagConstraints();
		gbc_label_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_label_2.insets = new Insets(0, 0, 5, 5);
		gbc_label_2.gridx = 7;
		gbc_label_2.gridy = 8;
		add(label_2, gbc_label_2);
		
		JButton options = new JButton("Settings");
		options.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GUI.getInstance().setContentPane(new SettingsScreen());
			}
		});
		
		stats.setBackground(new Color(51, 0, 51));
		GridBagConstraints gbc_stats = new GridBagConstraints();
		gbc_stats.gridwidth = 2;
		gbc_stats.insets = new Insets(0, 0, 5, 5);
		gbc_stats.fill = GridBagConstraints.BOTH;
		gbc_stats.gridx = 2;
		gbc_stats.gridy = 10;
		add(stats, gbc_stats);
		options.setForeground(new Color(51, 0, 51));
		options.setFont(new Font("Century Schoolbook L", Font.PLAIN, 28));
		GridBagConstraints gbc_options = new GridBagConstraints();
		gbc_options.gridwidth = 2;
		gbc_options.fill = GridBagConstraints.HORIZONTAL;
		gbc_options.insets = new Insets(0, 0, 5, 5);
		gbc_options.gridx = 5;
		gbc_options.gridy = 10;
		add(options, gbc_options);
		
		JLabel label_4 = new JLabel("");
		label_4.setIcon(new ImageIcon("/afs/ec.auckland.ac.nz/users/a/t/atag549/unixhome/Documents/Softeng_206/Project2/voxSpell/settings.png"));
		GridBagConstraints gbc_label_4 = new GridBagConstraints();
		gbc_label_4.insets = new Insets(0, 0, 5, 5);
		gbc_label_4.gridx = 7;
		gbc_label_4.gridy = 10;
		add(label_4, gbc_label_4);

	}
	private void showStats(){
		int longestStreak = Lists.getInstance().getLongestStreak();
		int currentStreak = Lists.getInstance().getStreak();
		int wordsRight= Lists.getInstance().getWordsRight();
		int wordsAttempted = Lists.getInstance().getWordsAttempted();
		String accuracy;
		System.out.println(wordsAttempted);
		if(wordsAttempted!=0){
			accuracy = "" +(((double)wordsRight/(double)wordsAttempted)*100);
			if(accuracy.length() > 4){
				accuracy = accuracy.substring(0, 4);
			}
		} else {
			accuracy = "-";
		}
		stats.setText("Longest Streak: " + longestStreak + "\nCurrent Streak: " + currentStreak + "\nNumber of Words Right: " + wordsRight + "\nAccuracy: " + accuracy + "%");
	}
}