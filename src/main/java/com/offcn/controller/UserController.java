package com.offcn.controller;

import com.offcn.po.User;
import com.offcn.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Slice;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/")
    public String save(@RequestBody User user){
        try {
            userService.save(user);
            return "success";
        } catch (Exception e) {
            e.printStackTrace();
            return "fail";
        }
    }

    @PutMapping("/{id}")
    public String update(@PathVariable("id") Long id,@RequestBody User user){
        try {
            user.setId(id);
            userService.update(user);
            return "success";
        } catch (Exception e) {
            e.printStackTrace();
            return "fail";
        }
    }

    @DeleteMapping("/{id}")
    public String  delete(@PathVariable("id")Long id){
        try {
            userService.deleteId(id);
            return "success";
        } catch (Exception e) {
            e.printStackTrace();
            return "fail";
        }
    }

    @GetMapping("/")
    public List<User> getAll(){
        return userService.getAll();
    }

    @GetMapping("/name/{name}")
    public List<User> findByName(@PathVariable("name") String name){
        return userService.findByName(name);
    }

    @GetMapping("/nameage/{name}/{age}")
    public User findByNameAndAge(@PathVariable("name") String name,@PathVariable("age")Integer age){
        return userService.findByNameAndAge(name, age);
    }

    @GetMapping("/{id}")
    public User findOneUser(@PathVariable("id")Long id){
        return userService.findOneUser(id);
    }

    @GetMapping("/search/{name}")
    public List<User> searchNnnn(@PathVariable("name") String name){
        return userService.searchNnnn(name);
    }

    @GetMapping("/search2/{name}/{age}")
    public User searchNnnn(@PathVariable("name") String name,@PathVariable("age")Integer age){
        return userService.searchNameAndAge(name,age);
    }

    @PutMapping("/{id}/{name}")
    public String updatename(@PathVariable("id")Long id,@PathVariable("name")String name){
      int num = userService.updateName(id, name);
      if(num>0){
          return "success";
      }else {
          return "fail";
      }
    }


    //排序
    @RequestMapping("findByNameOrder/{name}/{sort}")
    public List<User> findByNameOrder(@PathVariable("name") String name,@PathVariable("sort") String sort){
       return userService.findByName(name,new Sort(Sort.Direction.fromString(sort),"id"));
    }
 /*   @RequestMapping("findByNameLike/{name}/{page}/{size}/{sort}")
    public Page<User> findByNameLike(@PathVariable("name") String name,@PathVariable("page")int page ,@PathVariable("size")int size,@PathVariable("sort")String sort){

        return userService.findByNameLike(name, PageRequest.of(page, size,new Sort(Sort.Direction.fromString(sort),"id")));
    }
*/

    @RequestMapping("findByNameLike/{name}/{page}/{size}/{sort}")
    public Slice<User> findByNameLike(@PathVariable("name") String name, @PathVariable("page")int page , @PathVariable("size")int size, @PathVariable("sort")String sort){

        return userService.findByNameLike(name, PageRequest.of(page, size,new Sort(Sort.Direction.fromString(sort),"id")));
    }

    @RequestMapping("/findByNameOrderByIdDesc/{name}")
    public List<User> findByNameOrderByIdDesc(@PathVariable("name")String name){
        return userService.findByNameOrderByIdDesc(name);
    }

    @RequestMapping("/findFirst2ByNameOrderByIdDesc/{name}")
    public List<User> findFirst2ByNameOrderByIdDesc(@PathVariable("name")String name){
        return userService.findFirst2ByNameOrderByIdDesc(name);
    }
}
