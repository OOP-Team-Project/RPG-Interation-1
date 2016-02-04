import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class View {
	
	JFrame gameFrame = new JFrame();
	AreaView displayArea = new AreaView();
	
	public View() { //defines the frame the game will be displayed in
		displayArea.drawAreaView();
		gameFrame.add(displayArea); //adds a new AreaView to the frame
		gameFrame.setSize(1200, 600);
		gameFrame.setTitle("Game");
		gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) { //creates the View for the player this will actually be implemented in the main class?
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
		    View gameView = new View();
				(gameView.gameFrame).setVisible(true);
		  }
		});
	}

}