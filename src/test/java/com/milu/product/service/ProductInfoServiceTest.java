package com.milu.product.service;

import com.milu.product.ProductApplicationTests;
import com.milu.product.entity.ProductInfo;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class ProductInfoServiceTest extends ProductApplicationTests {

    @Autowired
    private ProductInfoService service;

    @Test
    public void findUpAll() {
        List<ProductInfo> productInfoList = service.findUpAll();
        Assert.assertTrue(productInfoList.size() > 0);
    }
}