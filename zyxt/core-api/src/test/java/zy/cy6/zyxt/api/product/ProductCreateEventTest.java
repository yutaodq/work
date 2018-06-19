package zy.cy6.zyxt.api.product;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ProductCreateEventTest {
  ProductId productId;
  ProductName productName;
  ProductCreateEvent productCreateEvent;

  @Before
  public void setUp() throws Exception {
    productId = ProductId.create();
    productName = ProductName.create("name", "model", "size");
  }

  @Test
  public void createCreateProductCommandTest() {
    productCreateEvent = ProductCreateEvent.create(productId, productName);
    assertThat(productCreateEvent.getProductName()).as("工具名称不正确").isEqualTo(productName);
    assertThat(productCreateEvent.getProductId()).as("工具标识不正确").isEqualTo(productId);

  }

  @Test(expected = NullPointerException.class)
  public void testProductIdIsNull() {
    productCreateEvent = ProductCreateEvent.create(null, productName);
  }

  @Test(expected = NullPointerException.class)
  public void testProductNameIdIsNull() {
    productCreateEvent = ProductCreateEvent.create(productId, null);
  }

}
