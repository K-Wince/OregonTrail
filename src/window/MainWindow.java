package window;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.CardLayout;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.text.MaskFormatter;
import javax.swing.text.NumberFormatter;

import World.Hunt;
import World.Person;
import World.Supplies;
import World.rndEvents;

import java.awt.Font;
import java.awt.Image;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Random;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JFormattedTextField;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import javax.swing.ImageIcon;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JTextPane;
import javax.swing.JSeparator;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;
import java.awt.event.InputMethodListener;
import java.awt.event.InputMethodEvent;

public class MainWindow {
	// GUI Variables
	private JFrame frame;
	private JPanel titleScreen;
	private JPanel creditsScreen;
	private JPanel wagonShopScreen;
	private JTextField textCredit;
	private JTextArea textStory;
	private JFormattedTextField txtFood;
	private JFormattedTextField txtClothing;
	private JFormattedTextField txtAmmo;
	private JFormattedTextField txtOxen;
	private JFormattedTextField txtWheel;
	private JFormattedTextField txtAxle;
	private JFormattedTextField txtTongue;
	private JFormattedTextField txtMedBox;
	private JLabel moneyFood;
	private JLabel moneyClothing;
	private JLabel moneyAmmo;
	private JLabel moneyOxen;
	private JLabel moneyWheel;
	private JLabel moneyAxle;
	private JLabel moneyTongue;
	private JLabel moneyMedBox;
	private JLabel moneyLeft;
	private JLabel moneyTotal;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private final ButtonGroup buttonGroup_1 = new ButtonGroup();
	private final ButtonGroup buttonGroup_2 = new ButtonGroup();
	private JTextArea mainText;
	private JLabel lblWagon;
	private JButton btnNext;
	private JLabel infoMiles;
	private JLabel infoLBFood;
	private JLabel infoHealth;
	private JButton btnShop;
	private JLabel lblShop;
	
	// Game Variables
	private Supplies supply = new Supplies();
	private int day = 1;
	private int milesLeft = 102;
	private int milesTraveled = 0;
	private int people = 5;
	private int pace = 10;
	private int portion = 10;
	private String[] landMarks = {
	"Independence, Missouri",
	"Kansas River Crossing",
	"Fort Kearney",
	"Chimney Rock",
	"Fort Loramie",
	"Independence Rock",
	"Fort Bridger",
	"Soda Springs",
	"Fort Hall",
	"Snake River Crossing",
	"Fort Boise",
	"Blue Mountains",
	"Fort Walla Walla",
	"The Dalles",
	"Willamete Valley"
	};
	private Integer[] distance = {102, 201, 250, 86, 190, 227, 
			162, 58, 182, 113, 160, 55, 120, 100, -99};
	private int location = 0;
	private Image wagonImage = null;
	private int dayWithoutFood = 0;
	private boolean Injured = false;
	
	//Create People
	Person Charles = new Person("Charles");
	Person Agusta = new Person("Agusta");
	Person Hattie = new Person("Hattie");
	Person Ben = new Person("Ben");
	Person Jake = new Person("Jake");
	
