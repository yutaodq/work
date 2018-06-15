package zy.cy6.dqyt.zygl.api.product;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Before;
import org.junit.Test;

public class ProductCreatedEventTest {
	ProductId productId;
	ProductName productName;
	ProductCreatedEvent productCreatedEvent;
	
	@Before
	public void setUp() throws Exception {
		productId = (ProductId) ProductId.create();
		productName = ProductName.create("name", "model", "size", "unit");
	}

	@Test
	public void createCreateProductCommandTest() {
		productCreatedEvent = ProductCreatedEvent.create(productId, productName);
		assertThat(productCreatedEvent.getProductName()).as("工具名称不正确").isEqualTo(productName);
		assertThat(productCreatedEvent.getProductId()).as("工具标识不正确").isEqualTo(productId);

	}
	@Test(expected = NullPointerException.class)
	public void testProductIdIsNull() {
		productCreatedEvent = ProductCreatedEvent.create(null, productName);
	}
	
	@Test(expected = NullPointerException.class)
	public void testProductNameIdIsNull() {
		productCreatedEvent = ProductCreatedEvent.create(productId, null);
	}

}
