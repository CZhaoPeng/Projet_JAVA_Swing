package DessinAssiste;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

/*
 * propri�t� pour le dessin actuel
 */
public class AttributeDialog extends JDialog implements ActionListener {

	private static final long serialVersionUID = 1L;
	/*Panel */
	private JPanel content;
	
	/* Couleur */
	private JPanel colorPanel;
	
	private JButton couleurButton;

	/* size de Panel */
	private JPanel sizePanel;
	/*Optimiser Panel */
	private JPanel fontPanel;
	/*Police */
	//private JComboBox faceCombox;
	/*style */
	//private JComboBox styleCombox;
	/*font */
	private JComboBox sizeCombox;
	/*coordonée */
	private Position position;
	/*paneau */
	private FormeComposite formecomposite;

	/*initial font */
	private final Font font = new Font("Dialog", 0, 12);
	/* pinceau */
	private final String STROKES[] = new String[] { "10.0px", "8.0px", "6.5px", "4.0px", "2.5px", "2.0px" };
	
	public AttributeDialog(FormeComposite formecomposite) {
		this.formecomposite = formecomposite;
		initGUI();
	}

	private void initGUI() {
		setModal(true);
		setTitle("Reviser l'image actuelle");
		setLayout(new GridBagLayout());

		content = new JPanel();
		content.setLayout(new BoxLayout(content, 1));
	
		GridBagConstraints gridbagconstraints = new GridBagConstraints();//layout menager 
		gridbagconstraints.weightx = 1.0D;//l’espace de range
		gridbagconstraints.insets = new Insets(10, 5, 5, 5);//l’espace autour
		getContentPane().add(content, gridbagconstraints);

		colorPanel = new JPanel();
		couleurButton = new JButton();
		sizePanel = new JPanel();
		fontPanel = new JPanel();
		sizeCombox = new JComboBox();

		// Color Panel
		colorPanel.setLayout(new FlowLayout(1, 20, 10));
		colorPanel.setBorder(new TitledBorder("Couleur"));
		content.add(colorPanel);

		couleurButton.setBackground(formecomposite.currantForme.color);
		couleurButton.setToolTipText("Selectionner la couleur ");
		couleurButton.setBorder(new LineBorder(new Color(0, 0, 0)));
		couleurButton.setPreferredSize(new Dimension(100, 50));
		couleurButton.addActionListener(this);
		colorPanel.add(couleurButton);

		// Size Panel
		
			sizePanel.setBorder(new TitledBorder("Font"));
			sizeCombox.setFont(font);
			sizeCombox.setPreferredSize(new Dimension(100, 25));
			sizeCombox.setModel(new DefaultComboBoxModel(STROKES));
			sizeCombox.setSelectedItem(String.valueOf(formecomposite.currantForme.stroke)+"px");
			sizeCombox.addActionListener(this);

			fontPanel.setLayout(new BorderLayout(0, 3));
			fontPanel.add(sizeCombox, "North");
			sizePanel.add(fontPanel);
			content.add(sizePanel);
		
		// Position & Diam�tre Panel
		if (!"line".equals(formecomposite.currantForme.getType())) {
			position = new Position(formecomposite);
			position.setBorder(new TitledBorder("Coordonn�e"));
			content.add(position);
		}

		pack();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == couleurButton) {
			Color color = JColorChooser.showDialog(this, "Selectionner la couleur", formecomposite.getForeground());
			if (color != null) {
				couleurButton.setBackground(color);
				formecomposite.setCurrentColor(color);
			}
		}
		
		
		if (e.getSource() == sizeCombox) {
			String temp = sizeCombox.getSelectedItem().toString();
			formecomposite.setStrokeSize(Float.parseFloat(temp.substring(0, temp.length() - 2)), formecomposite.currantForme.getType());
			}
		
	}

}
