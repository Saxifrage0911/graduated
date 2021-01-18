package com.xietian.graduated.service;

import com.xietian.graduated.common.util.Result;
import com.xietian.graduated.pojo.User;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface UserService {
    int addUser(User user);

    Result<String> registry(User user);

    Result<String> loginFromUser(String account, String password);

    boolean accountIsExist(String account);

    boolean idnumIsExist(String idnum);

    Result<List<User>> getAllUser();

    Result<User> getUserByToken(String token,Integer userId);

    Result<User> getUserByAccount(String account);

    Result<String> updateUser(User user);

    Result<String> logout(String token);

    Result<Integer> tokenValid(String token);
}
