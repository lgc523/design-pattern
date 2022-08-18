package cn.spider.design.behavior.strategy.simple;

public class Client {
    public static void main(String[] args) {
        SimpleStrategy strategy = new ConcreteStrategyFoo();
        Context strategyContext = new Context(strategy);
        strategyContext.algorithm();
    }

    interface SimpleStrategy {
        void algorithm();
    }

    static class Context {
        private SimpleStrategy strategy;

        public Context(SimpleStrategy strategy) {
            this.strategy = strategy;
        }

        public void algorithm() {
            this.strategy.algorithm();
        }
    }

    //concrete
    static class ConcreteStrategyFoo implements SimpleStrategy {

        @Override
        public void algorithm() {
            System.out.println("I`m strategy foo.");
        }
    }

    static class ConcreteStrategyBar implements SimpleStrategy {

        @Override
        public void algorithm() {
            System.out.println("I`m strategy bar.");
        }
    }
}
