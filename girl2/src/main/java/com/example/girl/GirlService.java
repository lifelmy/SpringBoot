package com.example.girl;

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
}
