package zy.cy6.dqyt.zygl.trade;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.env.Environment;

import zy.cy6.dqyt.common.config.Constants;
import zy.cy6.dqyt.common.config.DefaultProfileUtil;
import zy.cy6.dqyt.zygl.infra.config.CQRSInfrastructureConfig;
import zy.cy6.dqyt.zygl.infra.config.DataSourceConfig;

import java.util.Arrays;
import java.util.Collection;

import javax.annotation.PostConstruct;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.net.InetAddress;
import java.net.UnknownHostException;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import({
	DataSourceConfig.class,
	CQRSInfrastructureConfig.class
})

public class TradeApp {
    private static final Logger log = LoggerFactory.getLogger(TradeApp.class);
/*
 * Environment 环境变量
 * Spring抽象了一个Environment来表示Spring应用程序环境配置，它整合了各种各样的外部环境，并且提供统�?访问的方�?
 */
    private final Environment env;

    public TradeApp(Environment env) {
        this.env = env;
    }

	/**
	 * Initializes common .
	 * 被@PostConstruct修饰的方法会在服务器加载Servlet的时候运行，
	 * 并且只会被服务器调用�?次，类似于Serclet的inti()方法�?
	 * 被@PostConstruct修饰的方法会在构造函数之后，init()方法之前运行�?
	 * <p>
	 * Spring profiles can be configured with a program arguments
	 * --spring.profiles.active=your-active-profile
	 * <p>
	 * You can find more information on how profiles work with JHipster on
	 * <a href=
	 * "http://jhipster.github.io/profiles/">http://jhipster.github.io/profiles/</a>.
	 */

    @PostConstruct
    public void initApplication() {
        Collection<String> activeProfiles = Arrays.asList(env.getActiveProfiles());
        if (activeProfiles.contains(Constants.SPRING_PROFILE_DEVELOPMENT) && activeProfiles.contains(Constants.SPRING_PROFILE_PRODUCTION)) {
			log.error("你的应用程序配置错误!在同�?时间,程序不能在同�?时间运行�?'�?发模�?'和�?�生产模式�?�下�?"
					+"请检查application.yml文件spring.profiles的配�? ");
        }
        if (activeProfiles.contains(Constants.SPRING_PROFILE_DEVELOPMENT) && activeProfiles.contains(Constants.SPRING_PROFILE_CLOUD)) {
			log.error("你的应用程序配置错误!在同�?时间,程序不能在同�?时间运行�?'�?发模�?'�?'cloud'下�??"
					+"请检查application.yml文件spring.profiles的配�? ");
        }
    }

    /**
     * Main method, used to run the application.
     *
     * @param args the command line arguments
     * @throws UnknownHostException if the local host name could not be resolved into an address
     */
    public static void main(String[] args) throws UnknownHostException {
        SpringApplication app = new SpringApplication(TradeApp.class);
        DefaultProfileUtil.addDefaultProfile(app);
        Environment env = app.run(args).getEnvironment();
        String protocol = "http";
        if (env.getProperty("server.ssl.key-store") != null) {
            protocol = "https";
        }
        
		log.info("\n----------------------------------------------------------\n\t" +
                "应用程序: '{}' 正在运行! 访问  URLs:\n\t" +
                "本机: \t\t{}://localhost:{}\n\t" +
                "远程: \t{}://{}:{}\n\t" +
                "�?活的配置项有: \t{}\n----------------------------------------------------------",
            env.getProperty("spring.application.name"),
            protocol,
            env.getProperty("server.port"),
            protocol,
            InetAddress.getLocalHost().getHostAddress(),
            env.getProperty("server.port"),
            env.getActiveProfiles());
    }
    
}