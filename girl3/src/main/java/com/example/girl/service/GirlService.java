package com.example.girl.service;

import com.example.girl.domain.Girl;
import com.example.girl.domain.GirlEntity;
import com.example.girl.enums.ResultEnum;
import com.example.girl.exception.GirlException;
import com.example.girl.repository.GirlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class GirlService {
    @Autowired
    private GirlRepository girlRepository;

    @Transactional
    public void addTwo(){
        GirlEntity girlEntity1=new GirlEntity();
        girlEntity1.setCupSize("B");
        girlEntity1.setAge(23);
        girlRepository.save(girlEntity1);

        GirlEntity girlEntity2=new GirlEntity();
        girlEntity2.setCupSize("Ccccccc");
        girlEntity2.setAge(25);
        girlRepository.save(girlEntity2);

    }


    public void getAge(Integer id) throws Exception {
        GirlEntity girl=girlRepository.findOne(id);
        Integer age=girl.getAge();
        if(age<10){
            throw new GirlException(ResultEnum.PRIMARY_SCHOOL);
        }else if(age>=10&&age<16){
            throw new GirlException(ResultEnum.MIDDLE_SCHOOL);
        }
    }

    /**
     * 通过id查询一个女生
     * @param id
     */
    public GirlEntity findOne(Integer id){
        return girlRepository.findOne(id);
    }
}
