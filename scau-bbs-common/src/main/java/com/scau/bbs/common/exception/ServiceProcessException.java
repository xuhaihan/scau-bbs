package com.scau.bbs.common.exception;

/**
 * @Author xhh
 * Created by xhh on 2019/1/12
 */
public class ServiceProcessException extends RuntimeException {

    public ServiceProcessException(String message) {
        super(message);
    }

    public ServiceProcessException(String message, Throwable cause) {
        super(message, cause);
    }


}
