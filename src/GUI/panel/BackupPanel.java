package GUI.panel;

import GUI.listener.BackupListener;
import util.GUIUtil;

import javax.swing.*;
import java.awt.*;

public class BackupPanel extends WorkingPanel {
    static{
        GUIUtil.useLNF();
    }
    private static BackupPanel instance = new BackupPanel();

    public static BackupPanel getInstance(){
        return instance;
    }
    private JButton bSubmit = new JButton("备份");

    private BackupPanel(){
        GUIUtil.setColor(Color.blue, bSubmit);
        this.add(bSubmit);
        addListener();
    }

    @Override
    public void updateData() {
        super.updateData();
    }

    @Override
    public void addListener() {
        bSubmit.addActionListener(new BackupListener());
    }

    public static void main(String[] args){
        GUIUtil.showPanel(BackupPanel.getInstance());
    }

}
