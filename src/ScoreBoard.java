import javax.swing.*;
import java.awt.*;

public class ScoreBoard extends JPanel {
    private int score;
    private JLabel scoreLabel;

    public ScoreBoard() {
        setBackground(new Color(36, 105, 41));
        scoreLabel = new JLabel();
        updateLabel();
        scoreLabel.setFont(new Font("Helvetica", Font.BOLD, 25));
        this.add(scoreLabel);
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void updateVictoryLabel() {
        scoreLabel.setText("Winner! Score: " + this.score);
    }

    public void updateVegasFinalLabel() {
        scoreLabel.setText("Final score: $" + this.score);
    }

    public void updateVegasLabel() {
        scoreLabel.setText("Score: $" + this.score);
    }

    public void updateLabel() {
        scoreLabel.setText("Score: " + this.score);
    }
}
