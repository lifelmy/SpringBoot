package com.example.girl;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


//将配置文件中的配置注入到该变量中
@RestController
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

    @RequestMapping(value = "/hello",method = RequestMethod.GET)
    public String show(HttpServletResponse response) throws IOException {
        //return "hello Spring Boot"+cupSize+"---"+age;
        //return content;
        return girl.toString();
        //response.getWriter().write("sss");
    }
}
