package zy.cy6.dqyt.zygl.webui.resource;

import org.springframework.hateoas.mvc.ResourceAssemblerSupport;
import org.springframework.stereotype.Component;

import zy.cy6.dqyt.zygl.query.product.ProductEntry;
import zy.cy6.dqyt.zygl.webui.controller.ProductController;

@Component
public class ProductResourceAssembler extends ResourceAssemblerSupport<ProductEntry, ProductResource> {

	public ProductResourceAssembler() {
		super(ProductController.class, ProductResource.class);
	}

	@Override
	public ProductResource toResource(ProductEntry product) {
		return createResourceWithId(product.getIdentifier(), product);
		// resource.add(
		// linkTo(methodOn(ProductController.class).getProduct(entity.getIdentifier())).withSelfRel()

	}

	@Override
	protected ProductResource instantiateResource(ProductEntry entity) {
		return new ProductResource(entity);
	}
}
