package com.milu.product.DTO;

import lombok.Data;

/**
 * @program: product
 * @description:
 * @author: 马建鹏
 * @create: 2019-06-05 14:24
 */
@Data
public class CartDTO {

    /**
     * 商品Id
     */
    private String productId;

    /**
     * 商品数量
     */
    private Integer productQuantity;
}
