package zy.cy6.zyxt.query.product;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import zy.cy6.zyxt.common.domain.model.AbstractEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.util.Objects;

@Entity(name = "product")
@Data
@Slf4j
public class ProductEntity extends AbstractEntity {

  @Column(name = "identifier")
  private String identifier;
  @Column(name = "name")
  private String name;  //工具名称
  @Column(name = "gg")
  private String gg; // 规格
  @Column(name = "xh")
  private String xh; // 型号

  public ProductEntity() {
    log.info("新建：ProductEntity");
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof ProductEntity)) return false;
    AbstractEntity that = (ProductEntity) o;
    return Objects.equals(getId(), that.getId());
  }

  @Override
  public int hashCode() {
    return Objects.hash(getId());
  }

}
