package org.bookiosk.serializer;

import java.io.IOException;

/**
 * @author bookiosk
 */
public interface Serializer {

    /**
     * 序列化
     * @param object 序列化对象
     * @return 字节数组
     */
    <T> byte[] serialize(T object) throws IOException;

    /**
     * 反序列化
     * @param bytes 字节数组
     * @param type 序列化类
     */
    <T> T deserialize(byte[] bytes, Class<T> type) throws IOException;
}
