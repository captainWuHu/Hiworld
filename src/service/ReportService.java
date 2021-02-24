package service;

import dao.RecordDao;
import entity.Record;
import util.DateUtil;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class ReportService {

    public int[] getListThisMonth(){
        int[] DayOfMonthSpend = new int[DateUtil.thisMonthTotalDay()];
        List<Record> monthRecord = new RecordDao().listThisMonth();
        Date MonthBegin = DateUtil.monthBegin();
        Calendar DayOfMonth = Calendar.getInstance();
        DayOfMonth.setTime(MonthBegin);
        for(int i =0;i<DayOfMonthSpend.length;i++){

            for(Record r : monthRecord){
                if(r.getDate().equals(DayOfMonth.getTime())){
                       DayOfMonthSpend[i]+=r.getSpend();
                }
            }
            DayOfMonth.add(Calendar.DATE,1);
        }
        return DayOfMonthSpend;



    }
}
