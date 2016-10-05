package voxSpell.GUI;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Insets;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
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

	/**
	 * Create the panel.
	 */
	public StatisticsScreen() {
		setBackground(new Color(51, 0, 51));
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{30, 0, 50, 300, 20, 0, 30, 0};
		gridBagLayout.rowHeights = new int[]{30, 0, 20, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
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
		gbc_levelLabel.insets = new Insets(0, 0, 0, 5);
		gbc_levelLabel.gridx = 1;
		gbc_levelLabel.gridy = 3;
		add(levelLabel, gbc_levelLabel);
		
		chooseLevel = new JComboBox<String>();
		chooseLevel.setFont(new Font("Century Schoolbook L", Font.BOLD, 28));
		GridBagConstraints gbc_chooseLevel = new GridBagConstraints();
		gbc_chooseLevel.fill = GridBagConstraints.HORIZONTAL;
		gbc_chooseLevel.insets = new Insets(0, 0, 0, 5);
		gbc_chooseLevel.gridx = 3;
		gbc_chooseLevel.gridy = 3;
		add(chooseLevel, gbc_chooseLevel);
		
		submitLevel = new JButton("Submit");
		submitLevel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		submitLevel.setForeground(Color.WHITE);
		submitLevel.setFont(new Font("Century Schoolbook L", Font.PLAIN, 28));
		submitLevel.setBackground(new Color(51, 0, 51));
		GridBagConstraints gbc_submitLevel = new GridBagConstraints();
		gbc_submitLevel.insets = new Insets(0, 0, 0, 5);
		gbc_submitLevel.gridx = 5;
		gbc_submitLevel.gridy = 3;
		add(submitLevel, gbc_submitLevel);

	}

}
