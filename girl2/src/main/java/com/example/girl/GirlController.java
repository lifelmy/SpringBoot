package com.example.girl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class GirlController {

    @Autowired
    GirlRepository girlRepository;
    @Autowired
    GirlService girlService;

    //查询所有女生
    @GetMapping(value = "/girls")
    public List<GirlEntity> getGirls(){
        return girlRepository.findAll();
    }

    //添加一个女生
    @PostMapping(value = "girlAdd")
    public String girlAdd(@RequestParam(value = "cupSize") String cupSize, @RequestParam(value = "age")int age){
        GirlEntity girl=new GirlEntity();
        girl.setCupSize(cupSize);
        girl.setAge(age);
        GirlEntity entity=girlRepository.save(girl);
        return entity.toString();
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
}
