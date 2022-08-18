package cn.spider.design.behavior.strategy.abstracts;

public class TestCashier {
    public static void main(String[] args) {
        Cashier order = new Cashier("1", "123", 23.5);
        System.out.println(order.pay(PaymentStrategy.default_payment).toString());
    }
}
