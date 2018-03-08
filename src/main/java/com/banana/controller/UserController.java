package com.banana.controller;

import com.banana.foundation.common.ResultBase;
import com.banana.foundation.common.ResultBaseBuilder;
import com.banana.foundation.enums.ResultCode;
import com.banana.service.UserService;
import com.banana.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * Created by TJ on 18/3/7.
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/")
    public String index() {
        return "Greetings from Spring Boot!";
    }


    @RequestMapping(value = "/validateLogin", method = RequestMethod.POST)
    ResultBase validateLogin() {
        return ResultBaseBuilder.succ().rb();
    }

    @RequestMapping(value = "/getUserById/{id}", method = RequestMethod.GET)
    ResultBase<UserVO> getUserById(@PathVariable Long id) {
        UserVO userVO = null;
        if (id != null) {
            userVO = userService.getUserById(id);
        }
        return ResultBaseBuilder.succ().data(userVO).rb();
    }
}
