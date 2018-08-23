package zy.cy6.zyxt.api.exception;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * <p> The describe </p>
 * https://github.com/sky233/shared-bike
 *
 * @author Li Xingping
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class ErrorCode {

  public static final int BIKE_STATE_INVALID = 0X00F0;
  public static final int BIKE_NOT_FOUND = 0X00F1;

  public static final int USER_ACCOUNT_INVALID = 0X00D1;
  public static final int USER_NOT_FOUND = 0X00D2;

  public static final int USER_TRANSACTION_INVALID = 0X00E1;
  public static final int USER_TRANSACTION_NOT_FOUND = 0X00E2;

  public static final int VIOLATION_CONSTRAINT = 0XFFFE;
  public static final int UNKNOWN_ERROR = 0XFFFF;

}
