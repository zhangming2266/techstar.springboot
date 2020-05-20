package com.techstar.imtgbackend.comm.mapper;


import com.techstar.imtgbackend.comm.domain.User;
import org.jboss.logging.Param;

import java.util.List;

/**
 * descripiton:
 */
public interface UserMapper {
    List<User> selectUserList();
    User selectUserById(int id);
    void addUser(User user);
    void updateUser(User user);
    void deleteUser(int id);
}
