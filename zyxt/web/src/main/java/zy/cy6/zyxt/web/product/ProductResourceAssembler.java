/*
 * see
 *spring-hateoas-examples
 */
package zy.cy6.zyxt.web.product;

import org.springframework.stereotype.Component;
import zy.cy6.zyxt.common.hateoas.SimpleIdentifiableResourceAssembler;
import zy.cy6.zyxt.query.product.ProductEntity;
import zy.cy6.zyxt.web.controller.ProductController;


@Component
public class ProductResourceAssembler extends SimpleIdentifiableResourceAssembler<ProductEntity> {
  public ProductResourceAssembler() {
    super(ProductController.class);
  }

}


