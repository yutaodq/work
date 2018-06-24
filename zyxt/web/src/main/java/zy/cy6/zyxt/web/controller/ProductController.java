package zy.cy6.zyxt.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import zy.cy6.zyxt.query.product.ProductEntry;
import zy.cy6.zyxt.query.product.repositories.ProductQueryRepository;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@RestController
public class ProductController {
    private static final Logger log = LoggerFactory.getLogger(ProductController.class);
    private ProductQueryRepository productQueryRepository;

    @Autowired
    public ProductController(ProductQueryRepository productQueryRepository) {
        this.productQueryRepository = productQueryRepository;
    }

    @RequestMapping("/product")
    public List<ProductEntry> productList() {
        Iterator<ProductEntry> iterable = productQueryRepository.findAll().iterator();
        List<ProductEntry> list = new ArrayList<ProductEntry>();
        while (iterable.hasNext()) {
            ProductEntry product = iterable.next();

            String name = product.getName();
            log.info("ffffffffffffffffff:");
            list.add(product);
        }
        return list;
    }

    //    @RequestMapping("/product")
    //    List<ProductEntry> productList() {
    //        log.info("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
    //        List<ProductEntry> staffList = null;
    //        try {
    ////            int sl =staffList.size();
    //            staffList = productService.queryAllStaffList();
    ////            log.info("dddddddddddddddddddddd"+Integer.toString(sl));
    //
    //        } catch (Exception e) {
    //            log.error("查询失败");
    //        }
    //        return staffList;
    //
    //    }

}
