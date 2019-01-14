package DessinAssiste;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics2D;
import java.awt.Polygon;

public class Triangle extends Forme{

	private int xS[] = null;
    private int yS[] = null;
	protected Triangle(Color color1, float stroke1, String type1, boolean fill1, boolean degrader1, Color fill_couleur,
			boolean choix1, int x, int y) {
		super(color1, stroke1, type1, fill1, degrader1, fill_couleur, choix1, x, y);
		 xS = new int[3];
	        yS = new int[3];
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Override
	public void draw(Graphics2D graphics2d) {
		 xS[0] = currantX;
     yS[0] = currantY;
     xS[1] = currantX + currantD;
     yS[1] = currantY;
     xS[2] = currantX+ currantD / 2;
     yS[2] = (int)(currantY - currantD / 2*1.732 );// triangle equilateral
		graphics2d.setColor(color);
		graphics2d.setStroke(new BasicStroke(stroke));
		
		if(fill==true && degrader==false)
			
			graphics2d.fillPolygon(xS, yS,3);
		else if(fill == false && degrader ==false){
			
			 graphics2d.drawPolygon(xS, yS,3);

			}
		
		else if(fill == false && degrader == true)
		{
			if(choix)
			{
				GradientPaint grad = new GradientPaint(currantX, currantY,color,Math.abs(startX-endX), Math.abs(startY-endY),fillcouleur,true);
				graphics2d.setPaint(grad);
				Polygon triangle = new Polygon(xS, yS,3);
				graphics2d.fill(triangle);
			}
			else
			{
				GradientPaint grad = new GradientPaint(currantX, currantY,color,Math.abs(startX-endX), Math.abs(startY-endY),fillcouleur,false);
				graphics2d.setPaint(grad);
				Polygon triangle = new Polygon(xS, yS,3);
				graphics2d.fill(triangle);
				}
			}
    }
	
	
}
