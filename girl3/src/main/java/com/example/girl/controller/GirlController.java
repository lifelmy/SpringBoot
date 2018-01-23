package com.example.girl.controller;

import com.example.girl.aspect.HttpAspect;
import com.example.girl.domain.GirlEntity;
import com.example.girl.domain.Result;
import com.example.girl.repository.GirlRepository;
import com.example.girl.service.GirlService;
import com.example.girl.util.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class GirlController {

    @Autowired
    GirlRepository girlRepository;
    @Autowired
    GirlService girlService;

    private final static Logger logger= LoggerFactory.getLogger(GirlController.class);
    //查询所有女生
    @GetMapping(value = "/girls")
    public List<GirlEntity> getGirls(){
        logger.info("getGirls");
        return girlRepository.findAll();
    }

    //添加一个女生
    //添加验证，是否符合要求  BindingResult是出错返回的信息
    @PostMapping(value = "girlAdd")
    public Result girlAdd(@Valid GirlEntity girlEntity, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return null;
           // return ResultUtil.error(1,bindingResult.getFieldError().getDefaultMessage());
        }else{
            return ResultUtil.success(girlRepository.save(girlEntity));
        }

    }

    //查询一个女生
    @GetMapping(value = "/girls/{id}")
    public GirlEntity findGirlById(@PathVariable(value = "id") Integer id){
       return  girlRepository.findOne(id);
    }

    //更新一个女生
    @PutMapping(value = "/girls/{id}")
    public GirlEntity updateGirl(@PathVariable(value = "id") Integer id,
                                 @RequestParam(value = "cupSize") String cupSize,
                                 @RequestParam(value = "age")int age){
        GirlEntity girlEntity=new GirlEntity();
        girlEntity.setId(id);
        girlEntity.setAge(age);
        girlEntity.setCupSize(cupSize);
        return girlRepository.save(girlEntity);
    }

    //删除一个女生
    @DeleteMapping(value = "/girls/{id}")
    public String deleteGirl(@PathVariable(value = "id") Integer id){
        girlRepository.delete(id);
        return "success";
    }

    //根据年龄查询
    @GetMapping(value = "/girls/findByAge/{age}")
    public List<GirlEntity> findGirlsByAge(@PathVariable(value = "age") Integer age){
        return girlRepository.findByAge(age);
    }

    @PostMapping(value = "/girls/addTwo")
    public void addTwoGirls(){
        girlService.addTwo();
    }


    @GetMapping(value = "/girls/getAge/{id}")
    public void getAge(@PathVariable(value = "id") Integer id) throws Exception {
        girlService.getAge(id);
    }
}
