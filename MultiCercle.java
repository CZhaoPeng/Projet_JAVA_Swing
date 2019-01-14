package DessinAssiste;

import java.util.ArrayList;

public class MultiCercle extends FormeComposite{

/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


private ArrayList<Forme> cercle = new ArrayList<Forme>();
public MultiCercle(Forme currantForme){
	if(currantForme instanceof Cercle)
		cercle.add((Cercle)currantForme);
}

}
