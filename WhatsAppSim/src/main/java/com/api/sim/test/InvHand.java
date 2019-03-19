package com.api.sim.test;

import com.api.sim.handlers.logging.Loggable;
import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

@Slf4j
public class InvHand implements InvocationHandler {

    private Object obj;

    public InvHand(Object f1) {
        obj = f1;
    }

    @Loggable
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        log.info("INVOKEEE");
        log.info("{}/{}/{}", proxy, method, args);
        return method.invoke(obj, args);
    }
}
