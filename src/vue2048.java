import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.border.Border;

public class vue2048 extends JPanel {

	game g;
	
	public vue2048(game g) {
		super(new GridLayout (g.size,g.size));
		this.g = g;
		Border blackline = BorderFactory.createLineBorder(Color.black,1); 
		for(int i = 0; i<g.size*g.size;i++){
		   JPanel ptest = new JPanel();
		   ptest.setBorder(blackline);
		   this.add(ptest);
		}
		this.setBorder(blackline);
	}
}
