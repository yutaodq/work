package zy.cy6.zyxt.api.product;

import com.google.common.base.MoreObjects;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import java.io.Serializable;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;


@Getter
@EqualsAndHashCode
public final class ProductName implements Serializable {

  /** */
  //	private static final long serialVersionUID = 7033672379619326554L;
  private String name;

  private String model; // 型号
  private String size; // 规格
  private String unit; // 计量单位

  private ProductName() {}

  private ProductName(String name, String model, String size, String unit) {
    this.name = checkNotNull(name, "工具名称不能是null！");
    checkArgument(!this.name.trim().isEmpty(), "工具名称不能为空！");

    this.size = size;
    this.model = model;

    this.unit = checkNotNull(unit, "工具的计量单位不能是null！");
    checkArgument(!this.unit.trim().isEmpty(), "人计量单位名称不能为空！");
  }

  public static ProductName create(String name, String model, String size, String unit) {
    return new ProductName(name, model, size, unit);
  }

  @Override
  public String toString() {
    return MoreObjects.toStringHelper(this)
        .add("工具名称：", name)
        .add("型号", model)
        .add("规格：", size)
        .add("计量", unit)
        .toString();
  }
}
