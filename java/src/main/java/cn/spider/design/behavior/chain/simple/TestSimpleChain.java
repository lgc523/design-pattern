package cn.spider.design.behavior.chain.simple;

public class TestSimpleChain {
    public static void main(String[] args) {
        Handler foo = new ConcreteHandlerFoo();
        Handler bar = new ConcreteHandlerBar();
        foo.setNextHandler(bar);
        foo.handleReq("bar");
    }

    static abstract class Handler {
        protected Handler nextHandler;

        public void setNextHandler(Handler nextHandler) {
            this.nextHandler = nextHandler;
        }

        public abstract void handleReq(String req);
    }

    static class ConcreteHandlerFoo extends Handler {

        @Override
        public void handleReq(String req) {
            if (req.equals("foo")) {
                System.out.println("foo handler req.");
                return;
            }
            System.out.println("foo.handler done, do nothing.");
            if (this.nextHandler != null) {
                this.nextHandler.handleReq(req);
            }
        }
    }

    static class ConcreteHandlerBar extends Handler {

        @Override
        public void handleReq(String req) {
            if (req.equals("bar")) {
                System.out.println("bar handler req.");
                return;
            }
            System.out.println("bar.handler done, do nothing.");
            if (this.nextHandler != null) {
                this.nextHandler.handleReq(req);
            }
        }
    }
}
