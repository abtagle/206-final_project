package voxSpell.GUI;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import java.awt.Font;
import javax.swing.SwingConstants;

import voxSpell.quiz.Review;

import java.awt.Insets;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JToggleButton;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
/**
 * 
 * Class representing the view you see when you review words in a flashcard-like setting
 * 
 * @author atag549
 *
 */
public class ReviewScreen extends JPanel {
	private Review currentReview;

	private JToggleButton viewWordToggle;
	private JLabel word;
	private JLabel wordNumber;
	/**
	 * Create the panel.
	 */
	public ReviewScreen(boolean isFailed) {
		addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_RIGHT){
					currentReview.nextWord();
				} else if(e.getKeyCode() == KeyEvent.VK_LEFT){
					currentReview.previousWord();
				}  else if(e.getKeyCode() == KeyEvent.VK_SPACE){
					currentReview.sayWord();
				} else if(e.getKeyCode() == KeyEvent.VK_SPACE){
					if(viewWordToggle.isSelected()){
						viewWordToggle.setEnabled(false);
						word.setText("?");
						viewWordToggle.setText("Show Text");
					} else {
						viewWordToggle.setEnabled(true);
						word.setText(currentReview.getWord());
						viewWordToggle.setText("Hide Text");
					}
				}
				setForNewWord();
			}
		});
		
		currentReview = new Review(isFailed);
		
		setBackground(GUI.background);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{80, 40, 160, 160, 160, 40, 80, 0};
		gridBagLayout.rowHeights = new int[]{20, 0, 0, 0, 60, 60, 40, 0, 0, 50, 0, 20, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel title = new JLabel("Review");
		title.setVerticalAlignment(SwingConstants.BOTTOM);
		title.setHorizontalAlignment(SwingConstants.CENTER);
		title.setForeground(GUI.foreground);
		title.setFont(new Font(GUI.FONT, Font.BOLD, 72));
		GridBagConstraints gbc_title = new GridBagConstraints();
		gbc_title.fill = GridBagConstraints.HORIZONTAL;
		gbc_title.gridwidth = 7;
		gbc_title.insets = new Insets(0, 0, 5, 0);
		gbc_title.gridx = 0;
		gbc_title.gridy = 1;
		add(title, gbc_title);
		
		wordNumber = new JLabel("Word 1 of " + (currentReview.getLength()));
		wordNumber.setHorizontalAlignment(SwingConstants.CENTER);
		wordNumber.setForeground(GUI.foreground);
		wordNumber.setFont(new Font(GUI.FONT, Font.PLAIN, 36));
		GridBagConstraints gbc_wordNumber = new GridBagConstraints();
		gbc_wordNumber.gridwidth = 7;
		gbc_wordNumber.insets = new Insets(0, 0, 5, 0);
		gbc_wordNumber.gridx = 0;
		gbc_wordNumber.gridy = 3;
		add(wordNumber, gbc_wordNumber);
		
		JButton previous = new JButton("<<");
		previous.setBackground(GUI.background);
		previous.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				currentReview.previousWord();		
				setForNewWord();
				
			}
		});
		previous.setForeground(GUI.foreground);
		previous.setFont(new Font(GUI.FONT, Font.BOLD, 28));
		GridBagConstraints gbc_previous = new GridBagConstraints();
		gbc_previous.fill = GridBagConstraints.BOTH;
		gbc_previous.insets = new Insets(0, 0, 5, 5);
		gbc_previous.gridx = 1;
		gbc_previous.gridy = 5;
		add(previous, gbc_previous);
		
		JButton next = new JButton(">>");
		next.setBackground(GUI.background);
		next.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				currentReview.nextWord();
				setForNewWord();
			}
		});
		
		word = new JLabel("?");
		word.setHorizontalAlignment(SwingConstants.CENTER);
		word.setForeground(GUI.foreground);
		word.setFont(new Font(GUI.FONT, Font.PLAIN, 48));
		GridBagConstraints gbc_word = new GridBagConstraints();
		gbc_word.insets = new Insets(0, 0, 5, 5);
		gbc_word.fill = GridBagConstraints.HORIZONTAL;
		gbc_word.gridwidth = 3;
		gbc_word.gridx = 2;
		gbc_word.gridy = 5;
		add(word, gbc_word);
		next.setForeground(GUI.foreground);
		next.setFont(new Font(GUI.FONT, Font.BOLD, 28));
		GridBagConstraints gbc_next = new GridBagConstraints();
		gbc_next.fill = GridBagConstraints.VERTICAL;
		gbc_next.insets = new Insets(0, 0, 5, 5);
		gbc_next.gridx = 5;
		gbc_next.gridy = 5;
		add(next, gbc_next);
		
		JButton menu = new JButton("Back To Menu");
		menu.setBackground(GUI.background);
		menu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GUI.getInstance().setContentPane(new MainMenu());
			}
		});
		
		JButton relisten = new JButton("Listen to the Word");
		relisten.setBackground(GUI.background);
		relisten.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				currentReview.sayWord();
			}
		});
		relisten.setForeground(GUI.foreground);
		relisten.setFont(new Font(GUI.FONT, Font.PLAIN, 28));
		GridBagConstraints gbc_relisten = new GridBagConstraints();
		gbc_relisten.gridwidth = 7;
		gbc_relisten.insets = new Insets(0, 0, 5, 0);
		gbc_relisten.gridx = 0;
		gbc_relisten.gridy = 7;
		add(relisten, gbc_relisten);
		
		viewWordToggle = new JToggleButton("Show Spelling");
		viewWordToggle.setBackground(GUI.background);
		viewWordToggle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(viewWordToggle.isSelected()){
					word.setText(currentReview.getWord());
					viewWordToggle.setText("Hide Text");
				} else {
					word.setText("?");
					viewWordToggle.setText("Show Text");
				}
			}
		});
		viewWordToggle.setForeground(GUI.foreground);
		viewWordToggle.setFont(new Font(GUI.FONT, Font.PLAIN, 28));
		GridBagConstraints gbc_viewWordToggle = new GridBagConstraints();
		gbc_viewWordToggle.gridwidth = 7;
		gbc_viewWordToggle.insets = new Insets(0, 0, 5, 0);
		gbc_viewWordToggle.gridx = 0;
		gbc_viewWordToggle.gridy = 8;
		add(viewWordToggle, gbc_viewWordToggle);
		menu.setForeground(GUI.foreground);
		menu.setFont(new Font(GUI.FONT, Font.PLAIN, 28));
		GridBagConstraints gbc_menu = new GridBagConstraints();
		gbc_menu.fill = GridBagConstraints.HORIZONTAL;
		gbc_menu.insets = new Insets(0, 0, 5, 5);
		gbc_menu.gridx = 2;
		gbc_menu.gridy = 10;
		add(menu, gbc_menu);
		
		if(currentReview.getLength() == 0){
			JOptionPane.showMessageDialog(null, "There are no words available to review from that category. Please go back to the main menu", "Review", JOptionPane.ERROR_MESSAGE);
			viewWordToggle.setEnabled(false);
			next.setEnabled(false);
			previous.setEnabled(false);
			relisten.setEnabled(false);
		}

	}
	
	
	private void setForNewWord(){
		wordNumber.setText("Word " + (currentReview.getWordNumber()+1) + " of " + currentReview.getLength());
		if(viewWordToggle.isSelected()){
			word.setText(currentReview.getWord());
		} else{
			word.setText("?");
		}
	}

}
