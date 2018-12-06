package zy.cy6.zyxt.query.product.repositories.search;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import zy.cy6.zyxt.query.config.KufangEntity;
/**
 * Spring Data Elasticsearch repository for the Contact entity.
 */
public interface KufangSearchRepository extends ElasticsearchRepository<KufangEntity, Long> {
}
