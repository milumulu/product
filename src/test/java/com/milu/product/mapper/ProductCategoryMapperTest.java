package com.milu.product.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.milu.product.entity.ProductCategory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductCategoryMapperTest {

    @Autowired
    private ProductCategoryMapper mapper;

    @Test
    public void findByCategoryTypeInfo() {
        QueryWrapper<ProductCategory> queryWrapper = Wrappers.query();
        queryWrapper.in("category_type", Arrays.asList(101,102,103));
        List<ProductCategory> productCategoryList = mapper.selectList(queryWrapper);
        Assert.assertTrue(productCategoryList.size() > 0);
    }

    @Test
    public void save() {
        ProductCategory productCategory = new ProductCategory("快餐类", 104);
        int count = mapper.insert(productCategory);
        Assert.assertEquals(1, count);
    }
}