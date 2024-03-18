package org.bookiosk.provider;

import org.bookiosk.common.service.IUserService;
import org.bookiosk.register.LocalRegistry;
import org.bookiosk.server.HttpServer;
import org.bookiosk.server.VertxHttpServer;
import org.bookiosk.service.impl.UserServiceImpl;

/**
 * @author bookiosk
 */
public class ProviderExample {
    public static void main(String[] args) {
        // 注册服务
        LocalRegistry.register(IUserService.class.getName(), UserServiceImpl.class);

        HttpServer httpServer = new VertxHttpServer();
        httpServer.doStart(8090);
    }
}
