package GUI.listener;

import GUI.panel.BackupPanel;
import GUI.panel.ConfigPanel;
import GUI.panel.MainPanel;
import dao.ConfigDao;
import entity.Config;
import service.ConfigService;
import util.DBUtil;
import util.mysqlUtil;

import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class BackupListener implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        BackupPanel p = BackupPanel.getInstance();
        String mysqlPath = new ConfigService().get(new ConfigService().getMysqlPath());
        if (mysqlPath.length() == 0){
            JOptionPane.showMessageDialog(null,"备份前请先设置mysql路径!!");
            MainPanel.getInstance().workingPanel.show(ConfigPanel.getInstance());
            ConfigPanel.getInstance().getTfMySQL().grabFocus();
            return;
        }
        JFileChooser fc = new JFileChooser();
        fc.setSelectedFile(new File("hutubill.sql"));
        fc.setFileFilter(new FileFilter() {
            @Override
            public boolean accept(File f) {
                if (f.isDirectory()) {
                    return true;
                }
                return f.getName().toLowerCase().endsWith(".sql");
            }

            @Override
            public String getDescription() {
                return ".sql";
            }
        });
        int returnVal = fc.showSaveDialog(p);
        File file = fc.getSelectedFile();
        System.out.println(file);
        if(returnVal == JFileChooser.APPROVE_OPTION){
            System.out.println(file);
            if(!file.getName().toLowerCase().endsWith(".sql")){
                file = new File(file.getParent(),file.getName()+".sql");
            }
            System.out.println(file);
            try{
                mysqlUtil.Backup(mysqlPath,file.getAbsolutePath());
                JOptionPane.showMessageDialog(p,"备份成功，备份文件位置\r\n："+file.getAbsolutePath());
            }catch (IOException ioe){
                ioe.printStackTrace();
                JOptionPane.showMessageDialog(p,"备份失败\r\n,错误：\r\n"+ioe.getMessage());
            }
        }

    }
}
