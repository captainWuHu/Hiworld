package GUI.listener;

import GUI.panel.CategoryPanel;
import GUI.panel.MainPanel;
import GUI.panel.RecordPanel;
import GUI.panel.SpendPanel;
import dao.RecordDao;
import entity.Category;
import service.CategoryService;
import service.RecordService;
import util.GUIUtil;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class RecordListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        RecordPanel p = RecordPanel.getInstance();
        JButton b = (JButton) e.getSource();
        if(p.cbModel.getSize() == 0){
            JOptionPane.showMessageDialog(p,"当前没有分类，请添加");
            MainPanel.getInstance().workingPanel.show(CategoryPanel.getInstance());
            return;
        }
        if(!GUIUtil.checkZero(p.tfSpend,"分类消费")){
            JOptionPane.showMessageDialog(p,"消费不能为空或0");
            p.tfSpend.setText("");
            p.tfSpend.grabFocus();
            return;
        }
        int spend = Integer.parseInt(p.tfSpend.getText());
        RecordService rs = new RecordService();
        String comment = p.tfComment.getText();
        Date date = p.datepick.getDate();
        rs.add(spend,p.getSelectCategory(),comment,date);
        JOptionPane.showMessageDialog(p,"添加成功");
        MainPanel.getInstance().workingPanel.show(SpendPanel.getInstance());
    }
}
