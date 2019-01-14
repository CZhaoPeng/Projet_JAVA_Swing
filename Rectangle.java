package DessinAssiste;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.*;
import java.awt.geom.Rectangle2D;



public class Rectangle extends Forme{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public Rectangle(Color color1, float stroke1, String type1,boolean fill,boolean degrader, Color fill_couleur,boolean choix, int x, int y) {
        super(color1, stroke1, type1, fill,degrader,fill_couleur,choix, x, y);
    	
		
	}
	
	

	public void draw(Graphics2D graphics2d) {
		graphics2d.setColor(color);
		graphics2d.setStroke(new BasicStroke(stroke));
		if(fill==true && degrader==false)
		
			graphics2d.fillRect(currantX, currantY, currantD, Math.abs(startY-endY));
		else if(fill == false && degrader ==false){
			
				graphics2d.drawRect(currantX,currantY,currantD, Math.abs(startY-endY));
	
			}
		
		else if(fill == false && degrader == true)
		{
			if(choix)
			{
				GradientPaint grad = new GradientPaint(currantX, currantY,color,currantD, Math.abs(startY-endY),fillcouleur,true);
				graphics2d.setPaint(grad);
				Rectangle2D rect = new Rectangle2D.Double(currantX, currantY, currantD, Math.abs(startY-endY));
				graphics2d.fill(rect);
			}
			else
			{
				GradientPaint grad = new GradientPaint(currantX, currantY,color,currantD, Math.abs(startY-endY),fillcouleur,false);
				graphics2d.setPaint(grad);
				Rectangle2D rect = new Rectangle2D.Double(currantX, currantY, currantD, Math.abs(startY-endY));
				graphics2d.fill(rect);
				}
			}
}
}