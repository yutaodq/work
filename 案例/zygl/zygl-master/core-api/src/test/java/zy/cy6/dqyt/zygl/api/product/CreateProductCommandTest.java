package zy.cy6.dqyt.zygl.api.product;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Before;
import org.junit.Test;

public class CreateProductCommandTest {
	ProductId productId;
	ProductName productName;
	CreateProductCommand createProductCommand;
	
	@Before
	public void setUp() throws Exception {
		productId = (ProductId) ProductId.create();
		productName = ProductName.create("name", "model", "size", "unit");
	}

	@Test
	public void createCreateProductCommandTest() {
		createProductCommand = CreateProductCommand.create(productId, productName);
		assertThat(createProductCommand.getProductName()).as("工具名称不正确").isEqualTo(productName);
		assertThat(createProductCommand.getProductId()).as("工具标识不正确").isEqualTo(productId);

	}
	@Test(expected = NullPointerException.class)
	public void testProductIdIsNull() {
		createProductCommand = CreateProductCommand.create(null, productName);
	}
	
	@Test(expected = NullPointerException.class)
	public void testProductNameIdIsNull() {
		createProductCommand = CreateProductCommand.create(productId, null);
	}

}
