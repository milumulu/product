package com.milu.product.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.milu.product.entity.ProductCategory;
import com.milu.product.mapper.ProductCategoryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: product
 * @description: 商品类目Service
 * @author: 马建鹏
 * @create: 2019-06-03 16:17
 */
@Service
public class ProductCategoryService {

    @Autowired
    private ProductCategoryMapper mapper;

    public List<ProductCategory> QueryProductCategoryByType(List<Integer> categoryTypeList) {
        QueryWrapper<ProductCategory> queryWrapper = Wrappers.query();
        queryWrapper.in("category_type", categoryTypeList);
        return mapper.selectList(queryWrapper);
    }
}
