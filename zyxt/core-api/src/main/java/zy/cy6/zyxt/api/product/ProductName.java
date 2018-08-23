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
  private String gg; // 规格
  private String xh; // 型号

  private ProductName(String name, String gg, String xh) {
    log.info("新建：ProductName");
    setName(name);
    setGg(gg);
    setXh(xh);
  }

  public ProductName changeName(String name) {
    return create(name, this.gg, this.xh);
  }

  public ProductName changeGg(String gg) {
    return create(this.name, gg, this.xh);
  }

  public ProductName changeXh(String xh) {
    return create(this.name, this.gg, xh);
  }

  public ProductName changeProductName(String name, String gg, String xh) {
    return create(name, gg, xh);
  }

  public static ProductName create(String name, String gg, String xh) {
    return new ProductName(name, gg, xh);
  }

  private void setName(String name) {
    this.name = checkNotNull(name, "工具名称不能是null！");
    checkArgument(!this.name.trim().isEmpty(), "请您录入工具名称！");
  }

  private void setGg(String gg) {
    this.gg = notNullString(gg);
  }

  private void setXh(String xh) {
    this.xh = notNullString(xh);
  }

  @Override
  public String toString() {
    return MoreObjects.toStringHelper(this).add("工具名称：", name).add("规格:", gg).add("型号：", xh).toString();
  }
}
