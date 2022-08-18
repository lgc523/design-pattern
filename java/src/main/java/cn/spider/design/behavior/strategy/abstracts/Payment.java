package cn.spider.design.behavior.strategy.abstracts;

public abstract class Payment {
    public abstract String getRoute();

    public PaymentResult pay(String uid, double amount) {
        if (queryBalance(uid) < amount) {
            return new PaymentResult(500, "支付失败", "余额不足");
        }
        return new PaymentResult(200, "支付成功:余额:" + (queryBalance(uid) - amount), String.valueOf(amount));
    }

    public abstract double queryBalance(String uid);
}
