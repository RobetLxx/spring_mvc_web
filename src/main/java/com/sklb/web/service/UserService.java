package com.sklb.web.service;

import com.sklb.web.common.AjaxResult;
import com.sklb.web.mapper.UserMapper;
import com.sklb.web.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author: lingjunhao
 * create at:  2019-06-10  12:50
 * @description:
 */
@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;

    public AjaxResult queryList(){
        List<User> list=userMapper.queryList();
        return new AjaxResult(list);
    }

    public String getDate(){
        Date date=new Date();
        long time=date.getTime();
        SimpleDateFormat simpleTimeZone=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateString =simpleTimeZone.format(date);
        return dateString;
    }

    public AjaxResult save(User user){
        user.setUsername("user"+System.currentTimeMillis());
        user.setPassword("123456");
        user.setEmail("user"+System.currentTimeMillis());
        user.setUseable(1);
        user.setAddtime(getDate());
        user.setLogintime(null);
        userMapper.save(user);
        return new AjaxResult();
    }

    public AjaxResult batchDelete(Integer[] ids){
        userMapper.batchDelete(ids);
        return new AjaxResult();
    }

    public AjaxResult update(User user){
        userMapper.update(user);
        return new AjaxResult();
    }


}
