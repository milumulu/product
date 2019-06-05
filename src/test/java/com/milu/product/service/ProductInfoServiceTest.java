package com.milu.product.service;

import com.milu.product.DTO.CartDTO;
import com.milu.product.ProductApplicationTests;
import com.milu.product.entity.ProductInfo;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Component;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductInfoServiceTest extends ProductApplicationTests {

    @Autowired
    private ProductInfoService service;

    @Test
    public void findUpAll() {
        List<ProductInfo> productInfoList = service.findUpAll();
        Assert.assertTrue(productInfoList.size() > 0);
    }

    @Test
    public void findProductInfoListByIdsTest() {
        List<ProductInfo> productInfoList = service.findProductInfoListByIds(Arrays.asList("123456", "123459"));
        Assert.assertTrue(productInfoList.size() > 1);
    }

    @Test
    public void decreaseStockTest() {
        CartDTO cartDTO = new CartDTO();
        cartDTO.setProductId("09e22e4e8505a46a59e047db3df10190");
        cartDTO.setProductQuantity(10);
        service.decreaseStock(Arrays.asList(cartDTO));
    }
}