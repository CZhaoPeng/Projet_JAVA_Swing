package DessinAssiste;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;

public class Cercle extends Forme{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public Cercle(Color color1, float stroke1, String type1,boolean fill,boolean degrader,Color fill_couleur,boolean choix, int x, int y) {
        super(color1, stroke1, type1, fill,degrader,fill_couleur,choix, x, y);
    	}
	
	public void draw(Graphics2D graphics2d) {
		
		graphics2d.setColor(color);
		graphics2d.setStroke(new BasicStroke(stroke));
		
		if(fill==true && degrader==false)
			
			graphics2d.fillOval(currantX, currantY, currantD, currantD);
		else if(fill == false && degrader ==false){
			
				graphics2d.drawOval(currantX,currantY,currantD, currantD);
	
			}
		
		else if(fill == false && degrader == true)
		{
			if(choix)
			{
				GradientPaint grad = new GradientPaint(currantX, currantY,color,currantD, currantD,fillcouleur,true);
				graphics2d.setPaint(grad);
				Ellipse2D cercle = new Ellipse2D.Double(currantX, currantY, currantD, currantD);
				graphics2d.fill(cercle);
			}
			else
			{
				GradientPaint grad = new GradientPaint(currantX, currantY,color,currantD, currantD,fillcouleur,false);
				graphics2d.setPaint(grad);
				Ellipse2D cercle = new Ellipse2D.Double(currantX, currantY, currantD, currantD);
				graphics2d.fill(cercle);
				}
			}
	}

}