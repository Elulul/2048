package controller;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Observer;

import model.Game;
import vue.IVue;
import vue.Vue2048;



public class ControllerVue2048 implements KeyListener {

	private Game model;
	private IVue vue;
	
	public ControllerVue2048()
	{
		
	}
	
	public void setVue(IVue vue)
	{
		this.vue = vue;
	}
	
	public void ajouterObserver(Observer o)
	{
		this.model.addObserver(o);
	}
	
	public void setModel(Game g)
	{
		this.model = g;
	}
	

	@Override
	public void keyPressed(KeyEvent e) {
		switch (e.getKeyCode()) {
		case 37 :
			System.out.println("ControllerVue2048 : KeyPressed vers la gauche");
			this.model.jouer();
			break;
		case 38 :
			System.out.println("ControllerVue2048 : KeyPressed vers le haut");
			this.model.jouer();
			break;
		case 39 :
			System.out.println("ControllerVue2048 : KeyPressed vers la droite");
			this.model.jouer();
			break;
		case 40 : 
			System.out.println("ControllerVue2048 : KeyPressed vers le bas");
			this.model.jouer();
			break;
		
		}
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
	}

	@Override
	public void keyTyped(KeyEvent e) {
	
	}

}
