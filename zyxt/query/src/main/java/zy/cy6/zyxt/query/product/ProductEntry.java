package zy.cy6.zyxt.query.product;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

@Entity(name = "product")
@Data
public class ProductEntry implements Serializable {
  @Id
  @Column(name = "identifier")
  private String identifier;
  @Column(name = "name")
  private String name;  //工具名称
  @Column(name = "model")
  private String model; // 型号
  @Column(name = "size")
  private String size; // 规格

  public ProductEntry() {
  }
}
