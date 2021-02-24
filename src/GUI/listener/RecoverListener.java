package GUI.listener;

import GUI.panel.ConfigPanel;
import GUI.panel.MainPanel;
import GUI.panel.RecoverPanel;
import service.ConfigService;
import util.mysqlUtil;

import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class RecoverListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        RecoverPanel p = RecoverPanel.getInstance();
        String mysqlPath = new ConfigService().get(new ConfigService().getMysqlPath());
        if(mysqlPath.length()==0){
            JOptionPane.showMessageDialog(p,"恢复前请先设置mysql路径！！");
            MainPanel.getInstance().workingPanel.show(ConfigPanel.getInstance());
            ConfigPanel.getInstance().getTfMySQL().grabFocus();
            return;
        }

        JFileChooser fc = new JFileChooser();
        fc.setSelectedFile(new File("hutubill.sql"));
        fc.setFileFilter(new FileFilter() {
            @Override
            public boolean accept(File f) {
                if(f.isDirectory())return true;
                return f.getName().toLowerCase().endsWith(".sql");
            }

            @Override
            public String getDescription() {
                return ".sql";
            }
        });
        int returnVal = fc.showOpenDialog(p);
        File file = fc.getSelectedFile();
        System.out.println(file);
        if(returnVal == JFileChooser.APPROVE_OPTION){

            try{
                mysqlUtil.Recover(mysqlPath,file.getAbsolutePath());
                JOptionPane.showMessageDialog(p,"恢复成功\r\n");
            }catch(Exception e1){
                e1.printStackTrace();
                JOptionPane.showMessageDialog(p,"恢复失败\r\n,错误:\r\n"+e1.getMessage());
            }
        }

    }
}
