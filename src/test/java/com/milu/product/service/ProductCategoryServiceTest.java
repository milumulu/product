package com.milu.product.service;

import com.milu.product.ProductApplicationTests;
import com.milu.product.entity.ProductCategory;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

@Component
public class ProductCategoryServiceTest extends ProductApplicationTests {

    @Autowired
    private ProductCategoryService service;

    @Test
    public void queryProductCategoryByType() {
        List<ProductCategory> productCategoryList = service.QueryProductCategoryByType(Arrays.asList(101,102));
        Assert.assertTrue(productCategoryList.size() > 1);
    }
}