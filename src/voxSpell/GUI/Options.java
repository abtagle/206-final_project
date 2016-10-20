package voxSpell.GUI;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import voxSpell.quiz.Quiz;
import voxSpell.quiz.Settings;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;

import java.awt.Insets;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.HashMap;
import java.awt.event.ActionEvent;
/**
 * Options window that appears in quiz for options implemented for the 206 project. Now it only lets you change the voice
 * @author atag549
 * Last Modified: 21 October, 2016
 *
 */
public class Options extends JFrame {

	private JPanel contentPane;
	private JFrame thisFrame;
	private JButton menu;
	private JButton changeVoice;
	private JButton stats;
	private Quiz _quiz;
	

	/**
	 * Create the frame.
	 */
	public Options(Quiz quiz) {
		thisFrame = this;
		thisFrame.setSize(100, 300);
		_quiz = quiz;
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(GUI.background);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(new ChangeVoice());
		
	}
	
	private class ChangeVoice extends JPanel {

		/**
		 * Create the panel.
		 */
		private JComboBox<String> voiceSelect;
		private HashMap<String, String>voiceNames;
		public ChangeVoice() {
			setBackground(GUI.background);
			GridBagLayout gridBagLayout = new GridBagLayout();
			gridBagLayout.columnWidths = new int[]{30, 200, 30, 0};
			gridBagLayout.rowHeights = new int[]{20, 0, 0, 0, 0, 0, 0};
			gridBagLayout.columnWeights = new double[]{0.0, 1.0, 0.0, Double.MIN_VALUE};
			gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
			setLayout(gridBagLayout);
			
			//Title label that says Change Voice
			JLabel lblChangeVoice = new JLabel("Change Voice");
			lblChangeVoice.setHorizontalAlignment(SwingConstants.CENTER);
			lblChangeVoice.setForeground(GUI.foreground);
			lblChangeVoice.setFont(new Font(GUI.FONT, Font.PLAIN, 36));
			GridBagConstraints gbc_lblChangeVoice = new GridBagConstraints();
			gbc_lblChangeVoice.insets = new Insets(0, 0, 5, 0);
			gbc_lblChangeVoice.fill = GridBagConstraints.HORIZONTAL;
			gbc_lblChangeVoice.gridwidth = 3;
			gbc_lblChangeVoice.gridx = 0;
			gbc_lblChangeVoice.gridy = 1;
			add(lblChangeVoice, gbc_lblChangeVoice);
			
			voiceSelect = new JComboBox<String>();
			voiceSelect.setFont(new Font(GUI.FONT, Font.BOLD, 28));
			voiceSelect.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					Settings.getInstance().saySampleVoicePhrase(voiceNames.get((String)voiceSelect.getSelectedItem()));
				}
			});
			GridBagConstraints gbc_voiceSelect = new GridBagConstraints();
			gbc_voiceSelect.insets = new Insets(0, 0, 5, 5);
			gbc_voiceSelect.fill = GridBagConstraints.HORIZONTAL;
			gbc_voiceSelect.gridx = 1;
			gbc_voiceSelect.gridy = 3;
			add(voiceSelect, gbc_voiceSelect);
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
			voiceSelect.setModel(selectModel);
			
			//Button to submit voice change
			JButton button = new JButton("Submit");
			button.setBackground(GUI.background);
			button.setForeground(GUI.foreground);
			button.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Settings.getInstance().setVoice(voiceNames.get((String)voiceSelect.getSelectedItem()));
					JOptionPane.showMessageDialog(null, "Your voice has successfully been changed to " + (String)voiceSelect.getSelectedItem(), "Changed Voice", JOptionPane.INFORMATION_MESSAGE);
				}
			});
			button.setFont(new Font(GUI.FONT, Font.PLAIN, 28));
			GridBagConstraints gbc_button = new GridBagConstraints();
			gbc_button.fill = GridBagConstraints.HORIZONTAL;
			gbc_button.insets = new Insets(0, 0, 0, 5);
			gbc_button.gridx = 1;
			gbc_button.gridy = 5;
			add(button, gbc_button);

		}
	}

}