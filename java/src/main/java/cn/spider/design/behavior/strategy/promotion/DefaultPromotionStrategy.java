package cn.spider.design.behavior.strategy.promotion;

public class DefaultPromotionStrategy implements PromotionStrategy{
    @Override
    public void promotionAlgorithm() {
        System.out.println("promotion strategy default.");
    }
}
