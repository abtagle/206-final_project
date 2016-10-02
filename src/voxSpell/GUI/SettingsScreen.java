package voxSpell.GUI;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import javax.swing.SwingConstants;

import voxSpell.quiz.Lists;
import voxSpell.quiz.Settings;

import javax.swing.JComboBox;
import java.awt.Insets;
import java.awt.Font;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.awt.event.ActionEvent;
import javax.swing.JToggleButton;

public class SettingsScreen extends JPanel {

	/**
	 * Swing GUI representation of the options menu for this application
	 * Author: Aimee Tagle atag549
	 * Last Modified: 29 September, 2016
	 */
	
	JComboBox<String> levelSelect;
	JComboBox<String> voiceSelect;
	HashMap<String, String> voiceNames;
	JLabel currentLevel;
	JLabel sampleWords;
	
	public SettingsScreen() {
		GUI.getInstance().getFrame().setVisible(true);
		setBackground(new Color(51, 0, 51));
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{20, 190, 20, 160, 0, 160, 160, 0, 160, 20, 0};
		gridBagLayout.rowHeights = new int[]{120, 0, 0, 0, 0, 0, 0, 0, 20, 0, 0, 20, 0, 20, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 1.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel label = new JLabel("Settings");
		label.setVerticalAlignment(SwingConstants.BOTTOM);
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Century Schoolbook L", Font.BOLD, 72));
		GridBagConstraints gbc_label = new GridBagConstraints();
		gbc_label.anchor = GridBagConstraints.SOUTH;
		gbc_label.insets = new Insets(0, 0, 5, 0);
		gbc_label.fill = GridBagConstraints.HORIZONTAL;
		gbc_label.gridwidth = 9;
		gbc_label.gridx = 1;
		gbc_label.gridy = 0;
		add(label, gbc_label);
		
		//Level Select
		JLabel levelLabel = new JLabel("Level");
		levelLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		levelLabel.setForeground(new Color(255, 255, 255));
		levelLabel.setFont(new Font("Century Schoolbook L", Font.PLAIN, 36));
		GridBagConstraints gbc_levelLabel = new GridBagConstraints();
		gbc_levelLabel.anchor = GridBagConstraints.EAST;
		gbc_levelLabel.fill = GridBagConstraints.VERTICAL;
		gbc_levelLabel.insets = new Insets(0, 0, 5, 5);
		gbc_levelLabel.gridx = 1;
		gbc_levelLabel.gridy = 1;
		add(levelLabel, gbc_levelLabel);
		
		levelSelect = new JComboBox<String>();
		levelSelect.setFont(new Font("Century Schoolbook L", Font.BOLD, 28));
		ArrayList<String> levels = Lists.getInstance().getListNames();
		for(String list : levels){
			levelSelect.addItem(list);
		}
		GridBagConstraints gbc_levelSelect = new GridBagConstraints();
		gbc_levelSelect.gridwidth = 4;
		gbc_levelSelect.insets = new Insets(0, 0, 5, 5);
		gbc_levelSelect.fill = GridBagConstraints.BOTH;
		gbc_levelSelect.gridx = 3;
		gbc_levelSelect.gridy = 1;
		add(levelSelect, gbc_levelSelect);
		
		JButton submitLevel = new JButton("Submit");
		submitLevel.setFont(new Font("Century Schoolbook L", Font.PLAIN, 28));
		submitLevel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String selected = (String)levelSelect.getSelectedItem();
				Settings.getInstance().setLevel(selected);
				setCurrentLevelText();
				setSampleWords();
			}
		});
		submitLevel.setForeground(new Color(51, 0, 51));
		GridBagConstraints gbc_submitLevel = new GridBagConstraints();
		gbc_submitLevel.fill = GridBagConstraints.BOTH;
		gbc_submitLevel.insets = new Insets(0, 0, 5, 5);
		gbc_submitLevel.gridx = 8;
		gbc_submitLevel.gridy = 1;
		add(submitLevel, gbc_submitLevel);
		
		//Voice-related things
		JLabel voiceLabel = new JLabel("Voice");
		voiceLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		voiceLabel.setForeground(Color.WHITE);
		voiceLabel.setFont(new Font("Century Schoolbook L", Font.PLAIN, 36));
		GridBagConstraints gbc_voiceLabel = new GridBagConstraints();
		gbc_voiceLabel.anchor = GridBagConstraints.EAST;
		gbc_voiceLabel.insets = new Insets(0, 0, 5, 5);
		gbc_voiceLabel.gridx = 1;
		gbc_voiceLabel.gridy = 3;
		add(voiceLabel, gbc_voiceLabel);
		
		File pathToVoices = new File("/usr/share/festival/voices/english");
		File[] listOfVoices = pathToVoices.listFiles();
		//Create a model for JComboBox to select voice
		DefaultComboBoxModel<String> selectModel = new DefaultComboBoxModel<String>();
		voiceNames = new HashMap<String, String>();
		String name;
		for (File i : listOfVoices) {
			name = i.getName();
			voiceNames.put(Settings.getInstance().alternateName(name), name);
			selectModel.addElement(Settings.getInstance().alternateName(name));
		}
		voiceSelect = new JComboBox<String>();
		voiceSelect.setModel(selectModel);
		
		voiceSelect.setFont(new Font("Century Schoolbook L", Font.BOLD, 28));
		GridBagConstraints gbc_voiceSelect = new GridBagConstraints();
		gbc_voiceSelect.gridwidth = 4;
		gbc_voiceSelect.insets = new Insets(0, 0, 5, 5);
		gbc_voiceSelect.fill = GridBagConstraints.BOTH;
		gbc_voiceSelect.gridx = 3;
		gbc_voiceSelect.gridy = 3;
		
		voiceSelect.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Settings.getInstance().saySampleVoicePhrase(voiceNames.get((String)voiceSelect.getSelectedItem()));
			}
		});
		
		add(voiceSelect, gbc_voiceSelect);
		
		JButton submitVoice = new JButton("Submit");
		submitVoice.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Settings.getInstance().setVoice(voiceNames.get((String)voiceSelect.getSelectedItem()));
				JOptionPane.showMessageDialog(null, "Your voice has successfully been changed to " + (String)voiceSelect.getSelectedItem(), "Changed Voice", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		submitVoice.setForeground(new Color(51, 0, 51));
		submitVoice.setFont(new Font("Century Schoolbook L", Font.PLAIN, 28));
		GridBagConstraints gbc_submitVoice = new GridBagConstraints();
		gbc_submitVoice.fill = GridBagConstraints.HORIZONTAL;
		gbc_submitVoice.insets = new Insets(0, 0, 5, 5);
		gbc_submitVoice.gridx = 8;
		gbc_submitVoice.gridy = 3;
		add(submitVoice, gbc_submitVoice);
		
		JLabel quizSizeLabel = new JLabel("Quiz Size");
		quizSizeLabel.setHorizontalAlignment(SwingConstants.LEFT);
		quizSizeLabel.setForeground(Color.WHITE);
		quizSizeLabel.setFont(new Font("Century Schoolbook L", Font.PLAIN, 36));
		GridBagConstraints gbc_quizSizeLabel = new GridBagConstraints();
		gbc_quizSizeLabel.anchor = GridBagConstraints.EAST;
		gbc_quizSizeLabel.insets = new Insets(0, 0, 5, 5);
		gbc_quizSizeLabel.gridx = 1;
		gbc_quizSizeLabel.gridy = 5;
		add(quizSizeLabel, gbc_quizSizeLabel);
		
		JComboBox<Integer> quizSizeSelect = new JComboBox<Integer>();
		quizSizeSelect.setFont(new Font("L M Mono Lt10", Font.BOLD, 28));
		GridBagConstraints gbc_quizSizeSelect = new GridBagConstraints();
		gbc_quizSizeSelect.gridwidth = 4;
		gbc_quizSizeSelect.insets = new Insets(0, 0, 5, 5);
		gbc_quizSizeSelect.fill = GridBagConstraints.BOTH;
		gbc_quizSizeSelect.gridx = 3;
		gbc_quizSizeSelect.gridy = 5;
		add(quizSizeSelect, gbc_quizSizeSelect);
		
		JButton submitQuizSize = new JButton("Submit");
		submitQuizSize.setForeground(new Color(51, 0, 51));
		submitQuizSize.setFont(new Font("Century Schoolbook L", Font.PLAIN, 28));
		GridBagConstraints gbc_submitQuizSize = new GridBagConstraints();
		gbc_submitQuizSize.fill = GridBagConstraints.HORIZONTAL;
		gbc_submitQuizSize.insets = new Insets(0, 0, 5, 5);
		gbc_submitQuizSize.gridx = 8;
		gbc_submitQuizSize.gridy = 5;
		add(submitQuizSize, gbc_submitQuizSize);
		
		JLabel musicLabel = new JLabel("Music");
		musicLabel.setHorizontalAlignment(SwingConstants.LEFT);
		musicLabel.setForeground(Color.WHITE);
		musicLabel.setFont(new Font("Century Schoolbook L", Font.PLAIN, 36));
		GridBagConstraints gbc_musicLabel = new GridBagConstraints();
		gbc_musicLabel.anchor = GridBagConstraints.EAST;
		gbc_musicLabel.insets = new Insets(0, 0, 5, 5);
		gbc_musicLabel.gridx = 1;
		gbc_musicLabel.gridy = 7;
		add(musicLabel, gbc_musicLabel);
		
		JToggleButton tglbtnNewToggleButton = new JToggleButton("New toggle button");
		tglbtnNewToggleButton.setForeground(new Color(51, 0, 51));
		tglbtnNewToggleButton.setFont(new Font("Century Schoolbook L", Font.PLAIN, 28));
		GridBagConstraints gbc_tglbtnNewToggleButton = new GridBagConstraints();
		gbc_tglbtnNewToggleButton.fill = GridBagConstraints.BOTH;
		gbc_tglbtnNewToggleButton.gridwidth = 4;
		gbc_tglbtnNewToggleButton.insets = new Insets(0, 0, 5, 5);
		gbc_tglbtnNewToggleButton.gridx = 3;
		gbc_tglbtnNewToggleButton.gridy = 7;
		add(tglbtnNewToggleButton, gbc_tglbtnNewToggleButton);
		
		JButton btnBackToMenu = new JButton("Back To Menu");
		btnBackToMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GUI.getInstance().setContentPane(new MainMenu());
			}
		});
		
		currentLevel = new JLabel();
		setCurrentLevelText();
		currentLevel.setHorizontalAlignment(SwingConstants.RIGHT);
		currentLevel.setForeground(Color.WHITE);
		currentLevel.setFont(new Font("Century Schoolbook L", Font.PLAIN, 36));
		GridBagConstraints gbc_currentLevel = new GridBagConstraints();
		gbc_currentLevel.gridwidth = 8;
		gbc_currentLevel.insets = new Insets(0, 0, 5, 5);
		gbc_currentLevel.gridx = 1;
		gbc_currentLevel.gridy = 9;
		add(currentLevel, gbc_currentLevel);
		
		//Show the sample words for the level
		sampleWords = new JLabel();
		setSampleWords();
		sampleWords.setHorizontalAlignment(SwingConstants.CENTER);
		sampleWords.setForeground(Color.WHITE);
		sampleWords.setFont(new Font("Century Schoolbook L", Font.PLAIN, 24));
		GridBagConstraints gbc_sampleWords = new GridBagConstraints();
		gbc_sampleWords.gridwidth = 10;
		gbc_sampleWords.fill = GridBagConstraints.HORIZONTAL;
		gbc_sampleWords.insets = new Insets(0, 0, 5, 5);
		gbc_sampleWords.gridx = 0;
		gbc_sampleWords.gridy = 10;
		add(sampleWords, gbc_sampleWords);
		btnBackToMenu.setForeground(new Color(51, 0, 51));
		btnBackToMenu.setFont(new Font("Century Schoolbook L", Font.PLAIN, 28));
		GridBagConstraints gbc_btnBackToMenu = new GridBagConstraints();
		gbc_btnBackToMenu.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnBackToMenu.gridwidth = 3;
		gbc_btnBackToMenu.insets = new Insets(0, 0, 5, 5);
		gbc_btnBackToMenu.gridx = 1;
		gbc_btnBackToMenu.gridy = 12;
		add(btnBackToMenu, gbc_btnBackToMenu);

	}
	private void setCurrentLevelText(){
		currentLevel.setText("Current Level: " + Settings.getInstance().getLevel() );
		currentLevel.repaint();
	}
	private void setSampleWords(){
		sampleWords.setText("Sample Level Words: " + Lists.getInstance().getWordList(Settings.getInstance().getLevel()).getWord(0) + ", " + Lists.getInstance().getWordList(Settings.getInstance().getLevel()).getWord(1) + ", " + Lists.getInstance().getWordList(Settings.getInstance().getLevel()).getWord(2));
		sampleWords.repaint();
	}
}