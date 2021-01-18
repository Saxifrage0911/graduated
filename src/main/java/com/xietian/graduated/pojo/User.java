package com.xietian.graduated.pojo;

import javax.validation.constraints.NotNull;

public class User {
    private Integer uId;

    @NotNull(message = "昵称不能为空")
    private String uName;

    @NotNull(message ="真实姓名不能为空")
    private String uRealname;

    @NotNull(message ="身份证号不能为空")
    private String uIdnum;

    @NotNull(message ="账号不能为空")
    private String uAccount;

    @NotNull(message ="密码不能为空")
    private String uPassword;

    private String uSalt;

    private Byte uSex;

    private String uPhone;

    private String uEmail;

    private Byte uState;

    public Integer getuId() {
        return uId;
    }

    public void setuId(Integer uId) {
        this.uId = uId;
    }

    public String getuName() {
        return uName;
    }

    public void setuName(String uName) {
        this.uName = uName == null ? null : uName.trim();
    }

    public String getuRealname() {
        return uRealname;
    }

    public void setuRealname(String uRealname) {
        this.uRealname = uRealname == null ? null : uRealname.trim();
    }

    public String getuIdnum() {
        return uIdnum;
    }

    public void setuIdnum(String uIdnum) {
        this.uIdnum = uIdnum == null ? null : uIdnum.trim();
    }

    public String getuAccount() {
        return uAccount;
    }

    public void setuAccount(String uAccount) {
        this.uAccount = uAccount == null ? null : uAccount.trim();
    }

    public String getuPassword() {
        return uPassword;
    }

    public void setuPassword(String uPassword) {
        this.uPassword = uPassword == null ? null : uPassword.trim();
    }

    public String getuSalt() {
        return uSalt;
    }

    public void setuSalt(String uSalt) {
        this.uSalt = uSalt == null ? null : uSalt.trim();
    }

    public Byte getuSex() {
        return uSex;
    }

    public void setuSex(Byte uSex) {
        this.uSex = uSex;
    }

    public String getuPhone() {
        return uPhone;
    }

    public void setuPhone(String uPhone) {
        this.uPhone = uPhone == null ? null : uPhone.trim();
    }

    public String getuEmail() {
        return uEmail;
    }

    public void setuEmail(String uEmail) {
        this.uEmail = uEmail == null ? null : uEmail.trim();
    }

    public Byte getuState() {
        return uState;
    }

    public void setuState(Byte uState) {
        this.uState = uState;
    }

    @Override
    public String toString() {
        return "User{" +
                "uId=" + uId +
                ", uName='" + uName + '\'' +
                ", uRealname='" + uRealname + '\'' +
                ", uIdnum='" + uIdnum + '\'' +
                ", uAccount='" + uAccount + '\'' +
                ", uPassword='" + uPassword + '\'' +
                ", uSalt='" + uSalt + '\'' +
                ", uSex=" + uSex +
                ", uPhone='" + uPhone + '\'' +
                ", uEmail='" + uEmail + '\'' +
                ", uState=" + uState +
                '}';
    }
}