package zy.cy6.zyxt.web.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zy.cy6.zyxt.web.domain.ProductEntry;
import zy.cy6.zyxt.web.repositories.ProductQueryRepository;
import zy.cy6.zyxt.web.service.IProductService;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class ProductServiceImpl implements IProductService {
    private static final Logger log = LoggerFactory.getLogger(ProductServiceImpl.class);
    @Autowired
    private ProductQueryRepository productRepository;

    @Override
    public List<ProductEntry> queryAllStaffList() {

        Iterator<ProductEntry> iterable = productRepository.findAll().iterator();
        List<ProductEntry> list = new ArrayList<ProductEntry>();
        while(iterable.hasNext()){
            ProductEntry product = iterable.next();

            String name = product.getName();
            log.info("ffffffffffffffffff:");
            list.add(product);
        }
        return list;
    }
}
