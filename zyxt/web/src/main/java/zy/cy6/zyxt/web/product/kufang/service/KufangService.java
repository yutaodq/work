package zy.cy6.zyxt.web.product.kufang.service;

import org.springframework.hateoas.Resource;
import org.springframework.http.ResponseEntity;
import zy.cy6.zyxt.query.kufang.KufangEntity;

import java.util.List;
import java.util.Optional;

public interface KufangService {
//    List<KufangEntity> findAllKufang();

//    ResponseEntity<Resources<Resource<KufangEntity>>> findAll();
    ResponseEntity<List<KufangEntity>> findAll();

    ResponseEntity<Resource<KufangEntity>> findOne(Long id);

//    Optional<KufangEntity> findByIdentifier(String identifier);

    Optional<KufangEntity> findKufangName(String name);

//    ResponseEntity<Resource<KufangEntity>> create(KufangEntity product) throws Exception;

    void remove(String id);

    Optional<KufangEntity> create(KufangEntity kufang);
}