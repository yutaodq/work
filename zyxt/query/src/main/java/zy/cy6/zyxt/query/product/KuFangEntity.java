package zy.cy6.zyxt.query.product;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import zy.cy6.zyxt.common.domain.model.AbstractEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.util.Objects;

@Entity(name = "kuFang")
@Data
@Slf4j
public class KuFangEntity extends AbstractEntity {

    @Column(name = "identifier")
    private String identifier;
    @Column(name = "name")
    private String name;  //库房名称

    public KuFangEntity() {
        log.info("新建：KuFangEntity");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof KuFangEntity)) return false;
        AbstractEntity that = (KuFangEntity) o;
        return Objects.equals(getId(), that.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

}
