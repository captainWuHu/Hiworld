package service;

import dao.CategoryDao;
import dao.RecordDao;
import entity.Category;
import entity.Record;

import java.util.Collections;
import java.util.List;

public class CategoryService {
    CategoryDao categoryDao = new CategoryDao();
    RecordDao recordDao = new RecordDao();
    public List<Category> list(){
        List<Category> cs = categoryDao.list();
        for(Category c:cs){
            List<Record> rs = recordDao.list(c.getId());
            c.setRecordNumber(rs.size());
        }
        Collections.sort(cs,(c1,c2)->c2.getRecordNumber()-c1.getRecordNumber());
        return cs;
    }

    public void add(String name){
        Category category = new Category();
        category.setName(name);
        categoryDao.add(category);
    }

    public void update(int id, String name){
        Category category =new Category();
        category.setId(id);
        category.setName(name);
        categoryDao.update(category);
    }
    public void delete(int id){
        categoryDao.delete(id);
    }
}
