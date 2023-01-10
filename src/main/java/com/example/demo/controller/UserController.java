package com.example.demo.controller;

import com.example.demo.utils.Result;
import com.example.demo.utils.ResultUtil;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class UserController {

    @PostMapping("/user_info")
    public Result getUserInfo() {
        Map<String, Object> map = new HashMap<>();
        map.put("username", "admin");
        return ResultUtil.success(map);
    }

    @PostMapping("/login")
    public Result login() {
        HashMap<Object, Object> map = new HashMap<>();
        map.put("username", "admin");
        map.put("token","fjkdlasjfkldjalf");
        return ResultUtil.success(map);
    }
}
