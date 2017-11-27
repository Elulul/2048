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
		
	public void jouer(int dir)
	{
		moveCase(dir);
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
	public void moveCase(int dir)
	{
		int[][] Board = b.getBoard();
		switch(dir)
		{
		case 0: //Gauche
			moveLeft(Board);
			break;
		case 1: //Haut
			moveUp(Board);
			break;
		case 2: //Droite
			moveRight(Board);
			break;
		case 3: //Bas
			moveDown(Board);
			break;
		}
	}
	public void moveLeft(int[][] Board)
	{
		for(int i=0;i<Board.length;i++)
		{
			int[] temp = new int[Board.length];
			int cpt = 0;
			for(int j=0;j<Board.length;j++)
			{
				if(Board[i][j] != 0)
				{
					temp[cpt++] = Board[i][j];
				}
			}
			for(int k=0;k<temp.length-1;k++)
			{
				if(temp[k] == temp[k+1] && temp[k] != 0) 
				{
					temp[k] = temp[k]*2;
					temp[k+1] = 0;
					k++;
				}
			}
			cpt = 0;
			Board[i] = new int[Board.length];
			for(int j=0;j<Board.length;j++)
			{
				if(temp[j] != 0)
				{
					Board[i][cpt++] = temp[j];
				}
			}
		}
	}
	public void moveRight(int[][] Board)
	{
		for(int i=Board.length-1;i>=0;i--)
		{
			int[] temp = new int[Board.length];
			int cpt = Board.length-1;
			for(int j=Board.length-1;j>=0;j--)
			{
				if(Board[i][j] != 0)
				{
					temp[cpt--] = Board[i][j];
				}
			}
			for(int k=temp.length-1;k>0;k--)
			{
				if(temp[k] == temp[k-1] && temp[k] != 0) 
				{
					temp[k] = temp[k]*2;
					temp[k-1] = 0;
					k--;
				}
			}
			cpt = Board.length-1;
			Board[i] = new int[Board.length];
			for(int j=Board.length-1;j>=0;j--)
			{
				if(temp[j] != 0)
				{
					Board[i][cpt--] = temp[j];
				}
			}
		}
	}
	public void moveUp(int[][] Board)
	{
		for(int i=0;i<Board.length;i++)
		{
			int[] temp = new int[Board.length];
			int cpt = 0;
			for(int j=0;j<Board.length;j++)
			{
				if(Board[j][i] != 0)
				{
					temp[cpt++] = Board[j][i];
				}
			}
			for(int k=0;k<temp.length-1;k++)
			{
				if(temp[k] == temp[k+1] && temp[k] != 0) 
				{
					temp[k] = temp[k]*2;
					temp[k+1] = 0;
					k++;
				}
			}
			cpt = 0;
			for(int j=0;j<Board.length;j++)
			{
				Board[j][i] = 0;
				if(temp[j] != 0)
				{
					Board[cpt++][i] = temp[j];
				}
			}
		}
	}
	public void moveDown(int[][] Board)
	{
		for(int i=Board.length-1;i>=0;i--)
		{
			int[] temp = new int[Board.length];
			int cpt = Board.length-1;
			for(int j=Board.length-1;j>=0;j--)
			{
				if(Board[j][i] != 0)
				{
					temp[cpt--] = Board[j][i];
				}
			}
			for(int k=temp.length-1;k>0;k--)
			{
				if(temp[k] == temp[k-1] && temp[k] != 0) 
				{
					temp[k] = temp[k]*2;
					temp[k-1] = 0;
					k--;
				}
			}
			cpt = Board.length-1;
			for(int j=Board.length-1;j>=0;j--)
			{
				Board[j][i] = 0;
				if(temp[j] != 0)
				{
					Board[cpt--][i] = temp[j];
				}
			}
		}
	}
}
