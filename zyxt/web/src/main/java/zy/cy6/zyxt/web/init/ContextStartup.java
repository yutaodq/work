//package zy.cy6.zyxt.web.init;
//
//
//import lombok.extern.slf4j.Slf4j;
//import org.apache.commons.lang3.StringUtils;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.ApplicationArguments;
//import org.springframework.boot.ApplicationRunner;
//import org.springframework.core.annotation.Order;
//import org.springframework.core.io.ClassPathResource;
//import org.springframework.core.io.Resource;
//import org.springframework.jdbc.datasource.init.ScriptUtils;
//import org.springframework.stereotype.Component;
//import org.springframework.web.context.ServletContextAware;
//import org.hibernate.Session;
//import org.springframework.transaction.annotation.Transactional;
//
//import javax.persistence.EntityManager;
//import javax.servlet.ServletContext;
//import java.util.List;
//import java.util.Map;
//
///**
// * 加载配置信息到系统
// * @since 3.0
// */
//@Slf4j
//@Order(2)
//@Component
//public class ContextStartup implements ApplicationRunner, ServletContextAware {
//    @Autowired
//    private ServletContext servletContext;
//    @Autowired
//    private EntityManager entityManager;
//
//    @Override
//    public void run(ApplicationArguments applicationArguments) throws Exception {
//        log.info("initialization ...");
//        reloadOptions(true);
////        resetChannels();
//        log.info("OK, completed");
//    }
//
//    @Override
//    public void setServletContext(ServletContext servletContext) {
//        this.servletContext = servletContext;
//    }
//
//    public void reloadOptions(boolean startup) {
//
//        if (startup ) {
//            try {
//                log.info("init options...");
//                Resource resource = new ClassPathResource("/db/schema.sql");
//                initSettings(resource);
//            } catch (Exception e) {
//                log.error("------------------------------------------------------------");
//                log.error("-          ERROR: The database is not initialized          -");
//                log.error("------------------------------------------------------------");
//                log.error(e.getMessage(), e);
//                System.exit(1);
//            }
//        }
//
//    }
//    @Transactional
//    public void initSettings(Resource resource) {
//        Session session = entityManager.unwrap(Session.class);
//        session.doWork(connection -> ScriptUtils.executeSqlScript(connection, resource));
//    }
//
//}
