package zy.cy6.zyxt.api.product;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ProductNameTest {

  private static final String NAME = "工具名称";
  private static final String MODEL = "型号";
  private static final String SIZE = "规格";
  private static final String UNIT = "计量单位";

  private static final String NAME_NULL = null;
  private static final String NAME_EMPTY = "";

  private static final String UNIT_NULL = null;
  private static final String UNIT_EMPTY = "";

  //	private static final String CHANGE_NAME = "改变工具名称";
  //	private static final String CHANGE_MODEL = "改变型号";
  //	private static final String CHANGE_SIZE = "改变规格";
  //	private static final String CHANGE_UNIT = "改变计量单位";

  ProductName productName;

  @Test
  public void createIdentifierTest() {
    productName = ProductName.create(NAME, MODEL, SIZE, UNIT);
    assertThat(productName.getName()).as("工具名称不正确").isEqualTo(NAME);
    assertThat(productName.getModel()).as("型号不正确").isEqualTo(MODEL);
    assertThat(productName.getSize()).as("规格不正确").isEqualTo(SIZE);
    assertThat(productName.getUnit()).as("计量单位不正确").isEqualTo(UNIT);
  }

  @Test(expected = NullPointerException.class)
  public void testNameIsNull() {
    productName = ProductName.create(NAME_NULL, MODEL, SIZE, UNIT);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testNameIsEmpty() {
    productName = ProductName.create(NAME_EMPTY, MODEL, SIZE, UNIT);
  }

  @Test(expected = NullPointerException.class)
  public void testUnitIsNull() {
    productName = ProductName.create(NAME, MODEL, SIZE, UNIT_NULL);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testUnitIsEmpty() {
    productName = ProductName.create(NAME, MODEL, SIZE, UNIT_EMPTY);
  }
}
