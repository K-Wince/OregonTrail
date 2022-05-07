package World;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.Timer;

import window.MainWindow;

import javax.swing.JLabel;
import javax.swing.JTextField;

public class Hunt{

	private JFrame frmOregonTrail;
	private java.util.Random rndGenerator = new java.util.Random();
	private int deer;
	private int ducks;
	private int bullets = 500;
	private int random1;
	private int random2;
	private int random3;
	private int random4;
	private int random5;
	private int countdown = 1000;			//one second timer
	private JTextField digitTextField;
	private JButton buttonDeer;
	private JButton buttonDuck;
	private ImageIcon[] digitIcon;
	private int counter = 0;
	private String[] digitString = {"TEN", "NINE", "EIGHT", "SEVEN", "SIX", "FIVE", "FOUR", "THREE", "TWO", "ONE", "ZERO", "FIFTEEN", "FOURTEEN", "THIRTEEN", "TWELVE", "ELEVEN"};
	private Timer timer;
	private JLabel digitLabel;
	private ActionListener closeHunt;
	
	
	/**
	 * Launch the application.
	 */
	
	public Hunt(Supplies supply){
		
		if (supply.getAmmo() <=0){
			frmOregonTrail.dispose();
		}
		
		initialize();
		timer = new Timer(countdown, closeHunt);
		
		timer.start();
		frmOregonTrail.setVisible(true);
		
		
		
		timer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(counter >= 10) {
					supply.consumeAmmo(deer + ducks);
					supply.addFood((deer + ducks) * 5);
					frmOregonTrail.dispose();
				}
				counter = (counter + 1) % 11;
				digitLabel.setText(digitString[counter]);
				
				
				//buttonDuck.setBounds(48, 43, 85, 21);
				//buttonDeer.setBounds(295, 168, 85, 21);
				
				timer = new Timer(countdown, closeHunt);
			}
		});
	
	}
	
	public void clockActionPerformed(ActionEvent evt) {
		counter = (counter + 1) % 10;
		digitLabel.setText(digitString[counter]);
		
		random5 = rndGenerator.nextInt(15);
		random1 = random5+random1;
		buttonDuck.setBounds(random1, random2, 101, 51);
		
		random5 = rndGenerator.nextInt(15);
		random3 = random5+random3;
		buttonDeer.setBounds(random3, random4+170, 101, 51);
	}
	
	
	
	/**
	 * Initialize the contents of the frame.
	 */
	
	private void initialize() {
		frmOregonTrail = new JFrame();
		frmOregonTrail.setTitle("HUNT!");
		frmOregonTrail.setBounds(100, 100, 450, 300);
		frmOregonTrail.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmOregonTrail.getContentPane().setLayout(null);
		
		
		JButton buttonDuck = new JButton("");
		Image duckImg = new ImageIcon(MainWindow.class.getResource("/pictures/duck.jpg")).getImage().getScaledInstance(101, 51, Image.SCALE_SMOOTH);
		buttonDuck.setIcon(new ImageIcon(duckImg));
		buttonDuck.setBounds(48, 43, 101, 51);
		frmOregonTrail.getContentPane().add(buttonDuck);
		

		
		JButton buttonDeer = new JButton("");
		Image deerImg = new ImageIcon(MainWindow.class.getResource("/pictures/deer.jpg")).getImage().getScaledInstance(101, 51, Image.SCALE_SMOOTH);
		buttonDeer.setIcon(new ImageIcon(deerImg));
		buttonDeer.setBounds(295, 168, 101, 51);
		frmOregonTrail.getContentPane().add(buttonDeer);
		
		
		digitLabel = new JLabel(digitString[0]);
		digitLabel.setBounds(376, 10, 50, 31);
		frmOregonTrail.getContentPane().add(digitLabel);
		
		digitLabel.setText(digitString[counter]);
	
	
		buttonDuck.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ducks++;
				bullets--;
				if (bullets <=0){
					frmOregonTrail.dispose();
				}
				random1 = rndGenerator.nextInt(350);
				random2 = rndGenerator.nextInt(80);
				buttonDuck.setBounds(random1, random2, 101, 51);
			}
		});
		
		buttonDeer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				deer++;
				bullets--;
				if (bullets <=0){
					frmOregonTrail.dispose();
				}
				random3 = rndGenerator.nextInt(350);
				random4 = rndGenerator.nextInt(80);
				buttonDeer.setBounds(random3, random4+170, 101, 51);
			}
		});
	
	}
}

