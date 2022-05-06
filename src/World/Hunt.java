package World;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.Timer;
import javax.swing.JLabel;
import java.util.Date;
import java.util.concurrent.TimeUnit;

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
	
	public Hunt(){
		
		if (bullets <=0){
			frmOregonTrail.dispose();
		}
		
		initialize();
		timer = new Timer(countdown, closeHunt);
		
		timer.start();
		frmOregonTrail.setVisible(true);
		System.out.println(deer + ducks);
		
		
		
		timer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(counter >= 10) {
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
		
		
		JButton buttonDuck = new JButton("Duck");
		buttonDuck.setIcon(new ImageIcon(Hunt.class.getResource("/Pictures/duck.jpg")));
		buttonDuck.setBounds(48, 43, 101, 51);
		frmOregonTrail.getContentPane().add(buttonDuck);
		

		
		JButton buttonDeer = new JButton("Deer");
		buttonDeer.setIcon(new ImageIcon(Hunt.class.getResource("/Pictures/deer.jpg")));
		buttonDeer.setBounds(295, 168, 101, 51);
		frmOregonTrail.getContentPane().add(buttonDeer);
		
		
		digitLabel = new JLabel(digitString[0]);
		digitLabel.setBounds(376, 10, 50, 31);
		frmOregonTrail.getContentPane().add(digitLabel);
		
		
		/*digitIcon = new ImageIcon[ 10 ];
		for ( int i = 0; i < 10; i++ ) {
			
			// generate the filename for the image of each digit
			String filename = "/images/nix" + i + ".gif";
			
			// the following code is used to safely load a resource file containing a digit image
			// and then store that digit in the array under the appropriate index.
			//   this          - references the instantiation of this frame
			//   getClass      - given an object, gets the name of its class, 
			//	                   returns an object of type java.lang.Class
			//   getResource() - returns a URL that represents a resource file, 
			//	                   which can then be used to access that resource.
			digitIcon[i] = new ImageIcon( this.getClass().getResource(filename) );
		}*/
		
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
			//buttonDuck.setBounds(48, 43, 85, 21); 				//original placement
			System.out.println(ducks);
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
			//buttonRabbit.setBounds(295, 168, 85, 21); 			//original placement
			System.out.println(deer);
		}
	});
	
	
	}
}

