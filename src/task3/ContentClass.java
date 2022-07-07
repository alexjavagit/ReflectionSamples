package task3;

public class ContentClass {
    @Save
    public int field1;
    @Save
    private String field2;
    @Save
    public long field3;

    public void setField1(int field1) {
        this.field1 = field1;
    }

    public void setField2(String field2) {
        this.field2 = field2;
    }

    public void setField3(long field3) {
        this.field3 = field3;
    }

    public int getField1() {
        return field1;
    }

    public String getField2() {
        return field2;
    }

    public long getField3() {
        return field3;
    }
}
