package zy.cy6.zyxt.api.product;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ProductNameTest {

  private static final String NAME = "工具名称";
  private static final String MODEL = "型号";
  private static final String SIZE = "规格";

  private static final String NAME_NULL = null;
  private static final String NAME_EMPTY = "";

  private static final String CHANGE_NAME = "工具名称-修改后的";
  private static final String CHANGE_MODEL = "型号-修改后的";
  private static final String CHANGE_SIZE = "规格-修改后的";

  ProductName productName;

  @Test
  public void createProducNameTest() {
    productName = ProductName.create(NAME, MODEL, SIZE);

    assertThat(productName.getName()).as("工具名称不正确").isEqualTo(NAME);
    assertThat(productName.getModel()).as("型号不正确").isEqualTo(MODEL);
    assertThat(productName.getSize()).as("规格不正确").isEqualTo(SIZE);
  }

  @Test
  public void changeProductNameTest() {
    productName = ProductName.create(NAME, MODEL, SIZE).changeProductName(CHANGE_NAME, CHANGE_MODEL, CHANGE_SIZE);
    assertThat(productName.getName()).as("修改工具名称不正确").isEqualTo(CHANGE_NAME);
    assertThat(productName.getModel()).as("型号不正确").isEqualTo(CHANGE_MODEL);
    assertThat(productName.getSize()).as("规格不正确").isEqualTo(CHANGE_SIZE);
  }

  @Test
  public void changeNameTest() {
    productName = ProductName.create(NAME, MODEL, SIZE).changeName(CHANGE_NAME);
    assertThat(productName.getName()).as("修改工具名称不正确").isEqualTo(CHANGE_NAME);
    assertThat(productName.getModel()).as("型号不正确").isEqualTo(MODEL);
    assertThat(productName.getSize()).as("规格不正确").isEqualTo(SIZE);
  }

  @Test
  public void changeModelTest() {
    productName = ProductName.create(NAME, MODEL, SIZE).changeModel(CHANGE_MODEL);
    assertThat(productName.getName()).as("工具名称不正确").isEqualTo(NAME);
    assertThat(productName.getModel()).as("修改型号不正确").isEqualTo(CHANGE_MODEL);
    assertThat(productName.getSize()).as("规格不正确").isEqualTo(SIZE);
  }

  @Test
  public void changeSizeTest() {
    productName = ProductName.create(NAME, MODEL, SIZE).changeSize(CHANGE_SIZE);
    assertThat(productName.getName()).as("工具名称不正确").isEqualTo(NAME);
    assertThat(productName.getModel()).as("型号不正确").isEqualTo(MODEL);
    assertThat(productName.getSize()).as("规格不正确").isEqualTo(CHANGE_SIZE);
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
