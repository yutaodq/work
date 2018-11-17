package zy.cy6.zyxt.api.product.kuFang;

import lombok.Value;

@Value

public class KuFangNameNotUniqueException extends RuntimeException {
    //  private String errCode;
    private String errMsg;

    @SuppressWarnings("UnusedDeclaration")
    public KuFangNameNotUniqueException(String errMsg) {
        super(errMsg);
        this.errMsg = errMsg;
    }


}
