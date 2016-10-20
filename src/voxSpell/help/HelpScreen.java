package voxSpell.help;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import voxSpell.GUI.GUI;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collections;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.SwingConstants;

public class HelpScreen extends JFrame {

	private JPanel contentPane;
	private JButton newQuiz;
	private JButton review;
	private JButton stats;
	private JButton achievements;
	private JButton settings;
	private JTextArea helpArea;
	private JScrollPane scrollPane;
	private JLabel title;
	
	/**
	 * JFrame which shows the help for the application
	 */
	public HelpScreen() {
		this.setVisible(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setSize(590, 500);
		setSize(590, 500);
		//Set up content pane in terms of layout and colour
		contentPane.setBackground(GUI.background);
		contentPane.setForeground(GUI.foreground);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0, 900, 20, 0};
		gbl_contentPane.rowHeights = new int[]{30, 20, 0, 0, 0, 0, 0, 70, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		title = new JLabel("Help");
		title.setHorizontalAlignment(SwingConstants.CENTER);
		title.setForeground(GUI.foreground);
		title.setFont(new Font(GUI.FONT, Font.PLAIN, 36));
		GridBagConstraints gbc_title = new GridBagConstraints();
		gbc_title.gridwidth = 4;
		gbc_title.insets = new Insets(0, 0, 5, 5);
		gbc_title.gridx = 0;
		gbc_title.gridy = 1;
		contentPane.add(title, gbc_title);

		
		//Scroll pane showing help text
		scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.gridheight = 5;
		gbc_scrollPane.insets = new Insets(0, 0, 5, 5);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 2;
		gbc_scrollPane.gridy = 2;
		contentPane.add(scrollPane, gbc_scrollPane);
		scrollPane.setForeground(GUI.foreground);
		
		helpArea = new JTextArea("Select a mode to get help with on the left \n <<");
		helpArea.setWrapStyleWord(true);
		helpArea.setLineWrap(true);
		helpArea.setBackground(new Color(51, 0, 51));
		helpArea.setEditable(false);
		helpArea.setForeground(GUI.foreground);
		helpArea.setFont(new Font(GUI.FONT, Font.PLAIN, 24));
		scrollPane.setViewportView(helpArea);
		
		//New Quiz button
		newQuiz = new JButton("");
		newQuiz.setIcon(new ImageIcon(GUI.PATH+"/play.png"));
		newQuiz.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				helpArea.setText(getHelpText("NewQuiz"));
				title.setText("New Quiz");
			}
		});
		newQuiz.setForeground(GUI.foreground);
		newQuiz.setFont(new Font(GUI.FONT, Font.PLAIN, 28));
		newQuiz.setBackground(new Color(51, 0, 51));
		GridBagConstraints gbc_newQuiz = new GridBagConstraints();
		gbc_newQuiz.insets = new Insets(0, 0, 5, 5);
		gbc_newQuiz.gridx = 1;
		gbc_newQuiz.gridy = 2;
		contentPane.add(newQuiz, gbc_newQuiz);

		//Review button
		review = new JButton("");
		review.setIcon(new ImageIcon(GUI.PATH+"/review.png"));
		review.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				helpArea.setText(getHelpText("Review"));
				title.setText("Review");
			}
		});
		review.setForeground(GUI.foreground);
		review.setFont(new Font(GUI.FONT, Font.PLAIN, 28));
		review.setBackground(new Color(51, 0, 51));
		GridBagConstraints gbc_review = new GridBagConstraints();
		gbc_review.insets = new Insets(0, 0, 5, 5);
		gbc_review.gridx = 1;
		gbc_review.gridy = 3;
		contentPane.add(review, gbc_review);
		
		//Stats button
		stats = new JButton("");
		stats.setIcon(new ImageIcon(GUI.PATH+"/stats.png"));
		stats.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				helpArea.setText(getHelpText("stats"));
				title.setText("Statistics");
			}
		});
		stats.setForeground(GUI.foreground);
		stats.setFont(new Font(GUI.FONT, Font.PLAIN, 28));
		stats.setBackground(new Color(51, 0, 51));
		GridBagConstraints gbc_stats = new GridBagConstraints();
		gbc_stats.insets = new Insets(0, 0, 5, 5);
		gbc_stats.gridx = 1;
		gbc_stats.gridy = 4;
		contentPane.add(stats, gbc_stats);
		
		//Achievements button
		achievements = new JButton("");
		achievements.setIcon(new ImageIcon(GUI.PATH+"/achievements.png"));
		achievements.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				helpArea.setText(getHelpText("achievements"));
				title.setText("Achievements");
			}
		});
		achievements.setForeground(GUI.foreground);
		achievements.setFont(new Font(GUI.FONT, Font.PLAIN, 28));
		achievements.setBackground(new Color(51, 0, 51));
		GridBagConstraints gbc_achievements = new GridBagConstraints();
		gbc_achievements.insets = new Insets(0, 0, 5, 5);
		gbc_achievements.gridx = 1;
		gbc_achievements.gridy = 5;
		contentPane.add(achievements, gbc_achievements);
		
		//Settings button
		settings = new JButton("");
		settings.setIcon(new ImageIcon(GUI.PATH+"/settings.png"));
		settings.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				helpArea.setText(getHelpText("settings"));
				title.setText("Settings");
			}
		});
		settings.setForeground(GUI.foreground);
		settings.setFont(new Font(GUI.FONT, Font.PLAIN, 28));
		settings.setBackground(new Color(51, 0, 51));
		GridBagConstraints gbc_settings = new GridBagConstraints();
		gbc_settings.insets = new Insets(0, 0, 5, 5);
		gbc_settings.gridx = 1;
		gbc_settings.gridy = 6;
		contentPane.add(settings, gbc_settings);
		
	}
	
	
	/**
	 * Retrieves the help text from the .txt file in the Help folder for the specified mode
	 * @param mode
	 * @return
	 */
	private String getHelpText(String mode){
		File help = new File(GUI.PATH + "/Help/" + mode);
		StringBuilder text = new StringBuilder();
		if(help.exists()){
			try{
				BufferedReader wordListRead = new BufferedReader(new FileReader(help));
				String word;
				while((word = wordListRead.readLine()) != null){
					text.append(word + "\n");
				}
				wordListRead.close();	

			} catch (IOException e){
				JOptionPane.showMessageDialog(null, "Error: unable to load  help for " + help + ".");

			}
		}
		return text.toString();
	}
}
