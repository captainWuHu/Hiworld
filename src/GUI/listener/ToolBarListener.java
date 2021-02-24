package GUI.listener;

import GUI.panel.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ToolBarListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        MainPanel p = MainPanel.getInstance();
        JButton b = (JButton)e.getSource();
        if(b == p.bBackup)
           p.workingPanel.show(BackupPanel.getInstance());
        if(b == p.bCategory)
            p.workingPanel.show(CategoryPanel.getInstance());
        if(b == p.bConfig)
            p.workingPanel.show(ConfigPanel.getInstance());
        if(b == p.bRecord)
            p.workingPanel.show(RecordPanel.getInstance());
        if(b == p.bRecover)
            p.workingPanel.show(RecoverPanel.getInstance());
        if(b == p.bSpend)
            p.workingPanel.show(SpendPanel.getInstance());
        if(b == p.bReport){
            p.workingPanel.show(ReportPanel.getInstance());
        }
    }
}
