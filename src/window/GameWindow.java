package window;

import java.awt.*;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.util.ArrayList;
import java.util.Arrays;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;
import java.awt.event.WindowFocusListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowAdapter;

public class GameWindow {

	private JFrame frame;
	private JPanel panel;
	private JTextPane txtStory;
	private JButton btnContinue;
	
	private Shop swindow = new Shop();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GameWindow window = new GameWindow();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public GameWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		
		
		frame.setBounds(100, 100, 624, 428);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
				
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							swindow.setVisible();
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		
		JLabel lblNewLabel2 = new JLabel("PIZZA TIME");
		lblNewLabel2.setFont(new Font("Monotype Corsiva", Font.PLAIN, 50));
		lblNewLabel2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel2.setBounds(41, 68, 494, 145);
		
		swindow.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosed(WindowEvent e) {
				panel.add(lblNewLabel2);
			}
		});
	}
}