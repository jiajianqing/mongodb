package com.example.mongodb.service;


import com.example.mongodb.entity.UserEntity;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@Log4j
public class UserService {

    @Autowired
    private MongoTemplate mongoTemplate;

    /**
     * 查询用户信息
     *
     * @return
     */
    public List<UserEntity> findAll() {
        log.info("------------查询用户信息");
        return mongoTemplate.findAll(UserEntity.class);
    }

    /**
     * 新增用户信息对象
     *
     * @param userEntity
     * @return
     */
    public String saveObj(UserEntity userEntity) {
        log.info("----------------新增用户信息对象");
        userEntity.setCreateTime(new Date());
        userEntity.setUpdateTime(new Date());
        mongoTemplate.save(userEntity);
        return "添加成功";
    }

    /**
     * 根据id查询
     *
     * @param userId
     * @return
     */
    public UserEntity getUserById(String userId) {
        log.info("------------根据id查询");
        Query query = new Query(Criteria.where("_id").is(userId));
        return mongoTemplate.findOne(query, UserEntity.class);
    }

    /**
     * 根据用户名称查询用户信息
     *
     * @param userName
     * @return
     */
    public UserEntity getUserByName(String userName) {
        log.info("-----------------根据用户名称查询用户信息");
        Query query = new Query(Criteria.where("user_name").is(userName));
        return mongoTemplate.findOne(query, UserEntity.class);
    }

    /**
     * 更新用户信息对象
     *
     * @param userEntity
     * @return
     */
    public String updateUser(UserEntity userEntity) {
        log.info("--------------更新用户信息对象");
        Query query = new Query(Criteria.where("_id").is(userEntity.getUser_id()));
        Update update = new Update().set("user_name", userEntity.getUser_name())
                .set("user_pwd", userEntity.getUser_pwd())
                .set("updateTime", new Date());
        mongoTemplate.updateFirst(query, update, UserEntity.class);
        return "success";
    }

    /**
     * 删除对象
     *
     * @param userEntity
     * @return
     */
    public String deleteUser(UserEntity userEntity) {
        log.info("------------------删除对象");
        mongoTemplate.remove(userEntity);
        return "success";
    }

    /**
     * 根据id删除
     *
     * @param id
     * @return
     */
    public String deleteUserById(String id) {
        log.info("---------------根据id删除");
        UserEntity userEntity = getUserById(id);
        deleteUser(userEntity);
        return "success";
    }

}
