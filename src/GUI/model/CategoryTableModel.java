package GUI.model;

import entity.Category;
import service.CategoryService;

import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;
import java.util.ArrayList;
import java.util.List;

public class CategoryTableModel implements TableModel {
    private List<Category> cs;
    String[] columnNamex = new String[]{"分类名称", "消费次数"};
    public CategoryTableModel(){
        cs = new CategoryService().list();
    }

    public List<Category> getCs(){
        return cs;
    }
    public void SetCs(List<Category> cs){
        this.cs = cs;
    }
    @Override
    public int getRowCount() {
        return cs.size();
    }

    @Override
    public int getColumnCount() {
        return columnNamex.length;
    }

    @Override
    public String getColumnName(int columnIndex) {
        return columnNamex[columnIndex];
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return String.class;
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        if(columnIndex == 0)return cs.get(rowIndex).getName();
        if(columnIndex == 1)return cs.get(rowIndex).getRecordNumber();
        return null;
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {

    }

    @Override
    public void addTableModelListener(TableModelListener l) {

    }

    @Override
    public void removeTableModelListener(TableModelListener l) {

    }
}
