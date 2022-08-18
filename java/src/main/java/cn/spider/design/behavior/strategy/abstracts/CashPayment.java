package cn.spider.design.behavior.strategy.abstracts;

public class CashPayment extends Payment {
    @Override
    public String getRoute() {
        return "现金支付";
    }

    @Override
    public double queryBalance(String uid) {
        return 100;
    }
}
