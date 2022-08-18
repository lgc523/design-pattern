package cn.spider.design.behavior.strategy.abstracts;

public class Cashier {
    private String uid;
    private String orderNo;
    private double amount;

    public Cashier(String uid, String orderNo, double amount) {
        this.uid = uid;
        this.orderNo = orderNo;
        this.amount = amount;
    }

    public PaymentResult pay() {
        return pay(PaymentStrategy.default_payment);
    }

    public PaymentResult pay(String paymentRoute) {
        Payment payment = PaymentStrategy.get(paymentRoute);
        System.out.println("welcome to advanced intelligent cashier system!\n支付方式:" + payment.getRoute());
        System.out.println("本次交易金额: " + this.amount + "\n开始扣款...\n等待系统确认...");
        return payment.pay(this.uid, this.amount);
    }
}
