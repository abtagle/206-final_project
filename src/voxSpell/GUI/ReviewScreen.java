package voxSpell.GUI;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Font;
import javax.swing.SwingConstants;

import voxSpell.quiz.Review;

import java.awt.Insets;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ReviewScreen extends JPanel {
	
	private Review currentReview;

	/**
	 * Create the panel.
	 */
	public ReviewScreen(boolean isFailed) {
		
		currentReview = new Review(isFailed);
		
		setBackground(new Color(51, 0, 51));
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{80, 40, 160, 160, 160, 40, 80, 0};
		gridBagLayout.rowHeights = new int[]{20, 0, 0, 0, 20, 0, 60, 0, 80, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel title = new JLabel("Review");
		title.setVerticalAlignment(SwingConstants.BOTTOM);
		title.setHorizontalAlignment(SwingConstants.CENTER);
		title.setForeground(Color.WHITE);
		title.setFont(new Font("Century Schoolbook L", Font.BOLD, 72));
		GridBagConstraints gbc_title = new GridBagConstraints();
		gbc_title.fill = GridBagConstraints.HORIZONTAL;
		gbc_title.gridwidth = 7;
		gbc_title.insets = new Insets(0, 0, 5, 0);
		gbc_title.gridx = 0;
		gbc_title.gridy = 1;
		add(title, gbc_title);
		
		JLabel wordNumber = new JLabel("Word 1 of 0");
		wordNumber.setHorizontalAlignment(SwingConstants.CENTER);
		wordNumber.setForeground(Color.WHITE);
		wordNumber.setFont(new Font("Century Schoolbook L", Font.PLAIN, 36));
		GridBagConstraints gbc_wordNumber = new GridBagConstraints();
		gbc_wordNumber.gridwidth = 7;
		gbc_wordNumber.insets = new Insets(0, 0, 5, 0);
		gbc_wordNumber.gridx = 0;
		gbc_wordNumber.gridy = 3;
		add(wordNumber, gbc_wordNumber);
		
		JLabel word = new JLabel("?");
		word.setHorizontalAlignment(SwingConstants.CENTER);
		word.setForeground(Color.WHITE);
		word.setFont(new Font("Century Schoolbook L", Font.PLAIN, 36));
		GridBagConstraints gbc_word = new GridBagConstraints();
		gbc_word.insets = new Insets(0, 0, 5, 0);
		gbc_word.fill = GridBagConstraints.HORIZONTAL;
		gbc_word.gridwidth = 7;
		gbc_word.gridx = 0;
		gbc_word.gridy = 5;
		add(word, gbc_word);
		
		JButton previous = new JButton("<<");
		previous.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		previous.setForeground(new Color(51, 0, 51));
		previous.setFont(new Font("Century Schoolbook L", Font.PLAIN, 28));
		GridBagConstraints gbc_previous = new GridBagConstraints();
		gbc_previous.fill = GridBagConstraints.HORIZONTAL;
		gbc_previous.insets = new Insets(0, 0, 5, 5);
		gbc_previous.gridx = 1;
		gbc_previous.gridy = 6;
		add(previous, gbc_previous);
		
		JButton next = new JButton(">>");
		next.setForeground(new Color(51, 0, 51));
		next.setFont(new Font("Century Schoolbook L", Font.PLAIN, 28));
		GridBagConstraints gbc_next = new GridBagConstraints();
		gbc_next.insets = new Insets(0, 0, 5, 5);
		gbc_next.gridx = 5;
		gbc_next.gridy = 6;
		add(next, gbc_next);
		
		JButton menu = new JButton("Back To Menu");
		menu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GUI.getInstance().setContentPane(new MainMenu());
			}
		});
		
		JButton relisten = new JButton("Relisten");
		relisten.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		relisten.setForeground(new Color(51, 0, 51));
		relisten.setFont(new Font("Century Schoolbook L", Font.PLAIN, 28));
		GridBagConstraints gbc_relisten = new GridBagConstraints();
		gbc_relisten.gridwidth = 7;
		gbc_relisten.insets = new Insets(0, 0, 5, 5);
		gbc_relisten.gridx = 0;
		gbc_relisten.gridy = 7;
		add(relisten, gbc_relisten);
		menu.setForeground(new Color(51, 0, 51));
		menu.setFont(new Font("Century Schoolbook L", Font.PLAIN, 28));
		GridBagConstraints gbc_menu = new GridBagConstraints();
		gbc_menu.fill = GridBagConstraints.HORIZONTAL;
		gbc_menu.insets = new Insets(0, 0, 5, 5);
		gbc_menu.gridx = 2;
		gbc_menu.gridy = 10;
		add(menu, gbc_menu);

	}
	

}
