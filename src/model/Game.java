package model;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

public class Game extends Observable{
	
	public int size ;
	public Board b;
	
	public Game(int size) {
		this.size = size;
		this.b = new Board(size);
	}
		
	public void jouer()
	{
		System.out.println("Model : jouer");
		this.setChanged();
		this.notifyObservers();
	}
	
	public void new_value_box() {
		/*
		ArrayList<Integer> tampon = new ArrayList<Integer>();
		for (int i =0; i < size * size; i++) {
			if(b.getBoard().get(i) == 0) {
				tampon.add(i);
			}
		}
		int min=0;
		int max =tampon.size() - 1;
		int nbAlea = (int)(Math.random()*(max-min))+min;
		float tampon_value = (float) Math.random();
		int value = 0;
		if(tampon_value > 0.85 ) {
			value = 4;
		}
		else {
			value = 2;
		}
		b.getBoard().set(tampon.get(nbAlea), value);
		*/
		
	}


	
}
