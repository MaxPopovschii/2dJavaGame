package main;

import javax.swing.*;

public class App {
    public static void main(String[] args) throws Exception {
        JFrame window = new JFrame("2D Adventure");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(true);

        GamePanel gamePanel = new GamePanel();

        window.add(gamePanel);
        gamePanel.startGameThread();
        window.pack();
        window.setLocationRelativeTo(null);
        window.setVisible(true);
    }
}
