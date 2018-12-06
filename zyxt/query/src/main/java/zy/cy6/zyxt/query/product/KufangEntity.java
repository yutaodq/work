package zy.cy6.zyxt.query.product;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import zy.cy6.zyxt.common.domain.model.AbstractEntity;

import java.util.Objects;
import javax.persistence.*;

@Entity
@Table(name = "kufang")
//@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
@Data
@Slf4j
//@Document(indexName = "KufangEntity")
public class KufangEntity extends AbstractEntity {

    @Column(name = "identifier")
    private String identifier;
    @Column(name = "name")
    private String name;  //库房名称

    public KufangEntity() {
        log.info("新建：KufangEntity");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof KufangEntity)) return false;
        AbstractEntity that = (KufangEntity) o;
        return Objects.equals(getId(), that.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

}
