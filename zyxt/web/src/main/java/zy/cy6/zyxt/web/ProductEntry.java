package zy.cy6.zyxt.web;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

import javax.persistence.Entity;

@Entity
@Getter
@Setter
public class ProductEntry {
  @Id
  @javax.persistence.Id
  private String identifier;
  private String name;  //工具名称
  private String model; // 型号
  private String size; // 规格
}
