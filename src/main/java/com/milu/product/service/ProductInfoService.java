package com.milu.product.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.milu.product.entity.ProductInfo;
import com.milu.product.enums.ProductStatusEnum;
import com.milu.product.mapper.ProductInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: product
 * @description: 商品Serivce
 * @author: 马建鹏
 * @create: 2019-06-03 16:06
 */
@Service
public class ProductInfoService {

    @Autowired
    private ProductInfoMapper mapper;

    public List<ProductInfo> findUpAll() {
        QueryWrapper<ProductInfo> queryWrapper = Wrappers.query();
        queryWrapper.eq("product_status", ProductStatusEnum.UP);
        return mapper.selectList(queryWrapper);
    }
}
