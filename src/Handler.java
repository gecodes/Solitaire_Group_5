import javax.swing.*;

/**
 * Handler.java
 * The Handler is the driver class for Solitaire.
 * It initializes the game frame and panel and initially paints the screen.
 *
 * @author  Jake Wilson
 * @version Mar 15, 2014
 */
public class Handler {
  
  private static JFrame gameFrame;
  private static GameBoard gamePanel;
  private static Menu gameMenu;
  
  private static final int FRAME_WIDTH  = 700;
  private static final int FRAME_HEIGHT = 600;
  
  public static void main(String[] args) {
    loadGame();
//    runGame();
  }
  
  /**
   * Runs the game. There is currently no point in having a game loop, since the only
   * time the game needs to be re-painted is when the user moves a card.
   */
  public static void runGame() {
//    gamePanel.repaint();
//    while (true) {
//    }
  }
  public static void reloadGame(int mode) {
    gameFrame.remove(gamePanel);
    gamePanel = new GameBoard();
    gamePanel.setMode(mode);
    gameFrame.add(gamePanel);
    gameFrame.revalidate();
  }
  
  /**
   * Initializes game objects
   */
  public static void loadGame() {
    gameFrame = new JFrame("Solitaire");
    gamePanel = new GameBoard();
    gameMenu = new Menu();
    // set options here
    // maybe some ifs with option type
    gameFrame.setJMenuBar(gameMenu.createMenu());
    gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    gameFrame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
    gameFrame.setLocationRelativeTo(null);
    gameFrame.add(gamePanel);
    gameFrame.setVisible(true);
  }

}
