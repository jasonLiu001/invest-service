package cn.lands.liuwang.investservice.service;

import cn.lands.liuwang.investservice.model.UserInfo;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
    public UserInfo getUserByUsername();
}
