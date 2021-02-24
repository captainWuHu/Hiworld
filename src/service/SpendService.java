package service;

import GUI.panel.SpendPage;
import dao.RecordDao;
import entity.Category;
import entity.Record;
import util.DateUtil;

import java.util.List;

public class SpendService {
    public SpendPage getSpendPage() {
        int Budget = new ConfigService().getIntBudget();
        RecordDao recordDao = new RecordDao();
        List<Record> monthSpendRecord = recordDao.listThisMonth();
        List<Record> todaySpendRecord = recordDao.listToday();
        int monthSpend = 0;
        int todaySpend = 0;
        for (Record r : monthSpendRecord) {
            monthSpend += r.getSpend();
        }
        for (Record r : todaySpendRecord) {
            todaySpend += r.getSpend();
        }
        int monthTotalDay = DateUtil.thisMonthTotalDay();
        int monthLeftDay = DateUtil.thisMonthLeftDay();
        int monthAvailable = Budget - monthSpend;
        int dayAvgAvailable = Budget / monthTotalDay;
        int avgSpendPerDay = monthSpend / monthTotalDay;
        int usagePercentage = 100 * monthSpend / Budget;
        return new SpendPage(monthSpend, todaySpend, avgSpendPerDay, monthAvailable, dayAvgAvailable, monthLeftDay, usagePercentage);
    }


}
