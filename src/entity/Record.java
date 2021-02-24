package entity;

import java.util.Date;

public class Record {
    private int id;
    private int spend;
    private int cid;
    private String comment;
    private Date date;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public int getSpend() {
        return spend;
    }

    public int getCid() {
        return cid;
    }

    public String getComment() {
        return comment;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setSpend(int spend) {
        this.spend = spend;
    }

}
