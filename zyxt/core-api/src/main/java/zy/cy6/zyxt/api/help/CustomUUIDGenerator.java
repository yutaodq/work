package zy.cy6.zyxt.api.help;

import org.hibernate.id.UUIDGenerator;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.type.Type;

import java.util.Properties;

/**
 * <p> The describe </p>
 * https://github.com/sky233/shared-bike
 *
 * @author Li Xingping
 */
public class CustomUUIDGenerator extends UUIDGenerator {

  private String entityName;

  @Override
  public void configure(Type type, Properties params, ServiceRegistry serviceRegistry) {
    entityName = params.getProperty(ENTITY_NAME);
    super.configure(type, params, serviceRegistry);
  }

}
