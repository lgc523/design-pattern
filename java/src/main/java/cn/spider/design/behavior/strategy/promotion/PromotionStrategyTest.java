package cn.spider.design.behavior.strategy.promotion;

public class PromotionStrategyTest {
    public static void main(String[] args) {
        PromotionStrategyContext sFoo = new PromotionStrategyContext(new PromotionStrategyFoo());
        PromotionStrategyContext sBar = new PromotionStrategyContext(new PromotionStrategyBar());
        sFoo.doPromotion();
        sBar.doPromotion();

        String promotionKey = "foo";
        PromotionStrategy strategy = PromotionStrategyFactory.getStrategy(promotionKey);
        strategy.promotionAlgorithm();
    }
}
