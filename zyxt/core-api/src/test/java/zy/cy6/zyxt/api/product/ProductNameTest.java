package zy.cy6.zyxt.api.product;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ProductNameTest {

  private static final String NAME = "工具名称";
  private static final String MODEL = "型号";
  private static final String SIZE = "规格";

  private static final String NAME_NULL = null;
  private static final String NAME_EMPTY = "";

  ProductName productName;

  @Test
  public void createIdentifierTest() {
    productName = ProductName.create(NAME, MODEL, SIZE);

    assertThat(productName.getName()).as("工具名称不正确").isEqualTo(NAME);
    assertThat(productName.getModel()).as("型号不正确").isEqualTo(MODEL);
    assertThat(productName.getSize()).as("规格不正确").isEqualTo(SIZE);
  }

  @Test(expected = NullPointerException.class)
  public void testNameIsNull() {
    productName = ProductName.create(NAME_NULL, MODEL, SIZE);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testNameIsEmpty() {
    productName = ProductName.create(NAME_EMPTY, MODEL, SIZE);
  }


}
