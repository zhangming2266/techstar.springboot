package com.techstar.imtgbackend.api.service.impl;

import com.techstar.imtgbackend.api.service.UserService;
import com.techstar.imtgbackend.comm.domain.User;
import com.techstar.imtgbackend.comm.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * descripiton:
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    public List<User> listUser() {
        return userMapper.selectUserList();
    }

    public User getUserById(int id){
        return userMapper.selectUserById(id);
    }

    public void addUser(User user){
        userMapper.addUser(user);
    }

    public void updateUser(User user){
        userMapper.updateUser(user);
    }

    public void deleteUser(int id){
        userMapper.deleteUser(id);
    }
}
