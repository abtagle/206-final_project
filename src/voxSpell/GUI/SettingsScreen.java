package voxSpell.GUI;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

import java.awt.Color;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import javax.swing.SwingConstants;

import voxSpell.quiz.Lists;
import voxSpell.quiz.Settings;

import javax.swing.JComboBox;
import javax.swing.JFileChooser;

import java.awt.Insets;
import java.awt.Font;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.awt.event.ActionEvent;

public class SettingsScreen extends JPanel {

	/**
	 * Swing GUI representation of the options menu for this application
	 * Author: Aimee Tagle atag549
	 * Last Modified: 02 October, 2016
	 */
	
	private JComboBox<String> levelSelect;
	private JComboBox<String> voiceSelect;
	private HashMap<String, String> voiceNames;
	private JLabel currentLevel;
	private JLabel sampleWords;
	private JComboBox<String> quizSizeSelect;
	private JButton button;
	private JButton submitLevel;
	private JButton submitVoice;
	private JButton submitQuizSize;
	private JButton theme;
	private JButton btnBackToMenu;
	
	public SettingsScreen() {
		GUI.getInstance().getFrame().setVisible(true);
		setBackground(GUI.background);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{20, 190, 20, 160, 0, 160, 160, 0, 160, 20, 0};
		gridBagLayout.rowHeights = new int[]{90, 20, 0, 20, 0, 0, 0, 0, 0, 20, 0, 20, 0, 0, 20, 0, 30, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 1.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel label = new JLabel("Settings");
		label.setVerticalAlignment(SwingConstants.BOTTOM);
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setForeground(GUI.foreground);
		label.setFont(new Font(GUI.FONT, Font.BOLD, 72));
		GridBagConstraints gbc_label = new GridBagConstraints();
		gbc_label.insets = new Insets(0, 0, 5, 0);
		gbc_label.fill = GridBagConstraints.BOTH;
		gbc_label.gridwidth = 9;
		gbc_label.gridx = 1;
		gbc_label.gridy = 0;
		add(label, gbc_label);
		
		button = new JButton("Change Word List");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser chooser = new JFileChooser();
			    int returnVal = chooser.showOpenDialog(null);
			    if(returnVal == JFileChooser.APPROVE_OPTION) {
			    	if(chooser.getSelectedFile()!= null)
			            Lists.getInstance().setWordList(chooser.getSelectedFile());
			    		Settings.getInstance().setLevel(Lists.getInstance().getListNames().get(0));
			    }
			    GUI.getInstance().setContentPane(new SettingsScreen());
			}
		});
		button.setForeground(GUI.foreground);
		button.setFont(new Font(GUI.FONT, Font.PLAIN, 28));
		button.setBackground(GUI.background);
		GridBagConstraints gbc_button = new GridBagConstraints();
		gbc_button.fill = GridBagConstraints.HORIZONTAL;
		gbc_button.gridwidth = 4;
		gbc_button.insets = new Insets(0, 0, 5, 5);
		gbc_button.gridx = 3;
		gbc_button.gridy = 2;
		add(button, gbc_button);
		
		//Level Select
		JLabel levelLabel = new JLabel("Level");
		levelLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		levelLabel.setForeground(GUI.foreground);
		levelLabel.setFont(new Font(GUI.FONT, Font.PLAIN, 36));
		GridBagConstraints gbc_levelLabel = new GridBagConstraints();
		gbc_levelLabel.anchor = GridBagConstraints.EAST;
		gbc_levelLabel.fill = GridBagConstraints.VERTICAL;
		gbc_levelLabel.insets = new Insets(0, 0, 5, 5);
		gbc_levelLabel.gridx = 1;
		gbc_levelLabel.gridy = 4;
		add(levelLabel, gbc_levelLabel);
		
		levelSelect = new JComboBox<String>();
		levelSelect.setFont(new Font(GUI.FONT, Font.BOLD, 28));
		ArrayList<String> levels = Lists.getInstance().getListNames();
		for(String list : levels){
			levelSelect.addItem(list);
		}
		GridBagConstraints gbc_levelSelect = new GridBagConstraints();
		gbc_levelSelect.gridwidth = 4;
		gbc_levelSelect.insets = new Insets(0, 0, 5, 5);
		gbc_levelSelect.fill = GridBagConstraints.BOTH;
		gbc_levelSelect.gridx = 3;
		gbc_levelSelect.gridy = 4;
		add(levelSelect, gbc_levelSelect);
		
		submitLevel = new JButton("Submit");
		submitLevel.setBackground(GUI.background);
		submitLevel.setFont(new Font(GUI.FONT, Font.PLAIN, 28));
		submitLevel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String selected = (String)levelSelect.getSelectedItem();
				Settings.getInstance().setLevel(selected);
				setCurrentLevelText();
				setSampleWords();
				JOptionPane.showMessageDialog(null, "Your are now playing the level  \"" + levelSelect.getSelectedItem() + "\".","Changed Level", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		submitLevel.setForeground(GUI.foreground);
		GridBagConstraints gbc_submitLevel = new GridBagConstraints();
		gbc_submitLevel.fill = GridBagConstraints.BOTH;
		gbc_submitLevel.insets = new Insets(0, 0, 5, 5);
		gbc_submitLevel.gridx = 8;
		gbc_submitLevel.gridy = 4;
		add(submitLevel, gbc_submitLevel);
		
		//Voice-related things
		JLabel voiceLabel = new JLabel("Voice");
		voiceLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		voiceLabel.setForeground(GUI.foreground);
		voiceLabel.setFont(new Font(GUI.FONT, Font.PLAIN, 36));
		GridBagConstraints gbc_voiceLabel = new GridBagConstraints();
		gbc_voiceLabel.anchor = GridBagConstraints.EAST;
		gbc_voiceLabel.insets = new Insets(0, 0, 5, 5);
		gbc_voiceLabel.gridx = 1;
		gbc_voiceLabel.gridy = 6;
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
		
		voiceSelect.setFont(new Font(GUI.FONT, Font.BOLD, 28));
		GridBagConstraints gbc_voiceSelect = new GridBagConstraints();
		gbc_voiceSelect.gridwidth = 4;
		gbc_voiceSelect.insets = new Insets(0, 0, 5, 5);
		gbc_voiceSelect.fill = GridBagConstraints.BOTH;
		gbc_voiceSelect.gridx = 3;
		gbc_voiceSelect.gridy = 6;
		
		voiceSelect.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Settings.getInstance().saySampleVoicePhrase(voiceNames.get((String)voiceSelect.getSelectedItem()));
			}
		});
		
		add(voiceSelect, gbc_voiceSelect);
		
		submitVoice = new JButton("Submit");
		submitVoice.setBackground(GUI.background);
		submitVoice.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Settings.getInstance().setVoice(voiceNames.get((String)voiceSelect.getSelectedItem()));
				JOptionPane.showMessageDialog(null, "Your voice has successfully been changed to " + (String)voiceSelect.getSelectedItem(), "Changed Voice", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		submitVoice.setForeground(GUI.foreground);
		submitVoice.setFont(new Font(GUI.FONT, Font.PLAIN, 28));
		GridBagConstraints gbc_submitVoice = new GridBagConstraints();
		gbc_submitVoice.fill = GridBagConstraints.HORIZONTAL;
		gbc_submitVoice.insets = new Insets(0, 0, 5, 5);
		gbc_submitVoice.gridx = 8;
		gbc_submitVoice.gridy = 6;
		add(submitVoice, gbc_submitVoice);
		
		JLabel quizSizeLabel = new JLabel("Quiz Size");
		quizSizeLabel.setHorizontalAlignment(SwingConstants.LEFT);
		quizSizeLabel.setForeground(GUI.foreground);
		quizSizeLabel.setFont(new Font(GUI.FONT, Font.PLAIN, 36));
		GridBagConstraints gbc_quizSizeLabel = new GridBagConstraints();
		gbc_quizSizeLabel.anchor = GridBagConstraints.EAST;
		gbc_quizSizeLabel.insets = new Insets(0, 0, 5, 5);
		gbc_quizSizeLabel.gridx = 1;
		gbc_quizSizeLabel.gridy = 8;
		add(quizSizeLabel, gbc_quizSizeLabel);
		
		quizSizeSelect = new JComboBox<String>();
		quizSizeSelect.setModel(new DefaultComboBoxModel(new String[] {"3", "5", "10"}));
		quizSizeSelect.setFont(new Font(GUI.FONT, Font.BOLD, 28));
		GridBagConstraints gbc_quizSizeSelect = new GridBagConstraints();
		gbc_quizSizeSelect.gridwidth = 4;
		gbc_quizSizeSelect.insets = new Insets(0, 0, 5, 5);
		gbc_quizSizeSelect.fill = GridBagConstraints.BOTH;
		gbc_quizSizeSelect.gridx = 3;
		gbc_quizSizeSelect.gridy = 8;
		add(quizSizeSelect, gbc_quizSizeSelect);
		
		submitQuizSize = new JButton("Submit");
		submitQuizSize.setBackground(GUI.background);
		submitQuizSize.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Settings.getInstance().setQuizSize(Integer.parseInt((String)quizSizeSelect.getSelectedItem()));
				JOptionPane.showMessageDialog(null, "The quiz size has been changed to " +quizSizeSelect.getSelectedItem() +".","Changed Level", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		submitQuizSize.setForeground(GUI.foreground);
		submitQuizSize.setFont(new Font(GUI.FONT, Font.PLAIN, 28));
		GridBagConstraints gbc_submitQuizSize = new GridBagConstraints();
		gbc_submitQuizSize.fill = GridBagConstraints.HORIZONTAL;
		gbc_submitQuizSize.insets = new Insets(0, 0, 5, 5);
		gbc_submitQuizSize.gridx = 8;
		gbc_submitQuizSize.gridy = 8;
		add(submitQuizSize, gbc_submitQuizSize);
		
		btnBackToMenu = new JButton("Back To Menu");
		btnBackToMenu.setBackground(GUI.background);
		btnBackToMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GUI.getInstance().setContentPane(new MainMenu());
			}
		});
		
		currentLevel = new JLabel();
		setCurrentLevelText();
		
		JButton restart = new JButton("Restart Game");
		restart.setBackground(new Color(204, 0, 0));
		restart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				restart();
			}
		});
		restart.setForeground(Color.WHITE);
		restart.setFont(new Font(GUI.FONT, Font.PLAIN, 28));
		GridBagConstraints gbc_restart = new GridBagConstraints();
		gbc_restart.fill = GridBagConstraints.HORIZONTAL;
		gbc_restart.gridwidth = 4;
		gbc_restart.insets = new Insets(0, 0, 5, 5);
		gbc_restart.gridx = 3;
		gbc_restart.gridy = 10;
		add(restart, gbc_restart);
		currentLevel.setHorizontalAlignment(SwingConstants.RIGHT);
		currentLevel.setForeground(GUI.foreground);
		currentLevel.setFont(new Font(GUI.FONT, Font.PLAIN, 36));
		GridBagConstraints gbc_currentLevel = new GridBagConstraints();
		gbc_currentLevel.gridwidth = 8;
		gbc_currentLevel.insets = new Insets(0, 0, 5, 5);
		gbc_currentLevel.gridx = 1;
		gbc_currentLevel.gridy = 12;
		add(currentLevel, gbc_currentLevel);
		
		//Show the sample words for the level
		sampleWords = new JLabel();
		setSampleWords();
		sampleWords.setHorizontalAlignment(SwingConstants.CENTER);
		sampleWords.setForeground(GUI.foreground);
		sampleWords.setFont(new Font(GUI.FONT, Font.PLAIN, 24));
		GridBagConstraints gbc_sampleWords = new GridBagConstraints();
		gbc_sampleWords.gridwidth = 10;
		gbc_sampleWords.fill = GridBagConstraints.HORIZONTAL;
		gbc_sampleWords.insets = new Insets(0, 0, 5, 0);
		gbc_sampleWords.gridx = 0;
		gbc_sampleWords.gridy = 13;
		add(sampleWords, gbc_sampleWords);
		btnBackToMenu.setForeground(GUI.foreground);
		btnBackToMenu.setFont(new Font(GUI.FONT, Font.PLAIN, 28));
		GridBagConstraints gbc_btnBackToMenu = new GridBagConstraints();
		gbc_btnBackToMenu.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnBackToMenu.gridwidth = 3;
		gbc_btnBackToMenu.insets = new Insets(0, 0, 5, 5);
		gbc_btnBackToMenu.gridx = 1;
		gbc_btnBackToMenu.gridy = 15;
		add(btnBackToMenu, gbc_btnBackToMenu);
		
		theme = new JButton("Change Theme");
		theme.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GUI.getInstance().changeTheme();
				GUI.getInstance().setContentPane(new SettingsScreen());
			}
		});
		theme.setForeground(GUI.foreground);
		theme.setFont(new Font(GUI.FONT, Font.PLAIN, 28));
		theme.setBackground(GUI.background);
		GridBagConstraints gbc_theme = new GridBagConstraints();
		gbc_theme.anchor = GridBagConstraints.EAST;
		gbc_theme.gridwidth = 3;
		gbc_theme.insets = new Insets(0, 0, 5, 5);
		gbc_theme.gridx = 6;
		gbc_theme.gridy = 15;
		add(theme, gbc_theme);

	}
	private void setCurrentLevelText(){
		currentLevel.setText("Current Level: " + Settings.getInstance().getLevel() );
		currentLevel.repaint();
	}
	private void setSampleWords(){
		sampleWords.setText("Sample Level Words: " + Lists.getInstance().getWordList(Settings.getInstance().getLevel()).getWord(0) + ", " + Lists.getInstance().getWordList(Settings.getInstance().getLevel()).getWord(1) + ", " + Lists.getInstance().getWordList(Settings.getInstance().getLevel()).getWord(2));
		sampleWords.repaint();
	}
	private void restart(){
		int reply = JOptionPane.showConfirmDialog(null, "Are you sure you want to RESTART YOUR GAME? All your achievements and streaks will be lost.", "Restart Game", JOptionPane.YES_NO_OPTION);
		if (reply == JOptionPane.YES_OPTION) {
			Lists.getInstance().clearStats();
			JOptionPane.showMessageDialog(null, "Your game has been restarted", "Restart Game", JOptionPane.INFORMATION_MESSAGE);
		}
	}
}