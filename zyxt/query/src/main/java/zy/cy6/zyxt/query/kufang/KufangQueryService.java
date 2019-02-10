package zy.cy6.zyxt.query.kufang;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zy.cy6.zyxt.api.product.kufang.KufangName;
import zy.cy6.zyxt.query.kufang.repositories.KufangQueryRepository;

import java.util.List;
import java.util.Optional;


@Service
@Slf4j
public class KufangQueryService {
  private final KufangQueryRepository kuFangRepository;
//  private final KufangSearchRepository kufangSearchRepository;

  @Autowired
  public KufangQueryService(KufangQueryRepository kuFangRepository) {
    this.kuFangRepository = kuFangRepository;
//    this.kufangSearchRepository = kufangSearchRepository;

  }

  public Optional<KufangEntity> findOne(Long id) {
    return kuFangRepository.findById(id);
  }

  public Optional<KufangEntity> findByKuFangName(KufangName kuFangName) {
    String name = kuFangName.getName();
    return kuFangRepository.findByName(name);
  }

  public Optional<KufangEntity> findByIdentifier(String identifier) {
    return kuFangRepository.findByIdentifier(identifier);

  }

  public List<KufangEntity> findAllKufang() {
    log.info("所有的库房记录");
    return kuFangRepository.findAll();
  }

//  public List<KufangEntity> search(String query) {
//    return StreamSupport.stream(kufangSearchRepository.search(queryStringQuery(query)).spliterator(), false).collect(Collectors.toList());
//  }
}