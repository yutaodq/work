package zy.cy6.zyxt.api.product;


import org.junit.Test;
import zy.cy6.zyxt.api.product.product.ProductId;
import zy.cy6.zyxt.common.domain.AggregateIdentifier;

import static org.assertj.core.api.Assertions.assertThat;

public class ProductIdTest {
  private static final String IDENTIFIER_TEST = "identifier_test";
  private static final String IDENTIFIER_NULL = null;
  private static final String IDENTIFIER_EMPTY = "  ";

  AggregateIdentifier productId;

  @Test
  public void createIdentifierTest() {
    productId = ProductId.create();
    assertThat(productId.identifier()).as("标识符不能是null").isNotNull();
    assertThat(productId.identifier()).as("标识符不能是空的").isNotEmpty();
  }

  @Test
  public void testIdentifierEqual() {
    productId = ProductId.create(IDENTIFIER_TEST);

    assertThat(IDENTIFIER_TEST).isEqualTo(productId.identifier());
  }

  @Test(expected = NullPointerException.class)
  public void testIdentifierIsNull() {
    productId = ProductId.create(IDENTIFIER_NULL);


  }

  @Test(expected = IllegalArgumentException.class)
  public void testIdentifierIsEmpty() {
    productId = ProductId.create(IDENTIFIER_EMPTY);
  }

}
