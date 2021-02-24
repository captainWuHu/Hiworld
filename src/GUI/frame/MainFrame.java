package GUI.frame;

import GUI.panel.MainPanel;

import javax.swing.*;

public class MainFrame extends JFrame {
    private static MainFrame instance = new MainFrame();

    public static MainFrame getInstance(){
        return instance;
    }

    private MainFrame(){
        this.setSize(500,450);
        this.setTitle("记账本");
        this.setContentPane(MainPanel.getInstance());
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public static void main(String[] args){
        instance.setVisible(true);
    }



}
