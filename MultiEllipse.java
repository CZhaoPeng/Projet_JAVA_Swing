package DessinAssiste;

import java.util.ArrayList;

public class MultiEllipse extends FormeComposite{

/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

private ArrayList<Forme> ellipse = new ArrayList<Forme>();
public MultiEllipse(Forme currantForme){
	if(currantForme instanceof Ellipse)
		ellipse.add((Ellipse)currantForme);
	}
}