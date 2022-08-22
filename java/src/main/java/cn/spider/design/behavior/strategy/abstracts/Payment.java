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



    static class CashPayment extends Payment {
        @Override
        public String getRoute() {
            return "现金支付";
        }

        @Override
        public double queryBalance(String uid) {
            return 100;
        }
    }

    static class WxPayment extends Payment {
        @Override
        public String getRoute() {
            return "微信支付";
        }

        @Override
        public double queryBalance(String uid) {
            return 523;
        }
    }

    static class ZfbPayment extends Payment {
        @Override
        public String getRoute() {
            return "支付宝支付";
        }

        @Override
        public double queryBalance(String uid) {
            return 532;
        }
    }

    class PaymentResult {
        private int code;
        private String msg;
        private String data;

        public PaymentResult(int code, String msg, String data) {
            this.code = code;
            this.msg = msg;
            this.data = data;
        }

        @Override
        public String toString() {
            return msg + " 成功支付金额: " + data + "!";
        }
    }
}
