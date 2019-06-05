package com.milu.product.controller;

import com.milu.product.DTO.CartDTO;
import com.milu.product.VO.ResultVO;
import com.milu.product.controller.Data.ProductResult;
import com.milu.product.entity.ProductCategory;
import com.milu.product.entity.ProductInfo;
import com.milu.product.service.ProductCategoryService;
import com.milu.product.service.ProductInfoService;
import com.milu.product.utils.ResultVOUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @program: product
 * @description: 商品Controller
 * @author: 马建鹏
 * @create: 2019-06-03 16:43
 */
@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductCategoryService productCategoryService;

    @Autowired
    private ProductInfoService productInfoService;

    @GetMapping("/list")
    public ResultVO<ProductResult> list() {
        //查询所有上架商品
        List<ProductInfo> productInfoList = productInfoService.findUpAll();
        //查询所有上架商品类别
        List<Integer> categoryTypeList = productInfoList.stream()
                .map(e->e.getCategoryType()).collect(Collectors.toList());
        List<ProductCategory> productCategoryList = productCategoryService.QueryProductCategoryByType(categoryTypeList);
        //构造数据
        List<ProductResult> productResultList = new ArrayList<>();
        for (ProductCategory productCategory: productCategoryList) {
            ProductResult productResult = new ProductResult();
            List<ProductResult.ProductInfoResult> productInfoResultList = new ArrayList<>();
            BeanUtils.copyProperties(productCategory, productResult);

            for (ProductInfo productInfo: productInfoList) {
                if (productInfo.getCategoryType().equals(productResult.getCategoryType())) {
                    ProductResult.ProductInfoResult productInfoResult = new ProductResult.ProductInfoResult();
                    BeanUtils.copyProperties(productInfo, productInfoResult);
                    productInfoResultList.add(productInfoResult);
                }
            }

            productResult.setProductInfoResultList(productInfoResultList);
            productResultList.add(productResult);
        }
        return ResultVOUtil.success(productResultList);
    }

    @PostMapping("/getProductInfoListByIds")
    public List<ProductInfo> getProductInfoListByIds(@RequestBody  List<String> productIdList) {
        List<ProductInfo> productInfoList = productInfoService.findProductInfoListByIds(productIdList);
        return productInfoList;
    }

    @PostMapping("/decreaseStock")
    public void decreaseStock(@RequestBody List<CartDTO> cartDTOList) {
        productInfoService.decreaseStock(cartDTOList);
    }
}
