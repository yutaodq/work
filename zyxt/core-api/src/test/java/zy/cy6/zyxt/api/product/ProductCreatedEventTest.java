package zy.cy6.zyxt.api.product;

import org.junit.Before;
import org.junit.Test;
import zy.cy6.zyxt.api.product.product.ProductCreatedEvent;
import zy.cy6.zyxt.api.product.product.ProductId;
import zy.cy6.zyxt.api.product.product.ProductName;

import static org.assertj.core.api.Assertions.assertThat;

public class ProductCreatedEventTest {
  ProductId productId;
  ProductName productName;
  ProductCreatedEvent productCreatedEvent;

  @Before
  public void setUp() throws Exception {
    productId = ProductId.create();
    productName = ProductName.create("name", "model", "size");
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
