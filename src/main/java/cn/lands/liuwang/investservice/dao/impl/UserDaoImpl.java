package cn.lands.liuwang.investservice.dao.impl;

import cn.lands.liuwang.investservice.dao.BaseDao;
import cn.lands.liuwang.investservice.dao.UserDao;
import cn.lands.liuwang.investservice.model.UserInfo;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl extends BaseDao implements UserDao {
    @Override
    public UserInfo getUserByUsername() {
        PasswordEncoder passwordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
        UserInfo user = new UserInfo();
        user.setUserName("admin");
        user.setPwd(passwordEncoder.encode("admin"));
        user.setRole("user");
        return user;
    }
}
