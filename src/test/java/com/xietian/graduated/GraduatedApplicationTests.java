package com.xietian.graduated;

import com.xietian.graduated.pojo.User;
import com.xietian.graduated.service.FlightService;
import com.xietian.graduated.service.UserService;
import com.xietian.graduated.task.SystemTask;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

@SpringBootTest
class GraduatedApplicationTests {

    @Autowired
    UserService userService;
    @Autowired
    FlightService flightService;

	@Test
	void contextLoads() {
        System.out.println("Hello World");
    }

    @Test
    void testRegistry(){
        User user = new User();
        user.setuPassword("123456");
        user.setuAccount("test");
        user.setuName("tom");
        user.setuId(1);
        user.setuRealname("Lion");
        user.setuIdnum("440902199809110437");

        userService.registry(user);
    }

//    @Test
//    void testLogin(){
//        String account = "test";
//        String password = "123456";
//        String result = userService.loginFromUser(account,password);
//        System.out.println(result);
//    }

//    @Test
//    void testDistribute(){
//	    int[] arr = new SystemTask().distribute(7,10);
//        for(Integer i:arr){
//            System.out.println(i);
//        }
//    }

//    @Test
//    void testListClone(){
//        List<String> l1 = Arrays.asList("a","b","c");
//        List<String> l2 = null;
//        l2 = l1;
//        for(String s: l2){
//            System.out.println(s);
//        }
//    }

    @Test
    void testTicketSold(){
        System.out.println(flightService.soldTicket(1,"eco",1));
    }

}
