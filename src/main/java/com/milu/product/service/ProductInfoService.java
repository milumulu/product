package com.milu.product.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.milu.product.DTO.CartDTO;
import com.milu.product.entity.ProductInfo;
import com.milu.product.enums.ProductStatusEnum;
import com.milu.product.exception.ProductInfoException;
import com.milu.product.mapper.ProductInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    public List<ProductInfo> findProductInfoListByIds(List<String> ids) {
        QueryWrapper<ProductInfo> queryWrapper = Wrappers.query();
        queryWrapper.in("product_id", ids);
        return mapper.selectList(queryWrapper);
    }

    @Transactional
    public void decreaseStock(List<CartDTO> cartDTOList) {
        for (CartDTO cartDTO: cartDTOList) {
            ProductInfo productInfo = mapper.selectById(cartDTO.getProductId());
            if (productInfo == null) {
                throw new ProductInfoException(1, "商品不存在");
            }
            Integer result = productInfo.getProductStock() - cartDTO.getProductQuantity();
            if (result < 0) {
                throw new ProductInfoException(1, "库存不足");
            }
            productInfo.setProductStock(result);
            int judge = mapper.updateById(productInfo);
            if (judge != 1) {
                throw new ProductInfoException(1, "新增失败");
            }
        }
    }
}
