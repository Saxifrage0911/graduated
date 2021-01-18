package com.xietian.graduated.controller;

import com.google.code.kaptcha.impl.DefaultKaptcha;
import com.xietian.graduated.common.util.Result;
import com.xietian.graduated.dto.LoginDto;
import com.xietian.graduated.pojo.User;
import com.xietian.graduated.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.util.List;
@Api(tags = "用户登录注册以及数据操作")
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private DefaultKaptcha captchaProducer;


    @PostMapping("/login")
    @ApiOperation(value = "用户登录")
    public Result<String> login(@RequestBody @Validated LoginDto loginDto,HttpServletRequest httpServletRequest){
        if(loginDto.getCode().equalsIgnoreCase((String) httpServletRequest.getSession().getAttribute("code"))){
            return Result.isError(112,"验证码不正确");
        }
        return userService.loginFromUser(loginDto.getAccount(),loginDto.getPassword());
    }

    @GetMapping("/logout")
    @ApiOperation(value = "用户注销")
    public Result<String> logout(@RequestHeader("token") String token){
        return userService.logout(token);
    }

    @PostMapping("/registry")
    @ApiOperation(value = "用户注册")
    public Result<String> registry(@RequestBody @Validated User user){
        return userService.registry(user);
    }

    @PutMapping("/updateUser")
    @ApiOperation(value = "更新用户信息")
    public Result<String> updateUser(@RequestBody @Validated User user){
        return userService.updateUser(user);
    }

    @GetMapping("/accountIsExist")
    @ApiOperation(value = "检查账号是否重复")
    public boolean accountIsExist(@RequestParam("account") String account){
        return userService.accountIsExist(account);
    }

    @GetMapping("/idnumIsExist")
    @ApiOperation(value = "检查身份证号是否已被注册")
    public boolean idnumIsExist(@RequestParam("idnum") String idnum,@RequestParam(value = "page",defaultValue = "none") String page){
        return userService.idnumIsExist(idnum);
    }

    @GetMapping("/valid")
    @ApiOperation(value = "检查token合法性")
    public Result<Integer> valid(@RequestHeader("token") String token){
        return userService.tokenValid(token);
    }

    @GetMapping("/getUserByAccount")
    @ApiOperation(value = "通过账号获取用户信息")
    public Result<User> getByAccount(@RequestHeader("account") String account){
        if(account==null){
            return Result.isError(110,"参数错误");
        }
        else{
            return userService.getUserByAccount(account);
        }
    }

    @GetMapping("/admin/getAllUser")
    @ApiOperation(value = "获取所有用户数据(管理员)")
    public Result<List<User>> getAllUser(){
        return userService.getAllUser();
    }

    @ApiOperation(value = "获取谷歌验证码")
    @RequestMapping("/defaultKaptcha")
    public void defaultKaptcha(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        byte[] captchaChallengeAsJpeg = null;
        ByteArrayOutputStream jpegOutputStream = new ByteArrayOutputStream();
        try {
            //生产验证码字符串并保存到session中
            String createText = captchaProducer.createText();
            System.out.println("verifyCode:" + createText);
            httpServletRequest.getSession().setAttribute("code", createText);
            //使用生产的验证码字符串返回一个BufferedImage对象并转为byte写入到byte数组中
            BufferedImage challenge = captchaProducer.createImage(createText);
            ImageIO.write(challenge, "jpg", jpegOutputStream);
        } catch (IllegalArgumentException e) {
            httpServletResponse.sendError(HttpServletResponse.SC_NOT_FOUND);
            return;
        }

        //定义response输出类型为image/jpeg类型，使用response输出流输出图片的byte数组
        captchaChallengeAsJpeg = jpegOutputStream.toByteArray();

        httpServletResponse.setHeader("Cache-Control", "no-store");
        httpServletResponse.setHeader("Pragma", "no-cache");
        httpServletResponse.setDateHeader("Expires", 0);
        httpServletResponse.setContentType("image/jpeg");
        ServletOutputStream responseOutputStream = httpServletResponse.getOutputStream();
        responseOutputStream.write(captchaChallengeAsJpeg);
        responseOutputStream.flush();
        responseOutputStream.close();
    }
}
