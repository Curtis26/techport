import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.CardLayout;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;
import javax.swing.border.BevelBorder;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JScrollPane;

public class Application extends JFrame {

	private JPanel contentPane;
	private JTextField tfSpecies;
	private JTextField tfWeight;
	private JTextField tfSpecialInfo;
	private JTextField tfGPS;
	private JTextPane textReport;
	private JButton btnAddtotheList;
	private JButton btnSave;
	private JButton btnLoad;
	private JLabel lblInfo;
	private JRadioButton rdbtnMale;
	private JComboBox nameBox;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Application frame = new Application();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}
	
	Animals myPenguins = new Penguins();
	Animals myWalrus = new Walrus();
	Animals mySealions = new Sealions();
	Validator myVali = new Validator();
	Controller myCon = new Controller();
	ArrayList<String> List = new ArrayList<String>();
	
	
	public void makeReport(Animals a) {
		lblInfo.setText("Report Updated.");
		a.setAnimalName(nameBox.getSelectedItem().toString());
		a.setSex(rdbtnMale.isSelected());
		a.setSpecialInfo(tfSpecialInfo.getText());
		a.setSpecies(tfSpecies.getText());
		a.setWeight(tfWeight.getText());
		a.setGPSInfo(tfGPS.getText());
		a.printReport();
		textReport.setText(a.getReport());
		btnAddtotheList.setEnabled(true);
	}
	
