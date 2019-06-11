package com.sklb.web.mapper;

import com.sklb.web.model.User;

import java.util.List;

/**
 * @author: lingjunhao
 * create at:  2019-06-10  12:39
 * @description:
 */
public interface UserMapper {
    List<User> queryList();
    void save(User user);
    void batchDelete(Integer[] ids);
    void update(User user);
}
