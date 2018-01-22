package com.example.girl;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GirlRepository extends JpaRepository<GirlEntity,Integer> {

    public List<GirlEntity> findByAge(Integer age);
}
