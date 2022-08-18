package cn.spider.design.behavior.strategy.abstracts;

import com.google.common.collect.Maps;

import java.util.Map;

public class PaymentStrategy {
    public static final String wx = "WX_PAYMENT";
    public static final String zfb = "ZFB_PAYMENT";
    public static final String default_payment = "现金支付";
    private static Map<String, Payment> paymentStrategy = Maps.newHashMap();

    static {
        paymentStrategy.put(wx, new WxPayment());
        paymentStrategy.put(zfb, new ZfbPayment());
        paymentStrategy.put(default_payment, new CashPayment());
    }

    public static Payment get(String paymentRoute) {
        if (!paymentStrategy.containsKey(paymentRoute)) {
            return paymentStrategy.get(default_payment);
        }
        return paymentStrategy.get(paymentRoute);
    }
}
