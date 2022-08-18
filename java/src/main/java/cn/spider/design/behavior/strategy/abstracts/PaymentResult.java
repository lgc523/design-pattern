package cn.spider.design.behavior.strategy.abstracts;

import java.util.Objects;

public class PaymentResult {
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
        return msg + " 成功支付金额: " + data + "\n欢迎光临!";
    }
}
