package zy.cy6.zyxt.query.product;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import zy.cy6.zyxt.common.domain.model.AbstractEntity;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity(name = "product")
@Data
@Slf4j
public class ProductEntity extends AbstractEntity {

  @Column(name = "identifier")
  private String identifier;
  @Column(name = "name")
  private String name;  //工具名称
  @Column(name = "model")
  private String model; // 型号
  @Column(name = "size")
  private String size; // 规格

  public ProductEntity() {
    log.info("新建：ProductEntity");
  }
}
