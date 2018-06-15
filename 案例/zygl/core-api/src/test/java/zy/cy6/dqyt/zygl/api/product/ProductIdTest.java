package zy.cy6.dqyt.zygl.api.product;


import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

import zy.cy6.dqyt.common.domain.Identifier;

public class ProductIdTest {
	private static final String IDENTIFIER_TEST = "identifier_test";
	private static final String IDENTIFIER_NULL = null;
	private static final String IDENTIFIER_EMPTY = "  ";

	Identifier productId;
	
	@Test
	public void createIdentifierTest() {
		productId = ProductId.create();
		assertThat(productId.identifier()).as("标识符不能是null").isNotNull();
		assertThat(productId.identifier()).as("标识符不能是穿的").isNotEmpty();
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
