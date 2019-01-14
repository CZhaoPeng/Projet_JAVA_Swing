package DessinAssiste;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JToolBar;

/*
 * interfqce principable 
 */
public class DessinFrame extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	/*barre d'outils */
	private JToolBar toolbar;
	/* cercleBouton */
	private JButton cercleBouton;
	/* sortieBouton */
	private JButton exitBouton;
	/* Clear Button */
	private JButton clearBouton;
	/* Quadrilatere Button */
	private JButton quadrilatèreBouton;
	
	private JButton rectangleBouton;
	
	private JButton triangleBouton;
	
	private JButton lineBouton;
	private JButton ellipseBouton;
	/*rÃ©vocationButton */
	private JButton annuleBouton;
	

	private JButton backBouton;
	/* enregistrerBouton */
	//private JButton pictureBouton;
	/* configurationBouton*/
	private JButton configBouton;
	/*Pannequ */
	private FormeComposite formecomposite;
	
	private JMenuBar menubar;
	
	//public JLabel statusBar;
	private static final Font font = new Font("Arial", 0, 12);
	
	
	public DessinFrame() {
		initGUI();
	}

	private void initGUI() {
		setSize(920, 700);
		setTitle("Dessin Assiste");
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		// Button
		cercleBouton = new JButton();
		exitBouton = new JButton();
		clearBouton = new JButton();
		lineBouton = new JButton();
		quadrilatèreBouton = new JButton();
		rectangleBouton = new JButton();
		ellipseBouton = new JButton();
		triangleBouton = new JButton();
		annuleBouton = new JButton();
		backBouton = new JButton();
		//pictureBouton = new JButton();
		configBouton = new JButton();
		// ToolBar
		// ajouter des bouton dans barre d'outils   
		toolbar = new JToolBar();
		toolbar.add(configBouton);
		toolbar.add(cercleBouton);
		toolbar.add(quadrilatèreBouton);
		toolbar.add(lineBouton);
		toolbar.add(rectangleBouton);
		toolbar.add(ellipseBouton);
		toolbar.add(triangleBouton);
		toolbar.add(clearBouton);
		toolbar.add(annuleBouton);
		toolbar.add(backBouton);
		//toolbar.add(pictureBouton);
		toolbar.add(exitBouton);
		
		//menu bar
		menubar = new JMenuBar();
		JMenu filemenu = new JMenu(); 
		filemenu.setIcon(createImage("fichier.png"));
		filemenu.setFont(font);
		filemenu.setText("Fichier");
		filemenu.addActionListener(this);
		JMenuItem newItem = new JMenuItem();
		newItem.setIcon(createImage("nouveau.png"));
		newItem.setFont(font);
		newItem.setText("Nouveau");
		newItem.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        formecomposite.newFile();     //si activer, appeler la fonction 
                    }
                });
		JMenuItem openItem = new JMenuItem();
		openItem.setIcon(createImage("ouvrir.png"));
		openItem.setFont(font);
		openItem.setText("Ouvrir");
		openItem.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        formecomposite.loadFile();      //si activer(si vrai), appeler la fonction 
                    }
                });
		JMenuItem saveItem = new JMenuItem();
		saveItem.setIcon(createImage("enregistre.png"));
		saveItem.setFont(font);
		saveItem.setText("Enregistrer");
		saveItem.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        formecomposite.saveFile();      //si activer, appeler la fonction 
                    }
                });
		JMenuItem exitItem = new JMenuItem();
		exitItem.setIcon(createImage("exit.png"));
		exitItem.setFont(font);
		exitItem.setText("Sortie");
		exitItem.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                    	//int i = JOptionPane.showConfirmDialog(this,"Est-ce que vous confirmez la sortie?","Suggetion",JOptionPane.OK_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE);
            		    //if(i == JOptionPane.OK_OPTION)
            		        System.exit(0);      //si activer, appeler la fonction 
                    }
                });
		
		filemenu.add(newItem);
		filemenu.add(openItem);
		filemenu.add(saveItem);
		filemenu.addSeparator();
		filemenu.add(exitItem);
		JMenu fondmenu = new JMenu(); 
		fondmenu.setIcon(createImage("save_image.png"));
				fondmenu.setFont(font);
				fondmenu.setText("Fond");
				JMenuItem imageItem1 = new JMenuItem();
				imageItem1.setIcon(createImage("save_image.png"));
				imageItem1.setFont(font);
				imageItem1.setText("Image1");				
				imageItem1.addActionListener(
						new ActionListener() {
						 public void actionPerformed(ActionEvent e) {
							 formecomposite.path = "test1.jpg";
								formecomposite.repaint();
						         }
						    });
				JMenuItem imageItem2 = new JMenuItem();
				imageItem2.setIcon(createImage("save_image.png"));
				imageItem2.setFont(font);
				imageItem2.setText("Image2");				
				imageItem2.addActionListener(
						new ActionListener() {
						 public void actionPerformed(ActionEvent e) {
							 formecomposite.path = "test2.jpg";
								formecomposite.repaint();
						         }
						    });
				JMenuItem imageItem3 = new JMenuItem();
				imageItem3.setIcon(createImage("save_image.png"));
				imageItem3.setFont(font);
				imageItem3.setText("Image3");				
				imageItem3.addActionListener(
						new ActionListener() {
						 public void actionPerformed(ActionEvent e) {
							 formecomposite.path = "test3.jpg";
								formecomposite.repaint();
						         }
						    });
				fondmenu.add(imageItem1);
				fondmenu.add(imageItem2);
				fondmenu.add(imageItem3);
		JMenu aidemenu = new JMenu(); 
				//filemenu.setIcon(createImage("save_image.png"));
				aidemenu.setFont(font);
				aidemenu.setText("Aide");
				JMenuItem aboutItem = new JMenuItem();
				//aboutItem.setIcon(createImage("exit.png"));
				aboutItem.setFont(font);
				aboutItem.setText("A propos de");
				aboutItem.addActionListener(
				new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "C'est un programme crée pour le Projet java","A propos du logiciel",JOptionPane.INFORMATION_MESSAGE);      //si activer, appeler la fonction 
								      }
							});
				aidemenu.add(aboutItem);
		menubar.add(filemenu);
		menubar.add(fondmenu);
		menubar.add(aidemenu);
		// borad
		formecomposite = new FormeComposite();
		
		configBouton.setIcon(createImage("config.png"));
		configBouton.setFont(font);
		configBouton.setText("Configuration");
		configBouton.addActionListener(this);

		cercleBouton.setIcon(createImage("oval.png"));
		cercleBouton.setFont(font);
		cercleBouton.setText("Cercle");
		cercleBouton.addActionListener(this);

		quadrilatèreBouton.setIcon(createImage("quadrilatere.png"));
		quadrilatèreBouton.setFont(font);
		quadrilatèreBouton.setText("Quadrilatere");
		quadrilatèreBouton.addActionListener(this);

		lineBouton.setIcon(createImage("line.png"));
		lineBouton.setFont(font);
		lineBouton.setText("Ligne");
		lineBouton.addActionListener(this);
		rectangleBouton.setIcon(createImage("rectangle.png"));
		rectangleBouton.setFont(font);
		rectangleBouton.setText("Rectangle");
		rectangleBouton.addActionListener(this);
		
		ellipseBouton.setIcon(createImage("ellipse.png"));
		ellipseBouton.setFont(font);
		ellipseBouton.setText("Ellipse");
		ellipseBouton.addActionListener(this);
		
		triangleBouton.setIcon(createImage("triangle.png"));
		triangleBouton.setFont(font);
		triangleBouton.setText("Triangle");
		triangleBouton.addActionListener(this);
		
		
		clearBouton.setIcon(createImage("clear.png"));
		clearBouton.setFont(font);
		clearBouton.setText("Effacer");
		clearBouton.addActionListener(this);

		annuleBouton.setIcon(createImage("cancel.png"));
		annuleBouton.setFont(font);
		annuleBouton.setText("Annuler");
		annuleBouton.addActionListener(this);

		backBouton.setIcon(createImage("back.png"));
		backBouton.setFont(font);
		backBouton.setText("Retour");
		backBouton.addActionListener(this);

		//pictureBouton.setIcon(createImage("save_image.png"));
		//pictureBouton.setFont(font);
		//pictureBouton.setText("Enregistrer");
		//pictureBouton.addActionListener(this);

		exitBouton.setIcon(createImage("exit.png"));
		exitBouton.setFont(font);
		exitBouton.setText("Sortie");
		exitBouton.addActionListener(this);

		
		
		//getContentPane().add(toolbar, "North");
		//getContentPane().add(board, "Center");
		Container c = getContentPane();
        super.setJMenuBar(menubar);
        //buttonPanel.setLayout(new BoxLayout(buttonPanel,BoxLayout.Y_AXIS));
        c.add(toolbar, BorderLayout.NORTH);
        c.add(formecomposite, BorderLayout.CENTER);
       // statusBar = new JLabel();
       // c.add(statusBar, BorderLayout.SOUTH);
      // statusBar.setText("     Welcome To The Little Drawing Pad!!!  :)");
	}
	
	/**
	 * Obtenir l'image
	 * @param path: chemin d'image
	 * @return ImageIcon
	 */
	private ImageIcon createImage(String path) {
		if (null != path && !"".equals(path)) {
			return new ImageIcon("images/" + path);
		} else {
			System.err.println("impossible de trouver le fichier: " + path);
			return null;
		}
	}
	
	
	private void Peindre(int type, String name) {
		formecomposite.setTool(type);
		FormeComposite.cursor = 1;
		formecomposite.setCursor(new Cursor(1));
		
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == cercleBouton) {
			Peindre(0, null);
		} else if (e.getSource() == quadrilatèreBouton) {
			Peindre(1, null);
		} else if (e.getSource() == lineBouton) {
			Peindre(2, null);
		} 
		else if (e.getSource() == rectangleBouton) {
			Peindre(3, null);
		} 
		else if (e.getSource() == ellipseBouton) {
			Peindre(4, null);
		} 
		else if (e.getSource() == triangleBouton) {
			Peindre(5, null);
		} 
		else if (e.getSource() == clearBouton) {
			formecomposite.clearBoard();
			// vider
			formecomposite.formes.clear();
			formecomposite.cancel_formes.clear();
		} else if (e.getSource() == annuleBouton) {
			if (formecomposite.formes.size() < 1) {
				JOptionPane.showMessageDialog(null, "Aucune opération ne peut être annulé");
				return;
			}
			// obtenir la forme derniere
			int my_index = formecomposite.formes.indexOf(formecomposite.currantForme);//Retourne l'index de la première occurrence d'une valeur dans un tableau
			Forme before = my_index > 0 ? formecomposite.formes.get(my_index - 1) : null;
			if (!formecomposite.cancel_formes.contains(formecomposite.currantForme)) {//contien
				// annule le forme
				formecomposite.formes.remove(formecomposite.currantForme);
				// enregistré la forme qui a été annulé
				formecomposite.cancel_formes.add(formecomposite.currantForme);
				// mettre la forme est currant
				formecomposite.currantForme = before;
			}
			formecomposite.repaint();
		} else if (e.getSource() == backBouton) {
			if (formecomposite.cancel_formes.size() < 1) {
				JOptionPane.showMessageDialog(null, "Aucune opération ne peut être annulé");
				return;
			}
			
			Forme annulé = formecomposite.cancel_formes.get(formecomposite.cancel_formes.size()-1);
			if (!formecomposite.formes.contains(annulé)) {
				// revenir à la forme
				formecomposite.cancel_formes.remove(annulé);
				formecomposite.formes.add(annulé);
				formecomposite.currantForme = annulé;
			}
			formecomposite.repaint();
		}  else if (e.getSource() == exitBouton) {
			int i = JOptionPane.showConfirmDialog(this,"Est-ce que vous confirmez la sortie?","Suggetion",JOptionPane.OK_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE);
		    if(i == JOptionPane.OK_OPTION)
		        System.exit(0);
		} else if (e.getSource() == configBouton) {
			Configuration config = new Configuration(formecomposite);
			config.setLocationRelativeTo(null);
			config.setVisible(true);
		}
	}
}
