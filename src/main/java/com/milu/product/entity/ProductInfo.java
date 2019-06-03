package com.milu.product.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.milu.product.enums.ProductStatusEnum;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @program: product
 * @description: 商品列表
 * @author: 马建鹏
 * @create: 2019-06-03 11:26
 */
@Data
public class ProductInfo {

    @TableId(type = IdType.UUID)
    private String productId;

    /** 商品名称 */
    private  String productName;

    /** 商品价格 */
    private BigDecimal productPrice;

    /** 商品库存 */
    private  Integer productStock;

    /** 商品描述 */
    private  String productDescription;

    /** 商品图标 */
    private  String productIcon;

    /** 商品类别 */
    private  Integer categoryType;

    /** 商品状态 */
    private ProductStatusEnum productStatus = ProductStatusEnum.UP;

    private Date createTime;

    @TableField(update = "now()")
    private Date updateTime;
}
