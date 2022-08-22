package cn.spider.design.behavior.chain.build;

import cn.spider.design.behavior.chain.acl.Member;

public abstract class BuildChainHandler<T> {
    protected BuildChainHandler<T> chain;

    private void next(BuildChainHandler<T> handler) {
        this.chain = handler;
    }

    public abstract void check(Member member);

    public static class Builder<T> {
        private BuildChainHandler<T> head;
        private BuildChainHandler<T> tail;

        public Builder<T> addHandler(BuildChainHandler<T> handler) {
            if (this.tail == null) {
                this.head = this.tail = handler;
                return this;
            }
            this.tail.next(handler);
            this.tail = handler;
            return this;
        }

        public BuildChainHandler<T> build() {
            return this.head;
        }
    }
}
