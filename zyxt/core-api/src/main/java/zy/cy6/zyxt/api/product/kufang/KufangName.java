package zy.cy6.zyxt.api.product.kufang;

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
public final class KufangName implements Serializable {

    private String name;

    private KufangName(String name) {
        log.info("新建：KufangName");
        setName(name);
    }

    public KufangName changeName(String name) {
        return create(name);
    }


    public static KufangName create(String name) {
        return new KufangName(name);
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
