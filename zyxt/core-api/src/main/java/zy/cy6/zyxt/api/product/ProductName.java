package zy.cy6.zyxt.api.product;

import com.google.common.base.MoreObjects;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Serializable;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;
@Getter
@EqualsAndHashCode
public final class ProductName implements Serializable {
  private final static Logger log = LoggerFactory.getLogger(ProductId.class);

  private String name;

  private String model; // 型号
  private String size; // 规格

  private ProductName() {}

  private ProductName(String name, String model, String size) {
    log.info("新建：ProductName");
    this.name = checkNotNull(name, "工具名称不能是null！");
    checkArgument(!this.name.trim().isEmpty(), "工具名称不能为空！");
    this.size = size;
    this.model = model;

  }

  public static ProductName create(String name, String model, String size) {
    return new ProductName(name, model, size);
  }

  @Override
  public String toString() {
    return MoreObjects.toStringHelper(this)
        .add("工具名称：", name)
        .add("型号", model)
        .add("规格：", size)
        .toString();
  }
}
