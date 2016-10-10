package voxSpell.GUI;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Font;
import javax.swing.SwingConstants;

import voxSpell.achievements.AchievementList;

import java.awt.Insets;
import javax.swing.JProgressBar;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
/**
 * Class representing the screen users see when they view achievements
 * @author atag549
 *
 */
public class AchievementScreen extends JPanel {
	private JLabel title;
	private JLabel streak;
	private JLabel wordsRight;
	private JButton streak10ViewReward;
	private JLabel streakLabel25;
	private JButton streak25ViewReward;
	private JLabel streakLabel50;
	private JButton streak50ViewReward;
	private JButton menu;
	private ArrayList<JButton> viewRewardButtons;
	private JLabel rightLabel50;
	private JLabel rightLabel100;
	private JLabel rightLabel250;
	private JButton right50ViewReward;
	private JButton right100ViewReward;
	private JButton right250ViewReward;
	private JLabel title2;
	private JLabel eButton;

	/**
	 * Create the panel.
	 */
	public AchievementScreen() {
		viewRewardButtons = new ArrayList <JButton>();
		setBackground(GUI.background);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{80, 300, 0, 300, 80, 0};
		gridBagLayout.rowHeights = new int[]{30, 0, 20, 0, 10, 0, 0, 20, 0, 0, 20, 0, 0, 0, 50, 0, 30, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		title = new JLabel("Achiev");
		title.setVerticalAlignment(SwingConstants.BOTTOM);
		title.setHorizontalAlignment(SwingConstants.RIGHT);
		title.setForeground(GUI.foreground);
		title.setFont(new Font("Century Schoolbook L", Font.BOLD, 72));
		GridBagConstraints gbc_title = new GridBagConstraints();
		gbc_title.anchor = GridBagConstraints.EAST;
		gbc_title.insets = new Insets(0, 0, 5, 5);
		gbc_title.gridwidth = 2;
		gbc_title.gridx = 0;
		gbc_title.gridy = 1;
		add(title, gbc_title);
		
		eButton = new JLabel("e");
		eButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new VideoReward();
			}
		});
		eButton.setVerticalAlignment(SwingConstants.BOTTOM);
		eButton.setHorizontalAlignment(SwingConstants.RIGHT);
		eButton.setForeground(GUI.foreground);
		eButton.setFont(new Font("Century Schoolbook L", Font.BOLD, 72));
		GridBagConstraints gbc_eButton = new GridBagConstraints();
		gbc_eButton.insets = new Insets(0, 0, 5, 5);
		gbc_eButton.gridx = 2;
		gbc_eButton.gridy = 1;
		add(eButton, gbc_eButton);
		
		title2 = new JLabel("ments");
		title2.setVerticalAlignment(SwingConstants.BOTTOM);
		title2.setHorizontalAlignment(SwingConstants.RIGHT);
		title2.setForeground(GUI.foreground);
		title2.setFont(new Font("Century Schoolbook L", Font.BOLD, 72));
		GridBagConstraints gbc_title2 = new GridBagConstraints();
		gbc_title2.anchor = GridBagConstraints.NORTHWEST;
		gbc_title2.insets = new Insets(0, 0, 5, 5);
		gbc_title2.gridx = 3;
		gbc_title2.gridy = 1;
		add(title2, gbc_title2);
		
		streak = new JLabel("Streak Length");
		streak.setHorizontalAlignment(SwingConstants.RIGHT);
		streak.setForeground(GUI.foreground);
		streak.setFont(new Font("Century Schoolbook L", Font.PLAIN, 36));
		GridBagConstraints gbc_streak = new GridBagConstraints();
		gbc_streak.insets = new Insets(0, 0, 5, 5);
		gbc_streak.gridx = 1;
		gbc_streak.gridy = 3;
		add(streak, gbc_streak);
		
		wordsRight = new JLabel("Words Right");
		wordsRight.setHorizontalAlignment(SwingConstants.RIGHT);
		wordsRight.setForeground(GUI.foreground);
		wordsRight.setFont(new Font("Century Schoolbook L", Font.PLAIN, 36));
		GridBagConstraints gbc_wordsRight = new GridBagConstraints();
		gbc_wordsRight.insets = new Insets(0, 0, 5, 5);
		gbc_wordsRight.gridx = 3;
		gbc_wordsRight.gridy = 3;
		add(wordsRight, gbc_wordsRight);
		
		JLabel streakLabel10 = new JLabel("10 Words");
		streakLabel10.setHorizontalAlignment(SwingConstants.RIGHT);
		streakLabel10.setForeground(GUI.foreground);
		streakLabel10.setFont(new Font("Century Schoolbook L", Font.PLAIN, 24));
		GridBagConstraints gbc_streakLabel10 = new GridBagConstraints();
		gbc_streakLabel10.insets = new Insets(0, 0, 5, 5);
		gbc_streakLabel10.gridx = 1;
		gbc_streakLabel10.gridy = 5;
		add(streakLabel10, gbc_streakLabel10);
		
		streak10ViewReward = new JButton("View Reward");
		streak10ViewReward.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new VideoReward(AchievementList.getInstance().getAchievement(0));
			}
		});
		
		rightLabel50 = new JLabel("50 Words");
		rightLabel50.setHorizontalAlignment(SwingConstants.RIGHT);
		rightLabel50.setForeground(GUI.foreground);
		rightLabel50.setFont(new Font("Century Schoolbook L", Font.PLAIN, 24));
		GridBagConstraints gbc_rightLabel50 = new GridBagConstraints();
		gbc_rightLabel50.insets = new Insets(0, 0, 5, 5);
		gbc_rightLabel50.gridx = 3;
		gbc_rightLabel50.gridy = 5;
		add(rightLabel50, gbc_rightLabel50);
		streak10ViewReward.setForeground(GUI.foreground);
		streak10ViewReward.setFont(new Font("Century Schoolbook L", Font.PLAIN, 24));
		streak10ViewReward.setBackground(GUI.background);
		GridBagConstraints gbc_streak10ViewReward = new GridBagConstraints();
		gbc_streak10ViewReward.anchor = GridBagConstraints.NORTH;
		gbc_streak10ViewReward.insets = new Insets(0, 0, 5, 5);
		gbc_streak10ViewReward.gridx = 1;
		gbc_streak10ViewReward.gridy = 6;
		add(streak10ViewReward, gbc_streak10ViewReward);
		
		right50ViewReward = new JButton("View Reward");
		right50ViewReward.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new VideoReward(AchievementList.getInstance().getAchievement(1));
			}
		});
		right50ViewReward.setForeground(GUI.foreground);
		right50ViewReward.setFont(new Font("Century Schoolbook L", Font.PLAIN, 24));
		right50ViewReward.setBackground(GUI.background);
		GridBagConstraints gbc_right50ViewReward = new GridBagConstraints();
		gbc_right50ViewReward.insets = new Insets(0, 0, 5, 5);
		gbc_right50ViewReward.gridx = 3;
		gbc_right50ViewReward.gridy = 6;
		add(right50ViewReward, gbc_right50ViewReward);
		
		streakLabel25 = new JLabel("25 Words");
		streakLabel25.setHorizontalAlignment(SwingConstants.RIGHT);
		streakLabel25.setForeground(GUI.foreground);
		streakLabel25.setFont(new Font("Century Schoolbook L", Font.PLAIN, 24));
		GridBagConstraints gbc_streakLabel25 = new GridBagConstraints();
		gbc_streakLabel25.insets = new Insets(0, 0, 5, 5);
		gbc_streakLabel25.gridx = 1;
		gbc_streakLabel25.gridy = 8;
		add(streakLabel25, gbc_streakLabel25);
		
		rightLabel100 = new JLabel("100 Words");
		rightLabel100.setHorizontalAlignment(SwingConstants.RIGHT);
		rightLabel100.setForeground(GUI.foreground);
		rightLabel100.setFont(new Font("Century Schoolbook L", Font.PLAIN, 24));
		GridBagConstraints gbc_rightLabel100 = new GridBagConstraints();
		gbc_rightLabel100.insets = new Insets(0, 0, 5, 5);
		gbc_rightLabel100.gridx = 3;
		gbc_rightLabel100.gridy = 8;
		add(rightLabel100, gbc_rightLabel100);
		
		streak25ViewReward = new JButton("View Reward");
		streak25ViewReward.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new VideoReward(AchievementList.getInstance().getAchievement(2));
			}
		});
		streak25ViewReward.setForeground(GUI.foreground);
		streak25ViewReward.setFont(new Font("Century Schoolbook L", Font.PLAIN, 24));
		streak25ViewReward.setBackground(GUI.background);
		GridBagConstraints gbc_streak25ViewReward = new GridBagConstraints();
		gbc_streak25ViewReward.insets = new Insets(0, 0, 5, 5);
		gbc_streak25ViewReward.gridx = 1;
		gbc_streak25ViewReward.gridy = 9;
		add(streak25ViewReward, gbc_streak25ViewReward);
		
		right100ViewReward = new JButton("View Reward");
		right100ViewReward.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new VideoReward(AchievementList.getInstance().getAchievement(3));
			}
		});
		right100ViewReward.setForeground(GUI.foreground);
		right100ViewReward.setFont(new Font("Century Schoolbook L", Font.PLAIN, 24));
		right100ViewReward.setBackground(GUI.background);
		GridBagConstraints gbc_right100ViewReward = new GridBagConstraints();
		gbc_right100ViewReward.insets = new Insets(0, 0, 5, 5);
		gbc_right100ViewReward.gridx = 3;
		gbc_right100ViewReward.gridy = 9;
		add(right100ViewReward, gbc_right100ViewReward);
		
		streakLabel50 = new JLabel("50 Words");
		streakLabel50.setHorizontalAlignment(SwingConstants.RIGHT);
		streakLabel50.setForeground(GUI.foreground);
		streakLabel50.setFont(new Font("Century Schoolbook L", Font.PLAIN, 24));
		GridBagConstraints gbc_streakLabel50 = new GridBagConstraints();
		gbc_streakLabel50.insets = new Insets(0, 0, 5, 5);
		gbc_streakLabel50.gridx = 1;
		gbc_streakLabel50.gridy = 11;
		add(streakLabel50, gbc_streakLabel50);
		
		rightLabel250 = new JLabel("250 Words");
		rightLabel250.setHorizontalAlignment(SwingConstants.RIGHT);
		rightLabel250.setForeground(GUI.foreground);
		rightLabel250.setFont(new Font("Century Schoolbook L", Font.PLAIN, 24));
		GridBagConstraints gbc_rightLabel250 = new GridBagConstraints();
		gbc_rightLabel250.insets = new Insets(0, 0, 5, 5);
		gbc_rightLabel250.gridx = 3;
		gbc_rightLabel250.gridy = 11;
		add(rightLabel250, gbc_rightLabel250);
		
		streak50ViewReward = new JButton("View Reward");
		streak50ViewReward.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new VideoReward(AchievementList.getInstance().getAchievement(4));
			}
		});
		streak50ViewReward.setForeground(GUI.foreground);
		streak50ViewReward.setFont(new Font("Century Schoolbook L", Font.PLAIN, 24));
		streak50ViewReward.setBackground(GUI.background);
		GridBagConstraints gbc_streak50ViewReward = new GridBagConstraints();
		gbc_streak50ViewReward.insets = new Insets(0, 0, 5, 5);
		gbc_streak50ViewReward.gridx = 1;
		gbc_streak50ViewReward.gridy = 12;
		add(streak50ViewReward, gbc_streak50ViewReward);
		
		menu = new JButton("Back to Main Menu");
		menu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GUI.getInstance().setContentPane(new MainMenu());
			}
		});
		
		right250ViewReward = new JButton("View Reward");
		right250ViewReward.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new VideoReward(AchievementList.getInstance().getAchievement(5));
			}
		});
		right250ViewReward.setForeground(GUI.foreground);
		right250ViewReward.setFont(new Font("Century Schoolbook L", Font.PLAIN, 24));
		right250ViewReward.setBackground(GUI.background);
		GridBagConstraints gbc_right250ViewReward = new GridBagConstraints();
		gbc_right250ViewReward.insets = new Insets(0, 0, 5, 5);
		gbc_right250ViewReward.gridx = 3;
		gbc_right250ViewReward.gridy = 12;
		add(right250ViewReward, gbc_right250ViewReward);
		menu.setForeground(GUI.foreground);
		menu.setFont(new Font("Century Schoolbook L", Font.PLAIN, 24));
		menu.setBackground(GUI.background);
		GridBagConstraints gbc_menu = new GridBagConstraints();
		gbc_menu.gridwidth = 2;
		gbc_menu.insets = new Insets(0, 0, 5, 5);
		gbc_menu.gridx = 0;
		gbc_menu.gridy = 15;
		add(menu, gbc_menu);
		
		addButtonsToList();
		setButtonEnabling();

	}
	
	private void addButtonsToList(){
		viewRewardButtons.add(streak10ViewReward);
		viewRewardButtons.add(streak25ViewReward);
		viewRewardButtons.add(streak50ViewReward);
		viewRewardButtons.add(right50ViewReward);
		viewRewardButtons.add(right100ViewReward);
		viewRewardButtons.add(right250ViewReward);	
	}
	
	private void setButtonEnabling(){
		for(int i = 0; i < viewRewardButtons.size(); i++){
			if(!AchievementList.getInstance().getShallowCopy().get(i)){
				viewRewardButtons.get(i).setEnabled(false);
			}
		}
	}

}
