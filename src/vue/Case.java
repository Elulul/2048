package vue;

import java.awt.Color;
import java.util.Observable;
import java.util.Observer;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.border.Border;

public class Case extends JPanel implements Observer{
	
	public Case()
	{
		super();
		Border blackline = BorderFactory.createLineBorder(Color.black,1);
		this.setBorder(blackline);
	}
	
	@Override
	public void update(Observable o, Object arg) {
		System.out.println("Vue : le model a change");
	}

}
