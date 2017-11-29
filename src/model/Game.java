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
		//Ne pas oublier de vérifier si rien ne peut bouger, alors il faut interdire le move gauche !
		for(int i=0;i<Board.length;i++)
		{
			boolean fusionnable=true;
			int[] temp = new int[Board.length];
			int cpt = 0;
			for(int j=0;j<Board.length;j++)
			{
				if(Board[i][j] != 0 && fusionnable)
				{	
					if (cpt !=0 && Board[i][j] == temp[cpt-1])
							{
								temp[cpt-1] = temp[cpt-1]*2;
								fusionnable=false;
							}
					else{
					temp[cpt] = Board[i][j];
					cpt++;
					}
				}
				else if (!fusionnable) {
					temp[cpt++]=Board[i][j];
					fusionnable=true;
				}
				
			}

			Board[i]=temp;
		}
	}

		public void moveRight(int[][] Board)
		{
			for(int i=0;i<Board.length;i++)
			{
				boolean fusionnable=true;
				int[] temp = new int[Board.length];
				int cpt = Board.length-1;
				for(int j=Board.length-1;j>=0;j--)
				{
					if(Board[i][j] != 0 && fusionnable)
					{	
						if (cpt !=Board.length-1 && Board[i][j] == temp[cpt+1])
								{
									temp[cpt+1] = temp[cpt+1]*2;
									fusionnable=false;
								}
						else{
						temp[cpt] = Board[i][j];
						cpt--;
						}
					}
					else if (!fusionnable) {
						temp[cpt--]=Board[i][j];
						fusionnable=true;
					}
					
				}

				Board[i]=temp;
			}
		}

		public void moveUp(int[][] Board)
		{
			for(int j=0;j<Board.length;j++)
			{
				boolean fusionnable=true;
				int[] temp = new int[Board.length];
				int cpt = 0;
				for(int i=0;i<Board.length;i++)
				{
					if(Board[i][j] != 0 && fusionnable)
					{	
						if (cpt !=0 && Board[i][j] == temp[cpt-1])
								{
									temp[cpt-1] = temp[cpt-1]*2;
									fusionnable=false;
								}
						else{
						temp[cpt] = Board[i][j];
						cpt++;
						}
					}
					else if (!fusionnable) {
						temp[cpt++]=Board[i][j];
						fusionnable=true;
					}
					
				}
				for(int i=0;i<Board.length;i++)
				Board[i][j]=temp[i];
			}
		}
		
		public void moveDown(int[][] Board)
		{
			for(int j=0;j<Board.length;j++)
			{
				boolean fusionnable=true;
				int[] temp = new int[Board.length];
				int cpt = Board.length-1;
				for(int i=Board.length-1;i>=0;i--)
				{
					if(Board[i][j] != 0 && fusionnable)
					{	
						if (cpt !=Board.length-1 && Board[i][j] == temp[cpt+1])
								{
									temp[cpt+1] = temp[cpt+1]*2;
									fusionnable=false;
								}
						else{
						temp[cpt] = Board[i][j];
						cpt--;
						}
					}
					else if (!fusionnable) {
						temp[cpt--]=Board[i][j];
						fusionnable=true;
					}
					
				}
				for(int i=Board.length-1;i>=0;i--)
					Board[i][j]=temp[i];
			}
		}
}
