package cn.spider.design.behavior.strategy.promotion;

public class TestPromotionStrategy {
    public static void main(String[] args) {
        PromotionStrategyContext sFoo = new PromotionStrategyContext(new PromotionStrategy.PromotionStrategyFoo());
        PromotionStrategyContext sBar = new PromotionStrategyContext(new PromotionStrategy.PromotionStrategyBar());
        sFoo.doPromotion();
        sBar.doPromotion();

        String promotionKey = "foo";
        PromotionStrategy strategy = PromotionStrategyFactory.getStrategy(promotionKey);
        strategy.promotionAlgorithm();
    }
}
