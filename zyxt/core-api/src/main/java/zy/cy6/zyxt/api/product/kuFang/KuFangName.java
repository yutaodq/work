package zy.cy6.zyxt.api.product.kuFang;

import com.google.common.base.MoreObjects;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.io.Serializable;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;

// @Value
@Getter
@Slf4j
@EqualsAndHashCode
public final class KuFangName implements Serializable {

    private String name;

    private KuFangName(String name) {
        log.info("新建：KuFangName");
        setName(name);
    }

    public KuFangName changeName(String name) {
        return create(name);
    }


    public static KuFangName create(String name) {
        return new KuFangName(name);
    }

    private void setName(String name) {
        this.name = checkNotNull(name, "库房名称不能是null！");
        checkArgument(!this.name.trim().isEmpty(), "请您录入库房名称！");
    }


    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this).add("库房名称：", name).toString();
    }
}
