import javax.swing.JFrame;



public class fenetre extends JFrame {

	public fenetre() {
		this.setTitle("2048");
	    this.setSize(1280, 740);
	    game g = new game(4);
	    vue2048 v = new vue2048(g);
	    this.setContentPane(v);
	    this.setVisible(true);
	}
	
	
	public static void main(String[] args) {
		new fenetre();
	}
	
	
}
