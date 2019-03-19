package com.api.sim.test;

import java.lang.reflect.Proxy;

public class DinamicProxyTest {

    public static void main(String[] args) {
        UserImpl user = new UserImpl();
        UserInt userProxy = (UserInt) Proxy.newProxyInstance(
                UserImpl.class.getClassLoader(),
                UserImpl.class.getInterfaces(),
                new InvHand(user));
        userProxy.setName("Grisha");
        String h  = userProxy.getName() ;
        System.out.println(h);

        UserInt userProxy1 = (UserInt) Proxy.newProxyInstance(
                UserImpl.class.getClassLoader(),
                UserImpl.class.getInterfaces(),
                (proxy, method, args1) -> {
//                    System.out.println(proxy);
//                    System.out.println(method);
//                    System.out.println(args1);
                    if (method.getName().startsWith("get")) {
                        return "ssssssss";
                    } else{
                        return method.invoke(user, args1);
                    }
                });
        userProxy1.setName("sija");
        String h2  = userProxy1.getName() ;
        System.out.println(h2);

    }
}
