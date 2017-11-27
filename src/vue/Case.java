package vue;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagLayout;
import java.util.Observable;
import java.util.Observer;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

import controller.ControllerVue2048;

public class Case extends JPanel implements Observer{
	
	private int x;
	private int y;
	private ControllerVue2048 ctrl;
	
	
	private JLabel value;
	
	public Case(int x,int y)
	{
		super();
		this.x = x;
		this.y = y;
		Border blackline = BorderFactory.createLineBorder(Color.black,1);
		this.setBorder(blackline);
		
		this.setLayout(new GridBagLayout());
		
		//Value
		this.value = new JLabel();
		this.value.setText("");
		
		this.add(this.value);
		
	}
	
	public void setController(ControllerVue2048 ctrl)
	{
		this.ctrl = ctrl;
	}
	
	@Override
	public void update(Observable o, Object arg) {
		int valeur = this.ctrl.getModel().getBoard().getValeur(this.x, this.y);
		this.value.setText(valeur != 0 ? Integer.toString(valeur) : "");
	}

}
