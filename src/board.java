import java.util.ArrayList;

public class board {
	
	private ArrayList<Integer> board;
	private int size;

	public board(int size) {
		board  = new ArrayList<Integer>();
		init_board(size);
		this.size = size;
	}
	
	public void init_board(int size) {
		for (int i = 0; i < size * size; i++) {
			board.set(i, 0) ;
		}
	}
		
	

	public ArrayList<Integer> getBoard() {
		return board;
	}

	public void setBoard(ArrayList<Integer> board) {
		this.board = board;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}
	
	
	
	
}
