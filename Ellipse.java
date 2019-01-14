package DessinAssiste;

import java.awt.*;
import java.awt.geom.Ellipse2D;

/**
 * 
 * 
 * 
 */
public class Ellipse extends Forme {

	private static final long serialVersionUID = 1L;

	public Ellipse(Color color1, float stroke1, String type1,boolean fill,Boolean degrader,Color fill_couleur, Boolean choix,int x, int y) {
        super(color1, stroke1, type1, fill,degrader,fill_couleur,choix, x, y);
	}

	public void draw(Graphics2D graphics2d) {
		graphics2d.setColor(color);
		graphics2d.setStroke(new BasicStroke(stroke));
		
		if(fill==true && degrader==false)
			
			graphics2d.fillOval(currantX, currantY, currantD, Math.abs(startY-endY));
		else if(fill == false && degrader ==false){
			
				graphics2d.drawOval(currantX,currantY,currantD, Math.abs(startY-endY));
	
			}
		
		else if(fill == false && degrader == true)
		{
			if(choix)
			{
				GradientPaint grad = new GradientPaint(currantX, currantY,color,currantD, Math.abs(startY-endY),fillcouleur,true);
				graphics2d.setPaint(grad);
				Ellipse2D cercle = new Ellipse2D.Double(currantX, currantY, currantD, Math.abs(startY-endY));
				graphics2d.fill(cercle);
			}
			else
			{
				GradientPaint grad = new GradientPaint(currantX, currantY,color,currantD, Math.abs(startY-endY),fillcouleur,false);
				graphics2d.setPaint(grad);
				Ellipse2D cercle = new Ellipse2D.Double(currantX, currantY, currantD, Math.abs(startY-endY));
				graphics2d.fill(cercle);
				}
		}
	}
}
