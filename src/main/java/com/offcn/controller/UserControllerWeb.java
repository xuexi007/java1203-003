package com.offcn.controller;

import com.offcn.po.User;
import com.offcn.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/manageruser")
public class UserControllerWeb {
    @Autowired
    private UserService userService;

    //获取全部用户信息
    @GetMapping("/list")
    public String getall(Model model){
        List<User> list = userService.getAll();

        model.addAttribute("page",list);

        return "user/list";
    }
    //点击add按钮跳转到新增页面
    @RequestMapping("toAdd")
    public String toAdd(){
        return "user/userAdd";
    }

    //保存新增用户数据
    @PostMapping("/add")
    public String creatUser(User user){
        userService.save(user);
        return "redirect:/manageruser/list/";
    }

    //点击指定id用户数据，跳转到编辑页面
    @RequestMapping("/toEdit/{id}")
    public String toEdit(Model model, @PathVariable("id")Long id){
        User user = userService.findOneUser(id);
        model.addAttribute("user",user);
        return "user/userEdit";
    }

    //保存修改用户数据
    @RequestMapping("saveedit")
    public String saveedit(User user){
        userService.update(user);
        return "redirect:/manageruser/list/";
    }

    //点击指定id用户数据，跳转到编辑页面
    @RequestMapping("/delete/{id}")
    public String delte(Model model, @PathVariable("id")Long id){
     userService.delete(id);

        return "redirect:/manageruser/list/";
    }
}
