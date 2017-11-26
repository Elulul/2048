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

public class Vue2048 extends JPanel implements IVue{

	Game g;
	private ControllerVue2048 ctrl;
	
	public Vue2048(Game g) {
		super(new GridLayout (g.size,g.size));
		this.g = g;
		
	}

	public void setController(ControllerVue2048 ctrl)
	{
		this.ctrl = ctrl;
	}
	
	public void init()
	{
		Border blackline = BorderFactory.createLineBorder(Color.black,1);
		
		for(int i = 0; i<g.size*g.size;i++){
		   Case maCase = new Case();
		   
		   this.ctrl.ajouterObserver(maCase);
		   this.add(maCase);
		}
		this.setBorder(blackline);
	}
	

}
