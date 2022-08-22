package cn.spider.design.behavior.chain.acl;

import org.apache.commons.lang3.StringUtils;

import javax.annotation.Nullable;

public class MemberService {
    public static void main(String[] args) {
        MemberService service = new MemberService();
        service.login("spider", "12345");
        service.loginChain("spider", "12345");
    }

    public void login(String loginName, String loginPass) {
        if (StringUtils.isBlank(loginName) || StringUtils.isBlank(loginPass)) {
            System.out.println("please login in");
            return;
        }
        System.out.println("login check success");
        Member member = checkExists(loginName, loginPass);
        if (null == member) {
            System.out.println("user not exist.");
            return;
        }
        System.out.println("user:" + loginName + " login.");
        if (!member.getRoleName().equals("admin")) {
            System.out.println("admin auth fail.,no operation");
            return;
        }
        System.out.println("welcome admin " + ":" + loginName);
    }

    public void loginChain(String loginName, String loginPass) {
        System.out.println("-----login chain handler without check-----");
        //chain
        LoginHandler.LoginValidateHandler v1 = new LoginHandler.LoginValidateHandler();
        LoginHandler.LoginCheckHandler v2 = new LoginHandler.LoginCheckHandler();
        LoginHandler.LoginAuthHandler v3 = new LoginHandler.LoginAuthHandler();
        v1.next(v2);
        v2.next(v3);
        v1.check(new Member(loginName, loginPass));
    }

    @Nullable
    public static Member checkExists(String loginName, String loginPass) {
        Member member = new Member(loginName, loginPass);
        member.setRoleName("admin");
        return member;
    }
}
