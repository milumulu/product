package com.milu.product.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.util.Date;

/**
 * @program: product
 * @description: 类目表
 * @author: 马建鹏
 * @create: 2019-06-03 14:51
 */
@Data
public class ProductCategory {

    @TableId(type = IdType.AUTO)
    private Integer categoryId;

    /** 类目名称 */
    private String categoryName;

    /** 类目类型 */
    private  Integer categoryType;

    private Date createTime;

    @TableField(update = "now()")
    private Date updateTime;

    public ProductCategory() {
    }

    public ProductCategory(String categoryName, int categoryType) {
        this.categoryName = categoryName;
        this.categoryType = categoryType;
    }
}
