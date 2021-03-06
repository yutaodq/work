package zy.cy6.zyxt.common.config;

import org.springframework.boot.SpringApplication;
import org.springframework.core.env.Environment;
import zy.cy6.zyxt.common.constant.AppConstants;

import java.util.HashMap;
import java.util.Map;

/**
 * Utility class to load a Spring profile to be used as default
 * when there is no <code>spring.profiles.active</code> set in the environment or as command line argument.
 * If the value is not available in <code>application.yml</code> then <code>dev</code> profile will be used as default.
 * 设置应用程序的默认profiles.active属性，当没有在application.yml文件中设置障时就使用这个默认值
 */
public final class DefaultProfileUtil {

  private static final String SPRING_PROFILE_DEFAULT = "spring.profiles.default";

  private DefaultProfileUtil() {
  }

  /**
   * Set a default to use when no profile is configured.
   * <p>
   * 通过SpringApplication.setDefaultProperties指定默认属性
   *
   * @param app the Spring application
   */
  public static void addDefaultProfile(SpringApplication app) {
    Map<String, Object> defProperties = new HashMap<>();
    /*
     * The default profile to use when no other profiles are defined
     * This cannot be set in the <code>application.yml</code> file.
     * See https://github.com/spring-projects/spring-boot/issues/1219
     */

    defProperties.put(SPRING_PROFILE_DEFAULT, AppConstants.SPRING_PROFILE_DEVELOPMENT);
    app.setDefaultProperties(defProperties);
  }

  /**
   * Get the profiles that are applied else get default profiles.
   */
  public static String[] getActiveProfiles(Environment env) {
    String[] profiles = env.getActiveProfiles();
    if (profiles.length == 0) {
      return env.getDefaultProfiles();
    }
    return profiles;
  }
}
