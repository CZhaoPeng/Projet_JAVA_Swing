package DessinAssiste;

import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/*
 * Coordonnée et Proposition
 */
public class Position extends JPanel implements ChangeListener {

	private static final long serialVersionUID = 1L;
	/*X */
	private JSpinner xSpinner;
	/*Y */
	private JSpinner ySpinner;
	/*proposition */
	private JSpinner dSpinner;
	
	/* xSpinner model */
	private SpinnerModel xModel;
	/* ySpinner model */
	private SpinnerModel yModel;
	/* dSpinner model */
	private SpinnerModel dModel;
	
	/*  */
	private FormeComposite formecomposite;
	//private Forme forme;
	public Position(FormeComposite board) {
		this.formecomposite = board;
		setLayout(new GridLayout(3, 1, 5, 5));
		// initial interface
		initFenetre();
	}
	
	private void initX() {
		xModel = new SpinnerNumberModel(formecomposite.currantForme.currantX, 8, 1500, 1);//(value, min, max, step)
		xSpinner = createSpinner(this, "X:", xModel);
		xSpinner.setEditor(new JSpinner.NumberEditor(xSpinner, "#"));//un chiffre, zéro montre comme absent (String decimalFormatPattern)
		xSpinner.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
		xSpinner.addChangeListener(this);
		
	}
	private void initY() {
		yModel = new SpinnerNumberModel(formecomposite.currantForme.currantY, 20, 850, 1);
		ySpinner = createSpinner(this, "Y:", yModel);
		ySpinner.setEditor(new JSpinner.NumberEditor(ySpinner, "#"));
		ySpinner.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
		ySpinner.addChangeListener(this);
		
	}
	private void initD() {
		dModel = new SpinnerNumberModel(formecomposite.currantForme.currantD, 0, 700, 1);
		dSpinner = createSpinner(this, "Proposition:", dModel);
		dSpinner.setEditor(new JSpinner.NumberEditor(dSpinner, "#"));
		dSpinner.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));// 1 = taille de borde
		dSpinner.addChangeListener(this);
		
	}
	
	private void initFenetre() {

		initX();
		initY();
		initD();
		
	}

	@Override
	public void stateChanged(ChangeEvent e) {
		formecomposite.setCurrentX((Integer) xModel.getValue());
		formecomposite.setCurrentY((Integer) yModel.getValue());
		formecomposite.setCurrentD((Integer) dModel.getValue());
		
	}
	
	
	
	private JSpinner createSpinner(Container container, String text, SpinnerModel model) {
		// Xã€�Yã€�proposition Ã  gouhce
		JLabel label = new JLabel(text);
		container.add(label);
		// spinner Ã  droite
		JSpinner spinner = new JSpinner(model);
//		label.setLabelFor(spinner);
		container.add(spinner);

		return spinner;
	}

}
