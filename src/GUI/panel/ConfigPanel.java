package GUI.panel;

import GUI.listener.ConfigListener;
import service.ConfigService;
import util.GUIUtil;

import javax.swing.*;
import java.awt.*;

public class ConfigPanel extends WorkingPanel {
    static{
        GUIUtil.useLNF();
    }
    private static ConfigPanel instance = new ConfigPanel();
    public static ConfigPanel getInstance(){
        return instance;
    }
    private JLabel lBudget= new JLabel("本月预算(￥)");
    private JTextField tfBudget = new JTextField("1000");
    private JLabel lMySQL = new JLabel("MySQL安装目录");
    private JTextField tfMySQL = new JTextField("");
    public JButton bSubmit = new JButton("更新");
    private JPanel pInput = new JPanel();
    private JPanel pSubmit = new JPanel();
    private ConfigListener cl = new ConfigListener();

    private ConfigPanel(){
        this.setLayout(new BorderLayout());
        GUIUtil.setColor(Color.blue,bSubmit);
        pInput.setLayout(new GridLayout(4,1,40,40));
        pInput.add(lBudget);
        pInput.add(tfBudget);
        pInput.add(lMySQL);
        pInput.add(tfMySQL);
        pSubmit.add(bSubmit);
        this.add(pInput, BorderLayout.NORTH);
        this.add(pSubmit,BorderLayout.CENTER);

        addListener();
    }
    public static void main(String[] args){
        GUIUtil.showPanel(ConfigPanel.getInstance());
    }

    public JTextField getTfBudget() {
        return tfBudget;
    }

    public JTextField getTfMySQL() {
        return tfMySQL;
    }

    public JButton getbSubmit() {
        return bSubmit;
    }
    public void addListener(){
        ConfigListener listener = new ConfigListener();
        bSubmit.addActionListener(listener);
    }
    public void updateData(){
        ConfigService cs = new ConfigService();
        String budget = cs.get(cs.getBudget());
        String mysqlPath = cs.get(cs.getMysqlPath());
        tfBudget.setText(budget);
        tfMySQL.setText(mysqlPath);
        tfBudget.grabFocus();
    }

}
