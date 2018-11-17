package zy.cy6.zyxt.query.product;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zy.cy6.zyxt.api.product.kuFang.KuFangName;
import zy.cy6.zyxt.query.product.repositories.KuFangQueryRepository;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class KuFangQueryService {
    private final KuFangQueryRepository kuFangRepository;

    @Autowired
    public KuFangQueryService(KuFangQueryRepository kuFangRepository) {
        this.kuFangRepository = kuFangRepository;

    }

    public Optional<KuFangEntity> findOne(Long id) {
        return kuFangRepository.findById(id);
    }

    public Optional<KuFangEntity> findByKuFangName(KuFangName kuFangName) {
        String name = kuFangName.getName();
        return kuFangRepository.findByName(name);
    }

    public Optional<KuFangEntity> findByIdentifier(String identifier) {
        return kuFangRepository.findByIdentifier(identifier);

    }

    public List<KuFangEntity> findAllKuFang() {
        log.info("所有的库房记录");
        return kuFangRepository.findAll();
    }

}
