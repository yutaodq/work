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

package zy.cy6.zyxt.query.product.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import zy.cy6.zyxt.query.product.ProductEntity;
import java.util.Optional;
/**
 * @author Jettro Coenradie
 */
//public interface ProductQueryRepository extends CrudRepository<ProductEntity, Long> {
public interface ProductQueryRepository extends JpaRepository<ProductEntity, Long> {

  Optional<ProductEntity> findById(Long id);

  Optional<ProductEntity> findByIdentifier(String identifier);
//  ProductEntity findByIdentifier(String identifier);

  Optional<ProductEntity> findByNameAndGgAndXh(String name, String gg, String xh);
}
