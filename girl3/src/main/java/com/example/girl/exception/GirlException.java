package com.example.girl.exception;

import com.example.girl.enums.ResultEnum;

//Spring 只对RunException进行事务回滚，因此需要继承RunException，而不是Exception
public class GirlException extends RuntimeException {
    private Integer code;

    public GirlException(ResultEnum resultEnum) {
        super(resultEnum.getMsg());
        this.code = resultEnum.getCode();
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
