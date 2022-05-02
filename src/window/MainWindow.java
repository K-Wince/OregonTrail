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

import World.Supplies;

import java.awt.Font;
import java.awt.Image;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.NumberFormat;
import java.text.ParseException;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JFormattedTextField;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import javax.swing.ImageIcon;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;

public class MainWindow {
	// GUI Variables
	private JFrame frame;
	private JPanel titleScreen;
	private JPanel creditsScreen;
	private JPanel wagonShopScreen;
	private JTextField textCredit;
	private JTextField textStory;
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

	// Game Variables
	private Supplies supply = new Supplies();
	
	// Cost of Items
	private int rate = 1;
	private int foodCost = 1;
	private int clothingCost = 5;
	private int ammoCost = 2;
	private int oxenCost = 20;
	private int wheelCost = 10;
	private int axleCost = 10;
	private int tongueCost = 10;
	private int medCost = 25;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	
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
				card.show(frame.getContentPane(), "story");
			}
		});
		btnPlay.setBounds(263, 213, 89, 23);
		titleScreen.add(btnPlay);
		
		JButton btnCredits = new JButton("Credits");
		btnCredits.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			card.next(frame.getContentPane());
			}
		});
		btnCredits.setBounds(263, 247, 89, 23);
		titleScreen.add(btnCredits);
		
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
				card.previous(frame.getContentPane());
			}
		});
		btnMainMenu.setBounds(268, 329, 106, 23);
		creditsScreen.add(btnMainMenu);
		
		JPanel storyScreen = new JPanel();
		frame.getContentPane().add(storyScreen, "story");
		storyScreen.setLayout(null);
		
		JLabel lblStory = new JLabel("Story");
		lblStory.setFont(new Font("SWItalt", Font.PLAIN, 26));
		lblStory.setBounds(10, 11, 445, 49);
		storyScreen.add(lblStory);
		
		textStory = new JTextField();
		textStory.setBackground(Color.WHITE);
		textStory.setEditable(false);
		textStory.setText("Placeholder Text for Story");
		textStory.setColumns(10);
		textStory.setBounds(10, 55, 637, 261);
		storyScreen.add(textStory);
		
		JButton btnContinue = new JButton("Continue?");
		btnContinue.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				card.show(frame.getContentPane(), "wagonShop");
			}
		});
		btnContinue.setBounds(259, 327, 106, 23);
		storyScreen.add(btnContinue);
		
		JPanel shopScreen = new JPanel();
		frame.getContentPane().add(shopScreen, "shop");
		shopScreen.setLayout(null);
		
		JLabel lblShop = new JLabel("...Shop");
		lblShop.setFont(new Font("SWItalt", Font.PLAIN, 26));
		lblShop.setBounds(10, 11, 368, 58);
		shopScreen.add(lblShop);
		
		JButton btnBuy = new JButton("Buy");
		btnBuy.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnBuy.setBounds(553, 290, 89, 58);
		shopScreen.add(btnBuy);
		
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
				setTotal();
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
				setTotal();
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
				setTotal();
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
				setTotal();
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
				setTotal();
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
				setTotal();
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
				setTotal();
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
				setTotal();
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
		
		JButton btnWagonBuy = new JButton("Buy");
		btnWagonBuy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				card.show(frame.getContentPane(), "mainScreen");
				moneyLeft.setText("$" + supply.getMoney());
				setDollarAmount();
			}
		});
		btnWagonBuy.setBounds(276, 311, 89, 23);
		wagonShopScreen.add(btnWagonBuy);
		
		JRadioButton btnCovWag = new JRadioButton("");
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
		lblGround.setIcon(new ImageIcon(prairieImg));
		lblGround.setBounds(0, 0, 657, 84);
		mainScreen.add(lblGround);
	}
	
	public void setTotal() {
		int total = (Integer.parseInt(txtFood.getText().replaceAll(" ", ""))  * foodCost * rate)
				+ (Integer.parseInt(txtClothing.getText().replaceAll(" ", ""))  * clothingCost * rate)
				+ (Integer.parseInt(txtAmmo.getText().replaceAll(" ", ""))  * ammoCost * rate)
				+ (Integer.parseInt(txtOxen.getText().replaceAll(" ", ""))  * oxenCost * rate)
				+ ((Integer.parseInt(txtWheel.getText().replaceAll(" ", ""))  * wheelCost * rate))
				+ ((Integer.parseInt(txtAxle.getText().replaceAll(" ", ""))  * axleCost * rate))
				+ ((Integer.parseInt(txtTongue.getText().replaceAll(" ", ""))  * tongueCost * rate))
				+ ((Integer.parseInt(txtMedBox.getText().replaceAll(" ", ""))  * medCost * rate));
		moneyTotal.setText("$" + total);
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
}
