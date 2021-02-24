package GUI.panel;
import javax.swing.*;
import java.awt.*;

import service.SpendService;
import util.CircleProgressBar;
import util.ColorUtil;
import util.GUIUtil;
public class SpendPanel extends WorkingPanel{
    static{
        GUIUtil.useLNF();
    }
    private static SpendPanel instance;
    JLabel lMonthSpend = new JLabel("本月消费");
    JLabel lTodaySpend = new JLabel("今日消费");
    JLabel lAvgSpendPerDay = new JLabel("日均消费");
    JLabel lMonthLeft = new JLabel("本月剩余");
    JLabel lDayAvgAvailable = new JLabel("日均可用");
    JLabel lMonthLeftDay = new JLabel("距离月末");

    JLabel vMonthSpend = new JLabel("￥2300");
    JLabel vTodaySpend = new JLabel("￥25");
    JLabel vAvgSpendPerDay = new JLabel("￥120");
    JLabel vMonthAvailable = new JLabel("￥2084");
    JLabel vDayAvgAvailable = new JLabel("￥389");
    JLabel vMonthLeftDay = new JLabel("15天");

    CircleProgressBar bar;
    private SpendPanel(){
        this.setLayout(new BorderLayout());
        bar = new CircleProgressBar();
        bar.setBackgroundColor(ColorUtil.blueColor);

        GUIUtil.setColor(ColorUtil.blueColor, vMonthSpend, vTodaySpend);
        GUIUtil.setColor(ColorUtil.grayColor, lMonthSpend, lTodaySpend, lAvgSpendPerDay, lMonthLeft, lDayAvgAvailable,
                lMonthLeftDay, vAvgSpendPerDay, vMonthAvailable, vDayAvgAvailable, vMonthLeftDay);
        vMonthSpend.setFont(new Font("微软雅黑", Font.BOLD, 23));
        vTodaySpend.setFont(new Font("微软雅黑", Font.BOLD, 23));

        this.add(center(), BorderLayout.CENTER);
        this.add(south(), BorderLayout.SOUTH);
    }

    public static SpendPanel getInstance(){
        if(instance == null)instance = new SpendPanel();
        return instance;
    }


    private JPanel south(){
        JPanel p = new JPanel();
        p.setLayout(new GridLayout(2, 4));
        p.add(lAvgSpendPerDay);
        p.add(lMonthLeft);
        p.add(lDayAvgAvailable);
        p.add(lMonthLeftDay);
        p.add(vAvgSpendPerDay);
        p.add(vMonthAvailable);
        p.add(vDayAvgAvailable);
        p.add(vMonthLeftDay);
        return p;
    }
    private JPanel center() {
        JPanel p = new JPanel();
        p.setLayout(new BorderLayout());
        p.add(west(), BorderLayout.WEST);
        p.add(center2(),BorderLayout.CENTER);
        return p;
    }
    private Component center2() {
        return bar;
    }
    private Component west() {
        JPanel p = new JPanel();
        p.setLayout(new GridLayout(4, 1));
        p.add(lMonthSpend);
        p.add(vMonthSpend);
        p.add(lTodaySpend);
        p.add(vTodaySpend);
        return p;
    }

    public void updateData() {
        SpendPage spendPage = new SpendService().getSpendPage();
        vMonthSpend.setText(spendPage.getMonthSpend());
        vTodaySpend.setText(spendPage.getTodaySpend());
        vAvgSpendPerDay.setText(spendPage.getAvgSpendPerDay());
        vMonthAvailable.setText(spendPage.getMonthAvailable());
        vDayAvgAvailable.setText(spendPage.getDayAvgAvailable());
        vMonthLeftDay.setText(spendPage.getMonthLeftDay());
        bar.setProgress(spendPage.getUsagePercentage());
        addListener();
    }
    public void addListener(){

    }

    public static void main(String[] args){
        GUIUtil.showPanel(SpendPanel.getInstance());
    }


}
