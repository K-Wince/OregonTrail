package window;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;

public class Shop {
	
		public Shop() {
			initialize();
			frame.setVisible(true);
		}
		
		private JFrame frame;
		private JPanel panel;
		private JTextPane txtStory;
		private JButton btnContinue;
		
		private void initialize() {
			frame = new JFrame();
			frame.setBounds(100, 100, 624, 428);
			frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			frame.getContentPane().setLayout(null);
			
			panel = new JPanel();
			panel.setBounds(10, 11, 592, 372);
			frame.getContentPane().add(panel);
			panel.setLayout(null);
			
			JButton buttonStart = new JButton("Start");
			buttonStart.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					panel.removeAll();
					panel.repaint();
					
					panel.add(btnContinue);
					panel.add(txtStory);
				}
			});
			buttonStart.setBounds(243, 224, 89, 23);
			panel.add(buttonStart);
			
			JButton buttonCredits = new JButton("Credits");
			buttonCredits.setBounds(243, 262, 89, 23);
			panel.add(buttonCredits);
			
			JLabel lblNewLabel = new JLabel("OREGON TRAIL");
			lblNewLabel.setFont(new Font("Monotype Corsiva", Font.PLAIN, 50));
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel.setBounds(41, 68, 494, 145);
			panel.add(lblNewLabel);
			
			txtStory = new JTextPane();
			txtStory.setText("Placeholder Text for Story");
			txtStory.setBounds(10, 11, 572, 274);
			txtStory.setEditable(false);
			
			btnContinue = new JButton("Continue?");
			btnContinue.setBounds(214, 316, 131, 23);
			btnContinue.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					panel.removeAll();
					panel.repaint();
				}
			});
		}
}
