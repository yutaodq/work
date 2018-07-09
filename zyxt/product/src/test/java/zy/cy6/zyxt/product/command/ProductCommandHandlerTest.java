package zy.cy6.zyxt.product.command;

import org.axonframework.messaging.interceptors.BeanValidationInterceptor;
import org.axonframework.messaging.interceptors.JSR303ViolationException;
import org.axonframework.test.aggregate.AggregateTestFixture;
import org.axonframework.test.aggregate.FixtureConfiguration;
import org.junit.Before;
import org.junit.Test;
import zy.cy6.zyxt.api.product.CreateProductCommand;
import zy.cy6.zyxt.api.product.ProductCreatedEvent;
import zy.cy6.zyxt.api.product.ProductId;
import zy.cy6.zyxt.api.product.ProductName;

public class ProductCommandHandlerTest {
  private FixtureConfiguration<Product> testFixture;
  private ProductId id = ProductId.create("productId");
  private ProductName productName = ProductName.create("aaaa", "bbbb", "cccc");

  @Before
  public void setUp() {
    testFixture = new AggregateTestFixture<>(Product.class);

    testFixture.registerAnnotatedCommandHandler(new ProductCommandHandler(testFixture.getRepository(), testFixture.getEventStore()));
    testFixture.registerCommandDispatchInterceptor(new BeanValidationInterceptor<>());
  }

  @Test
  public void testCreateProduct() throws Exception {
    testFixture.givenNoPriorActivity().when(new CreateProductCommand(id, productName)).expectEvents(ProductCreatedEvent.create(id, productName));
  }

  @Test(expected = JSR303ViolationException.class)
  public void testCreateProduct_PorductNull() throws Exception {
    testFixture.givenNoPriorActivity().when(new CreateProductCommand(id, null));
  }

  @Test(expected = JSR303ViolationException.class)
  public void testCreateProduct_PorductIdNull() throws Exception {
    testFixture.givenNoPriorActivity().when(new CreateProductCommand(null, productName));
  }

}
