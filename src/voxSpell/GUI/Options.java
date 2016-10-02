package voxSpell.GUI;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import voxSpell.quiz.Settings;

import java.awt.Color;
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
					dispose();
					GUI.getInstance().setContentPane(new MainMenu());
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
		
		JButton changeVoice = new JButton("Change Voice");
		changeVoice.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				thisFrame.setVisible(false);
				thisFrame.setContentPane(new ChangeVoice());
				thisFrame.setVisible(true);
			}
		});
		changeVoice.setForeground(new Color(51, 0, 51));
		changeVoice.setFont(new Font("Century Schoolbook L", Font.PLAIN, 28));
		GridBagConstraints gbc_settings = new GridBagConstraints();
		gbc_settings.fill = GridBagConstraints.HORIZONTAL;
		gbc_settings.insets = new Insets(0, 0, 5, 5);
		gbc_settings.gridx = 1;
		gbc_settings.gridy = 5;
		contentPane.add(changeVoice, gbc_settings);
		
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
	
	class ChangeVoice extends JPanel {

		/**
		 * Create the panel.
		 */
		private JComboBox<String> voiceSelect;
		private HashMap<String, String>voiceNames;
		public ChangeVoice() {
			setBackground(new Color(51, 0, 51));
			GridBagLayout gridBagLayout = new GridBagLayout();
			gridBagLayout.columnWidths = new int[]{30, 200, 30, 0};
			gridBagLayout.rowHeights = new int[]{20, 0, 0, 0, 0, 0, 0};
			gridBagLayout.columnWeights = new double[]{0.0, 1.0, 0.0, Double.MIN_VALUE};
			gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
			setLayout(gridBagLayout);
			
			JLabel lblChangeVoice = new JLabel("Change Voice");
			lblChangeVoice.setHorizontalAlignment(SwingConstants.CENTER);
			lblChangeVoice.setForeground(Color.WHITE);
			lblChangeVoice.setFont(new Font("Century Schoolbook L", Font.PLAIN, 36));
			GridBagConstraints gbc_lblChangeVoice = new GridBagConstraints();
			gbc_lblChangeVoice.insets = new Insets(0, 0, 5, 0);
			gbc_lblChangeVoice.fill = GridBagConstraints.HORIZONTAL;
			gbc_lblChangeVoice.gridwidth = 3;
			gbc_lblChangeVoice.gridx = 0;
			gbc_lblChangeVoice.gridy = 1;
			add(lblChangeVoice, gbc_lblChangeVoice);
			
			voiceSelect = new JComboBox<String>();
			voiceSelect.setFont(new Font("Century Schoolbook L", Font.BOLD, 28));
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
			
			JButton button = new JButton("Submit");
			button.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Settings.getInstance().setVoice(voiceNames.get((String)voiceSelect.getSelectedItem()));
					JOptionPane.showMessageDialog(null, "Your voice has successfully been changed to " + (String)voiceSelect.getSelectedItem(), "Changed Voice", JOptionPane.INFORMATION_MESSAGE);
				}
			});
			button.setForeground(new Color(51, 0, 51));
			button.setFont(new Font("Century Schoolbook L", Font.PLAIN, 28));
			GridBagConstraints gbc_button = new GridBagConstraints();
			gbc_button.fill = GridBagConstraints.HORIZONTAL;
			gbc_button.insets = new Insets(0, 0, 0, 5);
			gbc_button.gridx = 1;
			gbc_button.gridy = 5;
			add(button, gbc_button);

		}

	}

}