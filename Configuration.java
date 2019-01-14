package DessinAssiste;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JColorChooser;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Configuration extends JDialog implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel panel1;
	// label
	private JLabel backLabel;
	private JLabel formecouleurLabel;
	private JLabel formesizeLabel;
	//private JLabel texteLabel;
	private JLabel checkboxLabel;
	private JLabel fillLabel;
	// button
	private JButton backCouleur;
	private JButton formeCouleur;
	private JButton okButton;
	private JButton quitButton;
	//private JButton texteCouleur;
	private JButton fillCouleur;
	//Checkbox
	
   private JCheckBox checkbox1 ;
   private JCheckBox checkbox2;
   private JCheckBox checkbox3;
   private JCheckBox checkbox4;
	// combox
	private JComboBox formeSize;
	//private JComboBox textFace;// police
	//private JComboBox textStyle;// style
	//private JComboBox textSize;// font
	private FormeComposite formecompisite;
	private boolean fill =false;
	private boolean choix =false;
	private boolean degrader = false;
	/*liste de Pinceau */
	private final String STROKES[] = new String[] { "10.0px", "8.0px", "6.5px", "4.0px", "2.5px", "2.0px" };
	/*liste de police  */
	//private final String STYLE[] = new String[] { "PLAIN", "BOLD", "ITALIC" };
	/*liste de font */
	//private final String SIZES[] = new String[] { "20", "22", "24", "26", "28", "30", "32", "34", "36", "38", "40", "42", "44", "46", "48", "50" };

	// font
	private static final Font font = new Font("Arial", Font.PLAIN, 12);
	public Configuration(FormeComposite board) {
		this.formecompisite = board;
		initGUI();
	}
	
	public void initGUI() {
		setModal(true);
		setSize(460, 260);
		setTitle("Conception de propriété");
		setResizable(false);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
	        
		panel1 = new JPanel();
		panel1.setLayout(null );
		
		getContentPane().add(panel1);
		backLabel = new JLabel("FondCouleur");
		backLabel.setBounds(10, 10, 80, 25);
		backLabel.setFont(font);
		panel1.add(backLabel);
		
		backCouleur = new JButton();
		backCouleur.setBounds(90, 10, 80, 25);
		backCouleur.setBackground(formecompisite.getBackground());
		backCouleur.setPreferredSize(new Dimension(50, 25));
		backCouleur.addActionListener(this);
		panel1.add(backCouleur);
		
		formecouleurLabel = new JLabel("FormeCouleur");
		formecouleurLabel.setBounds(10, 55, 80, 25);
		formecouleurLabel.setFont(font);
		panel1.add(formecouleurLabel);
		
		
		formeCouleur = new JButton();
		formeCouleur.setBackground(formecompisite.forme_couleur);
		formeCouleur.setBounds(90, 55, 80, 25);
		formeCouleur.setPreferredSize(new Dimension(50, 25));
		formeCouleur.addActionListener(this);
		panel1.add(formeCouleur);
		
		formesizeLabel = new JLabel("FormeSize");
		formesizeLabel.setBounds(10, 100, 80, 25);
		formesizeLabel.setFont(font);
		panel1.add(formesizeLabel);
		formeSize = new JComboBox();
		formeSize.setBounds(90, 100, 80, 25);
		formeSize.setFont(font);
		formeSize.setModel(new DefaultComboBoxModel(STROKES));
		formeSize.setSelectedItem(transToString(formecompisite.forme_stroke));
		formeSize.addActionListener(this);
		panel1.add(formeSize);
		
		
		
		checkboxLabel = new JLabel("Remplir");
		checkboxLabel.setBounds(10, 135, 70, 25);
		checkboxLabel.setFont(font);
		panel1.add(checkboxLabel);
		
		
		
		ButtonGroup buttonGroup = new ButtonGroup();
		checkbox1 = new JCheckBox("Non",false);
		checkbox1.setBounds(85, 135, 80, 25);
		checkbox1.setFont(font);
		checkbox1.setPreferredSize(new Dimension(50, 25));
		checkbox1.addActionListener(this);
		buttonGroup.add(checkbox1);
		panel1.add(checkbox1);
		checkbox2 = new JCheckBox("Oui",false);
		checkbox2.setBounds(190, 135, 80, 25);
		checkbox2.setFont(font);
		checkbox2.setPreferredSize(new Dimension(50, 25));
		checkbox2.addActionListener(this);
		buttonGroup.add(checkbox2);
		panel1.add(checkbox2);
		checkbox3 = new JCheckBox("Degrader",false);
		checkbox3.setBounds(290, 135, 90, 25);
		checkbox3.setFont(font);
		checkbox3.setPreferredSize(new Dimension(50, 25));
		checkbox3.addActionListener(this);
		buttonGroup.add(checkbox3);
		panel1.add(checkbox3);
		
		fillLabel = new JLabel("FillCouleur");
		fillLabel.setBounds(290, 160, 75, 25);
		fillLabel.setFont(font);
		fillLabel.setVisible(false);
		panel1.add(fillLabel);
		fillCouleur = new JButton();
		fillCouleur.setBackground(formecompisite.fill_couleur);
		fillCouleur.setBounds(365, 160, 80, 25);
		fillCouleur.setPreferredSize(new Dimension(50, 25));
		fillCouleur.addActionListener(this);
		fillCouleur.setVisible(false);
		panel1.add(fillCouleur);
		
		checkbox4 = new JCheckBox("Choix");
		checkbox4.setBounds(365, 185, 90, 25);
		checkbox4.addActionListener(this);
		checkbox4.setVisible(false);
		panel1.add(checkbox4);
		okButton = new JButton("Confirmer");
		okButton.setBounds(85, 200, 90, 30);
		okButton.setFont(font);
		okButton.addActionListener(this);
		panel1.add(okButton);

		quitButton = new JButton("Annuler");
		quitButton.setBounds(290, 200, 90, 30);
		quitButton.setFont(font);
		quitButton.addActionListener(this);
		panel1.add(quitButton);
	}

	

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == backCouleur) {
			Color color = JColorChooser.showDialog(this, "Choisir le font couleur", formecompisite.getBackground());
			backCouleur.setBackground(color);
		}if (e.getSource() == formeCouleur) {
			Color color = JColorChooser.showDialog(this, "Choisis la couleur du pinceau", formecompisite.forme_couleur);
			formeCouleur.setBackground(color);
		}
		if(checkbox1.isSelected()){
			fill = false;
			degrader =false;
			fillCouleur.setVisible(false);
			fillLabel.setVisible(false);
			checkbox4.setVisible(false);
		}
		if(checkbox2.isSelected()){
			fill = true;
			degrader=false;
			fillCouleur.setVisible(false);
			fillLabel.setVisible(false);
			checkbox4.setVisible(false);
		}
		if(checkbox3.isSelected()){
			fill = false;
			degrader = true;
			choix =false;
			fillCouleur.setVisible(true);
			fillLabel.setVisible(true);
			checkbox4.setVisible(true);
			
		}
		if(checkbox4.isSelected()){
			//fill = true;
			degrader = true;
			choix = true;
			
			
		}
		if (e.getSource() == fillCouleur) {
			Color color = JColorChooser.showDialog(this, "Choisir le font couleur", formecompisite.getBackground());
			fillCouleur.setBackground(color);
		}
		if (e.getSource() == okButton) {
			// color
			formecompisite.setBackground(backCouleur.getBackground());
			formecompisite.forme_couleur = formeCouleur.getBackground();
			formecompisite.fill_couleur = fillCouleur.getBackground();
			
			// size
			formecompisite.forme_stroke = transToFloat(formeSize);
			//fill
			formecompisite.fill = fill;
			formecompisite.degrader=degrader;
			formecompisite.choix = choix;
		
			// close
			dispose();
		}
		if (e.getSource() == quitButton) {
			dispose();
		}
	}

	/*
	 * Float convetit en String pour le pinceau
	 */
	private String transToString(float value) {
		String temp = String.valueOf(value);
		return temp + "px";
	}

	private float transToFloat(Object object) {
		String temp = ((JComboBox) object).getSelectedItem().toString();
		return Float.parseFloat(temp.substring(0, temp.length() - 2));// (debut, fin) 10.0px
	}

	

}

