package com.bob;/**
 * @Author:bob
 * @DATE:2024/1/24 21:38
 * @Description:
 */

import jdk.nashorn.internal.ir.ReturnNode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.Email;
import java.util.List;

/**
 * @author: bob
 * @date: 2024/1/24 21:38
 * @description: TODO
 */
@RestController
@Slf4j
@Validated
public class ValidController {


    @PostMapping("/valid/test1")
    public ServiceVO test1(@Validated @RequestBody ValidVO validVO,
                           BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            List<FieldError> fieldErrors = bindingResult.getFieldErrors();
            String msg = "";
            for(int i = 0;i<fieldErrors.size();i++){
                if(i!=0)msg += "," ;
                msg += fieldErrors.get(i).getDefaultMessage();
            }
            return new ServiceVO(RetunCode.FAILED_CODE,msg);
        }
        log.info("validEntity is {}", validVO);
        return new ServiceVO(RetunCode.SUCCESS_CODE,"参数校验成功");
    }

    @PostMapping(value = "/valid/test2")
    public String test2(@Validated ValidVO validVO){
        log.info("validEntity is {}", validVO);
        return "test2 valid success";
    }

    @PostMapping(value = "/valid/test3")
    public ServiceVO test3(@Email String email, BindingResult bindingResult){
        log.info("email is {}", email);
        if(bindingResult.hasErrors())
        {
            return new ServiceVO(RetunCode.FAILED_CODE,bindingResult.getFieldError().getDefaultMessage());
        }


        return new ServiceVO(RetunCode.SUCCESS_CODE,"Email校验成功");
    }
}