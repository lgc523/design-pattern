package cn.spider.design.behavior.strategy.abstracts;

public class ZfbPayment extends Payment {
    @Override
    public String getRoute() {
        return "支付宝支付";
    }

    @Override
    public double queryBalance(String uid) {
        return 532;
    }
}
