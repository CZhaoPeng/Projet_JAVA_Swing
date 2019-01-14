package DessinAssiste;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;

public class Line extends Forme {

	private static final long serialVersionUID = 1L;

	private int lineStartX = 0;

	private int lineStartY = 0;

	private int lineEndX = 0;

	private int lineEndY = 0;

	private int direction = 0;

	protected Line(Color color1, float stroke1, String type1,boolean fill,Color fill_couleur, int x, int y) {
        super(color1, stroke1, type1, fill,degrader,fill_couleur,choix, x, y);
    	
	}

	@Override
	public void draw(Graphics2D graphics2d) {
		graphics2d.setColor(color);
		graphics2d.setStroke(new BasicStroke(stroke));
		graphics2d.drawLine(startX, startY, endX, endY);
		lineStartX = startX;
		lineStartY = startY;
		lineEndX = endX;
		lineEndY = endY;
	}

	public int getLineStartX() {
		return lineStartX;
	}

	public void setLineStartX(int lineStartX) {
		this.lineStartX = lineStartX;
	}

	public int getLineStartY() {
		return lineStartY;
	}

	public void setLineStartY(int lineStartY) {
		this.lineStartY = lineStartY;
	}

	public int getLineEndX() {
		return lineEndX;
	}

	public void setLineEndX(int lineEndX) {
		this.lineEndX = lineEndX;
	}

	public int getLineEndY() {
		return lineEndY;
	}

	public void setLineEndY(int lineEndY) {
		this.lineEndY = lineEndY;
	}

	public int getDirection() {
		return direction;
	}

	public void setDirection(int direction) {
		this.direction = direction;
	}

}
