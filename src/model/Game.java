package model;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

public class Game extends Observable{
	
	public int size ;
	private Board b;
	
	public Game(int size) {
		this.size = size;
		this.b = new Board(size);
	}
		
	public void jouer()
	{
		if(this.new_value_box())
		{
			this.setChanged();
			this.notifyObservers();
		}
		else
		{
			System.out.println("Faudrait afficher une PopUp de looser");
		}
	}
	
	public Board getBoard()
	{
		return this.b;
	}
	
	public boolean new_value_box() {
		ArrayList<int[]> tampon = new ArrayList<int[]>();
		
		int[][] monBoard = b.getBoard();
		
		for (int i =0; i < size ; i++) {
			for(int j = 0 ; j < size ; j++)
			{
				if(monBoard[i][j] == 0)
				{
					int coord[] = new int[2];
					coord[0] = i;
					coord[1] = j;
					tampon.add(coord);
				}
			}
		}
		if(tampon.size() != 0)
		{
			int min=0;
			int max = tampon.size() - 1;
			int nbAlea = (int)(Math.random()*(max-min))+min;
			float tampon_value = (float) Math.random();
			int value = 0;
			if(tampon_value > 0.85 ) {
				value = 4;
			}
			else {
				value = 2;
			}
			b.getBoard()[tampon.get(nbAlea)[0]][tampon.get(nbAlea)[1]] = value;
			return true;
		}
		else
		{
			//pas de case vide == défaite
			return false;
		}
		
	}


	
}
