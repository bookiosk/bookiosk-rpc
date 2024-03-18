package org.bookiosk.common.service;

import org.bookiosk.common.model.User;

/**
 * @author bookiosk
 */
public interface IUserService {


    User getUser(String userName);
}
