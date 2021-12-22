import javax.swing.*;
import java.awt.*;

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
  private static JPanel formatPanel;
  private static GameBoard gamePanel;
  private static ScoreBoard scoreBoard;
  private static Menu gameMenu;

  
  private static final int FRAME_WIDTH  = 725;
  private static final int FRAME_HEIGHT = 750;
  
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
    formatPanel.remove(gamePanel);
    formatPanel.remove(scoreBoard);
    gamePanel = new GameBoard(mode);
    scoreBoard = gamePanel.getScoreBoard();
    formatPanel.add(gamePanel);
    formatPanel.add(scoreBoard, BorderLayout.SOUTH);
    formatPanel.revalidate();
  }
  
  /**
   * Initializes game objects
   */
  public static void loadGame() {
    gameFrame = new JFrame("Solitaire");

    formatPanel = new JPanel();
    gamePanel = new GameBoard();
    scoreBoard = gamePanel.getScoreBoard();
    gameMenu = new Menu();

    gameFrame.setJMenuBar(gameMenu.createMenu());
    gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    gameFrame.setSize(FRAME_WIDTH, FRAME_HEIGHT);

    formatPanel.setLayout(new BorderLayout());
    formatPanel.add(gamePanel);
    formatPanel.add(scoreBoard, BorderLayout.SOUTH);
    gameFrame.add(formatPanel);
    gameFrame.setVisible(true);
    gameFrame.setResizable(false);
  }
}
