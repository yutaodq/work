package zy.cy6.zyxt.api.help;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Locale;

/**
 * <p> The describe </p>
 * https://github.com/sky233/shared-bike
 *
 * @author Li Xingping
 */
@Component
public class MessagesHelper {

  @Autowired
  private MessageSource messageSource;

  private MessageSourceAccessor accessor;

  @PostConstruct
  private void init() {
    accessor = new MessageSourceAccessor(messageSource, Locale.SIMPLIFIED_CHINESE);
  }

  public String get(String code) {
    return accessor.getMessage(code);
  }

  public String get(String code, Object[] args) {
    return accessor.getMessage(code, args);
  }

}
