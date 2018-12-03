package zy.cy6.zyxt.api.product;


import lombok.NoArgsConstructor;

//@Value
@NoArgsConstructor
public class ProductNameNotUniqueException extends RuntimeException {
  //  private String errCode;
  private String errMsg;

  public ProductNameNotUniqueException(String errMsg) {
    super(errMsg);
    this.errMsg = errMsg;
  }

  public String getErrMsg() {
    return errMsg;
  }

  public void setErrMsg(String errMsg) {
  }

}
