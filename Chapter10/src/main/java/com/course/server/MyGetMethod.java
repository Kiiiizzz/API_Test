package com.course.server;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @author: hwk
 * @date: 2020/10/29 20:29
 */

@RestController
@Api(value = "/", description = "这是我的全部get方法")
public class MyGetMethod {

    @ApiOperation(value = "通过这个方法可以获得Cookies",  httpMethod = "GET")
    @RequestMapping(value = "/getCookies", method = RequestMethod.GET)
    public String getCookies(HttpServletResponse response){

        Cookie cookie = new Cookie("login", "true");
        response.addCookie(cookie);
        return "获得Cookies成功";
    }

    /**
     * 要求客户端携带Cookies访问
     */
    @ApiOperation(value = "要求客户端携带Cookies访问", httpMethod = "GET")
    @RequestMapping(value = "/get/with/cookies", method = RequestMethod.GET)
    public String getWithCookies(HttpServletRequest request){

        Cookie[] cookies = request.getCookies();
        if(Objects.isNull(cookies)){
            return "必须携带Cookies";
        }
        for(Cookie cookie : cookies){
            if(cookie.getName().equals("login") & cookie.getValue().equals("true")){
                return "hahahahahah";
            }
        }
        return "必须携带Cookies";
    }


    /**
     * 需要携带参数才能访问的get请求
     * &形式
     */
    @ApiOperation(value = "需要携带参数才能访问的get请求", httpMethod = "GET")
    @RequestMapping(value = "/get/with/param", method = RequestMethod.GET)
    public Map<String, Integer> getList(@RequestParam Integer start, @RequestParam Integer end){

        Map<String, Integer> myList = new HashMap<>();
        myList.put("鞋", 400);
        return myList;
    }

    /**
     * 需要携带参数才能访问的get请求2
     * /sds/sad/形式
     */
    @ApiOperation(value = "需要携带参数才能访问的get请求2", httpMethod = "GET")
    @RequestMapping(value = "/get/with/param/{start}/{end}", method = RequestMethod.GET)
    public Map<String, Integer> myGetList(@PathVariable Integer start, @PathVariable Integer end){
        Map<String, Integer> myList = new HashMap<>();
        myList.put("鞋", 40033);
        return myList;
    }

}
