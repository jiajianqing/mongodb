package com.example.mongodb.controller;

import com.example.mongodb.entity.UserEntity;
import com.example.mongodb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    /**
     * 查询用户信息
     *
     * @return
     */
    @GetMapping("/mongo/findAll")
    public List<UserEntity> findAll() {
        return userService.findAll();
    }

    /**
     * 新增用户信息
     *
     * @param userEntity
     * @return
     */
    @PostMapping("/mongo/save")
    public String saveObj(@RequestBody UserEntity userEntity) {
        return userService.saveObj(userEntity);
    }

    /**
     * 根据id查询
     *
     * @param userId
     * @return
     */
    @GetMapping("/mongo/findOne")
    public UserEntity findOne(@RequestParam String userId) {
        return userService.getUserById(userId);
    }

    /**
     * 根据用户名称查询用户信息
     *
     * @param userName
     * @return
     */
    @GetMapping("/mongo/findOneByName")
    public UserEntity findOneByName(@RequestParam String userName) {
        return userService.getUserByName(userName);
    }

    /**
     * 更新用户信息对象
     *
     * @param userEntity
     * @return
     */
    @PostMapping("/mongo/update")
    public String update(@RequestBody UserEntity userEntity) {
        return userService.updateUser(userEntity);
    }

    /**
     * 删除对象
     *
     * @param userEntity
     * @return
     */
    @PostMapping("/mongo/delOne")
    public String delOne(@RequestBody UserEntity userEntity) {
        return userService.deleteUser(userEntity);
    }

    /**
     * 根据id删除
     *
     * @param userId
     * @return
     */
    @PostMapping("/mongo/delById")
    public String delById(@RequestParam String userId) {
        return userService.deleteUserById(userId);
    }
}
