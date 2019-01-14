package DessinAssiste;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.HeadlessException;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;


import javax.swing.ImageIcon;
import javax.swing.JFileChooser;

import javax.swing.JPanel;





public class FormeComposite extends JPanel implements MouseListener, MouseMotionListener, MouseWheelListener {

	private static final long serialVersionUID = 1L;
	/*type de forme*/
	private int tool = 0;
	/*type de cursor 0:flèche; 1:croix*/
	public static int cursor = 0;
	/*forme actuelle */
	public Forme currantForme;
	/*liste des formes */
	public ArrayList<Forme> formes;
	/*liste des formse qui ont été annulé */
	public ArrayList<Forme> cancel_formes;
	/*classe d'image  */
	private ImageParam image;
	
	
	/*initialise la couleur de la  forme: la couleur est verte */
	public Color forme_couleur = Color.GREEN;
	//public Color texte_couleur = Color.GREEN;
	public Color fill_couleur = Color.ORANGE;
	public boolean fill = false;
	public boolean choix = false;
	public boolean degrader=false;
	/*initialise le pinceau*/
	
	public float forme_stroke = 5.0F;
	
	/*propriété du fond de  l'image */
	public String path= "test11.jpg";
	
	private int old_width = 0;
	private int old_height = 0;
	private int new_width = 0;
	private int new_height = 0;
	
	
	public FormeComposite() {
		setBackground(Color.WHITE);
		// initialise la liste
		formes = new ArrayList<Forme>();
		cancel_formes = new ArrayList<Forme>();
		// obtenir mouseevent
		addMouseListener(this);
		addMouseWheelListener(this);
		addMouseMotionListener(this);
		
		image = new ImageParam(800, 800, new ColorParam(0, 0, 0));
		
		
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D graphics2d = (Graphics2D) g;
		// pour obtenir l'image
		ImageIcon icon = createImageIcon(path);
		graphics2d.drawImage(icon.getImage(), 0, 0, new_width, new_height, this);
		
		// s'il y'a la forme ou pas
		if (null != formes && formes.size() > 0) {
			for (int i = 0; i < formes.size(); i++) {
				((Forme) formes.get(i)).draw(graphics2d);
			}
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
		if (cursor == 1) {
			if (e.getButton() == 1) {
				switch (tool) {
				case 0: // cercle
					currantForme = new Cercle(forme_couleur, forme_stroke, "cercle", fill,degrader,fill_couleur,choix,e.getX(), e.getY());
					
					break;
				case 1: // Quadrilatère
					currantForme = new Quadrillatere(forme_couleur, forme_stroke, "quadrilatete", fill,degrader,fill_couleur,choix,e.getX(), e.getY());
					break;
				case 2: // ligne
					currantForme = new Line(forme_couleur, forme_stroke, "line",fill,fill_couleur, e.getX(), e.getY());
					break;
				case 3: // Rectangle
					currantForme = new Rectangle(forme_couleur, forme_stroke, "rectangle", fill,degrader,fill_couleur,choix,e.getX(), e.getY());
					
					break;
				case 4: // Ellipse
					currantForme = new Ellipse(forme_couleur, forme_stroke, "ellipse",fill,degrader,fill_couleur,choix, e.getX(), e.getY());
					break;
				case 5: // triangle
					currantForme = new Triangle(forme_couleur, forme_stroke, "triangle",fill,degrader,fill_couleur,choix, e.getX(), e.getY());
					break;
				default:// 
					break;
				}
				formes.add(currantForme);
				repaint();
			}
		}
	}

	@Override
	public void mouseDragged(MouseEvent e) {

		
			if ( currantForme != null) {
				currantForme.mouseDragged(e);
				repaint();
			}
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		cursor = 0;
		setCursor(new Cursor(cursor));

		// ajouter une ligne 
		if (currantForme instanceof Line) {
			Line temp = (Line) currantForme;
			LineParam line = new LineParam();
			line.setSize(12);
			line.setStart(new Point2D(temp.getLineStartX(), temp.getLineStartY()));
			line.setEnd(new Point2D(temp.getLineEndX(), temp.getLineEndY()));
			
		}
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if (e.getButton() == 3) {
			if (null != currantForme) {
				AttributeDialog dialog = new AttributeDialog(this);
				dialog.setLocationRelativeTo(this);
				dialog.setVisible(true);
			}
		} else if (e.getButton() == 1) {
			if (null != currantForme) {
				currantForme.mouseDragged(e);
				repaint();
			}
		}
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		
	}
	
	@Override
	public void mouseMoved(MouseEvent e) {
		
		if (getCursor().getType() == 1) {
			return;
		}
		
	}

	
	
	
	
	/*
	 * nettoyer l'écran
	 */
	public void clearBoard() {
		formes.clear();
		repaint();
	}
	
	/*
	 * Chiosir la forme
	 *  0ã€�Cercle 1ã€�QuadrilatÃ¨re 2ã€�Line 3ã€�Texte
	 */
	public void setTool(int i) {
		if (i < 0 || i > 6) {
			throw new IllegalArgumentException("Invaild Tool Specified!");
		} else {
			tool = i;
		}
	}

	
	public void setStrokeSize(float size, String type) {
		if (null == currantForme) {
			throw new NullPointerException("currentShap is Null!");
		}
		if (size < 0 || size > 10) {
			throw new IllegalArgumentException("Invaild Weight Specified!");
		}
		if ("quadrilatete".equals(type)) {
			forme_stroke = size;
		}
		if ("triangle".equals(type)) {
			forme_stroke = size;
		}
		if ("line".equals(type)) {
			forme_stroke = size;
		}
		if ("cercle".equals(type)) {
			forme_stroke = size;
		}
		if ("rectangle".equals(type)) {
			forme_stroke = size;
		}
		if ("ellipse".equals(type)) {
			forme_stroke = size;
		}
		currantForme.stroke = size;
		repaint();
	}

	/*
	 * X
	 */
	public void setCurrentX(int x) {
		currantForme.currantX = x;
		repaint();
	}

	/*
	 * Y
	 */
	public void setCurrentY(int y) {
		currantForme.currantY = y;
		repaint();
	}

	/*
	 * proportion pour la forme
	 */
	public void setCurrentD(int d) {
		currantForme.currantD = d;
		repaint();
	}

	/*
	 * couleur actuelle
	 */
	public void setCurrentColor(Color color) {
		currantForme.color = color;
		repaint();
	}
	
	
	
	/**
	 *obtenir l'image
	 * path chemin d'image
	 * ImageIcon
	 */
	private ImageIcon createImageIcon(String path) {
		if (null != path && !"".equals(path)) {

			ImageIcon image = new ImageIcon("images/" + path);
			if (old_width == 0) {
				new_width = old_width = image.getIconWidth();
			}
			if (old_height == 0) {
				new_height = old_height = image.getIconHeight();
			}
			return image;
		} else {
			System.err.println("Trouver par file: " + path);
			return null;
		}
	}
	public void newFile(){
		formes.clear();
		repaint();
	}
	
	public void saveFile(){
		JFileChooser jfs = new JFileChooser();
		int  flag = -1;
		try{
			flag = jfs.showSaveDialog(this);
		} catch (HeadlessException he){
			System.out.println("Save File Dialog Exception");
		}
		if (flag == JFileChooser.APPROVE_OPTION ){
			String filenom = jfs.getSelectedFile().getPath();
			
			try
			{
				FileOutputStream fos = new FileOutputStream(filenom);
				ObjectOutputStream oos = new ObjectOutputStream(fos);
				oos.writeObject(formes);
				oos.close();
				repaint();
			} catch ( Exception e)
			{
				System.out.println(e);
			}
		}
		
	}
	public void loadFile(){
		JFileChooser jfs = new JFileChooser();
		int  flag = -1;
		try{
			flag = jfs.showOpenDialog(this);
		} catch (HeadlessException he){
			System.out.println("Save File Dialog Exception");
		}
		if (flag == JFileChooser.APPROVE_OPTION ){
			String filenom = jfs.getSelectedFile().getPath();
			
			try
			{
				FileInputStream fis = new FileInputStream(filenom);
				ObjectInputStream ois = new ObjectInputStream(fis);
				formes = (ArrayList<Forme>) ois.readObject();
				ois.close();
				repaint();
			} catch ( Exception e)
			{
				System.out.println(e);
			}
		}
	}
	public ImageParam getImage() {
		return image;
	}

	public void setImage(ImageParam image) {
		this.image = image;
	}

	@Override
	public void mouseWheelMoved(MouseWheelEvent e) {
		
		
	}

	
}
