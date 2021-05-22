package com.example.kakaopay2105.web.common;

import lombok.Getter;
import com.example.kakaopay2105.web.common.ResCode;

public class ComException extends RuntimeException{

    @Getter
    private final ResCode resCode;

    public ComException(ResCode resCode, Throwable e){
        super(resCode.getMessage(), e);
        this.resCode = resCode;
    }

    public ComException(ResCode resCode){
        super(resCode.getMessage());
        this.resCode = resCode;
    }
}
