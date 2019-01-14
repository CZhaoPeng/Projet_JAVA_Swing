package DessinAssiste;


/*
 * propri�t� d'image
 */

public class ImageParam {

	private int width;

	private int height;

	private ColorParam color;

	public ImageParam() {

	}

	public ImageParam(int width, int height, ColorParam color) {
		super();
		this.width = width;
		this.height = height;
		this.color = color;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public ColorParam getColor() {
		return color;
	}

	public void setColor(ColorParam color) {
		this.color = color;
	}

}
