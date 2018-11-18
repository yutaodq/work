package zy.cy6.zyxt.api.product.kuFang;

import lombok.Value;

@Value

public class KufangNameNotUniqueException extends RuntimeException {
    //  private String errCode;
    private String errMsg;

    @SuppressWarnings("UnusedDeclaration")
    public KufangNameNotUniqueException(String errMsg) {
        super(errMsg);
        this.errMsg = errMsg;
    }


}
