package test;

import entity.Users;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import service.UserService;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @BelongsProject: lagou-dubbo
 * @Author: GuoAn.Sun
 * @CreateTime: 2020-07-27 18:03
 * @Description: 测试 服务提供方
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:spring/spring-*.xml"})
public class TestService {

    @Autowired
    private UserService userService;

    @Test
    public void register(){
        String time = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
        Users user = new Users("a2","2","22",time);
        userService.register(user);
        System.out.println("注册成功！");
    }

    @Test
    public void delete(){
        String time = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
        Users user = new Users("a2","2","22",time);
        userService.deleteUser(2);
        System.out.println("注册成功！");
    }

    @Test
    public void select(){
        String time = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
        Users user = new Users("a2","2","22",time);
        List<Users> usersList = userService.selectUsersByName("a");
        System.out.println(usersList);
    }

    @Test
    public void update(){
        String time = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
        Users user = new Users("aaa","2","22",time);
        user.setUid(2);
        userService.updateUser(user);
        System.out.println("注册成功！");
    }
}
