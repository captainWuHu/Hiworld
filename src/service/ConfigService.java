package service;

import dao.ConfigDao;
import entity.Config;

public class ConfigService {
    private static final String budget = "budget";
    private static final String mysqlPath = "mysqlPath";
    private static final String default_budget = "500";

    static ConfigDao dao = new ConfigDao();
    static{
        init();
    }
    public static void init(){
        init(budget, default_budget);
        init(mysqlPath,"");
    }


    public static void init(String key, String value){
        if(dao.getByKey(key)==null){
            Config config = new Config();
            config.setKey(key);
            config.setValue(value);
            dao.add(config);
        }
    }
    public String get(String key){
        return dao.getByKey(key).getValue();
    }

    public void update(String key, String value){
        Config config = dao.getByKey(key);
        if(dao.getByKey(key)!=null){
            config.setValue(value);
            dao.update(config);
        }
        else{
            config = new Config();
            config.setKey(key);
            config.setValue(value);
            dao.add(config);
        }
    }
    public int getIntBudget(){
        return Integer.parseInt(get(budget));
    }

    public String getBudget() {
        return budget;
    }

    public String getMysqlPath() {
        return mysqlPath;
    }
}
