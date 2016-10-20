package voxSpell.GUI;

import java.awt.BorderLayout;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

/**
 * Class representing the frame that appears to show all the words that can be reviewed in the current review session
 * Last Modified: 14 October, 2016
 * @author atag549
 *
 */
public class WordListView extends JFrame {

	private JPanel _contentPane;
	private JTextArea _listView;
	private ArrayList<String> _wordList;
	/**
	 * Create the frame.
	 */
	public WordListView(ArrayList<String> wordList) {
		_wordList = wordList;
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		_contentPane = new JPanel();
		_contentPane.setBackground(GUI.background);
		_contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		_contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(_contentPane);

		JScrollPane scrollPane = new JScrollPane();
		_contentPane.add(scrollPane, BorderLayout.CENTER);

		//textarea where you can see all the words and scroll through
		_listView = new JTextArea();
		_listView.setFont(new Font(GUI.FONT,Font.PLAIN, 24));
		_listView.setEditable(false);
		for(String word : _wordList){
			_listView.append(word + "\n");
		}
		((JScrollPane) scrollPane).setViewportView(_listView);
		setVisible(true);
	}

}
