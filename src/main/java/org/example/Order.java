package org.example;

public class Order {
    private String orderNum;
    private String name;
    private double totamt;

    Order(String orderNum, String name, double totamt){
        setName(name);
        setOrderNum(orderNum);
        setOrderNum(orderNum);

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(String orderNum) {
        this.orderNum = orderNum;
    }

    public double getTotamt() {
        return totamt;
    }

    public void setTotamt(double totamt) {
        this.totamt = totamt;
    }
}
