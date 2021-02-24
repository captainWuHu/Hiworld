package GUI.panel;

import dao.RecordDao;
import entity.Record;
import service.RecordService;
import service.ReportService;
import util.ChartUtil;
import util.GUIUtil;

import java.awt.*;
import java.util.List;
import javax.swing.*;


public class ReportPanel extends WorkingPanel{
    static{
        GUIUtil.useLNF();
    }
    private static ReportPanel instance = new ReportPanel();
    public static ReportPanel getInstance(){
        return instance;
    }

    public JLabel I = new JLabel();
    private ReportPanel(){
        this.setLayout(new BorderLayout());
        Image img = new ChartUtil().getImage(350,250, new ReportService().getListThisMonth());
        ImageIcon icon = new ImageIcon(img);
        I.setIcon(icon);
        this.add(I);
    }

    @Override
    public void updateData() {
        Image img = new ChartUtil().getImage(350,250, new ReportService().getListThisMonth());
        ImageIcon icon = new ImageIcon(img);
        I.setIcon(icon);
    }

    @Override
    public void addListener() {

    }

    public static void main(String[] args){

        GUIUtil.showPanel(ReportPanel.getInstance());
    }

}
