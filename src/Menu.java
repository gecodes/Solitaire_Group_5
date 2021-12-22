import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Menu implements ActionListener {
    public JMenuBar createMenu() {
        JMenuBar menuBar;
        JMenu menu;
        ButtonGroup gameTypeOptions;
        JRadioButtonMenuItem gameTypeRegular, gameTypeVegas, gameTypeDraw3;
        JMenuItem newGame;

        // Create menu bar
        menuBar = new JMenuBar();

        // Build menu
        menu = new JMenu("Options");
        menuBar.add(menu);

        // Build menu options
        newGame = new JMenuItem("New Game");
        menu.add(newGame);

        menu.addSeparator();

        gameTypeOptions = new ButtonGroup();

        gameTypeRegular = new JRadioButtonMenuItem("Regular Rules");
        gameTypeRegular.setSelected(true);
        gameTypeRegular.addActionListener(e -> {
            Handler.reloadGame(1);
        });
        gameTypeOptions.add(gameTypeRegular);
        menu.add(gameTypeRegular);

        gameTypeVegas = new JRadioButtonMenuItem("Vegas Rules");
        gameTypeVegas.addActionListener(e -> {
            Handler.reloadGame(2);
        });
        gameTypeOptions.add(gameTypeVegas);
        menu.add(gameTypeVegas);

        gameTypeDraw3 = new JRadioButtonMenuItem("Draw 3 Rules");
        gameTypeDraw3.addActionListener(e -> {
            Handler.reloadGame(3);
        });
        gameTypeOptions.add(gameTypeDraw3);
        menu.add(gameTypeDraw3);

        newGame.addActionListener(e -> {
            if (gameTypeRegular.isSelected()) {
                Handler.reloadGame(1);
            }
            if (gameTypeVegas.isSelected()) {
                Handler.reloadGame(2);
            }
            if (gameTypeDraw3.isSelected()) {
                Handler.reloadGame(3);
            }

        });
        return menuBar;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
