package GUI.model;

import entity.Category;
import service.CategoryService;

import javax.swing.*;
import javax.swing.event.ListDataListener;
import java.util.ArrayList;
import java.util.List;

public class CategoryComboBoxModel implements ComboBoxModel {
    private List<Category> cs = new CategoryService().list();
    private Category c;
    public CategoryComboBoxModel(){

        if(!cs.isEmpty()){
            c = cs.get(0);
        }

    }

    @Override
    public void setSelectedItem(Object anItem) {
        c = (Category) anItem;
    }

    @Override
    public Object getSelectedItem() {
        return c;
    }

    @Override
    public int getSize() {
        return cs.size();
    }

    @Override
    public Object getElementAt(int index) {
        return cs.get(index);
    }

    @Override
    public void addListDataListener(ListDataListener l) {

    }

    @Override
    public void removeListDataListener(ListDataListener l) {

    }
    public List<Category> getCs(){
        return cs;
    }

    public void setCs(List<Category> cs) {
        this.cs = cs;
    }
}
