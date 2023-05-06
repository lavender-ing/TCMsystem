package com.example.indexmanager.controller;

import com.example.indexmanager.pojo.User;
import com.example.indexmanager.result.Result;
import com.example.indexmanager.result.ResultFactory;
import com.example.indexmanager.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/login")
    public Result login(String username, String password){
        User u = userService.selectByUsername(username);
        if(u == null || !u.getPassword().equals(password)){
            return ResultFactory.makeErrorResult("用户名或密码错误！");
        }else {
            Date date = new Date();
            userService.updateLastLogin(username,date);
            u.setLastlogin(date);
            return ResultFactory.makeSuccessResult(u);
        }
    }

    @PostMapping("/register")
    public Result register(@RequestBody User user){
        int res = userService.insert(user);
        if(res>0){
            return ResultFactory.makeSuccessResult(null);
        }else {
            return ResultFactory.makeErrorResult("存在同名用户！注册失败！");
        }
    }

    @PutMapping("/update")
    public Result update(@RequestBody User user){
        int res = userService.update(user);
        if(res>0){
            return ResultFactory.makeSuccessResult(null);
        }else {
            return ResultFactory.makeErrorResult("更新失败！");
        }
    }

    @GetMapping("/getquestion/{username}")
    public Result getQuestion(@PathVariable String username){
        return ResultFactory.makeSuccessResult(userService.getQuestion(username));
    }

    @PostMapping("/reset")
    public Result reset(@RequestBody User user){
        int res = userService.updatePassword(user);
        if(res>0){
            return ResultFactory.makeSuccessResult(null);
        }else {
            return ResultFactory.makeErrorResult("重置失败！");
        }
    }

    @GetMapping("/getall")
    public Result getAll(){
        return ResultFactory.makeSuccessResult(userService.getAll());
    }

    @DeleteMapping("/delete/{id}")
    public Result delete(@PathVariable int id){
        int res = userService.delete(id);
        if(res>0){
            return ResultFactory.makeSuccessResult("删除成功！");
        }else {
            return ResultFactory.makeErrorResult("删除失败！");
        }
    }
}