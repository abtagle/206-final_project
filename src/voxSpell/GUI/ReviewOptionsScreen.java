package voxSpell.GUI;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Insets;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ReviewOptionsScreen extends JPanel {

	/**
	 * Create the panel.
	 */
	public ReviewOptionsScreen() {
		setForeground(GUI.foreground);
		setBackground(GUI.background);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{160, 160, 160, 160, 160, 0};
		gridBagLayout.rowHeights = new int[]{20, 0, 60, 0, 20, 0, 120, 0, 40, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel title = new JLabel("Review");
		title.setVerticalAlignment(SwingConstants.BOTTOM);
		title.setHorizontalAlignment(SwingConstants.CENTER);
		title.setForeground(GUI.foreground);
		title.setFont(new Font("Century Schoolbook L", Font.BOLD, 72));
		GridBagConstraints gbc_title = new GridBagConstraints();
		gbc_title.gridwidth = 5;
		gbc_title.insets = new Insets(0, 0, 5, 0);
		gbc_title.gridx = 0;
		gbc_title.gridy = 1;
		add(title, gbc_title);
		
		JButton reviewFailed = new JButton("Review Failed Words");
		reviewFailed.setBackground(GUI.background);
		reviewFailed.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GUI.getInstance().setContentPane(new ReviewScreen(true));
			}
		});
		reviewFailed.setForeground(GUI.foreground);
		reviewFailed.setFont(new Font("Century Schoolbook L", Font.PLAIN, 28));
		GridBagConstraints gbc_reviewFailed = new GridBagConstraints();
		gbc_reviewFailed.fill = GridBagConstraints.HORIZONTAL;
		gbc_reviewFailed.gridwidth = 3;
		gbc_reviewFailed.insets = new Insets(0, 0, 5, 5);
		gbc_reviewFailed.gridx = 1;
		gbc_reviewFailed.gridy = 3;
		add(reviewFailed, gbc_reviewFailed);
		
		JButton btnReviewCurrentList = new JButton("Review Current Level");
		btnReviewCurrentList.setBackground(GUI.background);
		btnReviewCurrentList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GUI.getInstance().setContentPane(new ReviewScreen(false));
			}
		});
		btnReviewCurrentList.setForeground(GUI.foreground);
		btnReviewCurrentList.setFont(new Font("Century Schoolbook L", Font.PLAIN, 28));
		GridBagConstraints gbc_btnReviewCurrentList = new GridBagConstraints();
		gbc_btnReviewCurrentList.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnReviewCurrentList.gridwidth = 3;
		gbc_btnReviewCurrentList.insets = new Insets(0, 0, 5, 5);
		gbc_btnReviewCurrentList.gridx = 1;
		gbc_btnReviewCurrentList.gridy = 5;
		add(btnReviewCurrentList, gbc_btnReviewCurrentList);
		
		JButton button = new JButton("Back To Menu");
		button.setBackground(GUI.background);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GUI.getInstance().setContentPane(new MainMenu());
			}
		});
		button.setForeground(GUI.foreground);
		button.setFont(new Font("Century Schoolbook L", Font.PLAIN, 28));
		GridBagConstraints gbc_button = new GridBagConstraints();
		gbc_button.fill = GridBagConstraints.HORIZONTAL;
		gbc_button.insets = new Insets(0, 0, 5, 5);
		gbc_button.gridx = 1;
		gbc_button.gridy = 7;
		add(button, gbc_button);

	}

}
