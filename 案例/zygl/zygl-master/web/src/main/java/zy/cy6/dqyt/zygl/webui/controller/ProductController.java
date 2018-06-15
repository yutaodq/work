package zy.cy6.dqyt.zygl.webui.controller;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static zy.cy6.dqyt.zygl.webui.resource.ProductResource.PRODUCTS_PATH;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.ExposesResourceFor;
import org.springframework.hateoas.PagedResources;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import zy.cy6.dqyt.zygl.query.product.ProductEntry;
import zy.cy6.dqyt.zygl.query.product.repositories.ProductQueryRepository;
import zy.cy6.dqyt.zygl.webui.resource.ProductResource;
import zy.cy6.dqyt.zygl.webui.resource.ProductResourceAssembler;
import zy.cy6.dqyt.zygl.webui.rest.errors.InternalServerErrorException;

@RestController
@RequestMapping(value = PRODUCTS_PATH, produces = { "application/xml", "application/json" })

@ExposesResourceFor(ProductEntry.class)

public class ProductController {
	private static final Logger log = LoggerFactory.getLogger(ProductController.class);

	private ProductQueryRepository productRepository;

	private ProductResourceAssembler assembler;

	@Autowired
	protected PagedResourcesAssembler<ProductEntry> pagedAssembler;

	@Autowired
	public ProductController(ProductQueryRepository productRepository,
			ProductResourceAssembler productResourceAssembler) {
		this.productRepository = productRepository;
		this.assembler = productResourceAssembler;
	}

	// http://localhost:8080/product/123
	@RequestMapping(value = "/{id}", method = GET, produces = "application/hal+json")
	ProductResource getProduct(@PathVariable String id) {

		ProductResource resource = Optional.ofNullable(productRepository.findOne(id)).map(assembler::toResource)
				.orElseThrow(() -> new InternalServerErrorException("对不起，没有您要找的记录"));

		return resource;
	}

	/*
	 * 可用的方法 这个方法的返回类型是Resources
	 * 
	 */
	// @RequestMapping(method = GET, produces = "application/hal+json")
	// Resources<ProductResource> getProducts() {
	// List<ProductResource> products = productRepository
	// .findAll().stream().map(assembler::toResource)
	// .collect(Collectors.toList());
	// return new Resources<>(products);
	//
	// }

	/*
	 * 可用的方法 这个方法的返回类型是PagedResources 案例见：spring mvc实战中的第章
	 */

	@RequestMapping(method = GET, produces = "application/hal+json")
	@ResponseStatus(HttpStatus.OK)
	// @ApiOperation(value = "Get overviews of indices", notes = "Return a page
	// of index-overviews")
	public PagedResources<ProductResource> getSeveral(Pageable pageable) {

		return pagedAssembler.toResource(productRepository.findAll(pageable), assembler);
	}

}
