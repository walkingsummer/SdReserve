package com.SdReserve.controller;

import com.SdReserve.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * Created by zhangxz on 2017/7/18.
 */

@RequestMapping("/test")
@Controller
public class TestController {

    @Autowired
    TestService testService;

    @RequestMapping(value = "/testConn", method = RequestMethod.POST)
    public @ResponseBody int testConn(@RequestBody Map<String, Object> map){
        System.out.println(map);
        int id = Integer.valueOf(map.get("id").toString());
        String number = map.get("number").toString();
        return testService.testConn(id, number);
    }

    @RequestMapping(value = "/testConn2", method = RequestMethod.GET)
    public @ResponseBody int testConn2( @RequestParam("id") Integer id){
        if(id != null){
            System.out.println(id);
        }
        System.out.println("hao a ");
        return -11;

    }

}
