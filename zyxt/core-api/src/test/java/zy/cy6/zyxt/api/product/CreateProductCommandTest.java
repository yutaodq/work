package zy.cy6.zyxt.api.product;

import org.junit.Before;
import org.junit.Test;
import zy.cy6.zyxt.api.product.product.CreateProductCommand;
import zy.cy6.zyxt.api.product.product.ProductId;
import zy.cy6.zyxt.api.product.product.ProductName;

import static org.assertj.core.api.Assertions.assertThat;

public class CreateProductCommandTest {
  ProductId productId;
  ProductName productName;
  CreateProductCommand createProductCommand;

  @Before
  public void setUp() throws Exception {
    productId = ProductId.create();
    productName = ProductName.create("name", "model", "size");
  }

  @Test
  public void createCreateProductCommandTest() {
    createProductCommand = new CreateProductCommand(productId, productName);
    assertThat(createProductCommand.getProductName()).as("工具名称不正确").isEqualTo(productName);
    assertThat(createProductCommand.getProductId()).as("工具标识不正确").isEqualTo(productId);

  }

  @Test
//  @Test(expected = NullPointerException.class)
  public void testProductIdIsNull() {
    createProductCommand = new CreateProductCommand(null, productName);
  }

  @Test
//  @Test(expected = NullPointerException.class)
  public void testProductNameIsNull() {
    createProductCommand = new CreateProductCommand(productId, null);
  }

}
