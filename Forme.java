package DessinAssiste;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import javax.swing.JLabel;


public abstract class Forme extends JLabel implements MouseMotionListener {

	private static final long serialVersionUID = 1L;

	
	protected float stroke;
	
	protected Color color;
	protected Color fillcouleur;
	/*type de forme*/
	protected String type;
	
	protected int startX = 0;
	protected int startY = 0;
	protected int endX = 0;
	protected int endY = 0;
	protected int currantX = 0;
	protected int currantY = 0;
	protected int currantD = 0;
	protected static boolean fill = false;
	protected static boolean degrader = false;
	protected static boolean choix =false;
	protected Forme(Color color1, float stroke1, String type1,boolean fill1,boolean degrader1,Color fill_couleur, boolean choix1,int x, int y) {
		type = type1;
		color = color1;
		stroke = stroke1;
		startX = endX = currantX = x;
		startY = endY = currantY = y;
		fill=fill1;
		degrader = degrader1;
		choix =choix1;
		fillcouleur =fill_couleur;
		addMouseMotionListener(this);
	}

	public void mouseDragged(MouseEvent mouseevent) {
		// croix
		
		if (FormeComposite.cursor == 1) {
			
			endX = mouseevent.getX();
			endY = mouseevent.getY();
			currantD = Math.abs(startX - endX);

			if (startX > endX) {
				currantX = endX;
			}
			if (startY > endY) {
				currantY = endY;
			}
		} else {
			currantX = mouseevent.getX();
			currantY = mouseevent.getY();
		}
	}

	public void mouseMoved(MouseEvent mouseevent) {
		
	}

	public abstract void draw(Graphics2D graphics2d);

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	

}
