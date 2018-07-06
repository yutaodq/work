package zy.cy6.zyxt.api.product;

import com.google.common.base.MoreObjects;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.io.Serializable;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;
import static zy.cy6.zyxt.common.util.StringUtil.notNullString;

// @Value
@Getter
@Slf4j
@EqualsAndHashCode
public final class ProductName implements Serializable {

  private String name;
  private String model; // 型号
  private String size; // 规格

  private ProductName(String name, String model, String size) {
    log.info("新建：ProductName");
    setName(name);
    setSize(size);
    setModel(model);
  }

  public ProductName changeName(String name) {
    return create(name, this.model, this.size);
  }

  public ProductName changeModel(String model) {
    return create(this.name, model, this.size);
  }

  public ProductName changeSize(String size) {
    return create(this.name, this.model, size);
  }

  public static ProductName create(String name, String model, String size) {
    return new ProductName(name, model, size);
  }

  private void setName(String name) {
    this.name = checkNotNull(name, "工具名称不能是null！");
    checkArgument(!this.name.trim().isEmpty(), "请您录入工具名称！");
  }

  private void setModel(String model) {
    this.model = notNullString(model);
  }

  private void setSize(String size) {
    this.size = notNullString(size);
  }

  @Override
  public String toString() {
    return MoreObjects.toStringHelper(this).add("工具名称：", name).add("型号", model).add("规格：", size).toString();
  }
}
