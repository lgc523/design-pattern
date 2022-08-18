package cn.spider.design.behavior.strategy.promotion;

public class PromotionStrategyBar implements PromotionStrategy{
    @Override
    public void promotionAlgorithm() {
        System.out.println("promotion strategy bar.");
    }
}
