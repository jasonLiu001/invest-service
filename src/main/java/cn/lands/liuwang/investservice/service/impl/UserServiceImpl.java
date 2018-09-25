package cn.lands.liuwang.investservice.service.impl;

import cn.lands.liuwang.investservice.model.UserInfo;
import cn.lands.liuwang.investservice.service.BaseService;
import cn.lands.liuwang.investservice.service.UserService;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl extends BaseService implements UserService {
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        UserInfo userInfo = this.getUserByUsername();
        if (userInfo == null)
            throw new UsernameNotFoundException("用户不存在！");

        List<GrantedAuthority> list = new ArrayList<GrantedAuthority>();
        list.add(new SimpleGrantedAuthority(userInfo.getRole()));
        User authUser = new User(userInfo.getUserName(), userInfo.getPwd(), list);
        return authUser;
    }

    @Override
    public UserInfo getUserByUsername() {
        return userDao.getUserByUsername();
    }
}
