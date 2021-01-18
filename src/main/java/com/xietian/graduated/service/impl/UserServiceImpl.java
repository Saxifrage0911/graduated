package com.xietian.graduated.service.impl;

import com.xietian.graduated.common.util.Md5Encrypt;
import com.xietian.graduated.common.util.Result;
import com.xietian.graduated.dao.UserMapper;
import com.xietian.graduated.pojo.User;
import com.xietian.graduated.pojo.UserExample;
import com.xietian.graduated.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private RedisTemplate redisTemplate;

    @Override
    public int addUser(User user) {
        return userMapper.insertSelective(user);
    }

    @Override
    public Result<String> registry(User user) {
        if(!accountIsExist(user.getuAccount())){
            String salt = UUID.randomUUID().toString().toUpperCase();
            // - 基于原密码和盐值执行加密
            String md5Password = Md5Encrypt.getMd5Password(user.getuPassword(), salt);
            user.setuPassword(md5Password);
            user.setuSalt(salt);
            user.setuState((byte)0);
            if(addUser(user)==1) {
                return Result.isSuccess();
            }else return Result.isError(101,"插入失败");

        }else{
            return Result.isError(106,"账户已存在");
        }
    }


    @Override
    public Result<String> loginFromUser(String account, String password) {
        if(accountIsExist(account)){
            UserExample userExample = new UserExample();
            UserExample.Criteria criteria = userExample.createCriteria();
            criteria.andUAccountEqualTo(account);

            List<User> l1 = userMapper.selectByExample(userExample);
            criteria.andUPasswordEqualTo(Md5Encrypt.getMd5Password(password,l1.get(0).getuSalt()));

            List<User> l2 = userMapper.selectByExample(userExample);
            if(l2.size()!=0) {
                String token = UUID.randomUUID().toString();
                redisTemplate.opsForValue().set(token,l2.get(0).getuId());
                redisTemplate.expire(token, 2, TimeUnit.DAYS);
                return Result.isSuccess(token+"?"+l2.get(0).getuId());
            }
        }
        return Result.isError(107,"用户名或密码错误");
    }

    @Override
    public boolean accountIsExist(String account) {
        UserExample userExample = new UserExample();
        UserExample.Criteria criteria =userExample.createCriteria();
        criteria.andUAccountEqualTo(account);
        List<User> list = userMapper.selectByExample(userExample);
        if(list.size()!=0){
            return true;
        }
        else return false;

    }

    @Override
    public boolean idnumIsExist(String idnum) {
        UserExample userExample = new UserExample();
        UserExample.Criteria criteria =userExample.createCriteria();
        criteria.andUIdnumEqualTo(idnum);
        List<User> list = userMapper.selectByExample(userExample);
        if(list.size()!=0){
            return true;
        }
        else return false;
    }

    @Override
    public Result<List<User>> getAllUser() {
        UserExample userExample = new UserExample();
        UserExample.Criteria criteria = userExample.createCriteria();
        criteria.andUIdGreaterThan(0);
        return Result.isSuccess(userMapper.selectByExample(userExample));
    }

    @Override
    public Result<User> getUserByToken(String token, Integer userId) {
        Integer uid = (Integer) redisTemplate.opsForValue().get(token);
        if(uid==null){
            return Result.isError(108,"验证信息失效");
        }
        else{
            User user = userMapper.selectByPrimaryKey(uid);
            if(user==null){
                return Result.isError(104,"操作数据不存在");
            }
            else if(!user.getuId().equals(userId)){
                return Result.isError(109,"验证不通过");
            }
            else return Result.isSuccess(user);
        }
    }

    @Override
    public Result<User> getUserByAccount(String account) {
        UserExample userExample = new UserExample();
        UserExample.Criteria criteria = userExample.createCriteria();
        criteria.andUAccountEqualTo(account);
        List<User> list = userMapper.selectByExample(userExample);
        if(list.size()==0){
            return Result.isError(104,"操作数据不存在");
        }
        else{
            return Result.isSuccess(list.get(0));
        }
    }

    @Override
    public Result<String> updateUser(User user) {
        UserExample userExample = new UserExample();
        UserExample.Criteria criteria = userExample.createCriteria();
        criteria.andUIdEqualTo(user.getuId());
        if(userMapper.updateByExampleSelective(user,userExample)>0){
            return Result.isSuccess();
        }
        else return Result.isError(103,"更新失败");
    }

    @Override
    public Result<String> logout(String token) {
        if(redisTemplate.opsForValue().get(token)!=null&&redisTemplate.delete(token)){
            return Result.isSuccess();
        }
        return Result.isError(108,"验证信息失效");
    }

    @Override
    public Result<Integer> tokenValid(String token) {
        if(redisTemplate.opsForValue().get(token)!=null){
            int userId = (int) redisTemplate.opsForValue().get(token);
            return Result.isSuccess(userId);
        }

        else return Result.isError(109,"验证不通过");
    }

}
