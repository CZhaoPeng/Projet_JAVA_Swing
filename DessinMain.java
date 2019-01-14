package DessinAssiste;

import javax.swing.UIManager;

public class DessinMain {
	
				
public static void main(String args[]) {
	try {
		UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			       
	} catch (Exception e) {}
			        
			   
	DessinFrame frame = new DessinFrame();
	frame.setLocationRelativeTo(null);
	frame.setVisible(true);

	}
}
