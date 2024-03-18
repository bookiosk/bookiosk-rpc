package org.bookiosk.service.impl;

import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import org.bookiosk.common.model.User;
import org.bookiosk.common.service.IUserService;
import org.bookiosk.model.RpcRequest;
import org.bookiosk.model.RpcResponse;
import org.bookiosk.serializer.JDKSerializer;
import org.bookiosk.serializer.Serializer;

import java.io.IOException;

/**
 * @author bookiosk
 */
public class UserServiceImpl implements IUserService {
    @Override
    public User getUser(String userName) {
        Serializer serializer = new JDKSerializer();

        RpcRequest rpcRequest = RpcRequest.builder()
                .serviceName(IUserService.class.getName())
                .methodName("getUser")
                .parameterTypes(new Class[]{User.class})
                .args(new Object[]{userName})
                .build();
        try {
            byte[] bodyBytes = serializer.serialize(rpcRequest);
            byte[] result;
            try (HttpResponse httpResponse = HttpRequest.post("localhost:8090")
                    .body(bodyBytes)
                    .execute()) {
                result = httpResponse.bodyBytes();
            }
            RpcResponse rpcResponse = serializer.deserialize(result, RpcResponse.class);
            return (User) rpcResponse.getData();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
