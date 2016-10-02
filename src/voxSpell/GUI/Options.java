package voxSpell.GUI;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.JButton;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
/**
 * Options window that appears in quiz for options implemented for the 206 project
 * @author atag549
 *
 */
public class Options extends JFrame {

	private JPanel contentPane;
	private JFrame thisFrame;

	/**
	 * Create the frame.
	 */
	public Options() {
		thisFrame = this;
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(51, 0, 51));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{50, 300, 50, 0};
		gbl_contentPane.rowHeights = new int[]{30, 36, 0, 0, 0, 0, 0, 0, 30, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JLabel title = new JLabel("Options");
		title.setHorizontalAlignment(SwingConstants.CENTER);
		title.setForeground(Color.WHITE);
		title.setFont(new Font("Century Schoolbook L", Font.PLAIN, 36));
		GridBagConstraints gbc_title = new GridBagConstraints();
		gbc_title.gridwidth = 3;
		gbc_title.fill = GridBagConstraints.HORIZONTAL;
		gbc_title.insets = new Insets(0, 0, 5, 0);
		gbc_title.anchor = GridBagConstraints.NORTH;
		gbc_title.gridx = 0;
		gbc_title.gridy = 1;
		contentPane.add(title, gbc_title);
		
		JButton menu = new JButton("Back to Menu");
		menu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int reply = JOptionPane.showConfirmDialog(null, "Are you sure you want to leave this quiz? All quiz progress will be lost.","Exit Quiz",  JOptionPane.YES_NO_OPTION);
				if (reply == JOptionPane.YES_OPTION) {
					dispose();
					GUI.getInstance().setContentPane(new MainMenu());
				}
				
			}
		});
		menu.setForeground(new Color(51, 0, 51));
		menu.setFont(new Font("Century Schoolbook L", Font.PLAIN, 28));
		GridBagConstraints gbc_menu = new GridBagConstraints();
		gbc_menu.fill = GridBagConstraints.HORIZONTAL;
		gbc_menu.insets = new Insets(0, 0, 5, 5);
		gbc_menu.gridx = 1;
		gbc_menu.gridy = 3;
		contentPane.add(menu, gbc_menu);
		
		JButton settings = new JButton("Settings");
		settings.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				thisFrame.setSize(700,500);
				thisFrame.setVisible(false);
				thisFrame.setContentPane(new SettingsScreen());
				thisFrame.setVisible(true);
			}
		});
		settings.setForeground(new Color(51, 0, 51));
		settings.setFont(new Font("Century Schoolbook L", Font.PLAIN, 28));
		GridBagConstraints gbc_settings = new GridBagConstraints();
		gbc_settings.fill = GridBagConstraints.HORIZONTAL;
		gbc_settings.insets = new Insets(0, 0, 5, 5);
		gbc_settings.gridx = 1;
		gbc_settings.gridy = 5;
		contentPane.add(settings, gbc_settings);
		
		JButton stats = new JButton("Statistics");
		stats.setForeground(new Color(51, 0, 51));
		stats.setFont(new Font("Century Schoolbook L", Font.PLAIN, 28));
		GridBagConstraints gbc_stats = new GridBagConstraints();
		gbc_stats.fill = GridBagConstraints.HORIZONTAL;
		gbc_stats.insets = new Insets(0, 0, 5, 5);
		gbc_stats.gridx = 1;
		gbc_stats.gridy = 7;
		contentPane.add(stats, gbc_stats);
	}

}