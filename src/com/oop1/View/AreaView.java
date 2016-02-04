import javax.swing.JPanel;
import java.awt.GridLayout;


public class AreaView extends JPanel{ //displays the subset of visible tiles to the player
	//viewableTiles defined here
	
	
	String[] areaEffect = {"grass", "water", "road"}; //using list of areaEffect for testing purposes
	
	
	public AreaView() {
		setLayout(new GridLayout(0, 10)); //lays the tiles from left to right
	}
	
	public void drawAreaView() {
		for (int i = 0; i < 50; i++) {
			add(new TileView());
		}
	}
}