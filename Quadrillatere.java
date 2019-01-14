package DessinAssiste;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics2D;
import java.awt.Polygon;


public class Quadrillatere extends Forme {
	
	private static final long serialVersionUID = 1L;
	
	private int xS[] = null;
    private int yS[] = null;

    public Quadrillatere(Color color1, float stroke1, String type1,boolean fill,boolean degrader,Color fill_couleur,boolean choix, int x, int y) {
        super(color1, stroke1, type1, fill,degrader,fill_couleur,choix, x, y);
    	
        // initialization
        xS = new int[4];
        yS = new int[4];
    }

    public void draw(Graphics2D graphics2d) {
        xS[0] = currantX;
        yS[0] = currantY;
        xS[1] = Math.abs(currantX+currantD/2);
        yS[1] = Math.abs(currantY-currantD/2);
        xS[2] = currantX;
        yS[2] = Math.abs(currantY-currantD);
        xS[3] = Math.abs(currantX-currantD/2);
        yS[3] = Math.abs(currantY-currantD/2);
       		graphics2d.setColor(color);
		graphics2d.setStroke(new BasicStroke(stroke));
if(fill==true && degrader==false)
			
			graphics2d.fillPolygon(xS, yS,4);
		else if(fill == false && degrader ==false){
			
			 graphics2d.drawPolygon(xS, yS,4);

			}
		
		else if(fill == false && degrader == true)
		{
			if(choix)
			{
				GradientPaint grad = new GradientPaint(currantX, currantY,color,Math.abs(startX-endX), Math.abs(startY-endY),fillcouleur,true);
				graphics2d.setPaint(grad);
				Polygon quadrillatere = new Polygon(xS, yS,4);
				graphics2d.fill(quadrillatere);
			}
			else
			{
				GradientPaint grad = new GradientPaint(currantX, currantY,color,Math.abs(startX-endX), Math.abs(startY-endY),fillcouleur,false);
				graphics2d.setPaint(grad);
				Polygon quadrillatere = new Polygon(xS, yS,4);
				graphics2d.fill(quadrillatere);
				}
			}
    }
    

}