//	public void valiAndmake(String a,Animals b,Validator[] args,String c) {
//		if (args(tfSpecialInfo.getText())==false){
//			lblInfo.setText(a);
//			textReport.setText("");
//			btnAddtotheList.setEnabled(false);
//		}
//		else if(myVali.validateWeight(tfWeight.getText())==false) {
//			lblInfo.setText("Wrong Weight.");
//			textReport.setText("");
//			btnAddtotheList.setEnabled(false);
//		}
//		else if(myVali.validateGPS(tfGPS.getText())==false) {
//			lblInfo.setText("Wrong GPS Pattern.");
//			textReport.setText("");
//			btnAddtotheList.setEnabled(false);
//		}
//		else {
//			lblInfo.setText("Report Updated.");
//			b.setAnimalName(nameBox.getSelectedItem().toString());
//			b.setSex(rdbtnMale.isSelected());
//			b.setSpecialInfo(tfSpecialInfo.getText());
//			b.setSpecies(tfSpecies.getText());
//			b.setWeight(tfWeight.getText());
//			b.setGPSInfo(tfGPS.getText());
//			b.printReport();
//			textReport.setText(b.getReport());
//			btnAddtotheList.setEnabled(true);
//		}
//	}
	

	/**
	 * Create the frame.
	 */
	public Application() {
		
		
		
		setTitle("Antarctic Wildlife Tracking Application");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 400, 750);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new CardLayout(0, 0));
		
		JPanel panel = new JPanel();
		contentPane.add(panel, "name_1698064551314315");
		panel.setLayout(null);
		
		JLabel lblCBtitle = new JLabel("Animal Name");
		lblCBtitle.setBounds(6, 6, 110, 16);
		panel.add(lblCBtitle);
		
		nameBox = new JComboBox();
		nameBox.setModel(new DefaultComboBoxModel(new String[] {"Select Animal", "Penguins", "Sea lions", "Walrus"}));
		nameBox.setSelectedIndex(0);
		nameBox.setBounds(0, 24, 179, 34);
		panel.add(nameBox);
		
		JLabel lblSex = new JLabel("Sex");
		lblSex.setBounds(205, 6, 61, 16);
		panel.add(lblSex);
		
		rdbtnMale = new JRadioButton("Male");
		rdbtnMale.setSelected(true);
		rdbtnMale.setBounds(205, 28, 69, 23);
		panel.add(rdbtnMale);
		
		JRadioButton rdbtnFemale = new JRadioButton("Female");
		rdbtnFemale.setBounds(285, 28, 86, 23);
		panel.add(rdbtnFemale);
		
		ButtonGroup bgroup = new ButtonGroup();
        bgroup.add(rdbtnMale);
        bgroup.add(rdbtnFemale);
        
		
		JLabel lblSpecies = new JLabel("Species");
		lblSpecies.setBounds(6, 70, 61, 16);
		panel.add(lblSpecies);
		
		JLabel lblWeight = new JLabel("Weight");
		lblWeight.setBounds(205, 70, 61, 16);
		panel.add(lblWeight);
		
		tfSpecies = new JTextField();
		tfSpecies.setBounds(6, 98, 173, 26);
		panel.add(tfSpecies);
		tfSpecies.setColumns(10);
		
		tfWeight = new JTextField();
		tfWeight.setBounds(205, 98, 173, 26);
		panel.add(tfWeight);
		tfWeight.setColumns(10);
		
		JLabel lblSpecialTrackingInformation = new JLabel("Special Tracking Information");
		lblSpecialTrackingInformation.setBounds(6, 136, 219, 16);
		panel.add(lblSpecialTrackingInformation);
		
		tfSpecialInfo = new JTextField();
		tfSpecialInfo.setBounds(6, 164, 372, 26);
		panel.add(tfSpecialInfo);
		tfSpecialInfo.setColumns(10);
		
		JLabel lblGps = new JLabel("GPS Information");
		lblGps.setBounds(6, 202, 173, 16);
		panel.add(lblGps);
		
		tfGPS = new JTextField();
		tfGPS.setHorizontalAlignment(SwingConstants.CENTER);
		tfGPS.setText("00.0000000 -00.0000000");
		tfGPS.setBounds(6, 230, 372, 26);
		panel.add(tfGPS);
		tfGPS.setColumns(10);
		
		JButton btnGenerateReport = new JButton("Generate Report");
		btnGenerateReport.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(nameBox.getSelectedIndex() == 1 ) {
//					valiAndmake("Wrong Blood Pressure.",myPenguins,myVali validateBP(String));
					if (myVali.validateBP(tfSpecialInfo.getText())==false){
						lblInfo.setText("Wrong Blood Pressure.");
						textReport.setText("");
						btnAddtotheList.setEnabled(false);
					}
					else if(myVali.validateWeight(tfWeight.getText())==false) {
						lblInfo.setText("Wrong Weight.");
						textReport.setText("");
						btnAddtotheList.setEnabled(false);
					}
					else if(myVali.validateGPS(tfGPS.getText())==false) {
						lblInfo.setText("Wrong GPS Pattern.");
						textReport.setText("");
						btnAddtotheList.setEnabled(false);
					}
					else {
						makeReport(myPenguins);
					}
				}
				else if(nameBox.getSelectedIndex() == 2) {
					if (myVali.validateNumSpots(tfSpecialInfo.getText())==false){
						lblInfo.setText("Wrong Number of Spots.");
						textReport.setText("");
						btnAddtotheList.setEnabled(false);
					}
					else if(myVali.validateWeight(tfWeight.getText())==false) {
						lblInfo.setText("Wrong Weight.");
						textReport.setText("");
						btnAddtotheList.setEnabled(false);
					}
					else if(myVali.validateGPS(tfGPS.getText())==false) {
						lblInfo.setText("Wrong GPS Pattern.");
						textReport.setText("");
						btnAddtotheList.setEnabled(false);
					}
					else {
						makeReport(mySealions);
					}
				}
				else if(nameBox.getSelectedIndex() == 3) {
					if (myVali.validateDH(tfSpecialInfo.getText())==false){
						lblInfo.setText("Wrong Dental Health Status.");
						textReport.setText("");
						btnAddtotheList.setEnabled(false);
					}
					else if(myVali.validateWeight(tfWeight.getText())==false) {
						lblInfo.setText("Wrong Weight.");
						textReport.setText("");
						btnAddtotheList.setEnabled(false);
					}
					else if(myVali.validateGPS(tfGPS.getText())==false) {
						lblInfo.setText("Wrong GPS Pattern.");
						textReport.setText("");
						btnAddtotheList.setEnabled(false);
					}
					else {
						makeReport(myWalrus);
					}
				}
				else {
				};
			}
		});
		btnGenerateReport.setBounds(6, 296, 173, 29);
		panel.add(btnGenerateReport);
		
		btnAddtotheList = new JButton("Add to the List");
		btnAddtotheList.setEnabled(false);
		btnAddtotheList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				List.add(textReport.getText());
				btnAddtotheList.setEnabled(false);
				lblInfo.setText("List added.");
				btnSave.setEnabled(true);
			}
		});
		btnAddtotheList.setBounds(205, 296, 173, 29);
		panel.add(btnAddtotheList);
		
		JLabel lblOperationOptions = new JLabel("Operation Options");
		lblOperationOptions.setBounds(6, 268, 128, 16);
		panel.add(lblOperationOptions);
		
		btnSave = new JButton("Save to File");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				myCon.writeFile(List);
				btnAddtotheList.setEnabled(false);
				btnSave.setEnabled(false);
				btnLoad.setEnabled(true);
			}
		});
		btnSave.setEnabled(false);
		btnSave.setBounds(6, 337, 173, 29);
		panel.add(btnSave);
		
		btnLoad = new JButton("Load the File");
		btnLoad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textReport.setText(myCon.readFile());
				lblInfo.setText("File loaded.");
			}
		});
		btnLoad.setEnabled(false);
		btnLoad.setBounds(205, 337, 173, 29);
		panel.add(btnLoad);
		
		textReport = new JTextPane();
		textReport.setMaximumSize(new Dimension(378, 281));
		textReport.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		textReport.setBounds(6, 396, 378, 281); 
		panel.add(textReport);
		
		
		
		JLabel lblTrackingReport = new JLabel("Tracking Report:");
		lblTrackingReport.setBounds(6, 378, 128, 16);
		panel.add(lblTrackingReport);
		
		JLabel lblInformation = new JLabel("Status Information");
		lblInformation.setBounds(6, 689, 128, 16);
		panel.add(lblInformation);
		
		lblInfo = new JLabel("");
		lblInfo.setForeground(Color.BLUE);
		lblInfo.setBounds(138, 689, 233, 16);
		panel.add(lblInfo);
		
		JScrollPane scrollPane = new JScrollPane(textReport);
		scrollPane.setMaximumSize(new Dimension(378, 32767));
		scrollPane.setBounds(6, 396, 378, 281);
		panel.add(scrollPane);
		
	}
}
