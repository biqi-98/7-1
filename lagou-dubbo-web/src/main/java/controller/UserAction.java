package controller;

import com.alibaba.dubbo.config.annotation.Reference;
import entity.Users;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import service.UserService;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @BelongsProject: lagou-dubbo
 * @Author: GuoAn.Sun
 * @CreateTime: 2020-07-27 18:16
 * @Description: 控制层
 */
@Controller
public class UserAction {

    @Reference
    private UserService userService;

    @RequestMapping("/register")
    public String register(Users user) {
        System.out.println("来注册");
        try {
            String nowTime = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
            user.setCreatetime(nowTime);
            userService.register(user);
            return "注册成功！";
        } catch (Exception e) {
            e.printStackTrace();
            return "失败";
        }
    }

    @RequestMapping("/deleteUser")
    public String deleteUser( int id ){
        try {
            userService.deleteUser(id);
            return "删除成功！";
        } catch (Exception e) {
            e.printStackTrace();
            return "失败";
        }
    }

    @RequestMapping("/updateUser")
    public String updateUser( Users users ){
        try {
            userService.updateUser(users);
            return "成功！";
        } catch (Exception e) {
            e.printStackTrace();
            return "失败";
        }
    }

    @RequestMapping("/selectUsersByName")
    public List<Users> selectUsersByName( Users users ){
        try {
            List<Users> usersList = userService.selectUsersByName(users.getUsername());
            return usersList;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
