package zy.cy6.zyxt.api.product.kufang;

import com.google.common.base.MoreObjects;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.Assert;

import java.io.Serializable;
import java.util.Collection;
import java.util.Set;

@Getter
@Slf4j
@EqualsAndHashCode
@Builder
public final class KufangName implements Serializable {

  private String name;

  private KufangName(String name) {
    log.info("新建：KufangName");
    setName(name);
  }

  public KufangName changeName(String name) {
    return KufangName.builder().name(name).build();
  }

  private void setName(String name) {
    Assert.hasLength(name, "库房名称不能为空或null");
    this.name = name;
  }


  @Override
  public String toString() {
    return MoreObjects.toStringHelper(this).add("库房名称是：", name).toString();
  }


}
