package model;
import java.util.ArrayList;

public class Board {
	
	private int[][] board;
	private int size;

	public Board(int size) {
		board  = new int[size][size];
		init_board(size);
		this.size = size;
	}
	
	public void init_board(int size) {
		for(int i = 0 ; i < size ; i++)
		{
			for(int j = 0; j < size ; j++)
			{
				this.board[i][j] = 0;
 			}
		}
	}
		

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}
	
	
	
	
}
