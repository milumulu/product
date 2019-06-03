package com.milu.product.controller.Data;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

/**
 * @program: product
 * @description: 商品Result
 * @author: 马建鹏
 * @create: 2019-06-03 16:44
 */
@Data
public class ProductResult {

    @JsonProperty("name")
    private String categoryName;

    @JsonProperty("type")
    private Integer categoryType;

    @JsonProperty("foods")
    private List<ProductInfoResult> productInfoResultList;

    @Data
    public static class ProductInfoResult {
        @JsonProperty("id")
        private String productId;

        @JsonProperty("name")
        private String productName;

        @JsonProperty("price")
        private BigDecimal productPrice;

        @JsonProperty("description")
        private String productDescription;

        @JsonProperty("icon")
        private String productIcon;
    }
}


