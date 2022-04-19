package window;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;

public class Shop {
	
		public Shop() {
			initialize();
		}
		
		private JFrame frame;
		private JPanel panel;
		
		private void initialize() {
			frame = new JFrame();
			frame.setBounds(100, 100, 624, 428);
			frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			frame.getContentPane().setLayout(null);
			
			panel = new JPanel();
			panel.setBounds(10, 11, 592, 372);
			frame.getContentPane().add(panel);
			panel.setLayout(null);
			
			JButton buttonBuy = new JButton("Buy");
			buttonBuy.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					frame.dispose();
				}
			});
			buttonBuy.setBounds(243, 224, 89, 23);
			panel.add(buttonBuy);
			
			JButton buttonCredits = new JButton("Info");
			buttonCredits.setBounds(243, 262, 89, 23);
			panel.add(buttonCredits);
			
			JLabel lblNewLabel = new JLabel("YE OLDE SHOP");
			lblNewLabel.setFont(new Font("Monotype Corsiva", Font.PLAIN, 50));
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel.setBounds(41, 68, 494, 145);
			panel.add(lblNewLabel);
			
		}
		
		public void setVisible() {
			frame.setVisible(true);
		}

		public void addWindowListener(WindowAdapter windowAdapter) {
			frame.addWindowListener(windowAdapter);
		}
		
		
}
