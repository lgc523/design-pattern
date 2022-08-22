package cn.spider.design.behavior.chain.acl;

import cn.spider.design.behavior.chain.build.BuildChainHandler;
import org.apache.commons.lang3.StringUtils;

public abstract class LoginHandler<T> extends BuildChainHandler<T> {
    public void next(LoginHandler<T> next) {
        this.chain = next;
    }

    public abstract void check(Member member);

    static class LoginValidateHandler<T> extends LoginHandler<T> {
        @Override
        public void check(Member member) {
            if (StringUtils.isBlank(member.getLoginName()) || StringUtils.isBlank(member.getLoginPass())) {
                System.out.println("please login in");
                return;
            }
            System.out.println("login pre check success");
            chain.check(member);
        }
    }

    static class LoginCheckHandler<T> extends LoginHandler<T> {
        @Override
        public void check(Member member) {
            member = MemberService.checkExists(member.getLoginName(), member.getLoginPass());
            if (null == member) {
                System.out.println("user not exist.");
                return;
            }
            System.out.println("user:" + member.getLoginName() + " login.");
            chain.check(member);
        }
    }

    static class LoginAuthHandler<T> extends LoginHandler<T> {
        @Override
        public void check(Member member) {
            if (!member.getRoleName().equals("admin")) {
                System.out.println("admin auth fail.,no operation");
                return;
            }
            System.out.println("welcome admin " + ":" + member.getLoginName());
        }

    }
}
