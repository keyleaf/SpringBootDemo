package com.banana.service.impl;

import com.banana.domain.User;
import com.banana.foundation.utils.BeanMapper;
import com.banana.mapper.UserMapper;
import com.banana.service.UserService;
import com.banana.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by TJ on 18/3/8.
 */
@Service
public class UserServiceImpl implements UserService {

    @SuppressWarnings("SpringJavaAutowiringInspection")
    @Autowired
    private UserMapper userMapper;

    @Override
    public UserVO getUserById(Long id) {
        User user = userMapper.getUserById(id);
        UserVO userVO = null;
        if (user != null) {
            userVO = new UserVO();
            BeanMapper.copy(user, userVO);
        }
        return userVO;
    }
}
