package GUI.listener;

import GUI.panel.ConfigPanel;
import service.ConfigService;
import util.GUIUtil;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class ConfigListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {

        ConfigPanel p = ConfigPanel.getInstance();
        if(!GUIUtil.checkNumber(p.getTfBudget(),"本月预算"))return;
        String mysqlPath = p.getTfMySQL().getText();
        if(mysqlPath.length() == 0){
            JOptionPane.showMessageDialog(p,"路径不能为空");
        }else{
            File textFile = new File(mysqlPath,"bin/mysql.exe");
            if(!textFile.exists()){
                JOptionPane.showMessageDialog(p,"路径不正确");
                p.getTfMySQL().grabFocus();
                return;
            }
        }
        ConfigService cs = new ConfigService();
        cs.update(cs.getBudget(),p.getTfBudget().getText());
        cs.update(cs.getMysqlPath(),mysqlPath);
        JOptionPane.showMessageDialog(p, "设置修改成功");
    }
}
