package zy.cy6.zyxt.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import zy.cy6.zyxt.web.domain.ProductEntry;
import zy.cy6.zyxt.web.service.IProductService;

import java.util.List;

@RestController
public class ProductController {
    private static final Logger log = LoggerFactory.getLogger(ProductController.class);
    @Autowired
    private IProductService productService;

    @RequestMapping("/product")
    List<ProductEntry> productList() {
        log.info("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
        List<ProductEntry> staffList = null;
        try {
//            int sl =staffList.size();
            staffList = productService.queryAllStaffList();
//            log.info("dddddddddddddddddddddd"+Integer.toString(sl));

        } catch (Exception e) {
            log.error("查询失败");
        }
        return staffList;

    }

}
