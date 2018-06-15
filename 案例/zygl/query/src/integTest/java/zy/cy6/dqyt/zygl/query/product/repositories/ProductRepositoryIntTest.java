/*
 * Copyright (c) 2010-2012. Axon Framework
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package zy.cy6.dqyt.zygl.query.product.repositories;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import zy.cy6.dqyt.zygl.query.product.ProductEntry;

/**
 * @author Jettro Coenradie
 */
@RunWith(SpringRunner.class)
@SpringBootTest

public class ProductRepositoryIntTest {

	@Autowired
	private ProductQueryRepository productRepository;

	private static final String IDENTIFIER = "123456";
	private static final String NAME = "工具名称";
	private static final String MODEL = "型号";
	private static final String SIZE = "规格";
	private static final String UNIT = "计量单位";

	@Test
	public void storeProductInRepository() {
		ProductEntry productEntry = new ProductEntry.Builder().identifier(IDENTIFIER).name(NAME).model(MODEL).size(SIZE)
				.unit(UNIT).build();

		productRepository.save(productEntry);

	}
}
