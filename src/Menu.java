import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class Menu implements ActionListener, ItemListener {
    public JMenuBar createMenu() {
        JMenuBar menuBar;
        JMenu menu;
        ButtonGroup gameTypeOptions;
        JRadioButtonMenuItem gameTypeRegular, gameTypeVegas;
        JMenuItem newGame;

        // Create menu bar
        menuBar = new JMenuBar();

        // Build menu
        menu = new JMenu("Options");
        menuBar.add(menu);

        // Build menu options
        newGame = new JMenuItem("New Game");
        newGame.addActionListener(this);
        menu.add(newGame);

        menu.addSeparator();

        gameTypeOptions = new ButtonGroup();
        gameTypeRegular = new JRadioButtonMenuItem("Regular Rules");
        gameTypeRegular.setSelected(true);
        gameTypeOptions.add(gameTypeRegular);
        menu.add(gameTypeRegular);

        gameTypeVegas = new JRadioButtonMenuItem("Vegas Rules");
        gameTypeOptions.add(gameTypeVegas);
        menu.add(gameTypeVegas);

        // Return MenuBar
        return menuBar;
    }

//    public void setOptions();

    @Override
    public void actionPerformed(ActionEvent e) {
        Handler.reloadGame();
    }

    @Override
    public void itemStateChanged(ItemEvent e) {

    }
}
