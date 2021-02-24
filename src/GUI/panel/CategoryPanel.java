package GUI.panel;

import GUI.listener.CategoryListener;
import GUI.model.CategoryTableModel;
import entity.Category;
import service.CategoryService;
import util.ColorUtil;
import util.GUIUtil;

import javax.swing.*;
import java.awt.*;

public class CategoryPanel extends WorkingPanel {
    static{
        GUIUtil.useLNF();
    }
    private static CategoryPanel instance = new CategoryPanel();
    public static CategoryPanel getInstance(){
        return instance;
    }
    public JButton bAdd = new JButton("新增");
    public JButton bEdit = new JButton("编辑");
    public JButton bDelete = new JButton("删除");
    private String columNames[] = new String[]{"分类名称","消费次数"};
    public CategoryTableModel ctm = new CategoryTableModel();
    public JTable t = new JTable(ctm);
    public JPanel pSubmit = new JPanel();

    private CategoryPanel(){
        GUIUtil.setColor(ColorUtil.blueColor, bAdd,bEdit,bDelete);
        this.setLayout(new BorderLayout());
        JScrollPane sp =new JScrollPane(t);
        pSubmit.add(bAdd);
        pSubmit.add(bEdit);
        pSubmit.add(bDelete);
        this.add(sp,BorderLayout.CENTER);
        this.add(pSubmit,BorderLayout.SOUTH);

        addListener();
        updateData();
    }

    public Category getSelectedCategory(){
        int index = t.getSelectedRow();
        if(index==-1){
            JOptionPane.showMessageDialog(null,"没有分类");
            return null;
        }
        return ctm.getCs().get(index);
    }
    public void addListener(){
        CategoryListener listener = new CategoryListener();
        bAdd.addActionListener(listener);
        bDelete.addActionListener(listener);
        bEdit.addActionListener(listener);
    }

    public void updateData(){
        ctm.SetCs(new CategoryService().list());
        t.updateUI();
        t.getSelectionModel().setSelectionInterval(0, 0);

        if(ctm.getCs().size()==0){
            bEdit.setEnabled(false);
            bDelete.setEnabled(false);
        }else{
            bEdit.setEnabled(true);
            bDelete.setEnabled(true);
        }
    }

    public static void main(String[] args) {
        GUIUtil.showPanel(CategoryPanel.instance);
    }
}
