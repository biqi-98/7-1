package service;

import entity.Users;

import java.util.List;

/**
 * @BelongsProject: lagou-dubbo
 * @Author: GuoAn.Sun
 * @CreateTime: 2020-07-27 17:56
 * @Description: 用户服务的接口
 */

public interface UserService {
    int register(Users users);

    int deleteUser( Users users );

    int updateUser( Users users );

    List<Users> selectUsersByName(Users users );
}
