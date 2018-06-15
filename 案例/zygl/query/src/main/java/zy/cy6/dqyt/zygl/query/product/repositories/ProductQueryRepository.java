package zy.cy6.dqyt.zygl.query.product.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import zy.cy6.dqyt.zygl.query.product.ProductEntry;

public interface ProductQueryRepository extends JpaRepository<ProductEntry, String>{

}
