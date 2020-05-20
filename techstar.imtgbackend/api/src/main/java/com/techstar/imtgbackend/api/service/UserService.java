package com.techstar.imtgbackend.api.service;

import com.techstar.imtgbackend.comm.domain.User;

import java.util.List;

/**
 * descripiton:
 */
public interface UserService {

    List<User> listUser();
    User getUserById(int id);
    void addUser(User user);
    void updateUser(User user);
    void deleteUser(int id);
}
