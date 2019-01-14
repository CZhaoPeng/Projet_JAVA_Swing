
package DessinAssiste;
/*
 *  propriétée des couleurs
 */

public class ColorParam {

	/* return Rouge entre 0~255 */
	private int colR;
	/* return Vert entre 0~255 */
	private int colG;
	/* return Bleu entre 0~255 */
	private int colB;

	public ColorParam(int colR, int colG, int colB) {
		super();
		this.colR = colR;
		this.colG = colG;
		this.colB = colB;
	}

	public int getColR() {
		return colR;
	}

	public void setColR(int colR) {
		this.colR = colR;
	}

	public int getColG() {
		return colG;
	}

	public void setColG(int colG) {
		this.colG = colG;
	}

	public int getColB() {
		return colB;
	}

	public void setColB(int colB) {
		this.colB = colB;
	}
}
