package voxSpell.GUI;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Insets;
import javax.swing.JProgressBar;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AchievementScreen extends JPanel {
	private JLabel title;
	private JLabel streak;
	private JLabel wordsRight;
	private JButton streak10ViewReward;
	private JLabel label;
	private JButton streak0ViewReward;

	/**
	 * Create the panel.
	 */
	public AchievementScreen() {
		setBackground(new Color(51, 0, 51));
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{80, 300, 40, 300, 80, 0};
		gridBagLayout.rowHeights = new int[]{20, 0, 20, 0, 10, 0, 0, 20, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		title = new JLabel("Achievements");
		title.setVerticalAlignment(SwingConstants.BOTTOM);
		title.setHorizontalAlignment(SwingConstants.CENTER);
		title.setForeground(Color.WHITE);
		title.setFont(new Font("Century Schoolbook L", Font.BOLD, 72));
		GridBagConstraints gbc_title = new GridBagConstraints();
		gbc_title.insets = new Insets(0, 0, 5, 0);
		gbc_title.gridwidth = 5;
		gbc_title.gridx = 0;
		gbc_title.gridy = 1;
		add(title, gbc_title);
		
		streak = new JLabel("Streak Length");
		streak.setHorizontalAlignment(SwingConstants.RIGHT);
		streak.setForeground(Color.WHITE);
		streak.setFont(new Font("Century Schoolbook L", Font.PLAIN, 36));
		GridBagConstraints gbc_streak = new GridBagConstraints();
		gbc_streak.insets = new Insets(0, 0, 5, 5);
		gbc_streak.gridx = 1;
		gbc_streak.gridy = 3;
		add(streak, gbc_streak);
		
		wordsRight = new JLabel("Words Right");
		wordsRight.setHorizontalAlignment(SwingConstants.RIGHT);
		wordsRight.setForeground(Color.WHITE);
		wordsRight.setFont(new Font("Century Schoolbook L", Font.PLAIN, 36));
		GridBagConstraints gbc_wordsRight = new GridBagConstraints();
		gbc_wordsRight.insets = new Insets(0, 0, 5, 5);
		gbc_wordsRight.gridx = 3;
		gbc_wordsRight.gridy = 3;
		add(wordsRight, gbc_wordsRight);
		
		JLabel streakLabel10 = new JLabel("10 Words");
		streakLabel10.setHorizontalAlignment(SwingConstants.RIGHT);
		streakLabel10.setForeground(Color.WHITE);
		streakLabel10.setFont(new Font("Century Schoolbook L", Font.PLAIN, 24));
		GridBagConstraints gbc_streakLabel10 = new GridBagConstraints();
		gbc_streakLabel10.insets = new Insets(0, 0, 5, 5);
		gbc_streakLabel10.gridx = 1;
		gbc_streakLabel10.gridy = 5;
		add(streakLabel10, gbc_streakLabel10);
		
		streak10ViewReward = new JButton("View Reward");
		streak10ViewReward.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		streak10ViewReward.setEnabled(false);
		streak10ViewReward.setForeground(Color.WHITE);
		streak10ViewReward.setFont(new Font("Century Schoolbook L", Font.PLAIN, 24));
		streak10ViewReward.setBackground(new Color(51, 0, 51));
		GridBagConstraints gbc_streak10ViewReward = new GridBagConstraints();
		gbc_streak10ViewReward.anchor = GridBagConstraints.NORTH;
		gbc_streak10ViewReward.insets = new Insets(0, 0, 5, 5);
		gbc_streak10ViewReward.gridx = 1;
		gbc_streak10ViewReward.gridy = 6;
		add(streak10ViewReward, gbc_streak10ViewReward);
		
		label = new JLabel("10 Words");
		label.setHorizontalAlignment(SwingConstants.RIGHT);
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Century Schoolbook L", Font.PLAIN, 24));
		GridBagConstraints gbc_label = new GridBagConstraints();
		gbc_label.insets = new Insets(0, 0, 5, 5);
		gbc_label.gridx = 1;
		gbc_label.gridy = 8;
		add(label, gbc_label);
		
		streak0ViewReward = new JButton("View Reward");
		streak0ViewReward.setForeground(Color.WHITE);
		streak0ViewReward.setFont(new Font("Century Schoolbook L", Font.PLAIN, 24));
		streak0ViewReward.setBackground(new Color(51, 0, 51));
		GridBagConstraints gbc_streak0ViewReward = new GridBagConstraints();
		gbc_streak0ViewReward.insets = new Insets(0, 0, 0, 5);
		gbc_streak0ViewReward.gridx = 1;
		gbc_streak0ViewReward.gridy = 9;
		add(streak0ViewReward, gbc_streak0ViewReward);

	}

}
