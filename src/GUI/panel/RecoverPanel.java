package GUI.panel;

import GUI.listener.RecoverListener;
import util.GUIUtil;

import javax.swing.*;
import java.awt.*;

public class RecoverPanel extends WorkingPanel {
    static{
        GUIUtil.useLNF();
    }
    private static RecoverPanel instance = new RecoverPanel();

    public static RecoverPanel getInstance(){
        return instance;
    }
    private JButton bSubmit = new JButton("恢复");

    private RecoverPanel(){
        GUIUtil.setColor(Color.blue, bSubmit);
        this.add(bSubmit);
        addListener();
    }

    @Override
    public void addListener() {
        bSubmit.addActionListener(new RecoverListener());
    }

    @Override
    public void updateData() {
        super.updateData();
    }

    public static void main(String[] args){
        GUIUtil.showPanel(RecoverPanel.getInstance());
    }
}
