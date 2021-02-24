package GUI.listener;

import GUI.panel.CategoryPanel;
import entity.Category;
import entity.Record;
import service.CategoryService;
import service.RecordService;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CategoryListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        CategoryPanel p = CategoryPanel.getInstance();
        JButton b =(JButton)e.getSource();
        if(b== p.bAdd){
            String name = JOptionPane.showInputDialog(null);

            if(name==null||name.length()==0){
                JOptionPane.showMessageDialog(p,"分类名称不能为空");
                return;
            }
            new CategoryService().add(name);
        }
        if(b==p.bEdit){
            Category c = p.getSelectedCategory();
            int id = c.getId();
            String name = JOptionPane.showInputDialog("修改分类名称",c.getName());
            if(name==null||name.length()==0){
                JOptionPane.showMessageDialog(null,"分类名称不能为空");
                return;
            }
            new CategoryService().update(id,name);
        }
        if(b==p.bDelete){
            Category c = p.getSelectedCategory();
            if(c.getRecordNumber()!=0){
                JOptionPane.showMessageDialog(null,"本分类下存在消费记录，不能删除");
                return;
            }
            if (JOptionPane.OK_OPTION != JOptionPane.showConfirmDialog(p, "确认要删除？"))
                return;
            int id = c.getId();
            new CategoryService().delete(id);
        }
        p.updateData();
    }
}
