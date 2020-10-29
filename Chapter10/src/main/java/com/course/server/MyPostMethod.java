package com.course.server;

import com.course.bean.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author: hwk
 * @date: 2020/10/29 22:06
 */
@RestController
@Api(value = "/", description = "这是我的全部Post方法")
@RequestMapping("/v1")
public class MyPostMethod {

    // 用户登录成功获取到cookies，然后访问其他接口获取列表
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ApiOperation(value = "登录接口，成功后获取Cookies", httpMethod = "POST")
    public String login(HttpServletResponse response,
                        @RequestParam(value = "userName", required = true) String userName,
                        @RequestParam(value = "passWord", required = true) String passWord){
        // 用来保存cookies信息
        Cookie cookie = new Cookie("login", "true");
        response.addCookie(cookie);
        if(userName.equals("zhangsan") && passWord.equals("123456")){
            return "登录成功";
        }
        return "用户名或密码错误";
    }

    @RequestMapping(value = "/getUserList", method = RequestMethod.POST)
    @ApiOperation(value = "获取用户列表", httpMethod = "POST")
    public String getUserList(HttpServletRequest request, @RequestBody User u){

        Cookie[] cookies = request.getCookies();
        User user;
        for (Cookie c : cookies){
            if(c.getName().equals("login")
                    && c.getValue().equals("true")
                    && u.getUserName().equals("zhangsan")
                    && u.getPassWord().equals("123456")){
                user = new User();
                user.setName("lisi");
                user.setAge("15");
                return user.toString();
            }
        }
        return "参数不合法";
    }
}
