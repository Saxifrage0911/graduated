package com.xietian.graduated.dto;

import javax.validation.constraints.NotNull;

public class LoginDto {

    @NotNull(message = "登录所需账号不能为空")
    private String account;

    @NotNull(message = "登录所需密码不能为空")
    private String password;

    @NotNull(message = "验证码不能为空")
    private String code;

    public LoginDto() {
    }

    public LoginDto(@NotNull(message = "登录所需账号不能为空") String account, @NotNull(message = "登录所需密码不能为空") String password, @NotNull(message = "验证码不能为空") String code) {
        this.account = account;
        this.password = password;
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "LoginDto{" +
                "account='" + account + '\'' +
                ", password='" + password + '\'' +
                ", code='" + code + '\'' +
                '}';
    }
}
