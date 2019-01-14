
package DessinAssiste;

// propri�t� de ligne
public class LineParam {

	/* couleur de ligne */
	private ColorParam color;
	/* segment */
	
	/* size de segment 20 */
	private Integer size = 10;
	/* debut */
	private Point2D start;
	/* fin */
	private Point2D end;
	

	public ColorParam getColor() {
		return color;
	}

	public void setColor(ColorParam color) {
		this.color = color;
	}


	public Integer getSize() {
		return size;
	}

	public void setSize(Integer size) {
		this.size = size;
	}

	public Point2D getStart() {
		return start;
	}

	public void setStart(Point2D start) {
		this.start = start;
	}

	public Point2D getEnd() {
		return end;
	}

	public void setEnd(Point2D end) {
		this.end = end;
	}

}
