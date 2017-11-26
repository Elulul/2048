package vue;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.border.Border;

import model.Game;
import controller.ControllerVue2048;

public class Vue2048 extends JPanel implements Observer,IVue{

	Game g;
	private ControllerVue2048 ctrl;
	
	public Vue2048(Game g) {
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

	public void setController(ControllerVue2048 ctrl)
	{
		this.ctrl = ctrl;
	}
	
	@Override
	public void update(Observable o, Object arg) {
		System.out.println("Vue : le model a change");
	}

}
