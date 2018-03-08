package com.banana.controller;

import com.banana.foundation.common.ResultBase;
import com.banana.foundation.common.ResultBaseBuilder;
import com.banana.foundation.enums.ResultCode;
import com.banana.vo.UserVO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * Created by TJ on 18/3/7.
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @RequestMapping(value = "/validateLogin", method = RequestMethod.POST)
    ResultBase validateLogin() {
        return ResultBaseBuilder.succ().rb();
    }

    @RequestMapping(value = "/getUserById/{id}", method = RequestMethod.GET)
    ResultBase<UserVO> getUserById(@PathVariable Long id) {
        if (id != null) {

        }
        UserVO userVO = new UserVO();
        userVO.setId(id);
        userVO.setAccountName("AccountName");
        userVO.setUserName("UserName");
        return ResultBaseBuilder.succ().data(userVO).rb();
    }
}
