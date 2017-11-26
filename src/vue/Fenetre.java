package vue;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;

import controller.ControllerVue2048;
import model.Game;



public class Fenetre extends JFrame implements IVue{
	
	private ControllerVue2048 ctrl;
	
	public Fenetre() {
		this.setTitle("2048");
	    this.setSize(740, 740);
	    
	    //Model
	    Game g = new Game(4);
	    
	    //Vue
	    Vue2048 v = new Vue2048(g);
	    
	    //Controller
	    ControllerVue2048 ctrl = new ControllerVue2048();
	    
	    //Le controller connait la vue et le model
	    ctrl.setModel(g);
	    ctrl.setVue(v);
	    
	    
	    //La vue a besoin d'un controller
	    this.setController(ctrl);
	    v.setController(ctrl);

	   	this.addKeyListener(ctrl);   
	   	
	   	v.init();
	    
	    this.setContentPane(v);
	    this.setVisible(true);
	}
	
	public void setController(ControllerVue2048 ctrl)
	{
		this.ctrl = ctrl;
	}

}