	// Cost of Items
	private int rate = 1;
	private final int foodCost = 1;
	private final int clothingCost = 5;
	private final int ammoCost = 2;
	private final int oxenCost = 20;
	private final int wheelCost = 10;
	private final int axleCost = 10;
	private final int tongueCost = 10;
	private final int medCost = 25;

	
	
	
	/**
	* Launch the application.
	*/
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindow window = new MainWindow();
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
	public MainWindow() {
		initialize();
	}
	
	
	/**
	* Initialize the contents of the frame.
	*/
	private void initialize() {
		CardLayout card = new CardLayout();
	
		frame = new JFrame();
		frame.setBounds(100, 100, 669, 412);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(card);
		
		// Title Screen
		titleScreen = new JPanel();
		frame.getContentPane().add(titleScreen, "title");
		titleScreen.setLayout(null);
		
		JLabel lblTitle = new JLabel("Oregon Trail");
		lblTitle.setFont(new Font("SWItalt", Font.PLAIN, 44));
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setBounds(138, 80, 355, 100);
		titleScreen.add(lblTitle);
		
		JButton btnPlay = new JButton("Play");
		btnPlay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// When the user presses the play button then go to the story screen
				card.show(frame.getContentPane(), "story");
			}
		});
		btnPlay.setBounds(263, 213, 89, 23);
		titleScreen.add(btnPlay);
	
		JButton btnCredits = new JButton("Credits");
		btnCredits.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// When the user presses the credits button then go to credits screen
				card.next(frame.getContentPane());
			}
		});
		btnCredits.setBounds(263, 247, 89, 23);
		titleScreen.add(btnCredits);
		
		JLabel lblNewLabel = new JLabel("");
		Image titleImg = new ImageIcon(MainWindow.class.getResource("/pictures/titleImage.jpg")).getImage().getScaledInstance(657, 378, Image.SCALE_SMOOTH);
		lblNewLabel.setIcon(new ImageIcon(titleImg));
		lblNewLabel.setBounds(0, 0, 657, 378);
		titleScreen.add(lblNewLabel);
		
		// Credits Screen
		creditsScreen = new JPanel();
		frame.getContentPane().add(creditsScreen, "credits");
		creditsScreen.setLayout(null);
		
		textCredit = new JTextField();
		textCredit.setText("Placeholder Text for Credits");
		textCredit.setBackground(Color.WHITE);
		textCredit.setEditable(false);
		textCredit.setBounds(10, 57, 637, 261);
		creditsScreen.add(textCredit);
		textCredit.setColumns(10);
		
		JLabel lblCredits = new JLabel("Credits");
		lblCredits.setFont(new Font("SWItalt", Font.PLAIN, 26));
		lblCredits.setBounds(10, 24, 485, 32);
		creditsScreen.add(lblCredits);
	
		JButton btnMainMenu = new JButton("Main Menu");
		btnMainMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// When the user presses main menu then go back to title screen
				card.previous(frame.getContentPane());
			}
		});
		btnMainMenu.setBounds(268, 329, 106, 23);
		creditsScreen.add(btnMainMenu);
		
		// Story Screen
		JPanel storyScreen = new JPanel();
		frame.getContentPane().add(storyScreen, "story");
		storyScreen.setLayout(null);
		
		JLabel lblStory = new JLabel("Story");
		lblStory.setFont(new Font("SWItalt", Font.PLAIN, 26));
		lblStory.setBounds(10, 11, 445, 49);
		storyScreen.add(lblStory);
	
		textStory = new JTextArea();
		textStory.setBackground(Color.WHITE);
		String story = "Hattie and her family have become increasingly unhappy in Missouri and are looking to move. Hattie, along with her mom and dad,\r\n"
		+ "Augusta and Charles, plus her two younger brothers, Ben and Jake. They take sail towards Independence ready to move on to a\r\n"
		+ "bigger and better life in Oregon. Hattie and her family arrive in Independence looking around the large town. Hattie begins to journal.\r\n"
		+ "Hattie remarks how she is scared to start a new life, but also excited because she has read and heard many great things about Oregon.\r\n"
		+ "They begin to sell all of their household items and it hits Hattie that it is truly time to go. Hattie gathers her belongings that she could not live without. Then, her and her family set sail for Independence again to go buy a wagon. Hattie and her family bought \r\n"
		+ "a wagon from their shop Hiram Young's in Independence. They acquired a big shiny brown wagon. \r\n"
		+ "They loaded their wagon with supplies and started their journey. They approached multiple Forts and Landmarks along their way. \r\n"
		+ "Sometimes they stopped to look around, while other times they were too tired to stop and look around at others. \r\n"
		+ "\r\n"
		+ "Hattie and her family traveled hours and hours throughout the day tiring themselves as they made their way to Oregon. \r\n";
		textStory.setEditable(false);
	
		textStory.setColumns(10);
		textStory.setBounds(10, 55, 637, 261);
		textStory.append(story);
		storyScreen.add(textStory);
		
		JButton btnContinue = new JButton("Continue?");
		btnContinue.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// When the user continues then go to the wagon shop
				card.show(frame.getContentPane(), "wagonShop");
			}
		});
		btnContinue.setBounds(259, 327, 106, 23);
		storyScreen.add(btnContinue);
		
		// Shop Screen
		JPanel shopScreen = new JPanel();
		frame.getContentPane().add(shopScreen, "shop");
		shopScreen.setLayout(null);
		
		lblShop = new JLabel("...Shop");
		lblShop.setFont(new Font("SWItalt", Font.PLAIN, 16));
		lblShop.setBounds(10, 11, 368, 58);
		shopScreen.add(lblShop);
		
		// Set the format for all the text fields to only allow numbers from 0-999
		NumberFormat format = NumberFormat.getInstance();
		NumberFormatter mask = new NumberFormatter(format);
		mask.setValueClass(Integer.class);
		mask.setMinimum(0);
		mask.setMaximum(999);
		mask.setAllowsInvalid(false);
		mask.setCommitsOnValidEdit(true);
	   
		txtFood = new JFormattedTextField(mask);
		txtFood.setText("0");
		txtFood.addFocusListener(new FocusAdapter() {
		@Override
			public void focusLost(FocusEvent e) {
				// Update the total when the user loses focus
				getTotal();
			}
		});
		txtFood.setHorizontalAlignment(SwingConstants.CENTER);
		txtFood.setBounds(500, 33, 43, 20);
		shopScreen.add(txtFood);
	
		txtClothing = new JFormattedTextField(mask);
		txtClothing.setText("0");
		txtClothing.addFocusListener(new FocusAdapter() {
		@Override
			public void focusLost(FocusEvent e) {
				getTotal();
			}
		});
		txtClothing.setHorizontalAlignment(SwingConstants.CENTER);
		txtClothing.setBounds(500, 64, 43, 20);
		shopScreen.add(txtClothing);
	
		txtAmmo = new JFormattedTextField(mask);
		txtAmmo.setText("0");
		txtAmmo.addFocusListener(new FocusAdapter() {
		@Override
			public void focusLost(FocusEvent e) {
				getTotal();
			}
		});
		txtAmmo.setHorizontalAlignment(SwingConstants.CENTER);
		txtAmmo.setBounds(500, 95, 43, 20);
		shopScreen.add(txtAmmo);
	
		txtOxen = new JFormattedTextField(mask);
		txtOxen.setText("0");
		txtOxen.addFocusListener(new FocusAdapter() {
		@Override
			public void focusLost(FocusEvent e) {
				getTotal();
			}
		});
		txtOxen.setHorizontalAlignment(SwingConstants.CENTER);
		txtOxen.setBounds(500, 126, 43, 20);
		shopScreen.add(txtOxen);
	
		txtWheel = new JFormattedTextField(mask);
		txtWheel.setText("0");
		txtWheel.addFocusListener(new FocusAdapter() {
		@Override
			public void focusLost(FocusEvent e) {
				getTotal();
			}
		});
		txtWheel.setHorizontalAlignment(SwingConstants.CENTER);
		txtWheel.setBounds(500, 157, 43, 20);
		shopScreen.add(txtWheel);
	
		txtAxle = new JFormattedTextField(mask);
		txtAxle.setText("0");
		txtAxle.addFocusListener(new FocusAdapter() {
		@Override
			public void focusLost(FocusEvent e) {
				getTotal();
			}
		});
		txtAxle.setHorizontalAlignment(SwingConstants.CENTER);
		txtAxle.setBounds(500, 188, 43, 20);
		shopScreen.add(txtAxle);
	
		txtTongue = new JFormattedTextField(mask);
		txtTongue.setText("0");
		txtTongue.addFocusListener(new FocusAdapter() {
		@Override
			public void focusLost(FocusEvent e) {
				getTotal();
			}
		});
		txtTongue.setHorizontalAlignment(SwingConstants.CENTER);
		txtTongue.setBounds(500, 219, 43, 20);
		shopScreen.add(txtTongue);
	
		txtMedBox = new JFormattedTextField(mask);
		txtMedBox.setText("0");
		txtMedBox.addFocusListener(new FocusAdapter() {
		@Override
			public void focusLost(FocusEvent e) {
				getTotal();
			}
		});
		txtMedBox.setHorizontalAlignment(SwingConstants.CENTER);
		txtMedBox.setBounds(500, 250, 43, 20);
		shopScreen.add(txtMedBox);
	
		moneyFood = new JLabel("x $");
		moneyFood.setFont(new Font("Tahoma", Font.PLAIN, 14));
		moneyFood.setBounds(553, 36, 67, 14);
		shopScreen.add(moneyFood);
		
		moneyClothing = new JLabel("x $");
		moneyClothing.setFont(new Font("Tahoma", Font.PLAIN, 14));
		moneyClothing.setBounds(553, 67, 67, 14);
		shopScreen.add(moneyClothing);
		
		moneyAmmo = new JLabel("x $");
		moneyAmmo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		moneyAmmo.setBounds(553, 98, 67, 14);
		shopScreen.add(moneyAmmo);
		
		moneyOxen = new JLabel("x $");
		moneyOxen.setFont(new Font("Tahoma", Font.PLAIN, 14));
		moneyOxen.setBounds(553, 129, 67, 14);
		shopScreen.add(moneyOxen);
		
		moneyWheel = new JLabel("x $");
		moneyWheel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		moneyWheel.setBounds(553, 160, 67, 14);
		shopScreen.add(moneyWheel);
		
		moneyAxle = new JLabel("x $");
		moneyAxle.setFont(new Font("Tahoma", Font.PLAIN, 14));
		moneyAxle.setBounds(553, 191, 67, 14);
		shopScreen.add(moneyAxle);
		
		moneyTongue = new JLabel("x $");
		moneyTongue.setFont(new Font("Tahoma", Font.PLAIN, 14));
		moneyTongue.setBounds(553, 222, 67, 14);
		shopScreen.add(moneyTongue);
		
		moneyMedBox = new JLabel("x $");
		moneyMedBox.setFont(new Font("Tahoma", Font.PLAIN, 14));
		moneyMedBox.setBounds(553, 251, 67, 14);
		shopScreen.add(moneyMedBox);
		
		JLabel infoTotal = new JLabel("Total:  ");
		infoTotal.setHorizontalAlignment(SwingConstants.RIGHT);
		infoTotal.setFont(new Font("Tahoma", Font.BOLD, 12));
		infoTotal.setBounds(428, 303, 47, 34);
		shopScreen.add(infoTotal);
		
		moneyTotal = new JLabel("$0");
		moneyTotal.setFont(new Font("Tahoma", Font.BOLD, 12));
		moneyTotal.setBounds(476, 303, 67, 34);
		shopScreen.add(moneyTotal);
		
		JLabel infoMoney = new JLabel("Money Left:  ");
		infoMoney.setHorizontalAlignment(SwingConstants.RIGHT);
		infoMoney.setFont(new Font("Tahoma", Font.BOLD, 12));
		infoMoney.setBounds(261, 303, 89, 34);
		shopScreen.add(infoMoney);
		
		moneyLeft = new JLabel("$");
		moneyLeft.setFont(new Font("Tahoma", Font.BOLD, 12));
		moneyLeft.setBounds(351, 303, 67, 34);
		shopScreen.add(moneyLeft);
		
		JLabel infoFood = new JLabel("Box of Food:");
		infoFood.setToolTipText("5 pound of Food per box. Perfect for your daily nutrious meals on the trail");
		infoFood.setHorizontalAlignment(SwingConstants.RIGHT);
		infoFood.setBounds(370, 35, 120, 20);
		shopScreen.add(infoFood);
		
		JLabel infoClothing = new JLabel("Sets of Clothing:");
		infoClothing.setToolTipText("Perfect for winter weather");
		infoClothing.setHorizontalAlignment(SwingConstants.RIGHT);
		infoClothing.setBounds(388, 64, 102, 20);
		shopScreen.add(infoClothing);
		
		JLabel infoAmmo = new JLabel("Boxes of Ammo:");
		infoAmmo.setToolTipText("20 bullets per box");
		infoAmmo.setHorizontalAlignment(SwingConstants.RIGHT);
		infoAmmo.setBounds(388, 98, 102, 20);
		shopScreen.add(infoAmmo);
		
		JLabel infoOxen = new JLabel("Yokes of Oxen:");
		infoOxen.setToolTipText("2 Oxen per Yoke");
		infoOxen.setHorizontalAlignment(SwingConstants.RIGHT);
		infoOxen.setBounds(388, 129, 102, 20);
		shopScreen.add(infoOxen);
		
		JLabel infoWheel = new JLabel("Number of Wheels:");
		infoWheel.setToolTipText("Use to fix the wheel on your wagon.");
		infoWheel.setHorizontalAlignment(SwingConstants.RIGHT);
		infoWheel.setBounds(351, 160, 139, 20);
		shopScreen.add(infoWheel);
		
		JLabel infoAxle = new JLabel("Number of Axles:");
		infoAxle.setToolTipText("Use to fix the axle on your wagon.");
		infoAxle.setHorizontalAlignment(SwingConstants.RIGHT);
		infoAxle.setBounds(370, 191, 120, 20);
		shopScreen.add(infoAxle);
		
		JLabel infoTongue = new JLabel("Number of Tongues:");
		infoTongue.setToolTipText("Use to fix the tongue on your wagon.");
		infoTongue.setHorizontalAlignment(SwingConstants.RIGHT);
		infoTongue.setBounds(370, 222, 120, 20);
		shopScreen.add(infoTongue);
		
		JLabel infoMedBox = new JLabel("Number of MedBoxes:");
		infoMedBox.setToolTipText("Use these if somebody sustains an injury on your journey");
		infoMedBox.setHorizontalAlignment(SwingConstants.RIGHT);
		infoMedBox.setBounds(351, 253, 139, 20);
		shopScreen.add(infoMedBox);
		
		JLabel infoNotEnoughFunds = new JLabel("");
		infoNotEnoughFunds.setForeground(Color.RED);
		infoNotEnoughFunds.setHorizontalAlignment(SwingConstants.CENTER);
		infoNotEnoughFunds.setFont(new Font("Tahoma", Font.PLAIN, 11));
		infoNotEnoughFunds.setBounds(261, 333, 282, 34);
		shopScreen.add(infoNotEnoughFunds);
	
		JButton btnBuy = new JButton("Buy");
		btnBuy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Try to spend the money if it isn't able to then issue a warning
				if(!supply.spendMoney(getTotal())) {
					infoNotEnoughFunds.setText("Insufficient Funds to Purchase Items");
				} else {
					// Remove the warning
					infoNotEnoughFunds.setText(null);
					// Add the supplies
					supply.addFood(Integer.parseInt(txtFood.getText().replaceAll(" ", "")) * 5);
					supply.addAmmo(Integer.parseInt(txtAmmo.getText().replaceAll(" ", "")));
					supply.addClothing(Integer.parseInt(txtClothing.getText().replaceAll(" ", "")));
					supply.addOxen(Integer.parseInt(txtOxen.getText().replaceAll(" ", "")));
					supply.addWheel(Integer.parseInt(txtWheel.getText().replaceAll(" ", "")));
					supply.addAxle(Integer.parseInt(txtAxle.getText().replaceAll(" ", "")));
					supply.addTongue(Integer.parseInt(txtTongue.getText().replaceAll(" ", "")));
					supply.addMedBox(Integer.parseInt(txtMedBox.getText().replaceAll(" ", "")));
	
					// Go to the main screen
					updateStats();
					mainText.append("You have decided to set off on your journey.\n");
					checkLocation();
					card.show(frame.getContentPane(), "mainScreen");
				}
			}
		});
	
		btnBuy.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnBuy.setBounds(553, 290, 89, 58);
		shopScreen.add(btnBuy);
		
		wagonShopScreen = new JPanel();
		frame.getContentPane().add(wagonShopScreen, "wagonShop");
		wagonShopScreen.setLayout(null);
		
		JLabel lblWagonShop = new JLabel("Hiram Young's Wagon Shop");
		lblWagonShop.setHorizontalAlignment(SwingConstants.CENTER);
		lblWagonShop.setFont(new Font("SWItalt", Font.PLAIN, 26));
		lblWagonShop.setBounds(10, 11, 637, 49);
		wagonShopScreen.add(lblWagonShop);
		
		JLabel lblCoveredWagon = new JLabel("");
		lblCoveredWagon.setHorizontalAlignment(SwingConstants.CENTER);
		Image covImg = new ImageIcon(MainWindow.class.getResource("/pictures/coveredWagon.png")).getImage().getScaledInstance(185, 120, Image.SCALE_SMOOTH);
		lblCoveredWagon.setIcon(new ImageIcon(covImg));
		lblCoveredWagon.setBounds(20, 71, 185, 120);
		wagonShopScreen.add(lblCoveredWagon);
		
		JLabel lblRadio = new JLabel("");
		lblRadio.setHorizontalAlignment(SwingConstants.CENTER);
		Image radioImg = new ImageIcon(MainWindow.class.getResource("/pictures/radioFlyer.png")).getImage().getScaledInstance(210, 120, Image.SCALE_SMOOTH);
		lblRadio.setIcon(new ImageIcon(radioImg));
		lblRadio.setBounds(215, 71, 210, 120);
		wagonShopScreen.add(lblRadio);
		
		JLabel lblFancy = new JLabel("");
		Image fancyImg = new ImageIcon(MainWindow.class.getResource("/pictures/fancyCarriage.png")).getImage().getScaledInstance(185, 120, Image.SCALE_SMOOTH);
		lblFancy.setIcon(new ImageIcon(fancyImg));
		lblFancy.setBounds(435, 71, 185, 120);
		wagonShopScreen.add(lblFancy);
		
		JLabel moneyCovWagon = new JLabel("$100");
		moneyCovWagon.setFont(new Font("Tahoma", Font.BOLD, 14));
		moneyCovWagon.setHorizontalAlignment(SwingConstants.CENTER);
		moneyCovWagon.setBounds(10, 202, 195, 23);
		wagonShopScreen.add(moneyCovWagon);
		
		JLabel moneyRadioFlyer = new JLabel("$200");
		moneyRadioFlyer.setHorizontalAlignment(SwingConstants.CENTER);
		moneyRadioFlyer.setFont(new Font("Tahoma", Font.BOLD, 14));
		moneyRadioFlyer.setBounds(215, 202, 210, 23);
		wagonShopScreen.add(moneyRadioFlyer);
		
		JLabel moneyFancyCar = new JLabel("$400");
		moneyFancyCar.setHorizontalAlignment(SwingConstants.CENTER);
		moneyFancyCar.setFont(new Font("Tahoma", Font.BOLD, 14));
		moneyFancyCar.setBounds(435, 202, 185, 23);
		wagonShopScreen.add(moneyFancyCar);
		
		JLabel infoCovWagon = new JLabel("Covered Wagon");
		infoCovWagon.setToolTipText("A wagon that is covered for all your trailing needs.");
		infoCovWagon.setHorizontalAlignment(SwingConstants.CENTER);
		infoCovWagon.setFont(new Font("Tahoma", Font.PLAIN, 14));
		infoCovWagon.setBounds(20, 225, 185, 23);
		wagonShopScreen.add(infoCovWagon);
		
		JLabel infoRadioFlyer = new JLabel("Radio Flyer Wagon");
		infoRadioFlyer.setToolTipText("A bright red wagon that will allow you travel to your destination with ease.");
		infoRadioFlyer.setHorizontalAlignment(SwingConstants.CENTER);
		infoRadioFlyer.setFont(new Font("Tahoma", Font.PLAIN, 14));
		infoRadioFlyer.setBounds(215, 225, 210, 23);
		wagonShopScreen.add(infoRadioFlyer);
		
		JLabel infoFancyCar = new JLabel("Fancy Carriage");
		infoFancyCar.setToolTipText("A beautiful carriage to take you to your destination in style.");
		infoFancyCar.setHorizontalAlignment(SwingConstants.CENTER);
		infoFancyCar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		infoFancyCar.setBounds(435, 225, 185, 23);
		wagonShopScreen.add(infoFancyCar);
		
		JRadioButton btnCovWag = new JRadioButton("");
		btnCovWag.setSelected(true);
		buttonGroup.add(btnCovWag);
		btnCovWag.setBounds(100, 255, 36, 23);
		wagonShopScreen.add(btnCovWag);
		
		JRadioButton btnRadioFlyer = new JRadioButton("");
		buttonGroup.add(btnRadioFlyer);
		btnRadioFlyer.setBounds(308, 255, 36, 23);
		wagonShopScreen.add(btnRadioFlyer);
		
		JRadioButton btnFancyCar = new JRadioButton("");
		buttonGroup.add(btnFancyCar);
		btnFancyCar.setBounds(515, 255, 36, 23);
		wagonShopScreen.add(btnFancyCar);
	
	
		JButton btnWagonBuy = new JButton("Buy");
		btnWagonBuy.setBounds(276, 311, 89, 23);
		wagonShopScreen.add(btnWagonBuy);
		btnWagonBuy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(btnCovWag.isSelected()) {
					wagonImage = new ImageIcon(MainWindow.class.getResource("/pictures/coveredWagon.png")).getImage().getScaledInstance(65, 55, Image.SCALE_SMOOTH);
					supply.spendMoney(100);
				} else if(btnRadioFlyer.isSelected()) {
					wagonImage = new ImageIcon(MainWindow.class.getResource("/pictures/radioFlyer.png")).getImage().getScaledInstance(65, 55, Image.SCALE_SMOOTH);
					supply.spendMoney(200);
				} else if(btnFancyCar.isSelected()) {
					wagonImage = new ImageIcon(MainWindow.class.getResource("/pictures/fancyCarriage.png")).getImage().getScaledInstance(65, 55, Image.SCALE_SMOOTH);
					supply.spendMoney(400);
				}
		
				lblWagon.setIcon(new ImageIcon(wagonImage));
		
				moneyLeft.setText("$" + supply.getMoney());
				setDollarAmount();
			lblShop.setText(landMarks[location] + " Shop");
			card.show(frame.getContentPane(), "shop");
			}
		});
	
		JLabel lblMoneyInfo = new JLabel("Money Left: $1200");
		lblMoneyInfo.setHorizontalAlignment(SwingConstants.TRAILING);
		lblMoneyInfo.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblMoneyInfo.setBounds(109, 311, 157, 19);
		wagonShopScreen.add(lblMoneyInfo);
	
		JPanel mainScreen = new JPanel();
		frame.getContentPane().add(mainScreen, "mainScreen");
		mainScreen.setLayout(null);
		
		JLabel lblGround = new JLabel("");
		Image prairieImg = new ImageIcon(MainWindow.class.getResource("/pictures/prairie.jpg")).getImage().getScaledInstance(657, 150, Image.SCALE_SMOOTH);
		
		lblWagon = new JLabel("");
		lblWagon.setBounds(592, 29, 65, 55);
		mainScreen.add(lblWagon);
		
		JLabel lblPath = new JLabel("X   -    -    -    -    -    -    -    -    -    -    -    -    -    -    -    -    -    -    -    -    -    -    -    -    -    -    -    -    -    -    -    -    -    -    -    -    -");
		lblPath.setForeground(Color.WHITE);
		lblPath.setBounds(10, 44, 647, 29);
		mainScreen.add(lblPath);
		lblGround.setIcon(new ImageIcon(prairieImg));
		lblGround.setBounds(0, 0, 657, 84);
		mainScreen.add(lblGround);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(10, 84, 400, 254);
		mainScreen.add(scrollPane);
		
		mainText = new JTextArea();
		mainText.setWrapStyleWord(true);
		mainText.setLineWrap(true);
		mainText.setBackground(Color.WHITE);
		scrollPane.setViewportView(mainText);
		mainText.setEditable(false);
	
		btnNext = new JButton("Next Day");
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				nextDay(supply);
				updateStats();
				checkLocation();
			}
		});
		btnNext.setBounds(162, 344, 89, 23);
		mainScreen.add(btnNext);
	
		btnShop = new JButton("Shop");
		btnShop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				card.show(frame.getContentPane(), "shop");
			}
		});
		btnShop.setEnabled(false);
		btnShop.setBounds(438, 320, 89, 23);
		mainScreen.add(btnShop);
		
		JButton btnSupplies = new JButton("Supplies");
		btnSupplies.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				printSupplies();
			}
		});
		btnSupplies.setBounds(438, 344, 184, 23);
		mainScreen.add(btnSupplies);
	
		JLabel statMiles = new JLabel("Miles Left:");
		statMiles.setHorizontalAlignment(SwingConstants.TRAILING);
		statMiles.setBounds(438, 95, 89, 14);
		mainScreen.add(statMiles);
		
		JLabel statFood = new JLabel("Pounds of Food:");
		statFood.setHorizontalAlignment(SwingConstants.TRAILING);
		statFood.setBounds(420, 120, 107, 14);
		mainScreen.add(statFood);
		
		JLabel statHealth = new JLabel("Health:");
		statHealth.setHorizontalAlignment(SwingConstants.TRAILING);
		statHealth.setBounds(438, 145, 89, 14);
		mainScreen.add(statHealth);
		
		JLabel statPace = new JLabel("Pace:");
		statPace.setHorizontalAlignment(SwingConstants.CENTER);
		statPace.setBounds(438, 197, 89, 14);
		mainScreen.add(statPace);
		
		JLabel statPortion = new JLabel("Portions:");
		statPortion.setHorizontalAlignment(SwingConstants.CENTER);
		statPortion.setBounds(533, 197, 89, 14);
		mainScreen.add(statPortion);
		
		JRadioButton rdbtnSlow = new JRadioButton("Slow");
		rdbtnSlow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pace = 5;
			}
		});
		buttonGroup_1.add(rdbtnSlow);
		rdbtnSlow.setBounds(448, 218, 79, 23);
		mainScreen.add(rdbtnSlow);
	
		JRadioButton rdbtnSteady = new JRadioButton("Steady");
		rdbtnSteady.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pace = 10;
			}
		});
		rdbtnSteady.setSelected(true);
		buttonGroup_1.add(rdbtnSteady);
		rdbtnSteady.setBounds(448, 244, 79, 23);
		mainScreen.add(rdbtnSteady);
		
		JRadioButton rdbtnGruelling = new JRadioButton("Gruelling");
		rdbtnGruelling.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pace = 15;
			}
		});
		buttonGroup_1.add(rdbtnGruelling);
		rdbtnGruelling.setBounds(448, 273, 79, 23);
		mainScreen.add(rdbtnGruelling);
		
		JRadioButton rdbtnSkim = new JRadioButton("Skim");
		rdbtnSkim.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		portion = 5;
		}
		});
		buttonGroup_2.add(rdbtnSkim);
		rdbtnSkim.setBounds(543, 218, 79, 23);
		mainScreen.add(rdbtnSkim);
		
		JRadioButton rdbtnNormal = new JRadioButton("Normal");
		rdbtnNormal.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		portion = 10;
		}
		});
		rdbtnNormal.setSelected(true);
		buttonGroup_2.add(rdbtnNormal);
		rdbtnNormal.setBounds(543, 244, 79, 23);
		mainScreen.add(rdbtnNormal);
		
		JRadioButton rdbtnFilling = new JRadioButton("Filling");
		rdbtnFilling.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		portion = 15;
		}
		});
		buttonGroup_2.add(rdbtnFilling);
		rdbtnFilling.setBounds(543, 273, 79, 23);
		mainScreen.add(rdbtnFilling);
		
		infoMiles = new JLabel("");
		infoMiles.setFont(new Font("Tahoma", Font.BOLD, 11));
		infoMiles.setBounds(533, 95, 89, 14);
		mainScreen.add(infoMiles);
		
		infoLBFood = new JLabel("");
		infoLBFood.setFont(new Font("Tahoma", Font.BOLD, 11));
		infoLBFood.setBounds(533, 120, 89, 14);
		mainScreen.add(infoLBFood);
		
		infoHealth = new JLabel("Good");
		infoHealth.setFont(new Font("Tahoma", Font.BOLD, 11));
		infoHealth.setBounds(533, 145, 89, 14);
		mainScreen.add(infoHealth);
		
		JButton btnHunt = new JButton("Hunt");
		btnHunt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Hunt window = new Hunt();
				}
				catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		btnHunt.setBounds(533, 320, 89, 23);
		mainScreen.add(btnHunt);
	}
	
	public int getTotal() {
		int total = (Integer.parseInt(txtFood.getText().replaceAll(" ", ""))  * foodCost * rate)
		+ (Integer.parseInt(txtClothing.getText().replaceAll(" ", ""))  * clothingCost * rate)
		+ (Integer.parseInt(txtAmmo.getText().replaceAll(" ", ""))  * ammoCost * rate)
		+ (Integer.parseInt(txtOxen.getText().replaceAll(" ", ""))  * oxenCost * rate)
		+ ((Integer.parseInt(txtWheel.getText().replaceAll(" ", ""))  * wheelCost * rate))
		+ ((Integer.parseInt(txtAxle.getText().replaceAll(" ", ""))  * axleCost * rate))
		+ ((Integer.parseInt(txtTongue.getText().replaceAll(" ", ""))  * tongueCost * rate))
		+ ((Integer.parseInt(txtMedBox.getText().replaceAll(" ", ""))  * medCost * rate));
		moneyTotal.setText("$" + total);
		return total;
	}
	
	public void setDollarAmount () {
		moneyFood.setText("X $" + (foodCost * rate));
		moneyClothing.setText("X $" + (clothingCost * rate));
		moneyAmmo.setText("X $" + (ammoCost * rate));
		moneyOxen.setText("X $" + (oxenCost * rate));
		moneyWheel.setText("X $" + (wheelCost * rate));
		moneyAxle.setText("X $" + (axleCost * rate));
		moneyTongue.setText("X $" + (tongueCost * rate));
		moneyMedBox.setText("X $" + (medCost * rate));
	}
	
	public void nextDay(Supplies supplies) {
		day++;                    // Increase the Day count
		supply.eatFood(portion);
		Person temp = new Person("Temp");
		Random rand = new Random();
		int x = rand.nextInt(5);
		boolean cont = false;
		do{
		switch(x) {
		case 0: temp = Ben; break;
		case 1: temp = Jake; break;
		case 2: temp = Hattie; break;
		case 4: temp = Agusta; break;
		case 5: temp = Charles; break;}
		if(temp.checkDeath() == false) {cont = true; } //allows loop to move on if they are alive
		}while(cont = false);
		rndEvents event = new rndEvents(supply, temp); //create new random event
		mainText.append(event.PrintOutcome()+ "/n"); // print the outcome of the event
		checkInjury(temp);
		switch(x) {
		case 0: Ben = temp; break;
		case 1: Jake = temp; break;
		case 2: Hattie = temp; break;
		case 4: Agusta = temp; break;
		case 5: Charles = temp; break; }
		{Injured = event.getInjury();}
		
		// Remove the food eaten in a day
		// If miles left are greater than pace
		if(milesLeft > pace) {    
			milesLeft = milesLeft - pace; // Remove the amount traveled in a day
			milesTraveled += pace;
		} else {                          // Else cap the milesLeft at 0
			milesLeft = 0;  
		}
	}
	
	public void printSupplies() {
		// Print all the supplies
		mainText.append(          
			"The supplies you have are: " +
			supply.getFood() + " lbs of food, " +
			supply.getClothing() + " sets of clothing, " +
			supply.getAmmo() + " boxes of bullets, " +
			supply.getOxen() + " oxen, " +
			supply.getWheel() + " wheels, " +
			supply.getAxle() + " axles, " +
			supply.getTongue() + " tongues, and " +
			supply.getMedBox() + " medboxes.\n"
				);
	}
	
	public void checkLocation() {
		if(btnShop.isEnabled()) {
			btnShop.setEnabled(false);
		}
		if (location == 0 && milesLeft == distance[0]) {
			mainText.append("You are in " + landMarks[location] + ".\n");
		}
		// If it is not at the final location and its traveled the full distance
		if(milesLeft == 0 && location != 13) {
			if (location % 2 == 1) {
				btnShop.setEnabled(true);
				lblShop.setText(landMarks[location] + " Shop");
			}
			milesTraveled = 0;
			location++;                      // Increase the Location
			milesLeft = distance[location];  // Reset Miles Counter
			mainText.append(                  // Let the player know where they are
					"You are in " + landMarks[location] + ". You have "
					+ milesLeft + " miles until the next landmark.\n");
		} else if (milesLeft == 0) {         // If it is at the final location
			location++;                      // Increase the Location
			mainText.append(                  // Let the user know they are in Nebraska
					"You are in " + landMarks[location] +
					". You have made it to Oregon. Congratulations!\n");
			btnNext.setEnabled(false);   // End the game
		}
		checkLoss(); //checks for a loss
	}
	
	public void updateStats() {
		// If they have no food then increase the day counter
		if (supply.getFood() == 0) {
			dayWithoutFood++;
		} else {
			dayWithoutFood = 0;
		}
		// Determine the Health Readout of the wagon riders
		switch(dayWithoutFood) {
		case 0: infoHealth.setText("Good"); break;
		case 1: infoHealth.setText("Starving"); break;
		case 2: infoHealth.setText("Bad"); break;
		}
	
		// Print out the day and miles traveled
		mainText.append("Day " + day + ":\n");
		mainText.append("You traveled " + pace + " miles.\n");
		// Update milesLeft and pounds of food
		infoMiles.setText(milesLeft + "");
		infoLBFood.setText(supply.getFood() + "");
		// Update the wagon graphic
		lblWagon.setLocation(592 - (int)(592.0 * ((double)milesTraveled/distance[location])),29);
	}
	
	
	public void checkLoss() {
		// If they reach 0 on any of these items then end the game
	
		if(people == 0 || dayWithoutFood == 3 || supply.getOxen() == 0) {
			if(supply.getOxen() == 0) {
				mainText.append("You have run out of oxen.\n");
			}
			btnNext.setEnabled(false);
			mainText.append("You did not make it to Oregon.\n");
		}
	}
	
	public void checkInjury(Person p) {
		if(p.checkDeath()){
			mainText.append(p.getName() + " has died");
			people -= 1;
			checkLoss();
		}
		if(supply.getMedBox()>=1) {
			mainText.append(p.getName() + " was injured and used a Medbox");
			supply.consumeMedBox();
		}
	}

}