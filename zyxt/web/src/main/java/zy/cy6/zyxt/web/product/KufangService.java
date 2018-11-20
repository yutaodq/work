package zy.cy6.zyxt.web.product;

import org.springframework.hateoas.Resource;
import org.springframework.hateoas.Resources;
import org.springframework.http.ResponseEntity;
import zy.cy6.zyxt.query.product.KufangEntity;

import java.util.List;
import java.util.Optional;

public interface KufangService {
    List<KufangEntity> findAllKufang();

    ResponseEntity<Resources<Resource<KufangEntity>>> findAll();

    ResponseEntity<Resource<KufangEntity>> findOne(Long id);

    Optional<KufangEntity> findKufangName(String name, String gg, String xh);

    ResponseEntity<Resource<KufangEntity>> create(KufangEntity product) throws Exception;
}