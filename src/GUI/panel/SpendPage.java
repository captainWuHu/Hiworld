package GUI.panel;

public class SpendPage {
    private String monthSpend;
    private String todaySpend;
    private String getTodaySpend;
    private String monthAvailable;
    private String dayAvgAvailable;
    private String monthLeftDay;
    private String avgSpendPerDay;
    private int usagePercentage;
    public boolean isOverSpend = false;


    public SpendPage(int monthSpend, int todaySpend, int avgSpendPerDay,int monthAvailable, int dayAvgAvailable,
                  int monthLeftDay, int usagePercentage){
        this.monthSpend="￥"+monthSpend;
        this.todaySpend = "￥"+todaySpend;
        this.avgSpendPerDay = "￥" + avgSpendPerDay;
        if (monthAvailable < 0)
            isOverSpend = true;

        if (!isOverSpend) {
            this.monthAvailable = "￥" + monthAvailable;
            this.dayAvgAvailable = "￥" + dayAvgAvailable;
        } else {
            this.monthAvailable = "超支" + (0 - monthAvailable);
            this.dayAvgAvailable = "￥0";
        }

        this.monthLeftDay = monthLeftDay + "天";
        this.usagePercentage = usagePercentage;
    }





    public String getAvgSpendPerDay() {
        return avgSpendPerDay;
    }

    public void setAvgSpendPerDay(String avgSpendPerDay) {
        this.avgSpendPerDay = avgSpendPerDay;
    }


    public String getTodaySpend() {
        return todaySpend;
    }

    public void setTodaySpend(String todaySpend) {
        this.todaySpend = todaySpend;
    }

    public String getGetTodaySpend() {
        return getTodaySpend;
    }

    public void setGetTodaySpend(String getTodaySpend) {
        this.getTodaySpend = getTodaySpend;
    }

    public String getMonthAvailable() {
        return monthAvailable;
    }

    public void setMonthAvailable(String monthAvailable) {
        this.monthAvailable = monthAvailable;
    }

    public String getDayAvgAvailable() {
        return dayAvgAvailable;
    }

    public void setDayAvgAvailable(String dayAvgAvailable) {
        this.dayAvgAvailable = dayAvgAvailable;
    }

    public String getMonthLeftDay() {
        return monthLeftDay;
    }

    public void setMonthLeftDay(String monthLeftDay) {
        this.monthLeftDay = monthLeftDay;
    }

    public int getUsagePercentage() {
        return usagePercentage;
    }

    public void setUsagePercentage(int usagePercentage) {
        this.usagePercentage = usagePercentage;
    }

    public String getMonthSpend() {
        return monthSpend;
    }

    public void setMonthSpend(String monthSpend) {
        this.monthSpend = monthSpend;
    }


}
