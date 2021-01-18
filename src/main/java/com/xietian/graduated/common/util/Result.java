package com.xietian.graduated.common.util;

import java.util.Date;

public class Result<T> {
    /**
     * code统一含义：
     *      101：插入失败
     *      102：删除失败
     *      103：更新失败
     *      104：操作数据不存在
     *      105：机票数不足
     *      106：账户已存在
     *      107：用户名或密码错误
     *      108：验证信息失效
     *      109：验证不通过
     *      110：参数错误
     *      111：订单已过期
     *      112：验证码错误
     */
    private Integer code;
    private String msg;
    private Date timestamp;
    private T data;

    public Result(Integer code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
        this.timestamp = new Date();
    }

    public Result() {
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public T getData() {
        return data;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public void setData(T data) {
        this.data = data;
    }

    public static <T> Result<T> isSuccess(){
        return new Result(200,"操作成功",null);
    }

    public static <T> Result<T> isSuccess(T data){
        return new Result(200,"操作成功",data);
    }

    public static <T> Result<T> sysError(){
        return new Result(500,"系统内部错误",null);
    }

    public static <T> Result<T> isError(Integer code,String msg){
        return new Result(code,msg,null);
    }

    @Override
    public String toString() {
        return "Result{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", timestamp=" + timestamp +
                ", data=" + data +
                '}';
    }
}
