package voxSpell.GUI;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Insets;

public class EndOfQuiz extends JPanel {

	/**
	 * Create the panel.
	 */
	
	public EndOfQuiz() {
		setBackground(new Color(51, 0, 51));
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel congratulatoins = new JLabel("Congratulations");
		congratulatoins.setHorizontalAlignment(SwingConstants.CENTER);
		congratulatoins.setForeground(Color.WHITE);
		congratulatoins.setFont(new Font("Century Schoolbook L", Font.BOLD, 72));
		GridBagConstraints gbc_congratulatoins = new GridBagConstraints();
		gbc_congratulatoins.insets = new Insets(0, 0, 5, 0);
		gbc_congratulatoins.gridx = 1;
		gbc_congratulatoins.gridy = 0;
		add(congratulatoins, gbc_congratulatoins);
		
		JLabel label = new JLabel("Level");
		label.setHorizontalAlignment(SwingConstants.RIGHT);
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Century Schoolbook L", Font.PLAIN, 36));
		GridBagConstraints gbc_label = new GridBagConstraints();
		gbc_label.gridx = 1;
		gbc_label.gridy = 2;
		add(label, gbc_label);

	}

}