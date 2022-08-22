package cn.spider.design.behavior.strategy.promotion;

import com.google.common.collect.Maps;

import java.util.Map;

public class PromotionStrategyFactory {
    private static Map<String, PromotionStrategy> psMap = Maps.newHashMap();

    static {
        psMap.put(PromotionKey.FOO, new PromotionStrategy.PromotionStrategyFoo());
        psMap.put(PromotionKey.BAR, new PromotionStrategy.PromotionStrategyBar());
    }

    public static final PromotionStrategy emptyStrategy = new PromotionStrategy.DefaultPromotionStrategy();

    private PromotionStrategyFactory() {
    }

    public static PromotionStrategy getStrategy(String strategyKey) {
        PromotionStrategy promotionStrategy = psMap.get(strategyKey);
        return promotionStrategy == null ? emptyStrategy : promotionStrategy;
    }

    private interface PromotionKey {
        String FOO = "foo";
        String BAR = "bar";
    }
}
