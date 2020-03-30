package ro.unibuc.fmi;

public class Customer {
    private int spend;
    private String name;

    public Customer() {
        this.spend = 0;
        this.name = "not defined";
    }

    public Customer(int spend, String name) {
        this.spend=spend;
        this.name = name;
    }

    public void setSpend(int spend) {
        this.spend =spend;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSpend() {
        return spend;
    }

    public String getName() {
        return name;
    }
}