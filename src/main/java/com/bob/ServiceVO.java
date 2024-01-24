package com.bob;/**
 * @Author:bob
 * @DATE:2024/1/24 22:17
 * @Description:
 */

import lombok.Data;

import java.io.Serializable;

/**
 * @author: bob
 * @date: 2024/1/24 22:17
 * @description: TODO
 */
@Data
public class ServiceVO implements Serializable {
    private static final long serialVersionUID = 1L;
    private int code;
    private String msg;
    public ServiceVO(int code, String msg){
        this.code = code;
        this.msg = msg;
    }
}
