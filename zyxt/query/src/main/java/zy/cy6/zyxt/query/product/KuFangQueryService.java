package zy.cy6.zyxt.query.product;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zy.cy6.zyxt.api.product.kuFang.KufangName;
import zy.cy6.zyxt.query.product.repositories.KufangQueryRepository;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class KufangQueryService {
    private final KufangQueryRepository kuFangRepository;

    @Autowired
    public KufangQueryService(KufangQueryRepository kuFangRepository) {
        this.kuFangRepository = kuFangRepository;

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

}
