package zy.cy6.zyxt.query.kufang.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import zy.cy6.zyxt.query.kufang.KufangEntity;

import java.util.Optional;

/**
 * @author Jettro Coenradie
 */

//public interface KufangQueryRepository extends CrudRepository<KufangEntity, Long> {
public interface KufangQueryRepository extends JpaRepository<KufangEntity, Long> {

//    Optional<List<KufangEntity>> findAll();

    @Override
    Optional<KufangEntity> findById(Long id);

    Optional<KufangEntity> findByIdentifier(String identifier);

    Optional<KufangEntity> findByName(String name);
}
