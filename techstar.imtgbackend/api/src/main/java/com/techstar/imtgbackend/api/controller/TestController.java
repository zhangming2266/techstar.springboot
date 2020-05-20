package com.techstar.imtgbackend.api.controller;

import com.techstar.imtgbackend.api.RequestResult.ResultEnum;
import com.techstar.imtgbackend.api.RequestResult.ResultUtil;
import com.techstar.imtgbackend.api.service.UserService;
import com.techstar.imtgbackend.comm.domain.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.techstar.imtgbackend.api.RequestResult.Result;
import java.util.List;


/**
 * 文件描述
 **/
@RestController
@Api(tags = "用户信息接口")
@RequestMapping("/user")
public class TestController {

    private static final Logger LOGGER = LoggerFactory.getLogger(TestController.class);

    @Autowired
    private UserService userService;

    @GetMapping("/listUsers")
    @ApiOperation("获取所有用户信息接口")
    public Result listUsers() {
        try{
            List<User> list = userService.listUser();
            return ResultUtil.success(list);
        }catch (Exception e){
            return ResultUtil.error(ResultEnum.UNKNOWN_ERROR.getCode(),e.getMessage());
        }
    }

    ////get方法传递参数
    @GetMapping("/getUserById")
    @ApiOperation("根据id获取用户信息接口")
    public Result getUserById(@RequestParam(value = "id", required = true, defaultValue = "1") int id){
        try{
            User user = userService.getUserById(id);
            return ResultUtil.success(user);
        }catch (Exception e){
            return ResultUtil.error(ResultEnum.UNKNOWN_ERROR.getCode(),e.getMessage());
        }
    }

    ////post方法传递参数
    @PostMapping("/addUser")
    @ApiOperation("增加用户信息")
    public Result addUser(@RequestBody User user){
        try{
            userService.addUser(user);
        }catch (Exception e){
            return ResultUtil.error(ResultEnum.UNKNOWN_ERROR.getCode(),e.getMessage());
        }
        return ResultUtil.success();
    }

    ////post方法传递参数
    @PostMapping("/updateUser")
    @ApiOperation("修改用户信息")
    public Result updateUser(@RequestBody User user){
        try{
            userService.updateUser(user);
        }catch (Exception e){
            return ResultUtil.error(ResultEnum.UNKNOWN_ERROR.getCode(),e.getMessage());
        }
        return ResultUtil.success();
    }

    ////post方法传递参数
    @GetMapping("/deleteUser")
    @ApiOperation("删除用户信息")
    public Result deleteUser(int id){
        try{
            userService.deleteUser(id);
        }catch (Exception e){
            return ResultUtil.error(ResultEnum.UNKNOWN_ERROR.getCode(),e.getMessage());
        }
        return ResultUtil.success();
    }
}
