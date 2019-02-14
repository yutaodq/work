package zy.cy6.zyxt.api.product;

import org.junit.Test;
import zy.cy6.zyxt.api.product.product.ProductName;

import static org.assertj.core.api.Assertions.assertThat;

public class ProductNameTest {

  private static final String NAME = "工具名称";
  private static final String XH = "型号";
  private static final String GG = "规格";

  private static final String NAME_NULL = null;
  private static final String NAME_EMPTY = "";

  private static final String CHANGE_NAME = "工具名称-修改后的";
  private static final String CHANGE_XH = "型号-修改后的";
  private static final String CHANGE_GG = "规格-修改后的";

  ProductName productName;

  @Test
  public void createProducNameTest() {
    productName = ProductName.create(NAME, GG, XH);

    assertThat(productName.getName()).as("工具名称不正确").isEqualTo(NAME);
    assertThat(productName.getGg()).as("型号不正确").isEqualTo(XH);
    assertThat(productName.getXh()).as("规格不正确").isEqualTo(GG);
  }

  @Test
  public void changeProductNameTest() {
    productName = ProductName.create(NAME, XH, GG).changeProductName(CHANGE_NAME, CHANGE_GG, CHANGE_XH);
    assertThat(productName.getName()).as("修改工具名称不正确").isEqualTo(CHANGE_NAME);
    assertThat(productName.getGg()).as("型号不正确").isEqualTo(CHANGE_XH);
    assertThat(productName.getXh()).as("规格不正确").isEqualTo(CHANGE_GG);
  }

  @Test
  public void changeNameTest() {
    productName = ProductName.create(NAME, XH, GG).changeName(CHANGE_NAME);
    assertThat(productName.getName()).as("修改工具名称不正确").isEqualTo(CHANGE_NAME);
    assertThat(productName.getGg()).as("型号不正确").isEqualTo(XH);
    assertThat(productName.getXh()).as("规格不正确").isEqualTo(GG);
  }

  @Test
  public void changeModelTest() {
    productName = ProductName.create(NAME, XH, GG).changeGg(CHANGE_XH);
    assertThat(productName.getName()).as("工具名称不正确").isEqualTo(NAME);
    assertThat(productName.getGg()).as("修改规格不正确").isEqualTo(CHANGE_XH);
    assertThat(productName.getXh()).as("型号不正确").isEqualTo(GG);
  }

  @Test
  public void changeSizeTest() {
    productName = ProductName.create(NAME, XH, GG).changeXh(CHANGE_GG);
    assertThat(productName.getName()).as("工具名称不正确").isEqualTo(NAME);
    assertThat(productName.getGg()).as("规格不正确").isEqualTo(XH);
    assertThat(productName.getXh()).as("型号不正确").isEqualTo(CHANGE_GG);
  }

  @Test(expected = NullPointerException.class)
  public void testNameIsNull() {
    productName = ProductName.create(NAME_NULL, GG, XH);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testNameIsEmpty() {
    productName = ProductName.create(NAME_EMPTY, GG, XH);
  }


}
