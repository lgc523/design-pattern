package cn.spider.design.behavior.strategy.promotion;

public class PromotionStrategyContext {
    private PromotionStrategy strategy;

    public PromotionStrategyContext(PromotionStrategy ps) {
        this.strategy = ps;
    }

    public void doPromotion() {
        strategy.promotionAlgorithm();
    }
}
