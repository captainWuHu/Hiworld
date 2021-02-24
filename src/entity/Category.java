package entity;

public class Category {
    public Object getRecordNumber;
    private int id;
    private String name;
    private int recordNumber;

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public int getRecordNumber() {
        return recordNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setRecordNumber(int recordNumber) {
        this.recordNumber = recordNumber;
    }

    @Override
    public String toString() {
        return this.getName();
    }
}
