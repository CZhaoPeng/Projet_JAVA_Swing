package DessinAssiste;

import java.util.ArrayList;

public class MultiRectangle extends FormeComposite{

/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ArrayList<Forme> rectangle = new ArrayList<Forme>();
public MultiRectangle(Forme currantForme){
	if(currantForme instanceof Rectangle)
		rectangle.add((Rectangle)currantForme);
}

}
