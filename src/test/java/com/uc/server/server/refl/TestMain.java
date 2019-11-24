package com.uc.server.server.refl;

import net.sf.cglib.proxy.Enhancer;

public class TestMain {

    public static void main(String[] args) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(UserServiceImpl.class);
        enhancer.setCallback(new MyMethodInterceptor());
        UserServiceImpl userService = (UserServiceImpl) enhancer.create();
        //userService.add();
        userService.setName("xxx");
    }
}
