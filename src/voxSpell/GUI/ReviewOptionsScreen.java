package voxSpell.GUI;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Insets;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import javax.swing.UIManager;

import voxSpell.help.HelpScreen;

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
		
		//Review Title
		JLabel title = new JLabel("Review");
		title.setVerticalAlignment(SwingConstants.BOTTOM);
		title.setHorizontalAlignment(SwingConstants.CENTER);
		title.setForeground(GUI.foreground);
		title.setFont(new Font(GUI.FONT, Font.BOLD, 72));
		GridBagConstraints gbc_title = new GridBagConstraints();
		gbc_title.gridwidth = 5;
		gbc_title.insets = new Insets(0, 0, 5, 0);
		gbc_title.gridx = 0;
		gbc_title.gridy = 1;
		add(title, gbc_title);
		
		//Button for failed review
		JButton reviewFailed = new JButton("Review Failed Words");
		reviewFailed.setBackground(GUI.background);
		reviewFailed.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GUI.getInstance().setContentPane(new ReviewScreen(true));
			}
		});
		reviewFailed.setForeground(GUI.foreground);
		reviewFailed.setFont(new Font(GUI.FONT, Font.PLAIN, 28));
		GridBagConstraints gbc_reviewFailed = new GridBagConstraints();
		gbc_reviewFailed.fill = GridBagConstraints.HORIZONTAL;
		gbc_reviewFailed.gridwidth = 3;
		gbc_reviewFailed.insets = new Insets(0, 0, 5, 5);
		gbc_reviewFailed.gridx = 1;
		gbc_reviewFailed.gridy = 3;
		add(reviewFailed, gbc_reviewFailed);
		
		//Button for current level review
		JButton btnReviewCurrentList = new JButton("Review Current Level");
		btnReviewCurrentList.setBackground(GUI.background);
		btnReviewCurrentList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GUI.getInstance().setContentPane(new ReviewScreen(false));
			}
		});
		btnReviewCurrentList.setForeground(GUI.foreground);
		btnReviewCurrentList.setFont(new Font(GUI.FONT, Font.PLAIN, 28));
		GridBagConstraints gbc_btnReviewCurrentList = new GridBagConstraints();
		gbc_btnReviewCurrentList.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnReviewCurrentList.gridwidth = 3;
		gbc_btnReviewCurrentList.insets = new Insets(0, 0, 5, 5);
		gbc_btnReviewCurrentList.gridx = 1;
		gbc_btnReviewCurrentList.gridy = 5;
		add(btnReviewCurrentList, gbc_btnReviewCurrentList);
		
		//back to menu button
		JButton menu = new JButton("Back To Menu");
		menu.setBackground(GUI.background);
		menu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GUI.getInstance().setContentPane(new MainMenu());
			}
		});
		menu.setForeground(GUI.foreground);
		menu.setFont(new Font(GUI.FONT, Font.PLAIN, 28));
		GridBagConstraints gbc_menu = new GridBagConstraints();
		gbc_menu.fill = GridBagConstraints.HORIZONTAL;
		gbc_menu.insets = new Insets(0, 0, 5, 5);
		gbc_menu.gridx = 1;
		gbc_menu.gridy = 7;
		add(menu, gbc_menu);
		
		//help button
		JLabel help = new JLabel("");
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
		gbc_help.insets = new Insets(0, 0, 5, 0);
		gbc_help.gridx = 4;
		gbc_help.gridy = 7;
		add(help, gbc_help);

	}

}
