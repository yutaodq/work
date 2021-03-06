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
  private final KufangQueryRepository kufangRepository;
//  private final KufangSearchRepository kufangSearchRepository;

  @Autowired
  public KufangQueryService(KufangQueryRepository kufangRepository) {
    this.kufangRepository = kufangRepository;
  }

  public Optional<KufangEntity> findOne(Long id) {
    return kufangRepository.findById(id);
  }

  public Optional<KufangEntity> findByKufangName(KufangName kufangName) {
    String name = kufangName.getName();
    return kufangRepository.findByName(name);
  }

  public Optional<KufangEntity> findByIdentifier(String identifier) {
    return kufangRepository.findByIdentifier(identifier);

  }
  public List<KufangEntity> findAllKufangs() {
    log.info("所有的库房记录");
    return kufangRepository.findAll();
  }

}
