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
import javax.swing.SwingConstants;

/**
 * Class representing the main menu written using WindowBuilder for the final assignment of Softeng 206
 * @author atag549
 *
 */
public class MainMenu extends JPanel {
	public MainMenu() {
		setBackground(new Color(51, 0, 51));
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{40, 125, 0, 60, 160, 40, 10, 0};
		gridBagLayout.rowHeights = new int[]{30, 0, 0, 0, 0, 0, 30, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		

		File f = new File(System.getProperty("java.class.path"));
		File dir = f.getAbsoluteFile().getParentFile();
		String path = dir.toString();
		JButton newQuiz = new JButton("      New Quiz");
		newQuiz.setHorizontalAlignment(SwingConstants.RIGHT);
		newQuiz.setIcon(new ImageIcon(path+"/play.png"));
		newQuiz.setBackground(new Color(51, 0, 51));
		newQuiz.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GUI.getInstance().setContentPane(new QuizScreen("New Quiz"));
			}
		});
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(path+"/welcomeMini.gif"));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.gridheight = 5;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 1;
		gbc_lblNewLabel.gridy = 1;
		add(lblNewLabel, gbc_lblNewLabel);
		newQuiz.setForeground(new Color(255, 255, 255));
		newQuiz.setFont(new Font("Century Schoolbook L", Font.PLAIN, 28));
		GridBagConstraints gbc_newQuiz = new GridBagConstraints();
		gbc_newQuiz.gridwidth = 2;
		gbc_newQuiz.fill = GridBagConstraints.HORIZONTAL;
		gbc_newQuiz.insets = new Insets(0, 0, 5, 5);
		gbc_newQuiz.gridx = 3;
		gbc_newQuiz.gridy = 1;
		add(newQuiz, gbc_newQuiz);
		
		JButton review = new JButton("          Review");
		review.setHorizontalAlignment(SwingConstants.RIGHT);
		review.setIcon(new ImageIcon(path+"/review.png"));
		review.setBackground(new Color(51, 0, 51));
		review.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GUI.getInstance().setContentPane(new ReviewOptionsScreen());
			}
		});
		review.setForeground(new Color(255, 255, 255));
		review.setFont(new Font("Century Schoolbook L", Font.PLAIN, 28));
		GridBagConstraints gbc_review = new GridBagConstraints();
		gbc_review.fill = GridBagConstraints.HORIZONTAL;
		gbc_review.gridwidth = 2;
		gbc_review.insets = new Insets(0, 0, 5, 5);
		gbc_review.gridx = 3;
		gbc_review.gridy = 2;
		add(review, gbc_review);
		
		JButton statistics = new JButton("      Statistics");
		statistics.setHorizontalAlignment(SwingConstants.RIGHT);
		statistics.setIcon(new ImageIcon(path+"/stats.png"));
		statistics.setForeground(Color.WHITE);
		statistics.setFont(new Font("Century Schoolbook L", Font.PLAIN, 28));
		statistics.setBackground(new Color(51, 0, 51));
		GridBagConstraints gbc_statistics = new GridBagConstraints();
		gbc_statistics.fill = GridBagConstraints.HORIZONTAL;
		gbc_statistics.gridwidth = 2;
		gbc_statistics.insets = new Insets(0, 0, 5, 5);
		gbc_statistics.gridx = 3;
		gbc_statistics.gridy = 3;
		add(statistics, gbc_statistics);
		
		JButton achievements = new JButton("Achievements");
		achievements.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GUI.getInstance().setContentPane(new AchievementScreen());
			}
		});
		achievements.setHorizontalAlignment(SwingConstants.RIGHT);
		achievements.setIcon(new ImageIcon(path+"/achievements.png"));
		achievements.setForeground(Color.WHITE);
		achievements.setFont(new Font("Century Schoolbook L", Font.PLAIN, 28));
		achievements.setBackground(new Color(51, 0, 51));
		GridBagConstraints gbc_achievements = new GridBagConstraints();
		gbc_achievements.fill = GridBagConstraints.HORIZONTAL;
		gbc_achievements.gridwidth = 2;
		gbc_achievements.insets = new Insets(0, 0, 5, 5);
		gbc_achievements.gridx = 3;
		gbc_achievements.gridy = 4;
		add(achievements, gbc_achievements);
		
		JButton settings = new JButton("        Settings");
		settings.setHorizontalAlignment(SwingConstants.RIGHT);
		settings.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GUI.getInstance().setContentPane(new SettingsScreen());
			}
		});
		settings.setIcon(new ImageIcon(path+"/settings.png"));
		settings.setForeground(Color.WHITE);
		settings.setFont(new Font("Century Schoolbook L", Font.PLAIN, 28));
		settings.setBackground(new Color(51, 0, 51));
		GridBagConstraints gbc_settings = new GridBagConstraints();
		gbc_settings.gridwidth = 2;
		gbc_settings.fill = GridBagConstraints.HORIZONTAL;
		gbc_settings.insets = new Insets(0, 0, 5, 5);
		gbc_settings.gridx = 3;
		gbc_settings.gridy = 5;
		add(settings, gbc_settings);
	}
}