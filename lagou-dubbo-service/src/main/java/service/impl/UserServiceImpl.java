package service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import entity.Users;
import mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import service.UserService;

import java.util.List;

/**
 * @BelongsProject: lagou-dubbo
 * @Author: GuoAn.Sun
 * @CreateTime: 2020-07-27 17:58
 * @Description: 服务实现类
 */
@Service  //暴露服务（向zookeeper注册服务）
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    public int register(Users users) {
        return userMapper.register(users);
    }

    @Override
    public int deleteUser(int id) {
        return userMapper.deleteUser(id);
    }

    @Override
    public int updateUser(Users users) {
        return userMapper.updateUser(users);
    }

    @Override
    public List<Users> selectUsersByName(String username) {
        return userMapper.selectUsersByName(username);
    }
}
