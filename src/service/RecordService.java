package service;

import dao.CategoryDao;
import dao.RecordDao;
import entity.Category;
import entity.Record;

import java.util.Date;

public class RecordService {
    private RecordDao recordDao = new RecordDao();
    private CategoryDao categoryDao = new CategoryDao();
    public void add(int spend, Category c,String comment, Date date){
        Record r = new Record();
        r.setCid(c.getId());
        r.setDate(date);
        r.setSpend(spend);
        r.setComment(comment);
        recordDao.add(r);
    }



}
