package com.example.girl;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


//将配置文件中的配置注入到该变量中
@RestController
//为类也设置路径，这样访问路径就是类和方法路径的拼接
@RequestMapping(value = "hello")
public class Hello {

/*
    @Value("${cupSize}")
    private String cupSize;

    @Value("${age}")
    private Integer age;

    @Value("${content}")
    private String content;
*/
    @Autowired
    private Girl girl;

    //可以使用多个value，提供多个访问路径
    @RequestMapping(value = {"/say","speak"},method = RequestMethod.GET)
    public String show(HttpServletResponse response) throws IOException {
        return girl.toString();
    }

    //http://localhost:8081/hello/test?id=100
    @GetMapping(value ="/test" )
    public String test(int id){
        return  String.valueOf(id);
    }

    //http://localhost:8081/hello/test/111
    @GetMapping(value ="/test2/{id}" )
    public String test2(@PathVariable("id")Integer myId){
        return  String.valueOf(myId);
    }

    //http://localhost:8081/hello/test3?id=12
    @GetMapping(value ="/test3" )
    public String test3(@RequestParam(name = "id",value = "id",required = false,defaultValue = "0")Integer myId2){
        return  String.valueOf(myId2);
    }

}
