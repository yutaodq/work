package zy.cy6.zyxt.api.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * <p> The describe </p>
 * https://github.com/sky233/shared-bike
 *
 * @author Li Xingping
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ErrorMessage implements Serializable {
  private int code;
  private String message;
  private Date timestamp;

  public static ErrorMessage unKnown() {
    return of(ErrorCode.UNKNOWN_ERROR, "Internal Error.");
  }

  public static ErrorMessage unKnown(String message) {
    return new ErrorMessage(ErrorCode.UNKNOWN_ERROR, message, new Date());
  }

  public static ErrorMessage of(int code, String message) {
    return new ErrorMessage(code, message, new Date());
  }
}
