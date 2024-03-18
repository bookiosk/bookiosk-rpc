package org.bookiosk.consumer;

import org.bookiosk.common.model.User;
import org.bookiosk.common.service.IUserService;

/**
 * @author bookiosk
 */
public class ConsumerExample {
    public static void main(String[] args) {
        IUserService iUserService = null;
        User user = iUserService.getUser("bookiosk");
        if (user != null) {
            System.out.println(user);
        } else {
            System.out.println("user == null");
        }
    }
}
