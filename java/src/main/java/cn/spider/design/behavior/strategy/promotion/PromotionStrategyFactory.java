package cn.spider.design.behavior.strategy.promotion;

import com.google.common.collect.Maps;

import java.util.Map;
import java.util.Set;

public class PromotionStrategyFactory {
    private static Map<String, PromotionStrategy> psMap = Maps.newHashMap();

    static {
        psMap.put(PromotionKey.FOO, new PromotionStrategyFoo());
        psMap.put(PromotionKey.BAR, new PromotionStrategyBar());
    }

    public static final PromotionStrategy emptyStrategy = new DefaultPromotionStrategy();

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
