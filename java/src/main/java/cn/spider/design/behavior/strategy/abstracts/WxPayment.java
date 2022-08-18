package cn.spider.design.behavior.strategy.abstracts;

public class WxPayment extends Payment{
    @Override
    public String getRoute() {
        return "微信支付";
    }

    @Override
    public double queryBalance(String uid) {
        return 523;
    }
}
