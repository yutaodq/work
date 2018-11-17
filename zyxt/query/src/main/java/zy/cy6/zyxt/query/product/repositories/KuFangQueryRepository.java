package zy.cy6.zyxt.query.product.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import zy.cy6.zyxt.query.product.KuFangEntity;

import java.util.Optional;

/**
 * @author Jettro Coenradie
 */
//public interface KuFangQueryRepository extends CrudRepository<KuFangEntity, Long> {
public interface KuFangQueryRepository extends JpaRepository<KuFangEntity, Long> {

    Optional<KuFangEntity> findById(Long id);

    Optional<KuFangEntity> findByIdentifier(String identifier);
//  KuFangEntity findByIdentifier(String identifier);

    Optional<KuFangEntity> findByName(String name);
}
