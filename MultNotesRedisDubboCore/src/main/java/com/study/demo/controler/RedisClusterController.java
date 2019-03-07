package com.study.demo.controler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.study.demo.service.RedisClusterService;


@Controller
@RequestMapping(value = "redisCluster")
public class RedisClusterController {

 

    @Autowired
    private RedisClusterService redisClusterService;

    @RequestMapping(value = "save",method = RequestMethod.GET)
    @ResponseBody
    public Object save(){
        try{
            redisClusterService.save();
        }catch (Exception e){
            e.printStackTrace();
            return String.format("error: %s",e.getMessage());
        }

        return "ok";

    }

}