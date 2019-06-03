package com.milu.product.mapper;

import com.milu.product.entity.ProductInfo;
import com.milu.product.enums.ProductStatusEnum;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductInfoMapperTest {

    @Autowired
    private ProductInfoMapper mapper;

    @Test
    public void findAll() {
        List<ProductInfo> productInfoList = mapper.selectList(null);
        Assert.assertEquals(true, productInfoList.size() > 0);
    }

    @Test
    public void findByProductStatus() {
        Map<String, Object> map = new HashMap<>();
        map.put("product_status", ProductStatusEnum.UP.getCode());
        List<ProductInfo> productInfoList = mapper.selectByMap(map);
        Assert.assertNotEquals(0, productInfoList.size());
    }

    @Test
    public void save() {
        ProductInfo productInfo = new ProductInfo();
        productInfo.setProductName("韩国炸鸡");
        productInfo.setProductPrice(new BigDecimal(30));
        productInfo.setProductStock(100);
        productInfo.setProductDescription("甜辣口味");
        productInfo.setProductIcon("Http://xxxxx.jpg");
        productInfo.setProductStatus(ProductStatusEnum.UP);
        productInfo.setCategoryType(104);
        int count = mapper.insert(productInfo);
        Assert.assertEquals(1, count);
    }
}