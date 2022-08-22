package cn.spider.design.behavior.strategy.promotion;

public interface PromotionStrategy {
    void promotionAlgorithm();

    class PromotionStrategyFoo implements PromotionStrategy {
        @Override
        public void promotionAlgorithm() {
            System.out.println("promotion strategy foo.");
        }
    }

    class DefaultPromotionStrategy implements PromotionStrategy {
        @Override
        public void promotionAlgorithm() {
            System.out.println("promotion strategy default.");
        }
    }

    class PromotionStrategyBar implements PromotionStrategy {
        @Override
        public void promotionAlgorithm() {
            System.out.println("promotion strategy bar.");
        }
    }
}
