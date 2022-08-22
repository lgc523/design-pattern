package cn.spider.design.behavior.chain.acl;

import cn.spider.design.behavior.chain.build.BuildChainHandler;

public class TestBuilderChain {
    public static void main(String[] args) {
        BuildChainHandler.Builder<? extends LoginHandler> builder = new BuildChainHandler.Builder();
        builder.addHandler(new LoginHandler.LoginValidateHandler()).
                addHandler(new LoginHandler.LoginCheckHandler()).
                addHandler(new LoginHandler.LoginAuthHandler());
        BuildChainHandler<? extends LoginHandler> buildChain = builder.build();
        buildChain.check(new Member("spider", "12345"));
    }
}
