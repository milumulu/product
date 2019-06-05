package com.milu.product.exception;

/**
 * @program: product
 * @description: 异常
 * @author: 马建鹏
 * @create: 2019-06-05 14:33
 */
public class ProductInfoException extends RuntimeException {

    private Integer code;

    public ProductInfoException(Integer code, String message) {
        super(message);
        this.code = code;
    }
}
