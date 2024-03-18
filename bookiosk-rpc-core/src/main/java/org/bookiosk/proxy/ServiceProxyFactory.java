package org.bookiosk.proxy;

import java.lang.reflect.Proxy;

/**
 * @author bookiosk
 */
public class ServiceProxyFactory {


    public static <T> T getProxy(Class<T> serviceClass) {
        return (T) Proxy.newProxyInstance(
                serviceClass.getClassLoader(),
                new Class[]{serviceClass},
                new ServiceProxy());
    }
}
