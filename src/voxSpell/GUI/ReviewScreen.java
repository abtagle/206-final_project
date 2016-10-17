package voxSpell.GUI;

import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import java.awt.Font;
import javax.swing.SwingConstants;

import voxSpell.quiz.Review;

import java.awt.Insets;
import javax.swing.JButton;
import javax.swing.JFrame;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JToggleButton;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
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
	private JButton remove;
	private JButton relisten;
	private JButton next;
	private JButton previous;
	private JLabel title;
	private JButton viewList;
	private JButton shuffle;
	/**
	 * Create the panel.
	 */
	public ReviewScreen(boolean isFailed) {
		currentReview = new Review(isFailed);
		
		setBackground(GUI.background);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{20, 40, 160, 160, 160, 40, 20, 0};
		gridBagLayout.rowHeights = new int[]{20, 0, 0, 0, 60, 60, 40, 0, 0, 50, 0, 30, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		//Previous Button
		previous = new JButton("<<");
		previous.setMnemonic(KeyEvent.VK_KP_LEFT);
		previous.setBackground(GUI.background);
		previous.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				currentReview.previousWord();		
				setWordView();			
			}
		});
		//Title of the panel
		title = new JLabel("Review");
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
		
		shuffle = new JButton("Shuffle");
		shuffle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				currentReview.shuffle();
				wordNumber.setText("Word 1 of " + (currentReview.getLength()));
				setWordView();
			}
		});
		shuffle.setForeground(GUI.foreground);
		shuffle.setFont(new Font("Century Schoolbook L", Font.PLAIN, 18));
		shuffle.setBackground(GUI.background);
		GridBagConstraints gbc_shuffle = new GridBagConstraints();
		gbc_shuffle.gridwidth = 7;
		gbc_shuffle.insets = new Insets(0, 0, 5, 5);
		gbc_shuffle.gridx = 0;
		gbc_shuffle.gridy = 3;
		add(shuffle, gbc_shuffle);
		
		//Label that says what word you are on
		wordNumber = new JLabel("Word 1 of " + (currentReview.getLength()));
		wordNumber.setHorizontalAlignment(SwingConstants.CENTER);
		wordNumber.setForeground(GUI.foreground);
		wordNumber.setFont(new Font(GUI.FONT, Font.PLAIN, 36));
		GridBagConstraints gbc_wordNumber = new GridBagConstraints();
		gbc_wordNumber.gridwidth = 7;
		gbc_wordNumber.insets = new Insets(0, 0, 5, 0);
		gbc_wordNumber.gridx = 0;
		gbc_wordNumber.gridy = 4;
		add(wordNumber, gbc_wordNumber);
		previous.setForeground(GUI.foreground);
		previous.setFont(new Font(GUI.FONT, Font.BOLD, 28));
		GridBagConstraints gbc_previous = new GridBagConstraints();
		gbc_previous.fill = GridBagConstraints.BOTH;
		gbc_previous.insets = new Insets(0, 0, 5, 5);
		gbc_previous.gridx = 1;
		gbc_previous.gridy = 5;
		add(previous, gbc_previous);
		
		//Next button
		next = new JButton(">>");
		next.setBackground(GUI.background);
		next.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				currentReview.nextWord();
				setWordView();
			}
		});
		
		//Label that shows spelling if opted to
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
		
		//Back to menu button
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
		gbc_menu.gridx = 2;
		gbc_menu.gridy = 10;
		add(menu, gbc_menu);
		
		//Relisten button
		relisten = new JButton("Listen to the Word");
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
		gbc_relisten.gridy = 6;
		add(relisten, gbc_relisten);
		
		
		//Button that toggles if the spelling is visible
		viewWordToggle = new JToggleButton("Show Text");
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
				gbc_viewWordToggle.gridy = 7;
				add(viewWordToggle, gbc_viewWordToggle);
		//Remove Button
				if(isFailed){
					remove = new JButton("Remove Word");
					remove.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							int reply = JOptionPane.showConfirmDialog(null, "Are you sure you know the word \"" + currentReview.getWord() +"\" well enough to remove it from the list?", "Remove Word", JOptionPane.YES_NO_OPTION);
							if (reply == JOptionPane.YES_OPTION) {
								JOptionPane.showMessageDialog(null, "\""+currentReview.getWord()+"\" has been removed from the Failed list", "Remove Word", JOptionPane.INFORMATION_MESSAGE);
								currentReview.removeWord();
								if(currentReview.getLength() == 0){
									JOptionPane.showMessageDialog(null, "There are no words left to review. You will be taken back to the Main Menu.", "No Words to Review", JOptionPane.ERROR_MESSAGE);
									GUI.getInstance().setContentPane(new MainMenu());
								}
							}
						}
					});
					remove.setForeground(UIManager.getColor("Button.disabledToolBarBorderBackground"));
					remove.setFont(new Font("Century Schoolbook L", Font.PLAIN, 28));
					remove.setBackground(Color.RED);
					GridBagConstraints gbc_remove = new GridBagConstraints();
					gbc_remove.gridwidth = 7;
					gbc_remove.insets = new Insets(0, 0, 5, 5);
					gbc_remove.gridx = 0;
					gbc_remove.gridy = 8;
					add(remove, gbc_remove);					
				}
		
		
		viewList = new JButton("View List");
		viewList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new WordListView(currentReview.getReviewList());
			}
		});
		viewList.setForeground(GUI.foreground);
		viewList.setFont(new Font(GUI.FONT, Font.PLAIN, 28));
		viewList.setBackground(GUI.background);
		GridBagConstraints gbc_viewList = new GridBagConstraints();
		gbc_viewList.insets = new Insets(0, 0, 5, 5);
		gbc_viewList.gridx = 4;
		gbc_viewList.gridy = 10;
		add(viewList, gbc_viewList);
		
		//Tells user to go back to the menu if there are no words to review
		if(currentReview.getLength() == 0){
			JOptionPane.showMessageDialog(null, "There are no words available to review from that category. Please go back to the main menu", "Review", JOptionPane.ERROR_MESSAGE);
			viewWordToggle.setEnabled(false);
			next.setEnabled(false);
			previous.setEnabled(false);
			relisten.setEnabled(false);
			viewList.setEnabled(false);
			remove.setEnabled(false);
		}

	}
	
	/**
	 * Prepares the screen for the new word
	 */
	private void setForNewWord(){
		wordNumber.setText("Word " + (currentReview.getWordNumber()+1) + " of " + currentReview.getLength());

	}
	/**
	 * Sets the word view for the next question
	 */
	private void setWordView(){
		if(viewWordToggle.isSelected()){
			word.setText(currentReview.getWord());
		} else{
			word.setText("?");
		}
		setForNewWord();
	}
}
